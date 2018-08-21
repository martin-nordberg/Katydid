
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.events.types

//---------------------------------------------------------------------------------------------------------------------

interface KatydidEvent {

    val isDefaultPrevented: Boolean

    val isPropagationStopped: Boolean

    ////

    fun <T> getTargetAttribute(attrName: String): T

    fun preventDefault()

    fun <T> setTargetAttribute(attrName: String, value: T)

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

