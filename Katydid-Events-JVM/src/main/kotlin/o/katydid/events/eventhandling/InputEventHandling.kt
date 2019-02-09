
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
 * Adds an event handler for "beforeinput" events.
 * @param handler the callback that listens to beforeinput events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onbeforeinput(
    handler: KatydidInputEventToMessage<Msg>
) {

    onEvent("beforeinput") { event: Event ->
        handler(EventPool.makeInputEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "change" events.
 * @param handler the callback that listens to change events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onchange(
    handler: KatydidEventToMessage<Msg>
) {

    onEvent("change") { event: Event ->
        handler(EventPool.makeEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "input" events.
 * @param handler the callback that listens to input events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.oninput(
    handler: KatydidInputEventToMessage<Msg>
) {

    onEvent("input") { event: Event ->
        handler(EventPool.makeInputEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

