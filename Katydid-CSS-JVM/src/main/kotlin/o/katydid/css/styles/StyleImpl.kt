//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

//---------------------------------------------------------------------------------------------------------------------

class StyleImpl internal constructor() : Style {

    private val myProperties = mutableListOf<String>()

    override val important: Unit
        get() {
            require(properties.size > 0) { "Set a property before making it important." }
            require(!properties[properties.size - 1].endsWith("!important")) { "Last property already set to important." }

            myProperties[myProperties.size - 1] += " !important"
        }

    override val isNotEmpty
        get() = properties.isNotEmpty()

    override val properties = myProperties

    ////

    override fun include(style: Style) {

        for (property in style.properties) {
            myProperties.add(property)
        }

    }

    override fun inherit(key: String) =
        setProperty(key, "inherit")

    override fun <T> setBoxProperty(key: String, top: T, right: T, bottom: T, left: T) {

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

    override fun setProperty(key: String, value: String) {
        myProperties.add("$key: $value")
    }

    override fun <T> setXyProperty(key: String, x: T, y: T) {

        var css = "$x"

        if (x != y) {
            css += " $y"
        }

        setProperty(key, css)

    }

    override fun setStringProperty(key: String, value: String) {
        var cssValue = value.replace("\"", "\\\"")
        cssValue = cssValue.replace("\n", "\\A")
        // TODO: probably more characters worth escaping
        setProperty(key, "\"$cssValue\"")
    }

    override fun toCssString(indent: String, whitespace: String) =
        properties.map { p -> indent + p }.joinToString(";" + whitespace) + ";"

    override fun toString() =
        toCssString("", " ")

}

//---------------------------------------------------------------------------------------------------------------------

