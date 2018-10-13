//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

//---------------------------------------------------------------------------------------------------------------------

/**
 * A rule of any type (at-rule or style rule) in a style sheet, or the style sheet itself.
 */
abstract class CssRule {

    /** The parent rule containing this rule. */
    abstract val parent: CompositeCssRule

    ////

    /** Makes a copy of this rule, placing the copy as a child of [parentOfCopy]. */
    abstract fun copy(parentOfCopy: CompositeCssRule): CssRule

    /** Converts this rule to CSS. */
    abstract fun toCssString(): String

}

//---------------------------------------------------------------------------------------------------------------------

