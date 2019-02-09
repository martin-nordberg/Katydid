//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl
import o.katydid.css.stylesheets.KatydidMediaAtRule
import o.katydid.css.stylesheets.KatydidPlaceholderRule
import o.katydid.css.stylesheets.KatydidStyleRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@KatydidStyleBuilderDsl
internal class KatydidMediaAtRuleImpl(
    itsParent: KatydidCompositeCssRuleImpl,
    itsCondition: String
) : KatydidCompositeCssRuleImpl(), KatydidMediaAtRule {

    /** The rules nested inside this one. */
    private val myNestedRules: MutableList<KatydidCompositeCssRuleImpl> = mutableListOf()

    ////

    override val condition = itsCondition

    override val fullSelectors: List<String> = emptyList()

    override val nestedRules: List<KatydidCompositeCssRuleImpl> = myNestedRules

    override val parent = itsParent

    ////

    private fun addNestedRule(nestedRule: KatydidCompositeCssRuleImpl) {
        myNestedRules.add(nestedRule)
    }

    private fun addNestedRules(addedNestedRules: Collection<KatydidCompositeCssRuleImpl>) {
        myNestedRules.addAll(addedNestedRules)
    }

    override fun copy(parentOfCopy: KatydidCompositeCssRuleImpl): KatydidMediaAtRuleImpl {

        val result = KatydidMediaAtRuleImpl(parentOfCopy, condition)

        result.addNestedRules(nestedRules.map { b -> b.copy(result) })

        return result

    }

    override operator fun String.invoke(build: KatydidStyleRule.() -> Unit): KatydidStyleRule {

        // Create the new style rule.
        val result = KatydidStyleRuleImpl(this@KatydidMediaAtRuleImpl)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule inside this one.
        this@KatydidMediaAtRuleImpl.myNestedRules.add(result)

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

    override fun placeholder(name: String, build: KatydidPlaceholderRule.() -> Unit) {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = KatydidPlaceholderRuleImpl(this, name)

        // Nest the new placeholder in this style sheet.
        this.addNestedRule(result)

        // Build its style.
        result.build()

    }

    override fun toCssString(indent: Int): String {

        val result = StringBuilder("")

        val spaces = "                    ".substring(0, indent)

        result.append(spaces)
        result.append("@media ")
        result.append(condition)
        result.append(" {\n\n")

        for (rule in myNestedRules) {
            result.append(rule.toCssString(indent + 4))
        }

        result.append(spaces)
        result.append("}\n\n")

        return result.toString()

    }

}

//---------------------------------------------------------------------------------------------------------------------

