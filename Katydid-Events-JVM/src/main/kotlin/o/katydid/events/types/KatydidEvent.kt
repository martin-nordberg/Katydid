
//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.events.types

//---------------------------------------------------------------------------------------------------------------------

/** Wrapper for DOM events. */
interface KatydidEvent {

    /** True if the event has been prevented from its default handling. */
    val isDefaultPrevented: Boolean

    /** True if the event has had its propagation stopped. */
    val isPropagationStopped: Boolean

    ////

    /**
     * Returns the attribute named [attrName] of the event target.
     */
    fun <T> getTargetAttribute(attrName: String): T

    /**
     * Prevents the default handling of the event.
     */
    fun preventDefault()

    /**
     * Updates the attribute named [attrName] of the event target to [value].
     */
    fun <T> setTargetAttribute(attrName: String, value: T)

    /**
     * Stops the event from further propagation.
     */
    fun stopPropagation()

    // TODO: cf. React SyntheticEvent
    // boolean bubbles
    // boolean cancelable
    // DOMEventTarget currentTarget
    // number eventPhase
    // boolean isTrusted
    // DOMEvent nativeEvent
    // DOMEventTarget target
    // number timeStamp
    // string type

}

//---------------------------------------------------------------------------------------------------------------------

