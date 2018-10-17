//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EAuto
import o.katydid.css.types.EBoxSize
import o.katydid.css.types.ENone

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.height(value: Length) =
    setProperty("height", "$value")

fun KatydidStyle.height(value: Percentage) =
    setProperty("height", "$value")

fun KatydidStyle.height(value: EAuto) =
    setProperty("height", "$value")

fun KatydidStyle.height(value: EBoxSize) =
    setProperty("height", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.maxHeight(value: Length) =
    setProperty("max-height", "$value")

fun KatydidStyle.maxHeight(value: Percentage) =
    setProperty("max-height", "$value")

fun KatydidStyle.maxHeight(value: ENone) =
    setProperty("max-height", "$value")

fun KatydidStyle.maxHeight(value: EBoxSize) =
    setProperty("max-height", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.maxWidth(value: Length) =
    setProperty("max-width", "$value")

fun KatydidStyle.maxWidth(value: Percentage) =
    setProperty("max-width", "$value")

fun KatydidStyle.maxWidth(value: ENone) =
    setProperty("max-width", "$value")

fun KatydidStyle.maxWidth(value: EBoxSize) =
    setProperty("max-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.minHeight(value: Length) =
    setProperty("min-height", "$value")

fun KatydidStyle.minHeight(value: Percentage) =
    setProperty("min-height", "$value")

fun KatydidStyle.minHeight(value: EAuto) =
    setProperty("min-height", "$value")

fun KatydidStyle.minHeight(value: EBoxSize) =
    setProperty("min-height", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.minWidth(value: Length) =
    setProperty("min-width", "$value")

fun KatydidStyle.minWidth(value: Percentage) =
    setProperty("min-width", "$value")

fun KatydidStyle.minWidth(value: EAuto) =
    setProperty("min-width", "$value")

fun KatydidStyle.minWidth(value: EBoxSize) =
    setProperty("min-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.width(value: Length) =
    setProperty("width", "$value")

fun KatydidStyle.width(value: Percentage) =
    setProperty("width", "$value")

fun KatydidStyle.width(value: EAuto) =
    setProperty("width", "$value")

fun KatydidStyle.width(value: EBoxSize) =
    setProperty("width", "$value")

//---------------------------------------------------------------------------------------------------------------------
