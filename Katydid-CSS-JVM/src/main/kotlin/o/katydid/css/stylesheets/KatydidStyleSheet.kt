//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import i.katydid.css.stylesheets.KatydidStyleSheetImpl
import o.katydid.css.styles.builders.KatydidStyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Represents a CSS style sheet with SASS-like provisions to build style rules from string selectors and
 * styles.
 */
@KatydidStyleBuilderDsl
interface KatydidStyleSheet
    : KatydidCompositeCssRule {

    /** Creates a @charset at-rule. Must occur at the start of a stylesheet. */
    fun charset(characterSet: String): KatydidCharSetAtRule

    /** Includes the contents of another [styleSheet] directly in this one. */
    fun include(styleSheet: KatydidStyleSheet)

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: KatydidStyleRule.() -> Unit): KatydidStyleRule

    /** Creates a @media at-rule with given [condition]. The style block of the rule is computed by [build]. */
    fun media(condition: String, build: KatydidMediaAtRule.() -> Unit): KatydidMediaAtRule

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String): String

    /** Combines a selector with an already created [styleRule] by adding the selector to the rule. */
    infix fun String.or(styleRule: KatydidStyleRule): KatydidStyleRule

    /** Builds a placeholder rule from a selector and the [build] function for the rule. */
    fun placeholder(name: String, build: KatydidPlaceholderRule.() -> Unit): String

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style sheet object.
 * @param build the callback that fills in the CSS selectors and properties.
 */
fun makeStyleSheet(
    build: KatydidStyleSheet.() -> Unit
): KatydidStyleSheet {

    val result = KatydidStyleSheetImpl()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

