//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@StyleBuilderDsl
interface PlaceholderRule
    : AbstractStyleRule {

    /** The name or "placeholder selector" for this placeholder rule. */
    val name: String

}

//---------------------------------------------------------------------------------------------------------------------

