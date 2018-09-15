//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.types.EBackgroundAttachmentOption
import o.katydid.css.types.EBackgroundPositionOption
import o.katydid.css.types.EBackgroundPositionOption.center
import o.katydid.css.types.EBackgroundRepeatOption
import o.katydid.css.types.EDisplayOption

//---------------------------------------------------------------------------------------------------------------------

class Style {

    private val properties = mutableListOf<String>()

    ////

    // TODO: background

    fun backgroundAttachment(value: EBackgroundAttachmentOption) =
        setProperty("background-attachment", value.toCssString())

    fun backgroundColor(value: Color) =
        setColor("background-color", value)

    fun backgroundImage(url: String) =
        setProperty("background-image", "url(\"$url\")")

    fun backgroundImageNone() =
        setProperty("background-image", "none")

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
    // TODO: border-bottom

    fun borderBottomColor(value: Color) =
        setColor("border-bottom-color", value)

    // TODO: border-left
    // TODO: border-right
    // TODO: border-top

    fun color(value: Color) =
        setColor("color", value)

    fun display(value: EDisplayOption) =
        setProperty("display", value.toCssString())

    fun height(value: Length) =
        setLength("height", value)

    /** Funky getter actually sets the last used key to be !important. */
    val important: Unit
        get() {
            require(properties.size > 0) { "Set a property before making it important." }
            properties[properties.size - 1] += " !important"
        }

    fun width(value: Length) =
        setLength("width", value)

    ////

    fun inherit(key: String) {
        properties.add("$key: inherit")
    }

    private fun setColor(key: String, value: Color) {
        properties.add("$key: $value")
    }

    private fun setLength(key: String, value: Length?) {
        properties.add("$key: $value")
    }

    fun setProperty(key: String, value: String?) {
        properties.add("$key: $value")
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

