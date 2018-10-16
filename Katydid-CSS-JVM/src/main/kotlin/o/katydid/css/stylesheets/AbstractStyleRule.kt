//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one abstract style rule (placeholder or concrete style rule) in a larger style sheet.
 */
@StyleBuilderDsl
interface AbstractStyleRule
    : CompositeCssRule, Style {

    /**
     * Extends one or more style rules that have placeholder selectors [placeholderNames] with the selectors of this
     * style rule. The extended placeholder rules must be previously occurring siblings of this rule.
     */
    fun extend(vararg placeholderNames: String)

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String): String

    /** Combines a selector with an already created [styleRule] by adding the selector to the rule. */
    infix fun String.or(styleRule: StyleRule): StyleRule

}

//---------------------------------------------------------------------------------------------------------------------

