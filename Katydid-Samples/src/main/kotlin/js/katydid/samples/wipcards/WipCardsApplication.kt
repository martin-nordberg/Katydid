//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards

import js.katydid.css.buildStyleElement
import js.katydid.vdom.api.KatydidApplication
import js.katydid.vdom.api.KatydidApplicationCycle
import js.katydid.vdom.api.runApplication
import o.katydid.css.colors.black
import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.*
import o.katydid.css.stylesheets.makeStyleSheet
import o.katydid.css.types.EFontWeight
import o.katydid.css.types.ELineStyle
import o.katydid.css.types.ETextAlign
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import kotlin.browser.document

//---------------------------------------------------------------------------------------------------------------------

/**
 * Katydid application for a minimal kanban board.
 */
class WipCardsApplication : KatydidApplication<WipCardsAppState, WipCardsMsg> {

    /**
     * Initializes the application state for the first time.
     */
    override fun initialize(): KatydidApplicationCycle<WipCardsAppState, WipCardsMsg> =
        KatydidApplicationCycle(
            WipCardsAppState(
                listOf(
                    WipCardColumnState("To Do"),
                    WipCardColumnState("Analyze"),
                    WipCardColumnState("Implement"),
                    WipCardColumnState("Test"),
                    WipCardColumnState("Deploy")
                )
            )
        )

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    override fun update(
        applicationState: WipCardsAppState,
        message: WipCardsMsg
    ): KatydidApplicationCycle<WipCardsAppState, WipCardsMsg> =
        updateWipCards(applicationState, message)

    /**
     * Constructs the Katydid virtual DOM tree for given input application state [applicationState].
     * @return a builder that builds the root of the application's virtual DOM tree for given application state.
     */
    override fun view(
        applicationState: WipCardsAppState
    ): KatydidFlowContentBuilder<WipCardsMsg>.() -> Unit =
        viewWipCards(applicationState)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Runs the WIP Cards application.
 */
@Suppress("UNUSED_PARAMETER")
fun wipCardsMain(args: Array<String>) {

    val css = makeWipCardsStyleSheet()

    val cssElement = document.getElementById("appStyleElement")!!

    buildStyleElement(cssElement, css)

    runApplication(
        "app",
        WipCardsApplication()
    )

}

//---------------------------------------------------------------------------------------------------------------------

fun makeWipCardsStyleSheet() =
    makeStyleSheet {

        /* BODY */
        "body" {
            fontFamily("Arial", "Helvetica Neue", "Helvetica", "sans-serif")
        }

        /* TABLE */
        "table" {

            padding(0.px)

            "&.board" {

                width(100.percent)

                "th.column-heading" {
                    border(1.px, ELineStyle.solid, black)
                    fontWeight(EFontWeight.bold)
                    padding(5.px,0.px)
                }

                "td.column-content" {
                    textAlign(ETextAlign.center)
                }

            }

        }

    }

//---------------------------------------------------------------------------------------------------------------------
