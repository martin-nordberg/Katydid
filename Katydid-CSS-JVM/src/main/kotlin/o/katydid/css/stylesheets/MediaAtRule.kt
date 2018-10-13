//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@StyleBuilderDsl
class MediaAtRule(
    override val parent: CompositeCssRule,
    val condition: String
) : CompositeCssRule() {

    /** The rules nested inside this one. */
    private val myNestedRules: MutableList<CompositeCssRule> = mutableListOf()

    ////

    override val fullSelectors: List<String> = emptyList()

    override val nestedRules: List<CompositeCssRule> = myNestedRules

    ////

    internal fun addNestedRule(nestedRule: CompositeCssRule) {
        myNestedRules.add(nestedRule)
    }

    internal fun addNestedRules(addedNestedRules: Collection<CompositeCssRule>) {
        myNestedRules.addAll(addedNestedRules)
    }

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style rule.
        val result = StyleRule(this@MediaAtRule)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule inside this one.
        this@MediaAtRule.myNestedRules.add(result)

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

    /** Converts this style rule to CSS. */
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

    override fun copy(parentOfCopy: CompositeCssRule): MediaAtRule {

        val result = MediaAtRule(parentOfCopy, condition)

        result.addNestedRules(nestedRules.map { b -> b.copy(result) })

        return result

    }

    /** Builds a placeholder rule from a selector [name] and the [build] function for the rule. */
    fun placeholder(name: String, build: PlaceholderRule.() -> Unit) {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = PlaceholderRule(this, name)

        // Nest the new placeholder in this style sheet.
        this.addNestedRule(result)

        // Build its style.
        result.build()

    }

}

//---------------------------------------------------------------------------------------------------------------------

