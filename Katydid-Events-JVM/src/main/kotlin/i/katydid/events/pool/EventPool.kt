//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/i.katydid.events.pool

import o.katydid.events.types.KatydidEvent
import o.katydid.events.types.KatydidFocusEvent
import o.katydid.events.types.KatydidInputEvent
import x.katydid.events.domevents.FocusEvent
import x.katydid.events.domevents.InputEvent
import x.katydid.events.types.KatydidEventImpl
import x.katydid.events.types.KatydidFocusEventImpl
import x.katydid.events.types.KatydidInputEventImpl
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/** Interface to a focus event from the DOM. */
internal class EventPool {

    companion object {

        fun makeEvent(event: Event) : KatydidEvent =
            KatydidEventImpl(event)

        fun makeFocusEvent(event: Event) : KatydidFocusEvent =
            KatydidFocusEventImpl(event as FocusEvent)

        fun makeInputEvent(event: Event) : KatydidInputEvent =
            KatydidInputEventImpl(event as InputEvent)

    }

}

//---------------------------------------------------------------------------------------------------------------------

