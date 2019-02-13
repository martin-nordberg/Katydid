//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.digitalclock

import js.katydid.css.buildStyleElement
import js.katydid.vdom.api.KatydidApplication
import js.katydid.vdom.api.KatydidApplicationCycle
import js.katydid.vdom.api.runApplication
import o.katydid.css.colors.black
import o.katydid.css.measurements.em
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.*
import o.katydid.css.stylesheets.makeStyleSheet
import o.katydid.css.types.EFloat
import o.katydid.css.types.ETextAlign
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import kotlin.browser.document

//---------------------------------------------------------------------------------------------------------------------

/**
 * Katydid application for showing a digital clock.
 */
class DigitalClockApplication : KatydidApplication<DigitalClockAppState, DigitalClockMsg> {

    /**
     * Initializes the application state for the first time.
     */
    override fun initialize(): KatydidApplicationCycle<DigitalClockAppState, DigitalClockMsg> =
        KatydidApplicationCycle(DigitalClockAppState(),listOf(::updateTime))

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    override fun update(
        applicationState: DigitalClockAppState,
        message: DigitalClockMsg
    ): KatydidApplicationCycle<DigitalClockAppState, DigitalClockMsg> =
        updateDigitalClock(applicationState, message)

    /**
     * Constructs the Katydid virtual DOM tree for given input application state [applicationState].
     * @return a builder that builds the root of the application's virtual DOM tree for given application state.
     */
    override fun view(
        applicationState: DigitalClockAppState
    ): KatydidFlowContentBuilder<DigitalClockMsg>.() -> Unit =
        viewDigitalClock(applicationState)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Runs the Digital Clock application.
 */
@Suppress("UNUSED_PARAMETER")
fun digitalClockMain(args: Array<String>) {

    val css = makeDigitalClockStyleSheet()

    val cssElement = document.getElementById("appStyleElement")!!

    buildStyleElement(cssElement, css)

    runApplication(
        "app",
        DigitalClockApplication()
    )

}

//---------------------------------------------------------------------------------------------------------------------

fun makeDigitalClockStyleSheet() =
    makeStyleSheet {

        /* BODY */
        "body" {
            fontFamily("Arial", "Helvetica Neue", "Helvetica", "sans-serif")
        }

        "div.clock" {
            backgroundColor(black)
            float(EFloat.left)
            fontSize(100.px)
            fontFamily( "Orbitron" )
            textAlign(ETextAlign.center)

            "&.digit" {
                width(1.em)
            }

            "&.separator" {
                width(0.3.em)
            }
        }

    }

//---------------------------------------------------------------------------------------------------------------------
