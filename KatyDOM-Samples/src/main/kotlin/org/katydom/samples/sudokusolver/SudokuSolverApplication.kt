//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.sudokusolver

import js.org.katydom.api.KatyDomApplication
import js.org.katydom.api.runApplication
import o.org.katydom.builders.KatyDomFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * KatyDOM application.
 */
class SudokuSolverApplication : KatyDomApplication<SudokuSolverAppState, SudokuSolverMsg> {

    /**
     * Initializes the application state for the first time.
     */
    override fun initialize(): SudokuSolverAppState {
        return SudokuSolverAppState()
    }

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    override fun update(applicationState: SudokuSolverAppState, message: SudokuSolverMsg): SudokuSolverAppState {

        if (message.action == SudokuSolverAction.PLACE_VALUE) {
            return applicationState.withCellValueSet(
                message.cell.row.index, message.cell.column.index, message.newValue
            )
        }

        throw IllegalArgumentException("Unknown action: '${message.action}'.")

    }

    /**
     * Constructs the KatyDOM virtual DOM tree for given input application state [applicationState].
     * @return the root of the application's virtual DOM tree for given application state.
     */
    override fun view(applicationState: SudokuSolverAppState): KatyDomFlowContentBuilder<SudokuSolverMsg>.() -> Unit =
        {

            // This top level element replaces the "#app" div in greetme.html.
            main("#sudoku-solver-app", style = "margin-left: 30px") {

                h1 {
                    text("Sudoku Solver")
                }

                section(key="board") {

                    table(".game") {

                        tr(key = "headings") {
                            th {}
                            th(key = 1) { text("C1") }
                            th(key = 2) { text("C2") }
                            th(key = 3) { text("C3") }
                            th(key = 4) { text("C4") }
                            th(key = 5) { text("C5") }
                            th(key = 6) { text("C6") }
                            th(key = 7) { text("C7") }
                            th(key = 8) { text("C8") }
                            th(key = 9) { text("C9") }
                        }

                        for (i in 0..2) {

                            tr(key = 3 * i + 1) {

                                th {
                                    text("R${3 * i + 1}")
                                }

                                for (j in 0..2) {

                                    val cellGroup = applicationState.board.blocks[3 * i + j]

                                    td(".block", key = j, colspan = 3, rowspan = 3) {

                                        block(cellGroup)

                                    }

                                }

                            }

                            tr(key = 3 * i + 2) {
                                th {
                                    text("R${3 * i + 2}")
                                }
                            }

                            tr(key = 3 * i + 3) {
                                th {
                                    text("R${3 * i + 3}")
                                }
                            }

                        }

                    }

                }

                br {}

                section(key="changes") {

                    table(".changes") {

                        tr {

                            th(".change-description", key=1) {
                                text("Action")
                            }

                            th(".candidates-removed", key=2) {
                                text("Candidates Removed")
                            }

                        }

                        var row = 1
                        for (change in applicationState.changes) {

                            tr(key=row++) {

                                td(".change-description", key=1) {
                                    text(change.description)
                                }

                                td(".candidates-removed", key=2) {
                                    text(change.candidatesRemoved.sorted().joinToString(", "))
                                }

                            }

                        }

                    }

                }

            }

        }

    private fun KatyDomFlowContentBuilder<SudokuSolverMsg>.block(cellGroup: CellGroup) {

        table(".block") {

            for (k in 0..2) {

                tr(key = k) {

                    for (m in 0..2) {

                        td(".cell", key = m) {

                            val cell = cellGroup.cells[3 * k + m]
                            val v = cell.value

                            classes("solved" to cell.solved)

                            if (v != null) {
                                text("${v + 1}")
                            }
                            else {
                                candidates(cell)
                            }

                        }

                    }

                }

            }

        }

    }

    private fun KatyDomFlowContentBuilder<SudokuSolverMsg>.candidates(cell: Cell) {

        table(".candidates") {

            for (p in 0..2) {

                tr(key = p) {

                    for (q in 0..2) {

                        val c = 3 * p + q

                        td(key = q) {

                            if (cell.candidates.contains(c)) {

                                classes("candidate" to true)

                                onclick {
                                    listOf(SudokuSolverMsg(SudokuSolverAction.PLACE_VALUE, cell, c))
                                }

                                text("${c + 1}")

                            }

                        }

                    }

                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Runs the Sudoku Solver application.
 */
@Suppress("UNUSED_PARAMETER")
fun sudokuSolverMain(args: Array<String>) {

    runApplication(
        "app",
        SudokuSolverApplication()
    )

}

//---------------------------------------------------------------------------------------------------------------------
