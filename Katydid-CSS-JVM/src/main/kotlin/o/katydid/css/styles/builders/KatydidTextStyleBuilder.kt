//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting text style properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidTextDecorationStyleBuilder(
    private val style: KatydidStyle
) {

    fun color(value: Color) =
        style.textDecorationColor(value)

    fun line(value: ENone) =
        style.textDecorationLine(value)

    fun line(vararg values: ETextDecorationLine) =
        style.textDecorationLine(*values)

    fun style(value: ETextDecorationStyle) =
        style.textDecorationStyle(value)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting margin properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidTextStyleBuilder(
    private val style: KatydidStyle
) {

    fun align(value: ETextAlign) =
        style.textAlign(value)

    fun alignAll(value: ETextAlign) =
        style.textAlignAll(value)

    fun alignLast(value: ETextAlign) =
        style.textAlignLast(value)

    fun decoration(build: KatydidTextDecorationStyleBuilder.() -> Unit) =
        KatydidTextDecorationStyleBuilder(style).build()

    fun decoration(value: ENone) =
        style.textDecoration(value)

    fun decoration(line: ETextDecorationLine? = null, decorationStyle: ETextDecorationStyle? = null,
                   color: Color? = null, vararg moreLines: ETextDecorationLine? = arrayOf()) =
        style.textDecoration(line, decorationStyle, color, *moreLines)

    fun decorationColor(value: Color) =
        style.textDecorationColor(value)

    fun decorationLine(value: ENone) =
        style.textDecorationLine(value)

    fun decorationLine(vararg values: ETextDecorationLine) =
        style.textDecorationLine(*values)

    fun decorationStyle(value: ETextDecorationStyle) =
        style.textDecorationStyle(value)

    fun indent(value: Length) =
        style.textIndent(value)

    fun indent(value: Percentage) =
        style.textIndent(value)

    fun justify(value: ETextJustify) =
        style.textJustify(value)

    fun overflow(value: ETextOverflow) =
        style.textOverflow(value)

    fun transform(value: ETextTransform) =
        style.textTransform(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.tabSize(value: Int) {
    require(value >= 0) { "Tab size cannot be negative: '$value'." }
    setProperty("tab-size", "$value")
}

fun KatydidStyle.tabSize(value: Length) {
    require(value.isNotNegative) { "Tab size cannot be negative: '$value'." }
    setProperty("tab-size", "$value")
}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.text(build: KatydidTextStyleBuilder.() -> Unit) =
    KatydidTextStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textAlign(value: ETextAlign) =
    setProperty("text-align", "$value")

fun KatydidStyle.textAlignAll(value: ETextAlign) {
    require(value != ETextAlign.justifyAll) { "Option 'justify-all' does not apply for property text-align-all." }
    setProperty("text-align-all", "$value")
}

fun KatydidStyle.textAlignLast(value: ETextAlign) {
    require(value != ETextAlign.justifyAll) { "Option 'justify-all' does not apply for property text-align-last." }
    setProperty("text-align-last", "$value")
}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textDecoration(value: ENone) =
    setProperty("text-decoration", "$value")

fun KatydidStyle.textDecoration(line: ETextDecorationLine? = null, style: ETextDecorationStyle? = null,
                                color: Color? = null, vararg moreLines: ETextDecorationLine? = arrayOf()) {
    var css = ""
    if (line != null) {
        css = "$line"
    }
    if (style != null) {
        css += " $style"
    }
    if (color != null) {
        css += " $color"
    }
    for (l in moreLines) {
        css += " $l"
    }

    require(css.isNotEmpty()) { "Specify at least one non-null parameter for text-decoration." }

    setProperty("text-decoration", css.trim())
}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textDecorationColor(value: Color) =
    setProperty("text-decoration-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textDecorationLine(value: ENone) =
    setProperty("text-decoration-line", "$value")

fun KatydidStyle.textDecorationLine(vararg values: ETextDecorationLine) {
    val css = values.map { v -> v.toString() }.joinToString(" ")
    setProperty("text-decoration-line", css)
}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textDecorationStyle(value: ETextDecorationStyle) =
    setProperty("text-decoration-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textIndent(value: Length) =
    setProperty("text-indent", "$value")

fun KatydidStyle.textIndent(value: Percentage) =
    setProperty("text-indent", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textJustify(value: ETextJustify) =
    setProperty("text-justify", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textOverflow(value: ETextOverflow) =
    setProperty("text-overflow", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.textTransform(value: ETextTransform) =
    setProperty("text-transform", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.whiteSpace(value: EWhiteSpace) =
    setProperty("white-space", "$value")

//---------------------------------------------------------------------------------------------------------------------

