//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import i.katydid.css.stylesheets.StyleSheetImpl
import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Represents a CSS style sheet with SASS-like provisions to build style rules from string selectors and
 * styles.
 */
@StyleBuilderDsl
interface StyleSheet
    : CompositeCssRule {

    /** Creates a @charset at-rule. Must occur at the start of a stylesheet. */
    fun charset(characterSet: String): CharSetAtRule

    /** Includes the contents of another [styleSheet] directly in this one. */
    fun include(styleSheet: StyleSheet)

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule

    /** Creates a @media at-rule with given [condition]. The style block of the rule is computed by [build]. */
    fun media(condition: String, build: MediaAtRule.() -> Unit): MediaAtRule

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String): String

    /** Combines a selector with an already created [styleRule] by adding the selector to the rule. */
    infix fun String.or(styleRule: StyleRule): StyleRule

    /** Builds a placeholder rule from a selector and the [build] function for the rule. */
    fun placeholder(name: String, build: PlaceholderRule.() -> Unit): String

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style sheet object.
 * @param build the callback that fills in the CSS selectors and properties.
 */
fun makeStyleSheet(
    build: StyleSheet.() -> Unit
): StyleSheet {

    val result = StyleSheetImpl()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

