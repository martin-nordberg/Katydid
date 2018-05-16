//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of DOM focus event types.
 */
enum class EFocusEventType {

    /** A "blur" event. */
    BLUR,

    /** A "focus" event. */
    FOCUS;

    /**
     * The name of the event in the DOM.
     */
    val domName: String
        get() {
            return when (this) {
                BLUR      -> "blur"
                FOCUS     -> "focus"
            }
        }

}

//---------------------------------------------------------------------------------------------------------------------

