//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.colors

import o.katydid.css.colors.Color
import x.katydid.css.infrastructure.makeDecimalString
import kotlin.math.abs


//---------------------------------------------------------------------------------------------------------------------

internal class HslColor(
    itsHue: Int,
    itsSaturation: Float,
    itsLightness: Float,
    itsAlpha: Float
) : Color {

    private val myHue = (itsHue.rem(360) + 360).rem(360)

    private val mySaturation = if (itsSaturation < 0) 0f else if (itsSaturation > 1) 1f else itsSaturation

    private val myLightness = if (itsLightness < 0) 0f else if (itsLightness > 1) 1f else itsLightness

    private val myAlpha = if (itsAlpha < 0) 0f else if (itsAlpha > 1) 1f else itsAlpha

    private val myRgbColor: RgbColor

    ////

    init {

        // C = (1 - |2L - 1|) × S
        val c = (1 - abs(2 * myLightness - 1)) * mySaturation

        // X = C × (1 - |(H / 60°) mod 2 - 1|)
        val x = c * (1 - abs((myHue / 60).rem(2) - 1))

        // m = L - C/2
        val m = myLightness - c / 2

        val ic = ((c + m) * 255 + 0.49).toInt()
        val ix = ((x + m) * 255 + 0.49).toInt()
        val iz = (m * 255 + 0.49).toInt()

        myRgbColor = if (myHue < 60) {
            RgbColor(ic, ix, iz, myAlpha)
        }
        else if (myHue < 120) {
            RgbColor(ix, ic, iz, myAlpha)
        }
        else if (myHue < 180) {
            RgbColor(iz, ic, ix, myAlpha)
        }
        else if (myHue < 240) {
            RgbColor(iz, ix, ic, myAlpha)
        }
        else if (myHue < 300) {
            RgbColor(ix, iz, ic, myAlpha)
        }
        else {
            RgbColor(ic, iz, ix, myAlpha)
        }

    }

    ////

    override fun equals(other: Any?): Boolean {

        if (other is HslColor) {
            return myAlpha == other.myAlpha &&
                myHue == other.myHue &&
                mySaturation == other.mySaturation &&
                myLightness == other.myLightness
        }

        if (other is RgbColor) {
            return myRgbColor.equals(other)
        }

        return false

    }

    override fun hashCode() =
        myRgbColor.hashCode()

    override fun opacified(alphaIncrement: Float) =
        HslColor(myHue, mySaturation, myLightness, myAlpha + alphaIncrement)

    override fun toString(): String {

        val saturationStr = makeDecimalString(mySaturation)
        val lightnessStr = makeDecimalString(myLightness)
        val alphaStr = makeDecimalString(myAlpha)

        if (myAlpha < 1) {
            return "hsla($myHue,$saturationStr,$lightnessStr,$alphaStr)"
        }

        return "hsl($myHue,$saturationStr,$lightnessStr)"

    }

    override fun toHslColor() =
        this

    override fun toRgbColor() =
        myRgbColor

    override fun transparentized(alphaDecrement: Float) =
        HslColor(myHue, mySaturation, myLightness, myAlpha - alphaDecrement)

}

//---------------------------------------------------------------------------------------------------------------------

