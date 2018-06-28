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
 * KatyDOM application for solving Sudoku.
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
                message.rowIndex, message.columnIndex, message.newValue!!
            )
        }

        if (message.action == SudokuSolverAction.REMOVE_VALUE) {
            return applicationState.withCellValueRemoved(
                message.rowIndex, message.columnIndex
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

                board(applicationState)

                changes(applicationState)

            }

        }

    /**
     * Generates the virtual DOM for the Sudoku board as a whole.
     */
    private fun KatyDomFlowContentBuilder<SudokuSolverMsg>.board(
        applicationState: SudokuSolverAppState
    ) {

        section("#board") {

            span(style="font-weight: bold") {
                text( "Board")
            }

            table(".board") {

                tr(key = "headings") {

                    th {}

                    for (columnIndex in 1..9) {

                        th(key = columnIndex) {
                            text("C$columnIndex")
                        }

                    }

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

    }

    /**
     * Generates the virtual DOM for one block within the Sudoku board.
     */
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

                                if (!cell.solved) {

                                    classes("placed" to true)

                                    onclick {
                                        listOf(SudokuSolverMsg(SudokuSolverAction.REMOVE_VALUE, cell.row.index,
                                                               cell.column.index, null))
                                    }

                                }

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

    /**
     * Generates the virtual DOM for one cell of the Sudoku board.
     */
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
                                    listOf(SudokuSolverMsg(SudokuSolverAction.PLACE_VALUE, cell.row.index,
                                                           cell.column.index, c))
                                }

                                text("${c + 1}")

                            }

                        }

                    }

                }

            }

        }

    }

    /**
     * Generates the table of changes and candidate removals.
     */
    private fun KatyDomFlowContentBuilder<SudokuSolverMsg>.changes(
        applicationState: SudokuSolverAppState
    ) {

        section("#changes", style = "margin-left: 30px") {

            table(".changes") {

                tr {

                    th(".change-description", key = 1) {
                        text("Action")
                    }

                    th(".candidates-removed", key = 2) {
                        text("Candidates Removed")
                    }

                }

                var row = 1
                for (change in applicationState.changes) {

                    tr(key = row++) {

                        td(".change-description", key = 1) {
                            text(change.description)
                        }

                        td(".candidates-removed", key = 2) {
                            text(change.candidatesRemoved.sorted().joinToString(", "))
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
