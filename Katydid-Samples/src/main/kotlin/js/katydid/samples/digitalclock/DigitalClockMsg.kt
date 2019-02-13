//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.digitalclock

//---------------------------------------------------------------------------------------------------------------------

/** Simple message for user and system events. */
sealed class DigitalClockMsg

//---------------------------------------------------------------------------------------------------------------------

/** Message when a a second has elapsed. */
object ClockTickMsg : DigitalClockMsg()

//---------------------------------------------------------------------------------------------------------------------
