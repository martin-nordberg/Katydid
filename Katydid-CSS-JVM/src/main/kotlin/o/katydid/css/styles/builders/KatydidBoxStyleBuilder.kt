//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EBoxSizing

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.boxSizing(value: EBoxSizing) =
    setProperty("box-sizing", "$value")

//---------------------------------------------------------------------------------------------------------------------
