//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the wrap attribute of a textarea element.
 */
enum class EWrapType {

    /** Wrap type "hard". */
    HARD,

    /** Wrap type "soft". */
    SOFT;

    /** @return the HTML attribute text value corresponding to this wrap type. */
    fun toHtmlString(): String {
        return when (this) {
            HARD -> "hard"
            SOFT -> "soft"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

