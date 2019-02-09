//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EFontSize
import o.katydid.css.types.EFontStyle
import o.katydid.css.types.EFontVariant
import o.katydid.css.types.EFontWeight

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting font properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidFontStyleBuilder(
    private val style: KatydidStyle
) {

    fun family(vararg values: String) =
        style.fontFamily(*values)

    fun size(value: EFontSize) =
        style.fontSize(value)

    fun size(value: Length) =
        style.fontSize(value)

    fun size(value: Percentage) =
        style.fontSize(value)

    fun style(value: EFontStyle) =
        style.fontStyle(value)

    fun variant(value: EFontVariant) =
        style.fontVariant(value)

    fun weight(value: EFontWeight) =
        style.fontWeight(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.font(build: KatydidFontStyleBuilder.() -> Unit) =
    KatydidFontStyleBuilder(this).build()

// TODO: font, several more font-xxx properties

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.fontFamily(vararg values: String) {

    var css = ""
    var delimiter = ""

    for (value in values) {

        css += delimiter
        delimiter = ", "

        if (value.matches(Regex("[a-zA-Z-]+"))) {
            css += value
        }
        else {
            css += "\""
            css += value
            css += "\""
        }

    }

    setProperty("font-family", css.trim())

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.fontSize(value: EFontSize) =
    setProperty("font-size", "$value")

fun KatydidStyle.fontSize(value: Length) =
    setProperty("font-size", "$value")

fun KatydidStyle.fontSize(value: Percentage) =
    setProperty("font-size", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.fontStyle(value: EFontStyle) =
    setProperty("font-style", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.fontVariant(value: EFontVariant) =
    setProperty("font-variant", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.fontWeight(value: EFontWeight) =
    setProperty("font-weight", "$value")

//---------------------------------------------------------------------------------------------------------------------
