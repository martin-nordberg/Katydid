//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.events.eventhandling.types.WheelEvent2Message
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.events.eventhandling.types.EWheelEventType
import x.katydid.events.types.WheelEvent
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "wheel" events.
 * @param handler the callback that listens to wheel events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onwheel(handler: WheelEvent2Message<Msg>) {

    onEvent(EWheelEventType.WHEEL.domName) { event: Event ->
        handler(event as WheelEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

