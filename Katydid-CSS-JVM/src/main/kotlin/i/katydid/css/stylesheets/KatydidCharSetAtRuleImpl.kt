//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl
import o.katydid.css.stylesheets.KatydidCharSetAtRule
import o.katydid.css.stylesheets.KatydidCompositeCssRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing the @charset declaration at the beginning of a style sheet.
 */
@KatydidStyleBuilderDsl
class KatydidCharSetAtRuleImpl(
    override val parent: KatydidCompositeCssRuleImpl,
    override val characterSet: String
) : KatydidCharSetAtRule {

    init {
        require(parent.nestedRules.isEmpty()) { "A @charset at-rule must be the first rule in a style sheet." }
    }

    ////

    override fun copy(parentOfCopy: KatydidCompositeCssRule) =
        KatydidCharSetAtRuleImpl(parentOfCopy as KatydidCompositeCssRuleImpl, characterSet)

    override fun toCssString(indent: Int): String =
        "@charset \"$characterSet\";\n\n"

}

//---------------------------------------------------------------------------------------------------------------------

