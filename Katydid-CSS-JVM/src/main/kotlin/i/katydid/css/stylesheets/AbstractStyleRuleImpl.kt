//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import i.katydid.css.styles.StyleImpl
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.stylesheets.AbstractStyleRule
import o.katydid.css.stylesheets.StyleRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one abstract style rule (placeholder or concrete style rule) in a larger style sheet.
 */
@StyleBuilderDsl
internal abstract class AbstractStyleRuleImpl(
    itsParent: CompositeCssRuleImpl
) : CompositeCssRuleImpl(), AbstractStyleRule, Style by StyleImpl() {

    /** The rules nested inside this one. */
    private val myNestedRules: MutableList<CompositeCssRuleImpl> = mutableListOf()

    /** The selectors of this rule. */
    private val mySelectors: MutableList<String> = mutableListOf()

    ////

    override val parent = itsParent

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

    override val nestedRules: List<CompositeCssRuleImpl> = myNestedRules

    internal val selectors: List<String> = mySelectors

    ////

    internal fun addNestedRule(nestedRule: CompositeCssRuleImpl) {
        myNestedRules.add(nestedRule)
    }

    internal fun addNestedRules(addedNestedRules: Collection<CompositeCssRuleImpl>) {
        myNestedRules.addAll(addedNestedRules)
    }

    internal fun addSelectors(addedSelectors: Collection<String>) {
        mySelectors.addAll(addedSelectors)
        afterAddSelectors(addedSelectors)
    }

    internal open fun afterAddSelectors(addedSelectors: Collection<String>) {}

    override operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style rule.
        val result = StyleRuleImpl(this@AbstractStyleRuleImpl)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule inside this one.
        this@AbstractStyleRuleImpl.myNestedRules.add(result)

        // Build its style.
        result.build()

        return result

    }

    override infix fun String.or(that: String) =
        this + ", " + that

    override infix fun String.or(styleRule: StyleRule): StyleRule {

        (styleRule as StyleRuleImpl).prependSelectors(this)

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

    override fun toCssString(indent: Int): String {

        val result = StringBuilder("")

        val spaces = "                    ".substring(0, indent)

        val finalSelectors = fullSelectors

        if (isNotEmpty && finalSelectors.isNotEmpty()) {
            result.append(spaces)
            result.append(finalSelectors.joinToString(",\n$spaces"))
            result.append(" {\n")
            result.append(toCssString("$spaces    "), "\n")
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

