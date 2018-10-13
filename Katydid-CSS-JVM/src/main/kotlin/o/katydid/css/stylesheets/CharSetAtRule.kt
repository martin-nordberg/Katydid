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
class CharSetAtRule(
    override val parent: CompositeCssRule,
    internal val characterSet: String
) : CssRule() {

    init {
        require( parent.nestedRules.isEmpty() ) { "A @charset at-rule must be the first rule in a style sheet." }
    }

    ////

    override fun copy(parentOfCopy: CompositeCssRule) =
        CharSetAtRule(parentOfCopy,characterSet)

    override fun toCssString(): String =
        "@charset \"$characterSet\";\n\n"

}

//---------------------------------------------------------------------------------------------------------------------

