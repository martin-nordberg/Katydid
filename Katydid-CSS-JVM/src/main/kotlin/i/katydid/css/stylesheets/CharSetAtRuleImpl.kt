//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.stylesheets.CharSetAtRule
import o.katydid.css.stylesheets.CompositeCssRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing the @charset declaration at the beginning of a style sheet.
 */
@StyleBuilderDsl
class CharSetAtRuleImpl(
    override val parent: CompositeCssRuleImpl,
    override val characterSet: String
) : CharSetAtRule {

    init {
        require(parent.nestedRules.isEmpty()) { "A @charset at-rule must be the first rule in a style sheet." }
    }

    ////

    override fun copy(parentOfCopy: CompositeCssRule) =
        CharSetAtRuleImpl(parentOfCopy as CompositeCssRuleImpl, characterSet)

    override fun toCssString(indent: Int): String =
        "@charset \"$characterSet\";\n\n"

}

//---------------------------------------------------------------------------------------------------------------------

