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

        when (message) {

            is PlaceValueMsg     ->
                return applicationState.withCellValueSet(
                    message.rowIndex, message.columnIndex, message.newValue
                )

            is RemoveValueMsg    ->
                return applicationState.withCellValueRemoved(
                    message.rowIndex, message.columnIndex
                )

            is ChangeSettingsMsg ->
                when (message.settingsChange) {

                    is ChangeIsSolvedAutomatically ->
                        return applicationState.withSettingsChanged(
                            applicationState.settings.isXSudoku,
                            message.settingsChange.newIsSolvedAutomatically
                        )

                    is ChangeIsXSudoku ->
                        return applicationState.withSettingsChanged(
                            message.settingsChange.newIsXSudoku,
                            applicationState.settings.isSolvedAutomatically
                        )

                }

            else                 ->
                throw IllegalArgumentException("Unknown action: '${message}'.")

        }

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

                section {

                    board(applicationState)

                    settings(applicationState)

                }

                changes(applicationState)

            }

        }

    private fun KatyDomFlowContentBuilder<SudokuSolverMsg>.settings(
        applicationState: SudokuSolverAppState
    ) {

        section("#settings") {

            span(style = "font-weight: bold") {
                text("Settings")
            }

            form {

                inputCheckbox("#is-x-sudoku", checked = applicationState.settings.isXSudoku) {

                    onchange { event ->
                        val newValue: Boolean = (event.target.asDynamic().checked as Boolean)
                        listOf(ChangeSettingsMsg(ChangeIsXSudoku(newValue)))
                    }

                }

                label(`for` = "is-x-sudoku") {
                    text("X-Sudoku (unique values on diagonals)")
                }

                br {}

                inputCheckbox("#is-solved-automatically", checked = applicationState.settings.isSolvedAutomatically) {

                    onchange { event ->
                        val newValue: Boolean = (event.target.asDynamic().checked as Boolean)
                        listOf(ChangeSettingsMsg(ChangeIsSolvedAutomatically(newValue)))
                    }

                }

                label(`for` = "is-solved-automatically") {
                    text("Solve automatically")
                }

            }

        }

    }

    /**
     * Generates the virtual DOM for the Sudoku board as a whole.
     */
    private fun KatyDomFlowContentBuilder<SudokuSolverMsg>.board(
        applicationState: SudokuSolverAppState
    ) {

        section("#board") {

            span(style = "font-weight: bold") {
                text("Board")
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
                                        listOf(RemoveValueMsg(cell.row.index, cell.column.index))
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
                                    listOf(PlaceValueMsg(cell.row.index, cell.column.index, c))
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

                    th(".cell-value-set", key = 2) {
                        text("Value Set")
                    }

                    th(".candidates-removed", key = 3) {
                        text("Candidates Removed")
                    }

                }

                var row = 1
                for (change in applicationState.changes) {

                    tr(key = row++) {

                        td(".change-description", key = 1) {
                            text(change.description)
                        }

                        td(".cell-value-set", key = 2) {
                            text(change.cellValueSet)
                        }

                        td(".candidates-removed", key = 3) {
                            text(change.candidatesRemoved.sorted().joinToString(", "))
                        }

                    }

                }

                if (applicationState.changes.isEmpty()) {

                    tr(key = row) {

                        td(colspan = 3) {

                            text("Click any small candidate number in the board to begin defining a puzzle.")

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
