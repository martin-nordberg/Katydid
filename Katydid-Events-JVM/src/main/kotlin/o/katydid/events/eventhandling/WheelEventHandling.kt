//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import i.katydid.events.pool.EventPool
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "wheel" events.
 * @param handler the callback that listens to wheel events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onwheel(
    handler: KatydidWheelEventToMessage<Msg>
) {

    onEvent("wheel") { event: Event ->
        handler(EventPool.makeWheelEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

