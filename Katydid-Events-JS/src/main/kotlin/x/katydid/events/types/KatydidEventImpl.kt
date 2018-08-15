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
        get() = event.defaultPrevented

    override val isPropagationStopped : Boolean
        get() = false // TODO: need to track it ourself

    override fun preventDefault() {
        event.preventDefault()
    }

    override fun stopPropagation() {
        event.stopPropagation()
    }

    override fun <T> targetAttribute(attrName: String): T {
        return event.target.asDynamic()[attrName] as T
    }

}

//---------------------------------------------------------------------------------------------------------------------

