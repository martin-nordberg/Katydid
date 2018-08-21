//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.events.types

import o.katydid.events.types.KatydidMouseEvent
import x.katydid.events.domevents.MouseEvent

//---------------------------------------------------------------------------------------------------------------------

open class KatydidMouseEventImpl(
    private val event: MouseEvent
) : KatydidUiEventImpl(event), KatydidMouseEvent {

    override val altKey: Boolean
        get() = event.altKey

    override val button: Short
        get() = event.button

    override val buttons: Short
        get() = event.buttons

    override val clientX: Int
        get() = event.clientX

    override val clientY: Int
        get() = event.clientY

    override val ctrlKey: Boolean
        get() = event.ctrlKey

    override val metaKey: Boolean
        get() = event.metaKey

    override val pageX: Double
        get() = event.pageX

    override val pageY: Double
        get() = event.pageY

    override val screenX: Int
        get() = event.screenX

    override val screenY: Int
        get() = event.screenY

    override val shiftKey: Boolean
        get() = event.shiftKey

    ////

    override fun getModifierState(key: String): Boolean {
        return event.getModifierState(key)
    }

}

//---------------------------------------------------------------------------------------------------------------------

