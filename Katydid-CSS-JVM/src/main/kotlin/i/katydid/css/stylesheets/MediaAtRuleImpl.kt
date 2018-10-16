//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.stylesheets.MediaAtRule
import o.katydid.css.stylesheets.PlaceholderRule
import o.katydid.css.stylesheets.StyleRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@StyleBuilderDsl
class MediaAtRuleImpl(
    itsParent: CompositeCssRuleImpl,
    itsCondition: String
) : CompositeCssRuleImpl(), MediaAtRule {

    /** The rules nested inside this one. */
    private val myNestedRules: MutableList<CompositeCssRuleImpl> = mutableListOf()

    ////

    override val condition = itsCondition

    override val fullSelectors: List<String> = emptyList()

    override val nestedRules: List<CompositeCssRuleImpl> = myNestedRules

    override val parent = itsParent

    ////

    private fun addNestedRule(nestedRule: CompositeCssRuleImpl) {
        myNestedRules.add(nestedRule)
    }

    private fun addNestedRules(addedNestedRules: Collection<CompositeCssRuleImpl>) {
        myNestedRules.addAll(addedNestedRules)
    }

    override fun copy(parentOfCopy: CompositeCssRuleImpl): MediaAtRuleImpl {

        val result = MediaAtRuleImpl(parentOfCopy, condition)

        result.addNestedRules(nestedRules.map { b -> b.copy(result) })

        return result

    }

    override operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style rule.
        val result = StyleRuleImpl(this@MediaAtRuleImpl)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule inside this one.
        this@MediaAtRuleImpl.myNestedRules.add(result)

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

    override fun placeholder(name: String, build: PlaceholderRule.() -> Unit) {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = PlaceholderRuleImpl(this, name)

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

