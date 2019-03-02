//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.digitalclock

import js.katydid.vdom.api.KatydidApplicationCycle
import js.katydid.vdom.api.KatydidCommand


//---------------------------------------------------------------------------------------------------------------------

/**
 * Creates a new application state modified from given [applicationState] by the given [message].
 */
@Suppress("UNUSED_PARAMETER")
fun updateDigitalClock(
    applicationState: DigitalClockAppState,
    message: DigitalClockMsg
): KatydidApplicationCycle<DigitalClockAppState, DigitalClockMsg> {

    val commandsToExecute = listOf<KatydidCommand<DigitalClockMsg>>()

    val newApplicationState = when (message) {

        is ClockTickMsg ->
            DigitalClockAppState()

    }

    return KatydidApplicationCycle(newApplicationState, commandsToExecute)

}

//---------------------------------------------------------------------------------------------------------------------

