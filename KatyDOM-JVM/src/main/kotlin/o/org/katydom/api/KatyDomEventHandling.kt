//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.api

import x.org.katydom.dom.events.Event
import x.org.katydom.dom.events.MouseEvent

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
 * Message-generating event handler: input is any event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias Event2Message<Msg> = (event: Event) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

/**
 * Mouse event handler: input is a mouse event. To cancel an event throw EventCancellationException.
 */
typealias MouseEventHandler = (event: MouseEvent) -> Unit

//---------------------------------------------------------------------------------------------------------------------

/**
 * Message-generating event handler: input is any mouse event, output is a list of messages.
 * To cancel an event throw EventCancellationException.
 */
typealias MouseEvent2Message<Msg> = (event: MouseEvent) -> Iterable<Msg>

//---------------------------------------------------------------------------------------------------------------------

