//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import i.katydid.css.styles.KatydidStyleImpl
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.KatydidStyleBuilderDsl
import o.katydid.css.stylesheets.KatydidAbstractStyleRule
import o.katydid.css.stylesheets.KatydidStyleRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one abstract style rule (placeholder or concrete style rule) in a larger style sheet.
 */
@KatydidStyleBuilderDsl
internal abstract class KatydidAbstractStyleRuleImpl(
    itsParent: KatydidCompositeCssRuleImpl
) : KatydidCompositeCssRuleImpl(), KatydidAbstractStyleRule, KatydidStyle by KatydidStyleImpl() {

    /** The rules nested inside this one. */
    private val myNestedRules: MutableList<KatydidCompositeCssRuleImpl> = mutableListOf()

    /** The selectors of this rule. */
    private val mySelectors: MutableList<String> = mutableListOf()

    ////

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

    override val nestedRules: List<KatydidCompositeCssRuleImpl> = myNestedRules

    override val parent = itsParent

    internal val selectors: List<String> = mySelectors

    ////

    internal fun addNestedRule(nestedRule: KatydidCompositeCssRuleImpl) {
        myNestedRules.add(nestedRule)
    }

    internal fun addNestedRules(addedNestedRules: Collection<KatydidCompositeCssRuleImpl>) {
        myNestedRules.addAll(addedNestedRules)
    }

    internal fun addSelectors(addedSelectors: Collection<String>) {
        mySelectors.addAll(addedSelectors)
        afterAddSelectors(addedSelectors)
    }

    internal open fun afterAddSelectors(addedSelectors: Collection<String>) {}

    override operator fun String.invoke(build: KatydidStyleRule.() -> Unit): KatydidStyleRule {

        // Create the new style rule.
        val result = KatydidStyleRuleImpl(this@KatydidAbstractStyleRuleImpl)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule inside this one.
        this@KatydidAbstractStyleRuleImpl.myNestedRules.add(result)

        // Build its style.
        result.build()

        return result

    }

    override infix fun String.or(that: String) =
        this + ", " + that

    override infix fun String.or(styleRule: KatydidStyleRule): KatydidStyleRule {

        (styleRule as KatydidStyleRuleImpl).prependSelectors(this)

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

