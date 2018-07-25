
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.events.eventhandling.types.KeyboardEvent2Message
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.events.eventhandling.types.EKeyboardEventType
import x.katydid.events.types.KeyboardEvent
import x.katydid.vdom.dom.events.Event


//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "keydown" events.
 * @param handler the callback that listens to keydown events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onkeydown(handler: KeyboardEvent2Message<Msg>) {

    onEvent(EKeyboardEventType.KEY_DOWN.domName) { event: Event ->
        handler(event as KeyboardEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "keyup" events.
 * @param handler the callback that listens to keyup events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onkeyup(handler: KeyboardEvent2Message<Msg>) {

    onEvent(EKeyboardEventType.KEY_UP.domName) { event: Event ->
        handler(event as KeyboardEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

