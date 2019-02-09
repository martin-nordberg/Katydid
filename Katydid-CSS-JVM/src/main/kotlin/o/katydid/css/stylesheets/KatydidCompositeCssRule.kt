//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * A CSS rule that potentially has other CSS rules nested inside it.
 */
@KatydidStyleBuilderDsl
interface KatydidCompositeCssRule
    : KatydidCssRule {

    /**
     * Returns a list of the full-path selectors for this rule, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple selectors (comma separated in the eventual CSS) at each level.
     */
    val fullSelectors: List<String>

    /** The child rules nested within this parent rule. */
    val nestedRules: List<KatydidCssRule>

}

//---------------------------------------------------------------------------------------------------------------------

