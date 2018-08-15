//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.events.types

import o.katydid.events.types.KatydidEvent
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

open class KatydidEventImpl(
    private val event: Event
) : KatydidEvent {

    override val isDefaultPrevented : Boolean
        get() = false

    override val isPropagationStopped : Boolean
        get() = false

    override fun preventDefault() {
        // maybe add stuff for JVM mock testing
    }

    override fun stopPropagation() {
        // maybe add stuff for JVM mock testing
    }

    override fun <T> targetAttribute(attrName: String): T {
        TODO()
    }

}

//---------------------------------------------------------------------------------------------------------------------

