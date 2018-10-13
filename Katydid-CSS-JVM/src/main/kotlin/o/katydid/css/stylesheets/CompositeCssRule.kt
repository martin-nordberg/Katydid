//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * A CSS rule that potentially has other CSS rules nested inside it.
 */
@StyleBuilderDsl
abstract class CompositeCssRule : CssRule() {

    /**
     * Returns a list of the full-path selectors for this rule, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple selectors (comma separated in the eventual CSS) at each level.
     */
    abstract val fullSelectors: List<String>

    /** The child rules nested within this parent rule. */
    abstract val nestedRules: List<CssRule>

    ////

    abstract override fun copy(parentOfCopy: CompositeCssRule): CompositeCssRule

    /** Finds the placeholder with given [placeholderName]. */
    fun findPlaceholder(placeholderName: String): PlaceholderRule? {

        for (rule in nestedRules) {

            if (rule is PlaceholderRule && rule.name == placeholderName) {
                return rule
            }

        }

        return null

    }

}

//---------------------------------------------------------------------------------------------------------------------

