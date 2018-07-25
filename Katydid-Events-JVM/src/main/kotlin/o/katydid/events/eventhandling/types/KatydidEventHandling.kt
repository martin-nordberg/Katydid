//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.events.eventhandling.types

import x.katydid.events.types.*


//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any focus event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias FocusEvent2Message<Msg> = (event: FocusEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any input event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias InputEvent2Message<Msg> = (event: InputEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any keyboard event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KeyboardEvent2Message<Msg> = (event: KeyboardEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any mouse event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias MouseEvent2Message<Msg> = (event: MouseEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is a wheel event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias WheelEvent2Message<Msg> = (event: WheelEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

