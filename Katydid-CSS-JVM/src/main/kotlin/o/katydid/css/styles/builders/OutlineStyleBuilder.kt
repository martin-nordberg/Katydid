//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.styles.Style
import o.katydid.css.types.ELineStyle
import o.katydid.css.types.ELineWidth
import o.katydid.css.types.EOutlineColor

//---------------------------------------------------------------------------------------------------------------------

@StyleBuilderDsl
class OutlineStyleBuilder(
    private val style: Style
) {

    fun color(value: Color) =
        style.outlineColor(value)

    fun color(value: EOutlineColor) =
        style.outlineColor(value)

    fun Style.offset(value: Length) =
        style.outlineOffset(value)

    fun style(value: ELineStyle) =
        style.outlineStyle(value)

    fun width(value: ELineWidth) =
        style.outlineWidth(value)

    fun width(value: Length) =
        style.outlineWidth(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.outline(build: OutlineStyleBuilder.() -> Unit) =
    OutlineStyleBuilder(this).build()

fun Style.outline(color: Color, style: ELineStyle, width: ELineWidth) =
    setProperty("outline", "$color $style $width")

fun Style.outline(color: EOutlineColor, style: ELineStyle, width: ELineWidth) =
    setProperty("outline", "$color $style $width")

fun Style.outline(color: Color, style: ELineStyle, width: Length) =
    setProperty("outline", "$color $style $width")

fun Style.outline(color: EOutlineColor, style: ELineStyle, width: Length) =
    setProperty("outline", "$color $style $width")

//---------------------------------------------------------------------------------------------------------------------

fun Style.outlineColor(value: Color) =
    setProperty("outline-color", "$value")

fun Style.outlineColor(value: EOutlineColor) =
    setProperty("outline-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.outlineOffset(value: Length) =
    setProperty("outline-offset", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.outlineStyle(value: ELineStyle) =
    setProperty("outline-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.outlineWidth(value: ELineWidth) =
    setProperty("outline-width", "$value")

fun Style.outlineWidth(value: Length) =
    setProperty("outline-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

