//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.ELineStyle
import o.katydid.css.types.ELineWidth
import o.katydid.css.types.EOutlineColor

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting outline properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidOutlineStyleBuilder(
    private val style: KatydidStyle
) {

    fun color(value: Color) =
        style.outlineColor(value)

    fun color(value: EOutlineColor) =
        style.outlineColor(value)

    fun offset(value: Length) =
        style.outlineOffset(value)

    fun style(value: ELineStyle) =
        style.outlineStyle(value)

    fun width(value: ELineWidth) =
        style.outlineWidth(value)

    fun width(value: Length) =
        style.outlineWidth(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.outline(build: KatydidOutlineStyleBuilder.() -> Unit) =
    KatydidOutlineStyleBuilder(this).build()

fun KatydidStyle.outline(color: Color, style: ELineStyle, width: ELineWidth) =
    setProperty("outline", "$color $style $width")

fun KatydidStyle.outline(color: EOutlineColor, style: ELineStyle, width: ELineWidth) =
    setProperty("outline", "$color $style $width")

fun KatydidStyle.outline(color: Color, style: ELineStyle, width: Length) =
    setProperty("outline", "$color $style $width")

fun KatydidStyle.outline(color: EOutlineColor, style: ELineStyle, width: Length) =
    setProperty("outline", "$color $style $width")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.outlineColor(value: Color) =
    setProperty("outline-color", "$value")

fun KatydidStyle.outlineColor(value: EOutlineColor) =
    setProperty("outline-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.outlineOffset(value: Length) =
    setProperty("outline-offset", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.outlineStyle(value: ELineStyle) =
    setProperty("outline-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.outlineWidth(value: ELineWidth) =
    setProperty("outline-width", "$value")

fun KatydidStyle.outlineWidth(value: Length) =
    setProperty("outline-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

