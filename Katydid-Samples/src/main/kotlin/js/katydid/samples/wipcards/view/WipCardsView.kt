//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.view

import js.katydid.samples.wipcards.board.viewBoardName
import js.katydid.samples.wipcards.domain.model.Column
import js.katydid.samples.wipcards.messages.WipCardsBoardNameMsg
import js.katydid.samples.wipcards.messages.WipCardsMsg
import js.katydid.samples.wipcards.model.WipCardsAppState
import js.katydid.samples.wipcards.model.WipCardsBoardUiState
import o.katydid.css.measurements.percent
import o.katydid.css.styles.builders.width
import o.katydid.css.styles.style
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Constructs the Katydid virtual DOM tree for given input [applicationState].
 * @return the root of the application's virtual DOM tree for given application state.
 */
fun viewWipCards(applicationState: WipCardsAppState): KatydidFlowContentBuilder<WipCardsMsg>.() -> Unit =
    {

        // This top level element replaces the "#app" div in wipcards.html.
        main("#wip-cards-app") {

            when (applicationState.uiState) {

                is WipCardsBoardUiState -> with(applicationState.domain) {

                    viewBoardName(applicationState.uiState.boardName) { msg -> WipCardsBoardNameMsg(msg) }

                    table(".board") {

                        val board = boardWithUuid(applicationState.uiState.boardUuid)

                        if ( board != null ) {

                            viewColumnHeadings(board.columns())

                            viewColumnContent(board.columns())

                        }

                    }

                }

            }

        }

    }

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates one column heading of the WIP Cards board.
 */
private fun KatydidTableContentBuilder<WipCardsMsg>.viewColumnHeadings(columns: List<Column>) {

    tr("#headings") {

        var colIndex = 1
        for (column in columns) {

            th(".column-heading", key = colIndex) {

                style {
                    width((100 / columns.size).percent)
                }

                +column.heading

            }

            colIndex += 1

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates one column of the WIP Cards board.
 */
private fun KatydidTableContentBuilder<WipCardsMsg>.viewColumnContent(columns: List<Column>) {

    tr("#content") {

        var colIndex = 1
        for (column in columns) {

            td(".column-content", key = colIndex) {
                +"Place cards here"
            }

            colIndex += 1

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
