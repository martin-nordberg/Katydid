//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.css.colors

import o.katydid.css.colors.Color
import o.katydid.css.colors.rgba
import o.katydid.css.colors.transparent
import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

internal class RgbColor(
    red: Int,
    green: Int,
    blue: Int,
    alpha: Float,
    val colorName: String? = null
) : Color {

    private val _red: Int

    private val _green: Int

    private val _blue: Int

    private val _alpha: Float

    init {

        this._red = if (red < 0) 0 else if (red > 255) 255 else red
        this._green = if (green < 0) 0 else if (green > 255) 255 else green
        this._blue = if (blue < 0) 0 else if (blue > 255) 255 else blue

        this._alpha = if (alpha < 0) 0f else if (alpha > 1) 1f else alpha

        if (colorName != null && !namedColorsByHashCode.containsKey(this.hashCode())) {
            namedColorsByHashCode.put(this.hashCode(), this)
        }

    }

    constructor(
        red: Int,
        green: Int,
        blue: Int,
        alpha: Float
    ) : this(
        red,
        green,
        blue,
        alpha ,
        null
    )

    constructor(
        redFraction: Float,
        greenFraction: Float,
        blueFraction: Float,
        alpha: Float = 1.0f
    ) : this(
        (redFraction * 255 + 0.49).toInt(),
        (greenFraction * 255 + 0.49).toInt(),
        (blueFraction * 255 + 0.49).toInt(),
        alpha,
        null
    )

    override fun equals(other: Any?): Boolean {

        if (other is RgbColor) {
            return this._alpha == other._alpha &&
                this._red == other._red &&
                this._green == other._green &&
                this._blue == other._blue
        }

        if (other is HslColor) {
            return this.toHslColor().equals(other)
        }

        return false

    }

    override fun hashCode(): Int {
        return _red.shl(24) + _green.shl(16) + _blue.shl(8) + (_alpha*255).toInt()
    }

    override fun toString(): String {

        if (colorName != null) {
            return colorName
        }

        if (_alpha < 1f) {
            val alphaStr = makeDecimalString(_alpha)
            return "rgba($_red,$_green,$_blue,$alphaStr)"
        }

        return "#" + HEX_STRINGS[_red] + HEX_STRINGS[_green] + HEX_STRINGS[_blue]

    }

    override fun toHslColor(): Color {
        TODO("not yet implemented")
    }

    override fun toRgbColor() = this

    ////

    companion object {

        private val HEX_STRINGS = arrayListOf(
            "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F",
            "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F",
            "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F",
            "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F",
            "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F",
            "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F",
            "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F",
            "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F",
            "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F",
            "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF",
            "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF",
            "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF",
            "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF",
            "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF",
            "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"
        )

        private val INV_HEX_STRINGS: Map<String, Int>

        private var namedColorsByHashCode = HashMap<Int, RgbColor>()

        ////

        init {

            val inv = mutableMapOf<String, Int>()

            for (index in 0..255) {
                inv[HEX_STRINGS[index]] = index
            }

            INV_HEX_STRINGS = inv

            // wake up the color names so that they register themselves
            transparent.toString()

        }

        ////

        fun fromHex(_s: String): Color? {

            val s = (if (_s[0] == '#') _s.drop(1) else _s).toUpperCase()

            return when (s.length) {
                1    -> { // 0xb (odd)
                    val b = parseShortHandByte(s[0])
                    rgba(0, 0, b, 1f)
                }
                2    -> { // 0xgb (odd)
                    val g = parseShortHandByte(s[0])
                    val b = parseShortHandByte(s[1])
                    rgba(0, g, b, 1f)
                }
                3    -> { // 0xrgb (shorthand)
                    val r = parseShortHandByte(s[0])
                    val g = parseShortHandByte(s[1])
                    val b = parseShortHandByte(s[2])
                    rgba(r, g, b, 1f)
                }
                4    -> { // 0xrgba (CSS4 shorthand)
                    val r = parseShortHandByte(s[0])
                    val g = parseShortHandByte(s[1])
                    val b = parseShortHandByte(s[2])
                    val a = parseShortHandByte(s[3])
                    rgba(r, g, b, (a + 0.49f) / 255f)
                }
                5    -> { // 0xrggbb (odd)
                    val r = parseByte("0" + s[0])
                    val g = parseByte(s.substring(1, 3))
                    val b = parseByte(s.substring(3, 5))
                    rgba(r, g, b, 1f)
                }
                6    -> { // 0xrrggbb (usual)
                    val r = parseByte(s.substring(0, 2))
                    val g = parseByte(s.substring(2, 4))
                    val b = parseByte(s.substring(4, 6))
                    rgba(r, g, b, 1f)
                }
                7    -> { // 0xrggbbaa (odd)
                    val r = parseByte("0" + s[0])
                    val g = parseByte(s.substring(1, 3))
                    val b = parseByte(s.substring(3, 5))
                    val a = parseByte(s.substring(5, 7))
                    rgba(r, g, b, (a + 0.49f) / 255)
                }
                8    -> { // 0xrrggbbaa (CSS4)
                    val r = parseByte(s.substring(0, 2))
                    val g = parseByte(s.substring(2, 4))
                    val b = parseByte(s.substring(4, 6))
                    val a = parseByte(s.substring(6, 8))
                    rgba(r, g, b, (a + 0.49f) / 255)
                }
                else -> null

            }

        }

        // TODO: not sure this is useful. If it is needs to be non-Java dependent
//        fun fromHex(value: Int): RgbColor? {
//
//            if (value < 0x1000) {
//                return fromHex(Integer.toHexString(value).padStart(3, '0'))
//            }
//            else if (value < 0x1000000) {
//                return fromHex(Integer.toHexString(value).padStart(6, '0'))
//            }
//            else {
//                return fromHex(Integer.toHexString(value).padStart(8, '0'))
//            }
//
//        }

        fun getNamedColorByHashCode(hashCode: Int): RgbColor? =
            namedColorsByHashCode.get(hashCode)

        private fun parseByte(byteStr: String) =
            INV_HEX_STRINGS[byteStr] ?: throw IllegalArgumentException("Invalid hex byte: '$byteStr'.")

        private fun parseShortHandByte(byteChar: Char) =
            when (byteChar) {
                '0'  -> 0
                '1'  -> 0x11
                '2'  -> 0x22
                '3'  -> 0x33
                '4'  -> 0x44
                '5'  -> 0x55
                '6'  -> 0x66
                '7'  -> 0x77
                '8'  -> 0x88
                '9'  -> 0x99
                'A'  -> 0xAA
                'B'  -> 0xBB
                'C'  -> 0xCC
                'D'  -> 0xDD
                'E'  -> 0xEE
                'F'  -> 0xFF
                else -> throw IllegalArgumentException("Invalid hex byte shorthand: '$byteChar'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

