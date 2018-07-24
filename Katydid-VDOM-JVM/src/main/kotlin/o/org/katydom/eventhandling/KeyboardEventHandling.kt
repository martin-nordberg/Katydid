
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.org.katydom.eventhandling

import o.org.katydom.application.KeyboardEvent2Message
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.eventhandling.types.EKeyboardEventType
import x.org.katydom.dom.events.Event
import x.org.katydom.dom.events.KeyboardEvent


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

