//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the dir attribute.
 * See https://www.w3.org/TR/html5/dom.html#the-dir-attribute.
 */
@Suppress("EnumEntryName")
enum class EDirection(
    private val html: String
) {

    /** The "ltr" attribute value. */
    ltr("ltr"),

    /** The "rtl" attribute value. */
    rtl("rtl"),

    /** The "auto" attribute value. */
    auto("auto");

    ////

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

