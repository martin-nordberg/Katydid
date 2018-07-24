
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.vdom.eventhandling

import o.katydid.vdom.application.Event2Message
import o.katydid.vdom.application.InputEvent2Message
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.eventhandling.types.EEventType
import o.katydid.vdom.eventhandling.types.EInputEventType
import x.katydid.vdom.dom.events.Event
import x.katydid.vdom.dom.events.InputEvent


//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "beforeinput" events.
 * @param handler the callback that listens to beforeinput events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onbeforeinput(handler: InputEvent2Message<Msg>) {

    onEvent(EInputEventType.BEFORE_INPUT.domName) { event: Event ->
        handler(event as InputEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "change" events.
 * @param handler the callback that listens to change events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onchange(handler: Event2Message<Msg>) {

    onEvent(EEventType.CHANGE.domName) { event: Event ->
        handler(event)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "input" events.
 * @param handler the callback that listens to input events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.oninput(handler: InputEvent2Message<Msg>) {

    onEvent(EInputEventType.INPUT.domName) { event: Event ->
        handler(event as InputEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

