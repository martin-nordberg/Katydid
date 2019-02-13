//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.digitalclock

import kotlin.browser.window


//---------------------------------------------------------------------------------------------------------------------

fun updateTime( dispatchMessages: (Iterable<DigitalClockMsg>) -> Unit ) {

    window.setInterval(
        {
            dispatchMessages( listOf(ClockTickMsg) )
        },
        1000
    )

}

//---------------------------------------------------------------------------------------------------------------------

