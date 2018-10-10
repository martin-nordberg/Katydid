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

    fun Style.bottom(build: BorderBottomStyleBuilder.() -> Unit) =
        BorderBottomStyleBuilder(this).build()

    fun Style.bottom(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-bottom", "", style, color)

    fun Style.bottom(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-bottom", width, style, color)

    fun Style.bottom(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-bottom", width, style, color)

    fun Style.color(top: Color, right: Color = top, bottom: Color = top, left: Color = right) =
        setBoxProperty("border-color", top, right, bottom, left)

    fun Style.left(build: BorderLeftStyleBuilder.() -> Unit) =
        BorderLeftStyleBuilder(this).build()

    fun Style.left(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-left", "", style, color)

    fun Style.left(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-left", width, style, color)

    fun Style.left(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-left", width, style, color)

    fun Style.right(build: BorderRightStyleBuilder.() -> Unit) =
        BorderRightStyleBuilder(this).build()

    fun Style.right(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-right", "", style, color)

    fun Style.right(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-right", width, style, color)

    fun Style.right(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-right", width, style, color)

    fun Style.style(top: ELineStyle, right: ELineStyle = top,
                    bottom: ELineStyle = top, left: ELineStyle = right) =
        setBoxProperty("border-style", top, right, bottom, left)

    fun Style.top(build: BorderTopStyleBuilder.() -> Unit) =
        BorderTopStyleBuilder(this).build()

    fun Style.top(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-top", "", style, color)

    fun Style.top(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-top", width, style, color)

    fun Style.top(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-top", width, style, color)

    fun Style.width(top: ELineWidth, right: ELineWidth = top,
                    bottom: ELineWidth = top, left: ELineWidth = right) =
        setBoxProperty("border-width", top, right, bottom, left)

    fun Style.width(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
        setBoxProperty("border-width", top, right, bottom, left)

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

fun Style.borderStyle(top: ELineStyle, right: ELineStyle = top,
                      bottom: ELineStyle = top, left: ELineStyle = right) =
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

fun Style.borderWidth(top: ELineWidth, right: ELineWidth = top,
                      bottom: ELineWidth = top, left: ELineWidth = right) =
    setBoxProperty("border-width", top, right, bottom, left)

fun Style.borderWidth(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
    setBoxProperty("border-width", top, right, bottom, left)

//---------------------------------------------------------------------------------------------------------------------
