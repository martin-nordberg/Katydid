//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Represents a CSS style sheet with SASS-like provisions to build style rules from string selectors and
 * styles.
 */
@StyleBuilderDsl
class StyleSheet : CompositeCssRule() {

    override val fullSelectors: List<String> = emptyList()

    override val nestedRules: MutableList<CssRule> = mutableListOf()

    override val parent: CompositeCssRule
        get() = throw UnsupportedOperationException("A style sheet has no parent rule.")

    ////

    /** Creates a @charset at-rule. Must occur at the start of a stylesheet. */
    fun charset(characterSet: String): CharSetAtRule {
        val result = CharSetAtRule(this, characterSet)
        this.nestedRules.add(result)
        return result
    }

    override fun copy(parentOfCopy: CompositeCssRule): StyleSheet =
        throw UnsupportedOperationException("A style sheet cannot be copied inside another style rule.")

    /** Includes the contents of another [styleSheet] directly in this one. */
    fun include(styleSheet: StyleSheet) {

        for (rule in styleSheet.nestedRules) {

            if (rule is AbstractStyleRule) {
                nestedRules.add(rule.copy(this))
            }
            else if (rule is CharSetAtRule && nestedRules.isEmpty()) {
                nestedRules.add(rule.copy(this))
            }
            else if (rule is MediaAtRule) {
                nestedRules.add(rule.copy(this))
            }

        }

    }

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style rule.
        val result = StyleRule(this@StyleSheet)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new rule in this style sheet.
        this@StyleSheet.nestedRules.add(result)

        // Build its style.
        result.build()

        return result

    }

    fun media(condition: String, build: MediaAtRule.() -> Unit): MediaAtRule {
        val result = MediaAtRule(this, condition)
        this.nestedRules.add(result)
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

    /** Builds a placeholder rule from a selector and the [build] function for the rule. */
    fun placeholder(name: String, build: PlaceholderRule.() -> Unit): String {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = PlaceholderRule(this, name)

        // Nest the new placeholder in this style sheet.
        this.nestedRules.add(result)

        // Build its style.
        result.build()

        return name

    }

    override fun toCssString(indent: Int): String {

        val result = StringBuilder("")

        for (rule in nestedRules) {
            result.append(rule.toCssString(indent))
        }

        return result.toString()

    }

    override fun toString(): String =
        toCssString()

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style sheet object.
 * @param build the callback that fills in the CSS selectors and properties.
 */
fun makeStyleSheet(
    build: StyleSheet.() -> Unit
): StyleSheet {

    val result = StyleSheet()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

