//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import x.katydid.events.domevents.MouseEvent
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any mouse event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias MouseEvent2Message<Msg> = (event: MouseEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "click" events.
 * @param handler the callback that listens to click events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onclick(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("click") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "dblclick" events.
 * @param handler the callback that listens to dblclick events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.ondblclick(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("dblclick") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousedown" events.
 * @param handler the callback that listens to mousedown events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmousedown(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("mousedown") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseenter" events.
 * @param handler the callback that listens to mouseenter events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseenter(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("mouseenter") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseleave" events.
 * @param handler the callback that listens to mouseleave events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseleave(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("mouseleave") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousemove" events.
 * @param handler the callback that listens to mousemove events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmousemove(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("mousemove") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseout" events.
 * @param handler the callback that listens to mouseout events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseout(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("mouseout") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseover" events.
 * @param handler the callback that listens to mouseover events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseover(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("mouseover") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseup" events.
 * @param handler the callback that listens to mouseup events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseup(
    handler: MouseEvent2Message<Msg>
) {

    onEvent("mouseup") { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

