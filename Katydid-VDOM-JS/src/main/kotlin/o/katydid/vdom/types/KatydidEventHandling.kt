//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

import x.katydid.vdom.dom.events.*


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

