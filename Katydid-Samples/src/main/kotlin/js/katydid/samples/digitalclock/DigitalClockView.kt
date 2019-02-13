//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.digitalclock

import o.katydid.css.colors.red
import o.katydid.css.styles.builders.color
import o.katydid.css.styles.style
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Constructs the Katydid virtual DOM tree for given input [applicationState].
 * @return the root of the application's virtual DOM tree for given application state.
 */
fun viewDigitalClock(applicationState: DigitalClockAppState): KatydidFlowContentBuilder<DigitalClockMsg>.() -> Unit =
    {

        // This top level element replaces the "#app" div in digitalclock.html.
        main("#digital-clock-app") {

            val timePieces = applicationState.time.toTimeString().split(" ", limit=2)

            val time = timePieces[0]
            val timeZone = timePieces[1]

            h1 {
                text(timeZone)
            }

            div ( "#display" ) {

                style {
                    color(red)
                }

                div("#h1.clock.digit") {
                    text(time.substring(0..0))
                }
                div("#h2.clock.digit") {
                    text(time.substring(1..1))
                }
                div("#m0.clock.separator") {
                    text(":")
                }
                div("#m1.clock.digit") {
                    text(time.substring(3..3))
                }
                div("#m2.clock.digit") {
                    text(time.substring(4..4))
                }
                div("#s0.clock.separator") {
                    text(":")
                }
                div("#s1.clock.digit") {
                    text(time.substring(6..6))
                }
                div("#s2.clock.digit") {
                    text(time.substring(7..7))
                }

            }

        }

    }

//---------------------------------------------------------------------------------------------------------------------
