//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.events.eventhandling.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of DOM wheel event types.
 * See https://w3c.github.io/uievents/#events-mouseevents
 */
enum class EWheelEventType {

    /** Mouse event type "wheel". */
    WHEEL;

    /**
     * The name of the event in the DOM.
     */
    val domName: String
        get() =
            when (this) {
                WHEEL -> "wheel"
            }

}

//---------------------------------------------------------------------------------------------------------------------

