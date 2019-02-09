//
// (C) Copyright 2018-2019 Martin E. Nordberg III
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
        get() = TODO("not implemented")

    override val button: Short
        get() = TODO("not implemented")

    override val buttons: Short
        get() = TODO("not implemented")

    override val clientX: Int
        get() = TODO("not implemented")

    override val clientY: Int
        get() = TODO("not implemented")

    override val ctrlKey: Boolean
        get() = TODO("not implemented")

    override val metaKey: Boolean
        get() = TODO("not implemented")

    override val offsetX: Double
        get() = TODO("not implemented")

    override val offsetY: Double
        get() = TODO("not implemented")

    override val pageX: Double
        get() = TODO("not implemented")

    override val pageY: Double
        get() = TODO("not implemented")

    override val screenX: Int
        get() = TODO("not implemented")

    override val screenY: Int
        get() = TODO("not implemented")

    override val shiftKey: Boolean
        get() = TODO("not implemented")


    override fun getModifierState(key: String): Boolean {
        TODO("not implemented")
    }

}

//---------------------------------------------------------------------------------------------------------------------

