
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.events.eventhandling.types.InputEvent2Message
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.events.eventhandling.types.EEventType
import o.katydid.events.eventhandling.types.EInputEventType
import x.katydid.events.types.InputEvent
import x.katydid.vdom.dom.events.Event
import o.katydid.vdom.types.Event2Message


//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "beforeinput" events.
 * @param handler the callback that listens to beforeinput events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onbeforeinput(handler: InputEvent2Message<Msg>) {

    onEvent(EInputEventType.BEFORE_INPUT.domName) { event: Event ->
        handler(event as InputEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "change" events.
 * @param handler the callback that listens to change events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onchange(handler: Event2Message<Msg>) {

    onEvent(EEventType.CHANGE.domName) { event: Event ->
        handler(event)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "input" events.
 * @param handler the callback that listens to input events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.oninput(handler: InputEvent2Message<Msg>) {

    onEvent(EInputEventType.INPUT.domName) { event: Event ->
        handler(event as InputEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

