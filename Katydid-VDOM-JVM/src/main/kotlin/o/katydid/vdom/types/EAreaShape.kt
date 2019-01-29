//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the shape attribute of an area element.
 */
@Suppress("EnumEntryName")
enum class EAreaShape(
    private val html: String
) {

    /** Target shape is a circle. */
    circle("circle"),

    /** Target shape is default. */
    default("default"),

    /** Target shape is a polygon. */
    poly("poly"),

    /** Target shape is a rectangle. */
    rect("rect");

    ////

    /** @return the attribute value corresponding to this shape. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

