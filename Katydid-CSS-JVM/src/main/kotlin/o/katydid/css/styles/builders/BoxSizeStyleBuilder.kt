//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.Style
import o.katydid.css.types.EAuto
import o.katydid.css.types.EBoxSize
import o.katydid.css.types.EBoxSizing
import o.katydid.css.types.ENone

//---------------------------------------------------------------------------------------------------------------------

fun Style.boxSizing(value: EBoxSizing) =
    setProperty("box-sizing", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.height(value: Length) =
    setProperty("height", "$value")

fun Style.height(value: Percentage) =
    setProperty("height", "$value")

fun Style.height(value: EAuto) =
    setProperty("height", "$value")

fun Style.height(value: EBoxSize) =
    setProperty("height", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.maxHeight(value: Length) =
    setProperty("max-height", "$value")

fun Style.maxHeight(value: Percentage) =
    setProperty("max-height", "$value")

fun Style.maxHeight(value: ENone) =
    setProperty("max-height", "$value")

fun Style.maxHeight(value: EBoxSize) =
    setProperty("max-height", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.maxWidth(value: Length) =
    setProperty("max-width", "$value")

fun Style.maxWidth(value: Percentage) =
    setProperty("max-width", "$value")

fun Style.maxWidth(value: ENone) =
    setProperty("max-width", "$value")

fun Style.maxWidth(value: EBoxSize) =
    setProperty("max-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.minHeight(value: Length) =
    setProperty("min-height", "$value")

fun Style.minHeight(value: Percentage) =
    setProperty("min-height", "$value")

fun Style.minHeight(value: EAuto) =
    setProperty("min-height", "$value")

fun Style.minHeight(value: EBoxSize) =
    setProperty("min-height", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.minWidth(value: Length) =
    setProperty("min-width", "$value")

fun Style.minWidth(value: Percentage) =
    setProperty("min-width", "$value")

fun Style.minWidth(value: EAuto) =
    setProperty("min-width", "$value")

fun Style.minWidth(value: EBoxSize) =
    setProperty("min-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.width(value: Length) =
    setProperty("width", "$value")

fun Style.width(value: Percentage) =
    setProperty("width", "$value")

fun Style.width(value: EAuto) =
    setProperty("width", "$value")

fun Style.width(value: EBoxSize) =
    setProperty("width", "$value")

//---------------------------------------------------------------------------------------------------------------------
