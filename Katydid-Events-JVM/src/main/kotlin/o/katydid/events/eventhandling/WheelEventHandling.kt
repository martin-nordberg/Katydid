//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import x.katydid.events.domevents.WheelEvent
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is a wheel event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias WheelEvent2Message<Msg> = (event: WheelEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "wheel" events.
 * @param handler the callback that listens to wheel events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onwheel(
    handler: WheelEvent2Message<Msg>
) {

    onEvent("wheel") { event: Event ->
        handler(event as WheelEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

