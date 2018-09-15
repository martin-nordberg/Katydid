//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the wrap attribute of a textarea element.
 */
@Suppress("EnumEntryName")
enum class EWrapType(
    private val html: String
) {

    /** Wrap type "hard". */
    hard("hard"),

    /** Wrap type "soft". */
    soft("soft");

    ////

    /** @return the HTML attribute text value corresponding to this wrap type. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

