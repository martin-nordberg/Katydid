//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EAuto
import o.katydid.css.types.EPosition

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.bottom(value: Length) =
    setProperty("bottom", "$value")

fun KatydidStyle.bottom(value: Percentage) =
    setProperty("bottom", "$value")

fun KatydidStyle.bottom(value: EAuto) =
    setProperty("bottom", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.left(value: Length) =
    setProperty("left", "$value")

fun KatydidStyle.left(value: Percentage) =
    setProperty("left", "$value")

fun KatydidStyle.left(value: EAuto) =
    setProperty("left", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.position(value: EPosition) =
    setProperty("position", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.right(value: Length) =
    setProperty("right", "$value")

fun KatydidStyle.right(value: Percentage) =
    setProperty("right", "$value")

fun KatydidStyle.right(value: EAuto) =
    setProperty("right", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.top(value: Length) =
    setProperty("top", "$value")

fun KatydidStyle.top(value: Percentage) =
    setProperty("top", "$value")

fun KatydidStyle.top(value: EAuto) =
    setProperty("top", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.zIndex(value: Int) =
    setProperty("z-index", "$value")

fun KatydidStyle.zIndex(value: EAuto) =
    setProperty("z-index", "$value")

//---------------------------------------------------------------------------------------------------------------------

