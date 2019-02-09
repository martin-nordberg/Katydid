
//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.events.eventhandling

import o.katydid.events.types.*


//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KatydidEventToMessage<Msg> = (event: KatydidEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any focus event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KatydidFocusEventToMessage<Msg> = (event: KatydidFocusEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any input event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KatydidInputEventToMessage<Msg> = (event: KatydidInputEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any mouse event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KatydidMouseEventToMessage<Msg> = (event: KatydidMouseEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any wheel event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KatydidWheelEventToMessage<Msg> = (event: KatydidWheelEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

