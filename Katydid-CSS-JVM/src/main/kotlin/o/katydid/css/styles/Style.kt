//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

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

    fun include(style: Style) {

        for (property in style.properties) {
            properties.add(property)
        }

    }

    fun inherit(key: String) =
        setProperty(key, "inherit")

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

    fun toCssString(indent: String = "", whitespace: String = "\n") =
        properties.map { p -> indent + p }.joinToString(";" + whitespace) + ";"

    override fun toString() =
        toCssString("", " ")

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

