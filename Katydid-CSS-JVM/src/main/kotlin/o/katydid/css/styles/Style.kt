//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

import o.katydid.css.colors.Color
import o.katydid.css.measurements.Length
import o.katydid.css.types.EDisplayOption
import o.katydid.vdom.builders.KatydidAttributesContentBuilder

//---------------------------------------------------------------------------------------------------------------------

class Style {

    private val properties = mutableListOf<String>()

    ////

    var color: Color
        get() = throw UnsupportedOperationException("Styles are write-only.")
        set(value) = setColor("color", value)

    var display: EDisplayOption
        get() = throw UnsupportedOperationException("Styles are write-only.")
        set(value) = setProperty("display", value.toCssString())

    var height: Length
        get() = throw UnsupportedOperationException("Styles are write-only.")
        set(value) = setLength("height", value)

    /** Funky getter actually sets the last used key to be !important. */
    val important: Unit
        get() {
            require(properties.size > 0) { "Set a property before making it important." }
            properties[properties.size - 1] += " !important"
        }

    var width: Length
        get() = throw UnsupportedOperationException("Styles are write-only.")
        set(value) = setLength("width", value)

    ////

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
) : Style {

    val result = Style()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

