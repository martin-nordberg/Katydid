
//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.events.types

//---------------------------------------------------------------------------------------------------------------------

interface KatydidWheelEvent : KatydidMouseEvent {

    enum class DeltaMode {
        DELTA_PIXEL,
        DELTA_LINE,
        DELTA_PAGE
    }

    val deltaMode: DeltaMode

    val deltaX: Double

    val deltaY: Double

    val deltaZ: Double

}

//---------------------------------------------------------------------------------------------------------------------

