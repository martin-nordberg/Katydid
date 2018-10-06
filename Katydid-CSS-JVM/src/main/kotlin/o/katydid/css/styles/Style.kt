//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.types.*
import o.katydid.css.types.EBackgroundPosition.center
import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

class Style {

    private val properties = mutableListOf<String>()

    /** Funky side-effecting getter actually sets the last used property to be !important. */
    val important: Unit
        get() {
            require(properties.size > 0) { "Set a property before making it important." }
            require(!properties[properties.size - 1].endsWith("!important")) { "Last property already set to important." }

            properties[properties.size - 1] += " !important"
        }

    val isNotEmpty
        get() = properties.isNotEmpty()

    ////

    // TODO: background

    // TODO: consider SASS-like nested style groups: background { color(blue); position(center) }

    fun backgroundAttachment(vararg values: EAttachment) =
        setProperty("background-attachment", values.map { v -> v.toString() }.joinToString(", "))

    fun backgroundColor(value: Color) =
        setProperty("background-color", "$value")

    fun backgroundImage(vararg urls: String) {
        setProperty(
            "background-image",
            urls.map { url -> ENone.fromString(url) ?: "url(\"$url\")" }.joinToString(", ")
        )
    }

    fun backgroundImage(value: ENone) =
        setProperty("background-image", "$value")

    fun backgroundPosition(x: EBackgroundPosition, xOffset: Length, y: EBackgroundPosition, yOffset: Length) =
        setProperty("background-position", "$x $xOffset $y $yOffset")

    fun backgroundPosition(x: EBackgroundPosition, xOffset: Percentage, y: EBackgroundPosition, yOffset: Percentage) =
        setProperty("background-position", "$x $xOffset $y $yOffset")

    fun backgroundPosition(x: EBackgroundPosition, y: EBackgroundPosition = center) =
        setProperty("background-position", "$x $y")

    fun backgroundPosition(x: Length) =
        setProperty("background-position", "$x center")

    fun backgroundPosition(x: Length, y: Length) =
        setProperty("background-position", "$x $y")

    fun backgroundPosition(x: Percentage) =
        setProperty("background-position", "$x center")

    fun backgroundPosition(x: Percentage, y: Percentage) =
        setProperty("background-position", "$x $y")

    fun backgroundRepeat(x: ERepeatStyle, y: ERepeatStyle? = null) {

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

    fun backgroundRepeat(vararg values: Pair<ERepeatStyle, ERepeatStyle?>) {

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

    fun border(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border", "", style, color)

    fun border(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border", width, style, color)

    fun border(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border", width, style, color)

    fun borderBottom(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-bottom", "", style, color)

    fun borderBottom(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-bottom", width, style, color)

    fun borderBottom(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-bottom", width, style, color)

    fun borderBottomColor(value: Color) =
        setProperty("border-bottom-color", "$value")

    fun borderBottomStyle(value: ELineStyle) =
        setProperty("border-bottom-style", "$value")

    fun borderBottomWidth(value: ELineWidth) =
        setProperty("border-bottom-width", "$value")

    fun borderBottomWidth(value: Length) =
        setProperty("border-bottom-width", "$value")

    fun borderCollapse(value: EBorderCollapse) =
        setProperty("border-collapse", "$value")

    fun borderColor(top: Color, right: Color = top, bottom: Color = top, left: Color = right) =
        setBoxProperty("border-color", top, right, bottom, left)

    fun borderLeft(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-left", "", style, color)

    fun borderLeft(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-left", width, style, color)

    fun borderLeft(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-left", width, style, color)

    fun borderLeftColor(value: Color) =
        setProperty("border-left-color", "$value")

    fun borderLeftStyle(value: ELineStyle) =
        setProperty("border-left-style", "$value")

    fun borderLeftWidth(value: ELineWidth) =
        setProperty("border-left-width", "$value")

    fun borderLeftWidth(value: Length) =
        setProperty("border-left-width", "$value")

    fun borderRight(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-right", "", style, color)

    fun borderRight(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-right", width, style, color)

    fun borderRight(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-right", width, style, color)

    fun borderRightColor(value: Color) =
        setProperty("border-right-color", "$value")

    fun borderRightStyle(value: ELineStyle) =
        setProperty("border-right-style", "$value")

    fun borderRightWidth(value: ELineWidth) =
        setProperty("border-right-width", "$value")

    fun borderRightWidth(value: Length) =
        setProperty("border-right-width", "$value")

    fun borderSpacing(horizontal: Length, vertical: Length = horizontal) =
        setXyProperty("border-spacing", horizontal, vertical)

    fun borderStyle(top: ELineStyle, right: ELineStyle = top,
                    bottom: ELineStyle = top, left: ELineStyle = right) =
        setBoxProperty("border-style", top, right, bottom, left)

    fun borderTop(style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-top", "", style, color)

    fun borderTop(width: ELineWidth, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-top", width, style, color)

    fun borderTop(width: Length, style: ELineStyle? = null, color: Color? = null) =
        setBorderProperty("border-top", width, style, color)

    fun borderTopColor(value: Color) =
        setProperty("border-top-color", "$value")

    fun borderTopStyle(value: ELineStyle) =
        setProperty("border-top-style", "$value")

    fun borderTopWidth(value: ELineWidth) =
        setProperty("border-top-width", "$value")

    fun borderTopWidth(value: Length) =
        setProperty("border-top-width", "$value")

    fun borderWidth(top: ELineWidth, right: ELineWidth = top,
                    bottom: ELineWidth = top, left: ELineWidth = right) =
        setBoxProperty("border-width", top, right, bottom, left)

    fun borderWidth(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
        setBoxProperty("border-width", top, right, bottom, left)

    fun captionSide(value: ECaptionSide) =
        setProperty("caption-side", "$value")

    fun caretColor(value: Color) =
        setProperty("caret-color", "$value")

    fun caretColor(value: EAuto) =
        setProperty("caret-color", "$value")

    // TODO?: chains

    fun clear(value: EClear) =
        setProperty("clear", "$value")

    // TODO: clip

    // TODO: counter-increment

    // TODO: counter-reset

    // TODO?: cue, cue-before, cure-after

    fun cursor(value: ECursor) =
        setProperty("cursor", "$value")

    fun display(value: EDisplay) =
        setProperty("display", "$value")

    // TODO?: elevation

    fun emptyCells(value: EEmptyCells) =
        setProperty("empty-cells", "$value")

    fun float(value: EFloat) =
        setProperty("float", "$value")

    // TODO: font

    fun fontFamily(vararg values: String) {

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

    fun fontSize(value: EFontSize) =
        setProperty("font-size", "$value")

    fun fontSize(value: Length) =
        setProperty("font-size", "$value")

    fun fontSize(value: Percentage) =
        setProperty("font-size", "$value")

    fun fontStyle(value: EFontStyle) =
        setProperty("font-style", "$value")

    fun fontVariant(value: EFontVariant) =
        setProperty("font-variant", "$value")

    fun fontWeight(value: EFontWeight) =
        setProperty("font-weight", "$value")

    fun include(style: Style) {

        for (property in style.properties) {
            properties.add(property)
        }

    }

    fun inherit(key: String) =
        setProperty(key, "inherit")

    fun letterSpacing(value: Length) =
        setProperty("letter-spacing", "$value")

    fun letterSpacing(value: ENormal) =
        setProperty("letter-spacing", "$value")

    fun lineHeight(value: Length) =
        setProperty("line-height", "$value")

    fun lineHeight(value: Percentage) =
        setProperty("line-height", "$value")

    fun lineHeight(value: Float) =
        setProperty("line-height", makeDecimalString(value))

    fun lineHeight(value: ENormal) =
        setProperty("line-height", "$value")

    fun listStyle(type: EListStyleType, position: EListStylePosition? = null, imageUrl: String? = null) {

        var css = "$type"

        if (position != null) {
            css += " $position"
        }

        if (imageUrl != null) {
            // TODO: does image need to go first to be useful?
            css += " url(\"$imageUrl\")"
        }

        setProperty("list-style", css)

    }

    fun listStyleImage(url: String) =
        setProperty("list-style-image", "url(\"$url\")")

    fun listStyleImage(value: ENone) =
        setProperty("list-style-image", "$value")

    fun listStylePosition(value: EListStylePosition) =
        setProperty("list-style-position", "$value")

    fun listStyleType(value: EListStyleType) =
        setProperty("list-style-type", "$value")

    fun orphans(value: Int) {
        require(value > 0) { "CSS orphans property must be greater than zero." }
        setProperty("orphans", "$value")
    }

    // TODO: quotes

    fun resize(value: EResize) =
        setProperty("resize", "$value")

    private fun <T> setBorderProperty(key: String, width: T?, style: ELineStyle?, color: Color?) {

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

    fun <T> setBoxProperty(key: String, top: T, right: T = top, bottom: T = top, left: T = right) {

        var css = "$top"

        if (right != top || bottom != top || left != right) {
            css += " $right"
        }

        if (bottom != top || left != right) {
            css += " $bottom"
        }

        if (left != right) {
            css += " $left"
        }

        setProperty(key, css)

    }

    fun setProperty(key: String, value: String) {
        properties.add("$key: $value")
    }

    fun <T> setXyProperty(key: String, x: T, y: T = x) {

        var css = "$x"

        if (x != y) {
            css += " $y"
        }

        setProperty(key, css)

    }

    fun setStringProperty(key: String, value: String) {
        var cssValue = value.replace("\"", "\\\"")
        cssValue = cssValue.replace("\n", "\\A")
        // TODO: probably more characters worth escaping
        setProperty(key, "\"$cssValue\"")
    }

    fun tableLayout(value: ETableLayout) =
        setProperty("table-layout", "$value")

    fun toCssString(indent: String = "", whitespace: String = "\n") =
        properties.map { p -> indent + p }.joinToString(";" + whitespace) + ";"

    override fun toString() =
        toCssString("", " ")

    fun widows(value: Int) {
        require(value > 0) { "CSS widows property must be greater than zero." }
        setProperty("widows", "$value")
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style object.
 * @param build the callback that fills in the CSS properties.
 */
fun style(
    build: Style.() -> Unit
): Style {

    val result = Style()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

