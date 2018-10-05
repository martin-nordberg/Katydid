//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.Style
import o.katydid.css.types.EAuto
import o.katydid.css.types.EPosition

//---------------------------------------------------------------------------------------------------------------------

fun Style.bottom(value: Length) =
    setProperty("bottom", "$value")

fun Style.bottom(value: Percentage) =
    setProperty("bottom", "$value")

fun Style.bottom(value: EAuto) =
    setProperty("bottom", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.left(value: Length) =
    setProperty("left", "$value")

fun Style.left(value: Percentage) =
    setProperty("left", "$value")

fun Style.left(value: EAuto) =
    setProperty("left", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.position(value: EPosition) =
    setProperty("position", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.right(value: Length) =
    setProperty("right", "$value")

fun Style.right(value: Percentage) =
    setProperty("right", "$value")

fun Style.right(value: EAuto) =
    setProperty("right", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.top(value: Length) =
    setProperty("top", "$value")

fun Style.top(value: Percentage) =
    setProperty("top", "$value")

fun Style.top(value: EAuto) =
    setProperty("top", "$value")

//---------------------------------------------------------------------------------------------------------------------

