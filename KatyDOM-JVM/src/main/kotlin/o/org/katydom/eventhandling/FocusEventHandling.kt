
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.org.katydom.eventhandling

import o.org.katydom.api.FocusEvent2Message
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.eventhandling.types.EFocusEventType
import x.org.katydom.dom.events.Event
import x.org.katydom.dom.events.FocusEvent

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

