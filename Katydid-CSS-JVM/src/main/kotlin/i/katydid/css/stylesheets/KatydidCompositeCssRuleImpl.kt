//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl
import o.katydid.css.stylesheets.KatydidCompositeCssRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * A CSS rule that potentially has other CSS rules nested inside it.
 */
@KatydidStyleBuilderDsl
internal abstract class KatydidCompositeCssRuleImpl
    : KatydidCompositeCssRule {

    override fun copy(parentOfCopy: KatydidCompositeCssRule): KatydidCompositeCssRuleImpl =
        copy(parentOfCopy as KatydidCompositeCssRuleImpl)

    /** Delegated copy function with more concrete [parentOfCopy] parameter. */
    abstract fun copy(parentOfCopy: KatydidCompositeCssRuleImpl): KatydidCompositeCssRuleImpl

    /** Finds the placeholder with given [placeholderName]. */
    internal fun findPlaceholder(placeholderName: String): KatydidPlaceholderRuleImpl? {

        for (rule in nestedRules) {

            if (rule is KatydidPlaceholderRuleImpl && rule.name == placeholderName) {
                return rule
            }

        }

        return null

    }

}

//---------------------------------------------------------------------------------------------------------------------

