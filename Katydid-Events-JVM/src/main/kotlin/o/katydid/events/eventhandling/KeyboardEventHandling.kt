
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import x.katydid.events.domevents.KeyboardEvent
import x.katydid.vdom.dom.events.Event


//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any keyboard event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KeyboardEvent2Message<Msg> = (event: KeyboardEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "keydown" events.
 * @param handler the callback that listens to keydown events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onkeydown(
    handler: KeyboardEvent2Message<Msg>
) {

    onEvent("keydown") { event: Event ->
        handler(event as KeyboardEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "keyup" events.
 * @param handler the callback that listens to keyup events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onkeyup(
    handler: KeyboardEvent2Message<Msg>
) {

    onEvent("keyup") { event: Event ->
        handler(event as KeyboardEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

