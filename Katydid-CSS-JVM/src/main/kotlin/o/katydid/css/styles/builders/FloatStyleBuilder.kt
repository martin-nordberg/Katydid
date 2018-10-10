//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.types.EClear
import o.katydid.css.types.EFloat

//---------------------------------------------------------------------------------------------------------------------

fun Style.clear(value: EClear) =
    setProperty("clear", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.float(value: EFloat) =
    setProperty("float", "$value")

//---------------------------------------------------------------------------------------------------------------------
