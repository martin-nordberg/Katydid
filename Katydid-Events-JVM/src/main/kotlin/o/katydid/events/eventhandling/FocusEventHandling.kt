
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.events.eventhandling.types.EFocusEventType
import o.katydid.events.eventhandling.types.FocusEvent2Message
import x.katydid.events.types.FocusEvent
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "blur" events.
 * @param handler the callback that listens to blur events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onblur(handler: FocusEvent2Message<Msg>) {

    onEvent(EFocusEventType.BLUR.domName) { event: Event ->
        handler(event as FocusEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "focus" events.
 * @param handler the callback that listens to focus events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onfocus(handler: FocusEvent2Message<Msg>) {

    onEvent(EFocusEventType.FOCUS.domName) { event: Event ->
        handler(event as FocusEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

