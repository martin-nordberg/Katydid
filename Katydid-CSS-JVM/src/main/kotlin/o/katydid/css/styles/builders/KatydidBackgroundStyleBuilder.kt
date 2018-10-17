//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EAttachment
import o.katydid.css.types.EBackgroundPosition
import o.katydid.css.types.EImage
import o.katydid.css.types.ERepeatStyle

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting margin properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidBackgroundStyleBuilder(
    private val style: KatydidStyle
) {

    // TODO: background

    fun attachment(vararg values: EAttachment) =
        style.backgroundAttachment(*values)

    fun color(value: Color) =
        style.backgroundColor(value)

    fun image(vararg values: EImage) =
        style.backgroundImage(*values)

    fun position(x: EBackgroundPosition, xOffset: Length, y: EBackgroundPosition, yOffset: Length) =
        style.backgroundPosition(x, xOffset, y, yOffset)

    fun position(x: EBackgroundPosition, xOffset: Percentage, y: EBackgroundPosition, yOffset: Percentage) =
        style.backgroundPosition(x, xOffset, y, yOffset)

    fun position(x: EBackgroundPosition, y: EBackgroundPosition = EBackgroundPosition.center) =
        style.backgroundPosition(x, y)

    fun position(x: Length) =
        style.backgroundPosition(x)

    fun position(x: Length, y: Length) =
        style.backgroundPosition(x, y)

    fun position(x: Percentage) =
        style.backgroundPosition(x)

    fun position(x: Percentage, y: Percentage) =
        style.backgroundPosition(x, y)

    fun repeat(x: ERepeatStyle, y: ERepeatStyle? = null) =
        style.backgroundRepeat(x, y)

    fun repeat(vararg values: Pair<ERepeatStyle, ERepeatStyle?>) =
        style.backgroundRepeat(*values)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.background(build: KatydidBackgroundStyleBuilder.() -> Unit) =
    KatydidBackgroundStyleBuilder(this).build()

// TODO: background with parameters

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.backgroundAttachment(vararg values: EAttachment) =
    setProperty("background-attachment", values.joinToString(", ") { v -> v.toString() })

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.backgroundColor(value: Color) =
    setProperty("background-color", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.backgroundImage(vararg values: EImage) =
    setProperty("background-image", values.joinToString(", ") { v -> v.toString() })

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.backgroundPosition(x: EBackgroundPosition, xOffset: Length, y: EBackgroundPosition, yOffset: Length) =
    setProperty("background-position", "$x $xOffset $y $yOffset")

fun KatydidStyle.backgroundPosition(x: EBackgroundPosition, xOffset: Percentage, y: EBackgroundPosition, yOffset: Percentage) =
    setProperty("background-position", "$x $xOffset $y $yOffset")

fun KatydidStyle.backgroundPosition(x: EBackgroundPosition, y: EBackgroundPosition = EBackgroundPosition.center) =
    setProperty("background-position", "$x $y")

fun KatydidStyle.backgroundPosition(x: Length) =
    setProperty("background-position", "$x center")

fun KatydidStyle.backgroundPosition(x: Length, y: Length) =
    setProperty("background-position", "$x $y")

fun KatydidStyle.backgroundPosition(x: Percentage) =
    setProperty("background-position", "$x center")

fun KatydidStyle.backgroundPosition(x: Percentage, y: Percentage) =
    setProperty("background-position", "$x $y")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.backgroundRepeat(x: ERepeatStyle, y: ERepeatStyle? = null) {

    require(x != ERepeatStyle.repeatX && x != ERepeatStyle.repeatY || y == null) {
        "Background style $x cannot be combined with a second value."
    }

    if (y == null) {
        setProperty("background-repeat", "$x")
    }
    else {
        setProperty("background-repeat", "$x $y")
    }

}

fun KatydidStyle.backgroundRepeat(vararg values: Pair<ERepeatStyle, ERepeatStyle?>) {

    val strings = values.map { v ->

        require(v.first != ERepeatStyle.repeatX && v.first != ERepeatStyle.repeatY || v.second == null) {
            "Background style ${v.first} cannot be combined with a second value."
        }

        if (v.second == null) {
            "${v.first}"
        }
        else {
            "${v.first} ${v.second}"
        }

    }

    setProperty("background-repeat", strings.joinToString(", "))

}

//---------------------------------------------------------------------------------------------------------------------
