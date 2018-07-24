//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.vdom.dom.events

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to a DOM event.
 */
interface Event {

    /** Prevents the default handling of the event. Does nothing on the JVM. */
    fun preventDefault()

}

//---------------------------------------------------------------------------------------------------------------------

