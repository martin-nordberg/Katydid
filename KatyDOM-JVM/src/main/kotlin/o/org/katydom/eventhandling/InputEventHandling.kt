
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.org.katydom.eventhandling

import o.org.katydom.application.Event2Message
import o.org.katydom.application.InputEvent2Message
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.eventhandling.types.EEventType
import o.org.katydom.eventhandling.types.EInputEventType
import x.org.katydom.dom.events.Event
import x.org.katydom.dom.events.InputEvent


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

