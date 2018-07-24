//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the dir attribute.
 * See https://www.w3.org/TR/html5/dom.html#the-dir-attribute.
 */
enum class EDirection {

    /** The "ltr" attribute value. */
    LEFT_TO_RIGHT,

    /** The "rtl" attribute value. */
    RIGHT_TO_LEFT,

    /** The "auto" attribute value. */
    AUTO;

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString(): String {
        return when (this) {
            LEFT_TO_RIGHT -> "ltr"
            RIGHT_TO_LEFT -> "rtl"
            AUTO          -> "auto"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

