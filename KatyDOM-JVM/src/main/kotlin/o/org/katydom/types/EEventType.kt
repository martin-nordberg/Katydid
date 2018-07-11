//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of DOM event types.
 */
enum class EEventType {

    /** A "change" event. */
    CHANGE;

    /**
     * The name of the event in the DOM.
     */
    val domName: String
        get() =
            when (this) {
                CHANGE -> "change"
            }


}

//---------------------------------------------------------------------------------------------------------------------

