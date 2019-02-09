//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*js*/x.katydid.events.types

import o.katydid.events.types.KatydidWheelEvent
import x.katydid.events.domevents.WheelEvent

//---------------------------------------------------------------------------------------------------------------------

class KatydidWheelEventImpl(
    private val event: WheelEvent
) : KatydidMouseEventImpl(event), KatydidWheelEvent {

    override val deltaMode: KatydidWheelEvent.DeltaMode
        get() = deltaModes[event.deltaMode]

    override val deltaX: Double
        get() = event.deltaX

    override val deltaY: Double
        get() = event.deltaY

    override val deltaZ: Double
        get() = event.deltaZ

    ////

    companion object {

        val deltaModes: List<KatydidWheelEvent.DeltaMode> =
            listOf(
                KatydidWheelEvent.DeltaMode.DELTA_PIXEL,
                KatydidWheelEvent.DeltaMode.DELTA_LINE,
                KatydidWheelEvent.DeltaMode.DELTA_PAGE
            )

    }

}

//---------------------------------------------------------------------------------------------------------------------

