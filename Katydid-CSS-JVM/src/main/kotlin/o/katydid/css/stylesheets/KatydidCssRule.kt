//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

//---------------------------------------------------------------------------------------------------------------------

/**
 * A rule of any type (at-rule or style rule) in a style sheet, or the style sheet itself.
 */
interface KatydidCssRule {

    /** The parent rule containing this rule. */
    val parent: KatydidCompositeCssRule

    ////

    /** Makes a copy of this rule, placing the copy as a child of [parentOfCopy]. */
    fun copy(parentOfCopy: KatydidCompositeCssRule): KatydidCssRule

    /** Converts this rule to CSS. */
    fun toCssString(indent: Int = 0): String

}

//---------------------------------------------------------------------------------------------------------------------

