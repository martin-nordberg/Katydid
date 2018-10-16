//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing the @charset declaration at the beginning of a style sheet.
 */
@StyleBuilderDsl
interface CharSetAtRule
    : CssRule {

    /** The (unquoted) character set of the rule. */
    val characterSet: String

}

//---------------------------------------------------------------------------------------------------------------------

