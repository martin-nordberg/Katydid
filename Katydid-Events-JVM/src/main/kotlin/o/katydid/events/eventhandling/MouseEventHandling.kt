//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.events.eventhandling.types.MouseEvent2Message
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.events.eventhandling.types.EMouseEventType
import x.katydid.events.types.MouseEvent
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "click" events.
 * @param handler the callback that listens to click events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onclick(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.CLICK.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "dblclick" events.
 * @param handler the callback that listens to dblclick events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.ondblclick(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.DOUBLE_CLICK.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousedown" events.
 * @param handler the callback that listens to mousedown events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmousedown(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_DOWN.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseenter" events.
 * @param handler the callback that listens to mouseenter events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseenter(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_ENTER.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseleave" events.
 * @param handler the callback that listens to mouseleave events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseleave(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_LEAVE.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousemove" events.
 * @param handler the callback that listens to mousemove events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmousemove(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_MOVE.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseout" events.
 * @param handler the callback that listens to mouseout events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseout(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_OUT.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseover" events.
 * @param handler the callback that listens to mouseover events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseover(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_OVER.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseup" events.
 * @param handler the callback that listens to mouseup events.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.onmouseup(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_UP.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

