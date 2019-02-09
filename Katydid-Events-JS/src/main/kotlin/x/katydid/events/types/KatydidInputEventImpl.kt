//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*js*/x.katydid.events.types

import o.katydid.events.types.KatydidInputEvent
import x.katydid.events.domevents.InputEvent

//---------------------------------------------------------------------------------------------------------------------

class KatydidInputEventImpl(
    private val event: InputEvent
) : KatydidUiEventImpl(event), KatydidInputEvent {

}

//---------------------------------------------------------------------------------------------------------------------

