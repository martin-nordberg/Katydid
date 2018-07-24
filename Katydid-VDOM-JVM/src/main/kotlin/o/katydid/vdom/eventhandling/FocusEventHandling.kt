
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.vdom.eventhandling

import o.katydid.vdom.application.FocusEvent2Message
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.eventhandling.types.EFocusEventType
import x.katydid.vdom.dom.events.Event
import x.katydid.vdom.dom.events.FocusEvent

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "blur" events.
 * @param handler the callback that listens to blur events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onblur(handler: FocusEvent2Message<Msg>) {

    onEvent(EFocusEventType.BLUR.domName) { event: Event ->
        handler(event as FocusEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "focus" events.
 * @param handler the callback that listens to focus events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onfocus(handler: FocusEvent2Message<Msg>) {

    onEvent(EFocusEventType.FOCUS.domName) { event: Event ->
        handler(event as FocusEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

