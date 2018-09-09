//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the type attribute of a button element.
 */
enum class EButtonType {

    /** Simple button. */
    BUTTON,

    /** Button in a menu. */
    MENU,

    /** Button to submit a form. */
    RESET,

    /** Button to reset a form. */
    SUBMIT;

    /** @return the attribute value corresponding to this button type. */
    fun toHtmlString() =
        when (this) {
            BUTTON -> "button"
            MENU   -> "menu"
            RESET  -> "reset"
            SUBMIT -> "submit"
        }

}

//---------------------------------------------------------------------------------------------------------------------

