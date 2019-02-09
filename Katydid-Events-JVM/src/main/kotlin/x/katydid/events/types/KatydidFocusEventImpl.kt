//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.events.types

import o.katydid.events.types.KatydidFocusEvent
import x.katydid.events.domevents.FocusEvent

//---------------------------------------------------------------------------------------------------------------------

class KatydidFocusEventImpl(
    private val event: FocusEvent
) : KatydidUiEventImpl(event), KatydidFocusEvent {

}

//---------------------------------------------------------------------------------------------------------------------

