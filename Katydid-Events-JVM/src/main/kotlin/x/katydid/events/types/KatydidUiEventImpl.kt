//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.events.types

import o.katydid.events.types.KatydidUiEvent
import x.katydid.events.domevents.UIEvent

//---------------------------------------------------------------------------------------------------------------------

open class KatydidUiEventImpl(
    private val event: UIEvent
) : KatydidEventImpl(event), KatydidUiEvent {

}

//---------------------------------------------------------------------------------------------------------------------

