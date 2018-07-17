//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.org.katydom.eventhandling

import o.org.katydom.api.WheelEvent2Message
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.eventhandling.types.EWheelEventType
import x.org.katydom.dom.events.Event
import x.org.katydom.dom.events.WheelEvent

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "wheel" events.
 * @param handler the callback that listens to wheel events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onwheel(handler: WheelEvent2Message<Msg>) {

    onEvent(EWheelEventType.WHEEL.domName) { event: Event ->
        handler(event as WheelEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

