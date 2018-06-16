//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of DOM keyboard event types.
 */
enum class EKeyboardEventType {

    /** Keyboard event type "keydown". */
    KEY_DOWN,

    /** Keyboard event type "keyup". */
    KEY_UP;

    /**
     * The name of the event in the DOM.
     */
    val domName: String
        get() {
            return when (this) {
                KEY_DOWN -> "keydown"
                KEY_UP   -> "keyup"
            }
        }

}

//---------------------------------------------------------------------------------------------------------------------

