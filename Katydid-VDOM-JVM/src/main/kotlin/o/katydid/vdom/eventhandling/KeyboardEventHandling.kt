
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.vdom.eventhandling

import o.katydid.vdom.application.KeyboardEvent2Message
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.eventhandling.types.EKeyboardEventType
import x.katydid.vdom.dom.events.Event
import x.katydid.vdom.dom.events.KeyboardEvent


//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "keydown" events.
 * @param handler the callback that listens to keydown events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onkeydown(handler: KeyboardEvent2Message<Msg>) {

    onEvent(EKeyboardEventType.KEY_DOWN.domName) { event: Event ->
        handler(event as KeyboardEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "keyup" events.
 * @param handler the callback that listens to keyup events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onkeyup(handler: KeyboardEvent2Message<Msg>) {

    onEvent(EKeyboardEventType.KEY_UP.domName) { event: Event ->
        handler(event as KeyboardEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

