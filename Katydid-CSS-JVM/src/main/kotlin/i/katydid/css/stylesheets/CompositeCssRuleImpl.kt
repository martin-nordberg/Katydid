//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.stylesheets.CompositeCssRule

//---------------------------------------------------------------------------------------------------------------------

/**
 * A CSS rule that potentially has other CSS rules nested inside it.
 */
@StyleBuilderDsl
abstract class CompositeCssRuleImpl
    : CompositeCssRule {

    override fun copy(parentOfCopy: CompositeCssRule): CompositeCssRuleImpl =
        copy(parentOfCopy as CompositeCssRuleImpl)

    /** Delegated copy function with more concrete [parentOfCopy] parameter. */
    abstract fun copy(parentOfCopy: CompositeCssRuleImpl): CompositeCssRuleImpl

    /** Finds the placeholder with given [placeholderName]. */
    internal fun findPlaceholder(placeholderName: String): PlaceholderRuleImpl? {

        for (rule in nestedRules) {

            if (rule is PlaceholderRuleImpl && rule.name == placeholderName) {
                return rule
            }

        }

        return null

    }

}

//---------------------------------------------------------------------------------------------------------------------

