//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EClear
import o.katydid.css.types.EFloat

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.clear(value: EClear) =
    setProperty("clear", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.float(value: EFloat) =
    setProperty("float", "$value")

//---------------------------------------------------------------------------------------------------------------------
