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

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting border-bottom properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class BorderBottomStyleBuilder(
    private val style: Style
) {

    fun color(value: Color) =
        style.borderBottomColor(value)

    fun style(value: ELineStyle) =
        style.borderBottomStyle(value)

    fun width(value: ELineWidth) =
        style.borderBottomWidth(value)

    fun width(value: Length) =
        style.borderBottomWidth(value)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting border-left properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class BorderLeftStyleBuilder(
    private val style: Style
) {

    fun color(value: Color) =
        style.borderLeftColor(value)

    fun style(value: ELineStyle) =
        style.borderLeftStyle(value)

    fun width(value: ELineWidth) =
        style.borderLeftWidth(value)

    fun width(value: Length) =
        style.borderLeftWidth(value)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting border-right properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class BorderRightStyleBuilder(
    private val style: Style
) {

    fun color(value: Color) =
        style.borderRightColor(value)

    fun style(value: ELineStyle) =
        style.borderRightStyle(value)

    fun width(value: ELineWidth) =
        style.borderRightWidth(value)

    fun width(value: Length) =
        style.borderRightWidth(value)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting border-top properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class BorderTopStyleBuilder(
    private val style: Style
) {

    fun color(value: Color) =
        style.borderTopColor(value)

    fun style(value: ELineStyle) =
        style.borderTopStyle(value)

    fun width(value: ELineWidth) =
        style.borderTopWidth(value)

    fun width(value: Length) =
        style.borderTopWidth(value)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting border properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class BorderStyleBuilder(
    private val style: Style
) {

    fun bottom(build: BorderBottomStyleBuilder.() -> Unit) =
        BorderBottomStyleBuilder(style).build()

    fun bottom(lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderBottom(lineStyle, color)

    fun bottom(width: ELineWidth, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderBottom(width, lineStyle, color)

    fun bottom(width: Length, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderBottom(width, lineStyle, color)

    fun color(top: Color, right: Color = top, bottom: Color = top, left: Color = right) =
        style.borderColor(top, right, bottom, left)

    fun left(build: BorderLeftStyleBuilder.() -> Unit) =
        BorderLeftStyleBuilder(style).build()

    fun left(lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderLeft(lineStyle, color)

    fun left(width: ELineWidth, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderLeft(width, lineStyle, color)

    fun left(width: Length, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderLeft(width, lineStyle, color)

    fun right(build: BorderRightStyleBuilder.() -> Unit) =
        BorderRightStyleBuilder(style).build()

    fun right(lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderRight(lineStyle, color)

    fun right(width: ELineWidth, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderRight(width, lineStyle, color)

    fun right(width: Length, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderRight(width, lineStyle, color)

    fun style(top: ELineStyle, right: ELineStyle = top, bottom: ELineStyle = top, left: ELineStyle = right) =
        style.borderStyle(top, right, bottom, left)

    fun top(build: BorderTopStyleBuilder.() -> Unit) =
        BorderTopStyleBuilder(style).build()

    fun top(lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderTop(lineStyle, color)

    fun top(width: ELineWidth, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderTop(width, lineStyle, color)

    fun top(width: Length, lineStyle: ELineStyle? = null, color: Color? = null) =
        style.borderTop(width, lineStyle, color)

    fun width(top: ELineWidth, right: ELineWidth = top, bottom: ELineWidth = top, left: ELineWidth = right) =
        style.borderWidth(top, right, bottom, left)

    fun width(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
        style.borderWidth(top, right, bottom, left)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.border(build: BorderStyleBuilder.() -> Unit) =
    BorderStyleBuilder(this).build()

fun Style.border(style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border", "", style, color)

fun Style.border(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border", width, style, color)

fun Style.border(width: Length, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border", width, style, color)

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderBottom(style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-bottom", "", style, color)

fun Style.borderBottom(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-bottom", width, style, color)

fun Style.borderBottom(width: Length, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-bottom", width, style, color)

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderBottomColor(value: Color) =
    setProperty("border-bottom-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderBottomStyle(value: ELineStyle) =
    setProperty("border-bottom-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderBottomWidth(value: ELineWidth) =
    setProperty("border-bottom-width", "$value")

fun Style.borderBottomWidth(value: Length) =
    setProperty("border-bottom-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderColor(top: Color, right: Color = top, bottom: Color = top, left: Color = right) =
    setBoxProperty("border-color", top, right, bottom, left)

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderLeft(style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-left", "", style, color)

fun Style.borderLeft(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-left", width, style, color)

fun Style.borderLeft(width: Length, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-left", width, style, color)

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderLeftColor(value: Color) =
    setProperty("border-left-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderLeftStyle(value: ELineStyle) =
    setProperty("border-left-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderLeftWidth(value: ELineWidth) =
    setProperty("border-left-width", "$value")

fun Style.borderLeftWidth(value: Length) =
    setProperty("border-left-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderRight(style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-right", "", style, color)

fun Style.borderRight(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-right", width, style, color)

fun Style.borderRight(width: Length, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-right", width, style, color)

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderRightColor(value: Color) =
    setProperty("border-right-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderRightStyle(value: ELineStyle) =
    setProperty("border-right-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderRightWidth(value: ELineWidth) =
    setProperty("border-right-width", "$value")

fun Style.borderRightWidth(value: Length) =
    setProperty("border-right-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderStyle(top: ELineStyle, right: ELineStyle = top, bottom: ELineStyle = top, left: ELineStyle = right) =
    setBoxProperty("border-style", top, right, bottom, left)

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderTop(style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-top", "", style, color)

fun Style.borderTop(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-top", width, style, color)

fun Style.borderTop(width: Length, style: ELineStyle? = null, color: Color? = null) =
    setBorderProperty("border-top", width, style, color)

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderTopColor(value: Color) =
    setProperty("border-top-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderTopStyle(value: ELineStyle) =
    setProperty("border-top-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderTopWidth(value: ELineWidth) =
    setProperty("border-top-width", "$value")

fun Style.borderTopWidth(value: Length) =
    setProperty("border-top-width", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderWidth(top: ELineWidth, right: ELineWidth = top, bottom: ELineWidth = top, left: ELineWidth = right) =
    setBoxProperty("border-width", top, right, bottom, left)

fun Style.borderWidth(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
    setBoxProperty("border-width", top, right, bottom, left)

//---------------------------------------------------------------------------------------------------------------------

private fun <T> Style.setBorderProperty(key: String, width: T?, style: ELineStyle?, color: Color?) {

    var css = "$width"

    if (style != null) {
        css += " $style"
    }

    if (color != null) {
        css += " $color"
    }

    require(css.isNotEmpty()) { "Specify at least one non-null parameter for $key." }

    setProperty(key, css.trim())

}

//---------------------------------------------------------------------------------------------------------------------

