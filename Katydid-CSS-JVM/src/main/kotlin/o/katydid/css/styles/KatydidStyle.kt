//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

import i.katydid.css.styles.KatydidStyleImpl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to a style - one or more CSS properties with values.
 */
interface KatydidStyle {

    /** The individual properties making up this style. */
    val properties: List<String>

    /** Funky side-effecting getter actually sets the previously set property to be !important. */
    val important: Unit

    /** True if this style has at least one property. */
    val isNotEmpty: Boolean

    ////

    /** Copies all the properties from the given [style]. (Similar to CSS @import.) */
    fun include(style: KatydidStyle)

    /** Adds a given property with key [key] and value "inherit". */
    fun inherit(key: String)

    /** Sets a property with 1-4 values [top], [right], [bottom], [left] for the CSS box model. */
    fun <T> setBoxProperty(key: String, top: T, right: T = top, bottom: T = top, left: T = right)

    /** Sets a property of the style with given [key] and [value]. */
    fun setProperty(key: String, value: String)

    /** Sets an [x]/[y] or horizontal/vertical two-value property with given [key]. */
    fun <T> setXyProperty(key: String, x: T, y: T = x)

    /** Sets a property where the value is to become a quoted string. */
    fun setStringProperty(key: String, value: String)

    /**
     * Converts this style to CSS with [indent] spaces at the beginning of each line and [whitespace] between
     * successive lines.
     */
    fun toCssString(indent: String = "", whitespace: String = "\n"): String

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style object.
 * @param build the callback that fills in the CSS properties.
 */
fun makeStyle(
    build: KatydidStyle.() -> Unit
): KatydidStyle {

    val result = KatydidStyleImpl()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

