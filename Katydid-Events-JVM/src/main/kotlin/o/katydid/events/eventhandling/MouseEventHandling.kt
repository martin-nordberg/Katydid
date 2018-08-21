//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import i.katydid.events.pool.EventPool
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "click" events.
 * @param handler the callback that listens to click events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onclick(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("click") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "dblclick" events.
 * @param handler the callback that listens to dblclick events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.ondblclick(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("dblclick") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousedown" events.
 * @param handler the callback that listens to mousedown events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmousedown(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("mousedown") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseenter" events.
 * @param handler the callback that listens to mouseenter events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseenter(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("mouseenter") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseleave" events.
 * @param handler the callback that listens to mouseleave events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseleave(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("mouseleave") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousemove" events.
 * @param handler the callback that listens to mousemove events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmousemove(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("mousemove") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseout" events.
 * @param handler the callback that listens to mouseout events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseout(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("mouseout") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseover" events.
 * @param handler the callback that listens to mouseover events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseover(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("mouseover") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseup" events.
 * @param handler the callback that listens to mouseup events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseup(
    handler: KatydidMouseEventToMessage<Msg>
) {

    onEvent("mouseup") { event: Event ->
        handler(EventPool.makeMouseEvent(event))
    }

}

//---------------------------------------------------------------------------------------------------------------------

