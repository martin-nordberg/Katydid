//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.api

import x.org.katydom.dom.events.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * Exception indicating that default handling of an event should be cancelled.
 */
@Suppress("unused")
class EventCancellationException : RuntimeException()

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generic event handler: input is any event. To cancel an event throw EventCancellationException.
 */
typealias EventHandler = (event: Event) -> Unit

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias Event2Message<Msg> = (event: Event) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Focus event handler: argument is a focus event. To cancel an event throw EventCancellationException.
 */
typealias FocusEventHandler = (event: FocusEvent) -> Unit

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any focus event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias FocusEvent2Message<Msg> = (event: FocusEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Input event handler: argument is an input event. To cancel an event throw EventCancellationException.
 */
typealias InputEventHandler = (event: InputEvent) -> Unit

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any input event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias InputEvent2Message<Msg> = (event: InputEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Keyboard event handler: argument is a keyboard event. To cancel an event throw EventCancellationException.
 */
typealias KeyboardEventHandler = (event: KeyboardEvent) -> Unit

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any keyboard event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias KeyboardEvent2Message<Msg> = (event: KeyboardEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Mouse event handler: argument is a mouse event. To cancel an event throw EventCancellationException.
 */
typealias MouseEventHandler = (event: MouseEvent) -> Unit

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: argument is any mouse event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias MouseEvent2Message<Msg> = (event: MouseEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

