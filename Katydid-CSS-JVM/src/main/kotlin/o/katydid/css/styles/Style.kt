//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

//---------------------------------------------------------------------------------------------------------------------

interface Style {

    val properties: List<String>

    /** Funky side-effecting getter actually sets the previously set property to be !important. */
    val important: Unit

    val isNotEmpty: Boolean

    ////

    fun include(style: Style)

    fun inherit(key: String)

    fun <T> setBoxProperty(key: String, top: T, right: T = top, bottom: T = top, left: T = right)

    fun setProperty(key: String, value: String)

    fun <T> setXyProperty(key: String, x: T, y: T = x)

    fun setStringProperty(key: String, value: String)

    fun toCssString(indent: String = "", whitespace: String = "\n"): String

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style object.
 * @param build the callback that fills in the CSS properties.
 */
fun makeStyle(
    build: Style.() -> Unit
): Style {

    val result = StyleImpl()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

