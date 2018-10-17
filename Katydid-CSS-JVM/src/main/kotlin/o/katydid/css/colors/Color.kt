//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.colors

import i.katydid.css.colors.HslColor
import i.katydid.css.colors.RgbColor

//---------------------------------------------------------------------------------------------------------------------

/** Interface to a CSS color, independent of its color space. */
interface Color {

    /**
     * Returns a new color with the same RGB or HSL as this one, but with its alpha value increased by the
     * given [alphaIncrement]. Alpha is constrained 0 to 1 as usual.
     */
    fun opacified(alphaIncrement: Float): Color

    /**
     * Returns the HSL color corresponding to this one.
     */
    fun toHslColor(): Color

    /**
     * Returns the RGB color corresponding to this one.
     */
    fun toRgbColor(): Color

    /**
     * Returns a new color with the same RGB or HSL as this one, but with its alpha value decreased by the
     * given [alphaDecrement]. Alpha is constrained 0 to 1 as usual.
     */
    fun transparentized(alphaDecrement: Float): Color

// TODO:
//	fun lightened(dl: Float): Color
//
//	fun darkened(dl: Float): Color
//
//	fun saturated(dl: Float): Color
//
//	fun desaturated(dl: Float): Color

    companion object {

        fun fromHex(hexColor: String): Color? =
            RgbColor.fromHex(hexColor)

    }

}

//---------------------------------------------------------------------------------------------------------------------

/** Constructs a new RGB color with given attributes. */
fun rgb(
    redByte: Int,
    greenByte: Int,
    blueByte: Int
): Color {
    return rgba(redByte, greenByte, blueByte, 1f)
}

//---------------------------------------------------------------------------------------------------------------------

fun rgba(
    redByte: Int,
    greenByte: Int,
    blueByte: Int,
    alpha: Float
): Color {
    val result = RgbColor(redByte, greenByte, blueByte, alpha)
    return RgbColor.getNamedColorByHashCode(result.hashCode()) ?: result
}

//---------------------------------------------------------------------------------------------------------------------

fun rgb(
    redFraction: Float,
    greenFraction: Float,
    blueFraction: Float
): Color {
    return rgba(redFraction, greenFraction, blueFraction, 1f)
}

//---------------------------------------------------------------------------------------------------------------------

fun rgba(
    redFraction: Float,
    greenFraction: Float,
    blueFraction: Float,
    alpha: Float
): Color {
    val result = RgbColor(redFraction, greenFraction, blueFraction, alpha)
    return RgbColor.getNamedColorByHashCode(result.hashCode()) ?: result
}

//---------------------------------------------------------------------------------------------------------------------

fun hsl(
    hue: Int,
    saturation: Float,
    lightness: Float
): Color {
    return hsla(hue, saturation, lightness, 1f)
}

//---------------------------------------------------------------------------------------------------------------------

fun hsla(
    hue: Int,
    saturationFraction: Float,
    lightnessFraction: Float,
    alpha: Float
): Color {
    val result = HslColor(hue, saturationFraction, lightnessFraction, alpha)
    return RgbColor.getNamedColorByHashCode(result.hashCode()) ?: result
}

//---------------------------------------------------------------------------------------------------------------------

