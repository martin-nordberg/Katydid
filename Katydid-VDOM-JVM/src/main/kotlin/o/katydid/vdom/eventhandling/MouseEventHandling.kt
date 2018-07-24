//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.vdom.eventhandling

import o.katydid.vdom.application.MouseEvent2Message
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.eventhandling.types.EMouseEventType
import x.katydid.vdom.dom.events.Event
import x.katydid.vdom.dom.events.MouseEvent

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "click" events.
 * @param handler the callback that listens to click events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onclick(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.CLICK.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "dblclick" events.
 * @param handler the callback that listens to dblclick events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.ondblclick(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.DOUBLE_CLICK.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousedown" events.
 * @param handler the callback that listens to mousedown events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onmousedown(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_DOWN.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseenter" events.
 * @param handler the callback that listens to mouseenter events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onmouseenter(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_ENTER.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseleave" events.
 * @param handler the callback that listens to mouseleave events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onmouseleave(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_LEAVE.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mousemove" events.
 * @param handler the callback that listens to mousemove events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onmousemove(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_MOVE.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseout" events.
 * @param handler the callback that listens to mouseout events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onmouseout(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_OUT.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseover" events.
 * @param handler the callback that listens to mouseover events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onmouseover(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_OVER.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an event handler for "mouseup" events.
 * @param handler the callback that listens to mouseup events.
 */
fun <Msg> KatyDomAttributesContentBuilder<Msg>.onmouseup(handler: MouseEvent2Message<Msg>) {

    onEvent(EMouseEventType.MOUSE_UP.domName) { event: Event ->
        handler(event as MouseEvent)
    }

}

//---------------------------------------------------------------------------------------------------------------------

