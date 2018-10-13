//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.styles.makeStyle

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one abstract style rule (placeholder or concrete style rule) in a larger style sheet.
 */
@StyleBuilderDsl
abstract class AbstractStyleRule(
    override val parent: CompositeCssRule,
    private var style: Style = makeStyle {}
) : CompositeCssRule(), Style by style {

    /** The rules nested inside this one. */
    private val myNestedRules: MutableList<CompositeCssRule> = mutableListOf()

    /** The selectors of this rule. */
    private val mySelectors: MutableList<String> = mutableListOf()

    ////

    /**
     * Returns a list of the full-path selectors for this rule, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple selectors (comma separated in the eventual CSS) at each level.
     */
    override val fullSelectors: List<String>
        get() {

            if (parent.fullSelectors.isEmpty()) {
                return mySelectors.filter { s -> !s.startsWith("%") }
            }

            val result = mutableListOf<String>()

            for (outerSelector in parent.fullSelectors) {

                for (selector in mySelectors) {

                    if (selector.startsWith("%")) {
                        continue
                    }

                    var fullSelector = outerSelector

                    if (selector.contains("&")) {
                        fullSelector = selector.replace("&", fullSelector)
                    }
                    else {

                        if (outerSelector.isNotEmpty()) {
                            fullSelector += " "
                        }

                        fullSelector += selector

                    }

                    result.add(fullSelector)

                }

            }

            return result

        }

    override val nestedRules: List<CompositeCssRule> = myNestedRules

    val selectors: List<String> = mySelectors

    ////

    internal fun addNestedRule(nestedRule: CompositeCssRule) {
        myNestedRules.add(nestedRule)
    }

    internal fun addNestedRules(addedNestedRules: Collection<CompositeCssRule>) {
        myNestedRules.addAll(addedNestedRules)
    }

    internal fun addSelectors(addedSelectors: Collection<String>) {
        mySelectors.addAll(addedSelectors)
        afterAddSelectors(addedSelectors)
    }

    internal open fun afterAddSelectors(addedSelectors: Collection<String>) {}

    /**
     * Extends one or more style rules that have placeholder selectors [placeholderNames] with the selectors of this
     * style rule. The extended placeholder rules must be previously occurring siblings of this rule.
     */
    abstract fun extend(vararg placeholderNames: String)

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style rule.
        val result = StyleRule(this@AbstractStyleRule)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule inside this one.
        this@AbstractStyleRule.myNestedRules.add(result)

        // Build its style.
        result.build()

        return result

    }

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String) =
        this + ", " + that

    /** Combines a selector with an already created [styleRule] by adding the selector to the rule. */
    infix fun String.or(styleRule: StyleRule): StyleRule {

        styleRule.prependSelectors(this)

        return styleRule

    }

    /**
     * Adds the selectors (including placeholder selectors) split from the given [compoundSelector] to
     * the beginning of the selector list for this rule.
     */
    internal fun prependSelectors(compoundSelector: String) {

        // Iterate through its selectors or placeholder selectors
        // Note: the reversed() call below and the insert at index 0 is because the "or" operator is forced to
        // lower precedence than we want.
        for (selector in compoundSelector.split(",").map { s -> s.trim() }.reversed()) {
            mySelectors.add(0, selector)
        }

    }

    /** Converts this style rule to CSS. */
    override fun toCssString(indent: Int): String {

        val result = StringBuilder("")

        val spaces = "                    ".substring(0, indent)

        val finalSelectors = fullSelectors

        if (style.isNotEmpty && finalSelectors.isNotEmpty()) {
            result.append(spaces)
            result.append(finalSelectors.joinToString(",\n$spaces"))
            result.append(" {\n")
            result.append(style.toCssString("$spaces    "), "\n")
            result.append(spaces)
            result.append("}\n\n")
        }

        for (rule in myNestedRules) {
            result.append(rule.toCssString(indent))
        }

        return result.toString()

    }

}

//---------------------------------------------------------------------------------------------------------------------

