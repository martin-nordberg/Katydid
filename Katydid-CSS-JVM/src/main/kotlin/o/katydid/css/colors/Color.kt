//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.colors

import i.katydid.css.colors.HslColor
import i.katydid.css.colors.RgbColor

//---------------------------------------------------------------------------------------------------------------------

interface Color {

	fun toHslColor(): Color

	fun toRgbColor(): Color

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

fun rgb(
	red:Int,
	green:Int,
	blue:Int
) : Color {
	return rgba(red, green, blue, 1f)
}

//---------------------------------------------------------------------------------------------------------------------

fun rgba(
	red:Int,
	green:Int,
	blue:Int,
	alpha:Float
) : Color {
	val result = RgbColor(red, green, blue, alpha)
	return RgbColor.getNamedColorByHashCode(result.hashCode()) ?: result
}

//---------------------------------------------------------------------------------------------------------------------

fun rgb(
	redFraction: Float,
 	greenFraction: Float,
	blueFraction: Float
) : Color {
	return rgba(redFraction, greenFraction, blueFraction, 1f)
}

//---------------------------------------------------------------------------------------------------------------------

fun rgba(
	redFraction: Float,
	greenFraction: Float,
    blueFraction: Float,
	alpha:Float
) : Color {
	val result = RgbColor(redFraction, greenFraction, blueFraction, alpha)
	return RgbColor.getNamedColorByHashCode(result.hashCode()) ?: result
}

//---------------------------------------------------------------------------------------------------------------------

fun hsl(
	hue: Int,
 	saturationFraction: Float,
	lightnessFraction: Float
) : Color {
	return hsla(hue, saturationFraction, lightnessFraction, 1f)
}

//---------------------------------------------------------------------------------------------------------------------

fun hsla(
	hue: Int,
	saturationFraction: Float,
	lightnessFraction: Float,
	alpha:Float
) : Color {
	val result = HslColor(hue, saturationFraction, lightnessFraction, alpha)
	return RgbColor.getNamedColorByHashCode(result.hashCode()) ?: result
}

//---------------------------------------------------------------------------------------------------------------------

