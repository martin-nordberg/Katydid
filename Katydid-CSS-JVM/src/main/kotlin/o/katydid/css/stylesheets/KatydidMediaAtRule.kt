//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@KatydidStyleBuilderDsl
interface KatydidMediaAtRule
    : KatydidCompositeCssRule {

    /** The text of the media rule condition. */
    val condition: String

    ////

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: KatydidStyleRule.() -> Unit): KatydidStyleRule

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String): String

    /** Combines a selector with an already created [styleRule] by adding the selector to the rule. */
    infix fun String.or(styleRule: KatydidStyleRule): KatydidStyleRule

    /** Builds a placeholder rule from a selector [name] and the [build] function for the rule. */
    fun placeholder(name: String, build: KatydidPlaceholderRule.() -> Unit)

}

//---------------------------------------------------------------------------------------------------------------------

