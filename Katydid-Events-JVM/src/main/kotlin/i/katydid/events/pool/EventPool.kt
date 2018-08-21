//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/i.katydid.events.pool

import o.katydid.events.types.*
import x.katydid.events.domevents.FocusEvent
import x.katydid.events.domevents.InputEvent
import x.katydid.events.domevents.MouseEvent
import x.katydid.events.domevents.WheelEvent
import x.katydid.events.types.*
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/** Factory/pool for wrapping DOM events. */
internal class EventPool {

    companion object {

        /** Provides a new generic event wrapping a given DOM [event]. */
        fun makeEvent(event: Event) : KatydidEvent =
            KatydidEventImpl(event)

        /** Provides a new focus event wrapping a given DOM [event]. */
        fun makeFocusEvent(event: Event) : KatydidFocusEvent =
            KatydidFocusEventImpl(event as FocusEvent)

        /** Provides a new input event wrapping a given DOM [event]. */
        fun makeInputEvent(event: Event) : KatydidInputEvent =
            KatydidInputEventImpl(event as InputEvent)

        /** Provides a new mouse event wrapping a given DOM [event]. */
        fun makeMouseEvent(event: Event) : KatydidMouseEvent =
            KatydidMouseEventImpl(event as MouseEvent)

        /** Provides a new wheel event wrapping a given DOM [event]. */
        fun makeWheelEvent(event: Event) : KatydidWheelEvent =
            KatydidWheelEventImpl(event as WheelEvent)

    }

}

//---------------------------------------------------------------------------------------------------------------------

