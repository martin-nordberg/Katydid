//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards

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

        // This top level element replaces the "#app" div in sudokusolver.html.
        main("#wip-cards-app") {

            table( ".board" ) {

                viewColumnHeadings( applicationState.columns )

                viewColumnContent( applicationState.columns )

            }

        }

    }

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates one column heading of the WIP Cards board.
 */
private fun KatydidTableContentBuilder<WipCardsMsg>.viewColumnHeadings(columns: List<WipCardColumnState>) {

    tr("#headings") {

        var colIndex = 1
        for (column in columns) {

            th(".column-heading", key = colIndex) {

                style {
                    width((100/columns.size).percent)
                }

                span(".columnName") {
                    +column.name
                }

            }

            colIndex += 1

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates one column of the WIP Cards board.
 */
private fun KatydidTableContentBuilder<WipCardsMsg>.viewColumnContent(columns: List<WipCardColumnState>) {

    tr("#content") {

        var colIndex = 1
        for (column in columns) {

            td(".column-content", key = colIndex) {

                span(".columnName") {
                    +"Place cards here"
                }

            }

            colIndex += 1

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
