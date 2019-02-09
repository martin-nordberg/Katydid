//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.events.types

import o.katydid.events.types.KatydidWheelEvent
import x.katydid.events.domevents.MouseEvent

//---------------------------------------------------------------------------------------------------------------------

class KatydidWheelEventImpl(
    private val event: MouseEvent
) : KatydidMouseEventImpl(event), KatydidWheelEvent {

    override val deltaMode: KatydidWheelEvent.DeltaMode
        get() = TODO("not implemented")

    override val deltaX: Double
        get() = TODO("not implemented")

    override val deltaY: Double
        get() = TODO("not implemented")

    override val deltaZ: Double
        get() = TODO("not implemented")

}

//---------------------------------------------------------------------------------------------------------------------

