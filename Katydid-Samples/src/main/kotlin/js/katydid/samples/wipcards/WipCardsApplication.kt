//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards

import js.katydid.css.buildStyleElement
import js.katydid.samples.wipcards.board.BoardNameViewModel
import js.katydid.samples.wipcards.board.boardNameStyles
import js.katydid.samples.wipcards.domain.model.Board
import js.katydid.samples.wipcards.domain.model.Column
import js.katydid.samples.wipcards.domain.model.WipCardsDomain
import js.katydid.samples.wipcards.infrastructure.Uuid
import js.katydid.samples.wipcards.messages.WipCardsMsg
import js.katydid.samples.wipcards.model.WipCardsAppState
import js.katydid.samples.wipcards.model.WipCardsBoardUiState
import js.katydid.samples.wipcards.update.updateWipCards
import js.katydid.samples.wipcards.view.viewWipCards
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
class WipCardsApplication :
    KatydidApplication<WipCardsAppState, WipCardsMsg> {

    /**
     * Initializes the application state for the first time.
     */
    override fun initialize(): KatydidApplicationCycle<WipCardsAppState, WipCardsMsg> {

        val boardUuid = Uuid<Board>("theBoard")
        val board = Board(boardUuid, "Sample")

        val col1Uuid = Uuid<Column>("col1")
        val col1 = Column(col1Uuid,"To Do")

        val col2Uuid = Uuid<Column>("col2")
        val col2 = Column(col2Uuid,"Analyze")

        val col3Uuid = Uuid<Column>("col3")
        val col3 = Column(col3Uuid,"Implement")

        val col4Uuid = Uuid<Column>("col4")
        val col4 = Column(col4Uuid,"Test")

        val col5Uuid = Uuid<Column>("col5")
        val col5 = Column(col5Uuid,"Deploy")

        val domain = WipCardsDomain()
            .with(board).added()
            .with(col1).added()
            .with(board).contains(col1)
            .with(col2).added()
            .with(board).contains(col2)
            .with(col3).added()
            .with(board).contains(col3)
            .with(col4).added()
            .with(board).contains(col4)
            .with(col5).added()
            .with(board).contains(col5)

        return KatydidApplicationCycle(
            WipCardsAppState(
                domain = domain,
                uiState = WipCardsBoardUiState(
                    boardUuid = boardUuid,
                    boardName = BoardNameViewModel(domain=domain,boardUuid = boardUuid)
                )
            )
        )
    }

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

    buildStyleElement(
        document.getElementById("appStyleElement")!!,
        makeWipCardsStyleSheet()
    )

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

        boardNameStyles()

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
