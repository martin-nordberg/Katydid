//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of DOM mouse event types.
 * See https://w3c.github.io/uievents/#events-mouseevents
 */
enum class EMouseEventType {

    /** Mouse event type "click". */
    CLICK,

    /** Mouse event type "dblclick". */
    DBL_CLICK,

    /** Mouse event type "mousedown". */
    MOUSE_DOWN,

    /** Mouse event type "mouseenter". */
    MOUSE_ENTER,

    /** Mouse event type "mouseleave". */
    MOUSE_LEAVE,

    /** Mouse event type "mousemove". */
    MOUSE_MOVE,

    /** Mouse event type "mouseout". */
    MOUSE_OUT,

    /** Mouse event type "mouseover". */
    MOUSE_OVER,

    /** Mouse event type "mouseup". */
    MOUSE_UP;

    /**
     * The name of the event in the DOM.
     */
    val domName: String
        get() {
            return when (this) {
                CLICK       -> "click"
                DBL_CLICK   -> "dblclick"
                MOUSE_DOWN  -> "mousedown"
                MOUSE_ENTER -> "mouseenter"
                MOUSE_LEAVE -> "mouseleave"
                MOUSE_MOVE  -> "mousemove"
                MOUSE_OUT   -> "mouseout"
                MOUSE_OVER  -> "mouseover"
                MOUSE_UP    -> "mouseup"
            }
        }

}

//---------------------------------------------------------------------------------------------------------------------

