//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.types.*
import o.katydid.css.types.EBackgroundPositionOption.center
import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

class Style {

    private val properties = mutableListOf<String>()

    ////

    // TODO: background

    fun backgroundAttachment(value: EBackgroundAttachmentOption) =
        setProperty("background-attachment", value.toCssString())

    fun backgroundColor(value: Color) =
        setProperty("background-color", "$value")

    fun backgroundImage(url: String) =
        setProperty("background-image", "url(\"$url\")")

    fun backgroundImage(value: ENoneOption) =
        setProperty("background-image", value.toCssString())

    fun backgroundPosition(x: EBackgroundPositionOption, y: EBackgroundPositionOption = center) =
        setProperty("background-position", x.toCssString() + " " + y.toCssString())

    fun backgroundPosition(x: Length) =
        setProperty("background-position", "$x center")

    fun backgroundPosition(x: Length, y: Length) =
        setProperty("background-position", "$x $y")

    fun backgroundPosition(x: Percentage) =
        setProperty("background-position", "$x center")

    fun backgroundPosition(x: Percentage, y: Percentage) =
        setProperty("background-position", "$x $y")

    fun backgroundRepeat(value: EBackgroundRepeatOption) =
        setProperty("background-repeat", value.toCssString())

    // TODO: border

    fun borderBottom(width: EBorderWidthOption, style: EBorderStyleOption, color: Color) =
        setProperty("border-bottom", width.toCssString() + " " + style.toCssString() + " $color")

    fun borderBottomColor(value: Color) =
        setProperty("border-bottom-color", "$value")

    fun borderBottomStyle(value: EBorderStyleOption) =
        setProperty("border-bottom-style", value.toCssString())

    fun borderBottomWidth(value: EBorderWidthOption) =
        setProperty("border-bottom-width", value.toCssString())

    fun borderBottomWidth(value: Length) =
        setProperty("border-bottom-width", "$value")

    fun borderCollapse(value: EBorderCollapseOption) =
        setProperty("border-collapse", value.toCssString())

    fun borderColor(top: Color, right: Color = top, bottom: Color = top, left: Color = right) {

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

        setProperty("border-color", css)

    }

    fun borderLeft(width: EBorderWidthOption, style: EBorderStyleOption, color: Color) =
        setProperty("border-left", width.toCssString() + " " + style.toCssString() + " $color")

    fun borderLeftColor(value: Color) =
        setProperty("border-left-color", "$value")

    fun borderLeftStyle(value: EBorderStyleOption) =
        setProperty("border-left-style", value.toCssString())

    fun borderLeftWidth(value: EBorderWidthOption) =
        setProperty("border-left-width", value.toCssString())

    fun borderLeftWidth(value: Length) =
        setProperty("border-left-width", "$value")

    fun borderRight(width: EBorderWidthOption, style: EBorderStyleOption, color: Color) =
        setProperty("border-right", width.toCssString() + " " + style.toCssString() + " $color")

    fun borderRightColor(value: Color) =
        setProperty("border-right-color", "$value")

    fun borderRightStyle(value: EBorderStyleOption) =
        setProperty("border-right-style", value.toCssString())

    fun borderRightWidth(value: EBorderWidthOption) =
        setProperty("border-right-width", value.toCssString())

    fun borderRightWidth(value: Length) =
        setProperty("border-right-width", "$value")

    fun borderSpacing(horizontal: Length, vertical: Length = horizontal) {

        var css = "$horizontal"

        if (vertical != horizontal) {
            css += " $vertical"
        }

        setProperty("border-spacing", css)

    }

    fun borderStyle(top: EBorderStyleOption, right: EBorderStyleOption = top,
                    bottom: EBorderStyleOption = top, left: EBorderStyleOption = right) {

        var css = top.toCssString()

        if (right != top || bottom != top || left != right) {
            css += " " + right.toCssString()
        }

        if (bottom != top || left != right) {
            css += " " + bottom.toCssString()
        }

        if (left != right) {
            css += " " + left.toCssString()
        }

        setProperty("border-style", css)

    }

    fun borderTop(width: EBorderWidthOption, style: EBorderStyleOption, color: Color) =
        setProperty("border-top", width.toCssString() + " " + style.toCssString() + " $color")

    fun borderTopColor(value: Color) =
        setProperty("border-top-color", "$value")

    fun borderTopStyle(value: EBorderStyleOption) =
        setProperty("border-top-style", value.toCssString())

    fun borderTopWidth(value: EBorderWidthOption) =
        setProperty("border-top-width", value.toCssString())

    fun borderTopWidth(value: Length) =
        setProperty("border-top-width", "$value")

    fun bottom(value: Length) =
        setProperty("bottom", "$value")

    fun bottom(value: Percentage) =
        setProperty("bottom", "$value")

    fun bottom(value: EAutoOption) =
        setProperty("bottom", value.toCssString())

    fun boxSizing(value: EBoxSizingOption) =
        setProperty("box-sizing", value.toCssString())

    fun captionSide(value: ECaptionSideOption) =
        setProperty("caption-side", value.toCssString())

    fun caretColor(value: Color) =
        setProperty("caret-color", "$value")

    fun caretColor(value: EAutoOption) =
        setProperty("caret-color", value.toCssString())

    // TODO?: chains

    fun clear(value: EClearOption) =
        setProperty("clear", value.toCssString())

    // TODO: clip

    fun color(value: Color) =
        setProperty("color", "$value")

    fun content(value: EContentOption) =
        setProperty("content", value.toCssString())

    fun content(value: String) =
        setStringProperty("content", value)

    fun contentAttr(value: String) =
        setProperty("content", "attr($value)")

    fun contentUrl(value: String) =
        setProperty("content", "url(\"$value\")")

    // TODO: counter-increment

    // TODO: counter-reset

    // TODO?: cue, cue-before, cure-after

    fun cursor(value: ECursorOption) =
        setProperty("cursor", value.toCssString())

    fun direction(value: EDirectionOption) =
        setProperty("direction", value.toCssString())

    fun display(value: EDisplayOption) =
        setProperty("display", value.toCssString())

    // TODO?: elevation

    fun emptyCells(value: EEmptyCellsOption) =
        setProperty("empty-cells", value.toCssString())

    fun float(value: EFloatOption) =
        setProperty("float", value.toCssString())

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

    fun fontSize(value: EFontSizeOption) =
        setProperty("font-size", value.toCssString())

    fun fontSize(value: Length) =
        setProperty("font-size", "$value")

    fun fontSize(value: Percentage) =
        setProperty("font-size", "$value")

    fun fontStyle(value: EFontStyleOption) =
        setProperty("font-style", value.toCssString())

    fun fontVariant(value: EFontVariantOption) =
        setProperty("font-variant", value.toCssString())

    fun fontWeight(value: EFontWeightOption) =
        setProperty("font-weight", value.toCssString())

    fun height(value: Length) =
        setProperty("height", "$value")

    fun height(value: Percentage) =
        setProperty("height", "$value")

    fun height(value: EAutoOption) =
        setProperty("height", value.toCssString())

    /** Funky side-effecting getter actually sets the last used property to be !important. */
    val important: Unit
        get() {
            require(properties.size > 0) { "Set a property before making it important." }
            require(!properties[properties.size - 1].endsWith("!important")) { "Last property already set to important." }
            properties[properties.size - 1] += " !important"
        }

    fun left(value: Length) =
        setProperty("left", "$value")

    fun left(value: Percentage) =
        setProperty("left", "$value")

    fun left(value: EAutoOption) =
        setProperty("left", value.toCssString())

    fun letterSpacing(value: Length) =
        setProperty("letter-spacing", "$value")

    fun letterSpacing(value: ENormalOption) =
        setProperty("letter-spacing", value.toCssString())

    fun lineHeight(value: Length) =
        setProperty("line-height", "$value")

    fun lineHeight(value: Percentage) =
        setProperty("line-height", "$value")

    fun lineHeight(value: Float) =
        setProperty("line-height", makeDecimalString(value))

    fun lineHeight(value: ENormalOption) =
        setProperty("line-height", value.toCssString())

    fun listStyle(type: EListStyleTypeOption, position: EListStylePositionOption? = null, imageUrl: String? = null) {

        var css = type.toCssString()

        if (position != null) {
            css += " " + position.toCssString()
        }

        if (imageUrl != null) {
            // TODO: does image need to go first to be useful?
            css += " url(\"$imageUrl\")"
        }

        setProperty("list-style", css)

    }

    fun listStyleImage(url: String) =
        setProperty("list-style-image", "url(\"$url\")")

    fun listStyleImage(value: ENoneOption) =
        setProperty("list-style-image", value.toCssString())

    fun listStylePosition(value: EListStylePositionOption) =
        setProperty("list-style-position", value.toCssString())

    fun listStyleType(value: EListStyleTypeOption) =
        setProperty("list-style-type", value.toCssString())

    fun margin(top: Length, right: Length = top, bottom: Length = top, left: Length = right) {

        var css = "$top"

        if ( right != top || bottom != top || left != right ) {
            css += " $right"
        }

        if ( bottom != top || left != right ) {
            css += " $bottom"
        }

        if ( left != right ) {
            css += " $left"
        }

        setProperty("margin", css)

    }

    fun margin(top: Percentage, right: Percentage = top, bottom: Percentage = top, left: Percentage = right) {

        var css = "$top"

        if ( right != top || bottom != top || left != right ) {
            css += " $right"
        }

        if ( bottom != top || left != right ) {
            css += " $bottom"
        }

        if ( left != right ) {
            css += " $left"
        }

        setProperty("margin", css)

    }

    fun margin(value: EAutoOption) =
        setProperty("margin", value.toCssString())

    fun marginBottom(value: Length) =
        setProperty("margin-bottom", "$value")

    fun marginBottom(value: Percentage) =
        setProperty("margin-bottom", "$value")

    fun marginBottom(value: EAutoOption) =
        setProperty("margin-bottom", value.toCssString())

    fun marginLeft(value: Length) =
        setProperty("margin-left", "$value")

    fun marginLeft(value: Percentage) =
        setProperty("margin-left", "$value")

    fun marginLeft(value: EAutoOption) =
        setProperty("margin-left", value.toCssString())

    fun marginRight(value: Length) =
        setProperty("margin-right", "$value")

    fun marginRight(value: Percentage) =
        setProperty("margin-right", "$value")

    fun marginRight(value: EAutoOption) =
        setProperty("margin-right", value.toCssString())

    fun marginTop(value: Length) =
        setProperty("margin-top", "$value")

    fun marginTop(value: Percentage) =
        setProperty("margin-top", "$value")

    fun marginTop(value: EAutoOption) =
        setProperty("margin-top", value.toCssString())

    fun maxHeight(value: Length) =
        setProperty("max-height", "$value")

    fun maxHeight(value: Percentage) =
        setProperty("max-height", "$value")

    fun maxHeight(value: ENoneOption) =
        setProperty("max-height", value.toCssString())

    fun maxWidth(value: Length) =
        setProperty("max-width", "$value")

    fun maxWidth(value: Percentage) =
        setProperty("max-width", "$value")

    fun maxWidth(value: ENoneOption) =
        setProperty("max-width", value.toCssString())

    fun minHeight(value: Length) =
        setProperty("min-height", "$value")

    fun minHeight(value: Percentage) =
        setProperty("min-height", "$value")

    fun minWidth(value: Length) =
        setProperty("min-width", "$value")

    fun minWidth(value: Percentage) =
        setProperty("min-width", "$value")

    fun opacity(value:Float) {

        if ( value <= 0 ) {
            setProperty("opacity","0")
        }
        else if ( value >= 1 ) {
            setProperty("opacity","1")
        }
        else {
            setProperty("opacity", makeDecimalString(value))
        }

    }

    // TODO: orphans

    fun outline(color: Color, style: EBorderStyleOption, width:EBorderWidthOption) =
        setProperty("outline","$color " + style.toCssString() + " " + width.toCssString())

    fun outline(color: EOutlineColorOption, style: EBorderStyleOption, width:EBorderWidthOption) =
        setProperty("outline",color.toCssString() + " " + style.toCssString() + " " + width.toCssString())

    fun outline(color: Color, style: EBorderStyleOption, width:Length) =
        setProperty("outline","$color " + style.toCssString() + " $width")

    fun outline(color: EOutlineColorOption, style: EBorderStyleOption, width:Length) =
        setProperty("outline",color.toCssString() + " " + style.toCssString() + " $width")

    fun outlineColor(value: Color) =
        setProperty("outline-color", "$value")

    fun outlineColor(value: EOutlineColorOption) =
        setProperty("outline-color", value.toCssString())

    fun outlineStyle(value: EBorderStyleOption) =
        setProperty("outline-style", "$value")

    fun outlineWidth(value: EBorderWidthOption) =
        setProperty("outline-width", value.toCssString())

    fun outlineWidth(value: Length) =
        setProperty("outline-width", "$value")

    fun overflow(value: EOverflowOption) =
        setProperty("overflow", "$value")

    fun padding(top: Length, right: Length = top, bottom: Length = top, left: Length = right) {

        var css = "$top"

        if ( right != top || bottom != top || left != right ) {
            css += " $right"
        }

        if ( bottom != top || left != right ) {
            css += " $bottom"
        }

        if ( left != right ) {
            css += " $left"
        }

        setProperty("padding", css)

    }

    fun padding(top: Percentage, right: Percentage = top, bottom: Percentage = top, left: Percentage = right) {

        var css = "$top"

        if ( right != top || bottom != top || left != right ) {
            css += " $right"
        }

        if ( bottom != top || left != right ) {
            css += " $bottom"
        }

        if ( left != right ) {
            css += " $left"
        }

        setProperty("padding", css)

    }

    fun paddingBottom(value: Length) =
        setProperty("padding-bottom", "$value")

    fun paddingBottom(value: Percentage) =
        setProperty("padding-bottom", "$value")

    fun paddingLeft(value: Length) =
        setProperty("padding-left", "$value")

    fun paddingLeft(value: Percentage) =
        setProperty("padding-left", "$value")

    fun paddingRight(value: Length) =
        setProperty("padding-right", "$value")

    fun paddingRight(value: Percentage) =
        setProperty("padding-right", "$value")

    fun paddingTop(value: Length) =
        setProperty("padding-top", "$value")

    fun paddingTop(value: Percentage) =
        setProperty("padding-top", "$value")

    fun pageBreakAfter(value: EPageBreakOption) =
        setProperty("page-break-after", value.toCssString())

    fun pageBreakBefore(value: EPageBreakOption) =
        setProperty("page-break-before", value.toCssString())

    fun pageBreakInside(value: EPageBreakInsideOption) =
        setProperty("page-break-inside", value.toCssString())

    fun position(value: EPositionOption) =
        setProperty("position", value.toCssString())

    // TODO: quotes

    fun resize(value: EResizeOption) =
        setProperty("resize", value.toCssString())

    fun right(value: Length) =
        setProperty("right", "$value")

    fun right(value: Percentage) =
        setProperty("right", "$value")

    fun right(value: EAutoOption) =
        setProperty("right", value.toCssString())

    fun tableLayout(value: ETableLayoutOption) =
        setProperty("table-layout", value.toCssString())

    fun textAlign(value: ETextAlignOption) =
        setProperty("text-align", value.toCssString())

    fun textDecoration(value: ENoneOption) =
        setProperty("text-decoration", value.toCssString())

    fun textDecoration(vararg values: ETextDecorationOption) {
        val css = values.map { v -> v.toCssString() }.joinToString(" ")
        setProperty("text-decoration", css)
    }

    fun textIndent(value: Length) =
        setProperty("text-indent", "$value")

    fun textIndent(value: Percentage) =
        setProperty("text-indent", "$value")

    fun textOverflow(value: ETextOverflowOption) =
        setProperty("text-overflow", value.toCssString())

    fun textTransform(value: ETextTransformOption) =
        setProperty("text-transform", value.toCssString())



    fun top(value: Length) =
        setProperty("top", "$value")

    fun top(value: Percentage) =
        setProperty("top", "$value")

    fun top(value: EAutoOption) =
        setProperty("top", value.toCssString())

    // TODO: widows

    fun width(value: Length) =
        setProperty("width", "$value")

    fun width(value: Percentage) =
        setProperty("width", "$value")

    fun width(value: EAutoOption) =
        setProperty("width", value.toCssString())

    ////

    fun inherit(key: String) {
        properties.add("$key: inherit")
    }

    fun setProperty(key: String, value: String) {
        properties.add("$key: $value")
    }

    private fun setStringProperty(key: String, value: String) {
        var cssValue = value.replace("\"", "\\\"")
        cssValue = cssValue.replace("\n", "\\A")
        // TODO: probably more characters worth escaping
        setProperty(key, "\"$cssValue\"")
    }

    fun toCssString(whitespace: String = "\n") =
        properties.joinToString(";" + whitespace) + ";"

    override fun toString() =
        toCssString(" ")

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

