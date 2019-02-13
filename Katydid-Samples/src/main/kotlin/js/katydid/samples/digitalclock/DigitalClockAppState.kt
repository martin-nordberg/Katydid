//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.digitalclock

import x.katydid.vdom.types.KatyTime
import kotlin.js.Date


//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
data class DigitalClockAppState(

    val time: KatyTime = Date()

)

//---------------------------------------------------------------------------------------------------------------------

