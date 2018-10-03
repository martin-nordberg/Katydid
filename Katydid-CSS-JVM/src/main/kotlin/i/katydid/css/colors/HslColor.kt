//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.colors

import o.katydid.css.colors.Color
import x.katydid.css.infrastructure.makeDecimalString
import kotlin.math.abs


//---------------------------------------------------------------------------------------------------------------------

internal class HslColor(
    hue: Int,
    saturation: Float,
    lightness: Float,
    alpha: Float
) : Color {

    private val _hue: Int

    private val _saturation: Float

    private val _lightness: Float

    private val _alpha: Float

    private val _rgbColor: RgbColor

    init {

        _hue = (hue.rem(360) + 360).rem(360)

        _saturation = if (saturation < 0) 0f else if (saturation > 1) 1f else saturation
        _lightness = if (lightness < 0) 0f else if (lightness > 1) 1f else lightness

        _alpha = if (alpha < 0) 0f else if (alpha > 1) 1f else alpha

        // C = (1 - |2L - 1|) × S
        val c = (1 - abs(2 * _lightness - 1)) * _saturation

        // X = C × (1 - |(H / 60°) mod 2 - 1|)
        val x = c * (1 - abs((_hue / 60).rem(2) - 1))

        // m = L - C/2
        val m = _lightness - c / 2

        val ic = ((c + m) * 255 + 0.49).toInt()
        val ix = ((x + m) * 255 + 0.49).toInt()
        val iz = (m * 255 + 0.49).toInt()

        _rgbColor = if (_hue < 60) {
            RgbColor(ic, ix, iz, _alpha)
        }
        else if (_hue < 120) {
            RgbColor(ix, ic, iz, _alpha)
        }
        else if (_hue < 180) {
            RgbColor(iz, ic, ix, _alpha)
        }
        else if (_hue < 240) {
            RgbColor(iz, ix, ic, _alpha)
        }
        else if (_hue < 300) {
            RgbColor(ix, iz, ic, _alpha)
        }
        else {
            RgbColor(ic, iz, ix, _alpha)
        }

    }

    override fun equals(other: Any?): Boolean {

        if (other is HslColor) {
            return _alpha == other._alpha &&
                _hue == other._hue &&
                _saturation == other._saturation &&
                _lightness == other._lightness
        }

        if (other is RgbColor) {
            return this.toRgbColor().equals(other)
        }

        return false

    }

    override fun hashCode(): Int {
        return _rgbColor.hashCode()
    }

    override fun opacified(alphaIncrement: Float) =
        HslColor(_hue, _saturation, _lightness, _alpha + alphaIncrement)

    override fun toString(): String {

        val saturationStr = makeDecimalString(_saturation)
        val lightnessStr = makeDecimalString(_lightness)
        val alphaStr = makeDecimalString(_alpha)

        if (_alpha < 1) {
            return "hsla($_hue,$saturationStr,$lightnessStr,$alphaStr)"
        }

        return "hsl($_hue,$saturationStr,$lightnessStr)"

    }

    override fun toHslColor() = this

    override fun toRgbColor() = _rgbColor

    override fun transparentized(alphaDecrement: Float) =
        HslColor(_hue, _saturation, _lightness, _alpha - alphaDecrement)

}

//---------------------------------------------------------------------------------------------------------------------

