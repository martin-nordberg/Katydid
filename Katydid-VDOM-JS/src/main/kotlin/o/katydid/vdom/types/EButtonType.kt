//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the type attribute of a button element.
 */
@Suppress("EnumEntryName")
enum class EButtonType(
    private val html: String
) {

    /** Simple button. */
    button("button"),

    /** Button in a menu. */
    menu("menu"),

    /** Button to submit a form. */
    reset("reset"),

    /** Button to reset a form. */
    submit("submit");

    ////

    /** @return the attribute value corresponding to this button type. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

