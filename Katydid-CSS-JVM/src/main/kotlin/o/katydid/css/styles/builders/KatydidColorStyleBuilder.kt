//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.colors.Color
import o.katydid.css.styles.KatydidStyle
import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.color(value: Color) =
    setProperty("color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.opacity(value: Float) =
    when {
        value <= 0 -> setProperty("opacity", "0")
        value >= 1 -> setProperty("opacity", "1")
        else       -> setProperty("opacity", makeDecimalString(value))
    }


//---------------------------------------------------------------------------------------------------------------------

