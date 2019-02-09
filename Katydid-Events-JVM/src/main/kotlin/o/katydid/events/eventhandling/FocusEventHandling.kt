
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
 * Adds an event handler for "blur" events.
 * @param handler the callback that listens to blur events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onblur(
    handler: KatydidFocusEventToMessage<Msg>
) {

    onEvent("blur") { event: Event ->
        handler(EventPool.makeFocusEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "focus" events.
 * @param handler the callback that listens to focus events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onfocus(
    handler: KatydidFocusEventToMessage<Msg>
) {

    onEvent("focus") { event: Event ->
        handler(EventPool.makeFocusEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

