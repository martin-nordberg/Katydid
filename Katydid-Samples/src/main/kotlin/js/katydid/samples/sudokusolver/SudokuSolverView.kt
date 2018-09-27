//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.sudokusolver

import o.katydid.css.measurements.px
import o.katydid.css.styles.style
import o.katydid.css.types.EFontWeight
import o.katydid.events.eventhandling.onchange
import o.katydid.events.eventhandling.onclick
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Constructs the Katydid virtual DOM tree for given input [applicationState].
 * @return the root of the application's virtual DOM tree for given application state.
 */
fun viewSudokuSolver(applicationState: SudokuSolverAppState): KatydidFlowContentBuilder<SudokuSolverMsg>.() -> Unit =
    {

        // This top level element replaces the "#app" div in sudokusolver.html.
        main("#sudoku-solver-app") {

            style { marginLeft(30.px) }

            h1 {
                text("Sudoku Solver")
            }

            section {

                board(applicationState)

                settings(applicationState)

                notes()

            }

            changes(applicationState)

        }

    }

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the virtual DOM for one block corresponding to [cellGroup] within the Sudoku board.
 */
private fun KatydidFlowContentBuilder<SudokuSolverMsg>.block(cellGroup: CellGroup) {

    table(".block") {

        for (k in 0..2) {

            tr(key = k) {

                for (m in 0..2) {

                    td(".cell", key = m) {

                        val cell = cellGroup.cells[3 * k + m]
                        val v = cell.value

                        classes(
                            "solved" to (cell.state == Cell.State.SOLVED),
                            "defined" to (cell.state == Cell.State.DEFINED),
                            "guessed" to (cell.state == Cell.State.GUESSED)
                        )

                        if (v != null) {

                            if (cell.state != Cell.State.SOLVED) {

                                onclick {
                                    listOf(RemoveValueMsg(cell.row.index, cell.column.index))
                                }

                            }

                            text("${v + 1}")

                        }
                        else if (cell.candidates.isNotEmpty()) {
                            candidates(cell)
                        }
                        else {
                            classes("unfillable" to true)
                        }

                    }

                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the virtual DOM for the Sudoku board as a whole from given [applicationState].
 */
private fun KatydidFlowContentBuilder<SudokuSolverMsg>.board(
    applicationState: SudokuSolverAppState
) {

    section("#board") {

        span {
            style { fontWeight(EFontWeight.bold) }
            text("Board")
        }

        table(".board") {

            // Top row has column headings.
            tr(key = "headings") {

                th {}

                for (columnIndex in 1..9) {

                    th(key = columnIndex) {
                        text("C$columnIndex")
                    }

                }

            }

            // Loop through three rows of blocks.
            for (i in 0..2) {

                // First row left side heading plus block itself spanning three rows
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

                // Second and third row left side headings
                for (j in 2..3) {

                    tr(key = 3 * i + j) {

                        th {
                            text("R${3 * i + j}")
                        }

                    }

                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the virtual DOM for one [cell] of the Sudoku board when it has not yet been defined or solved.
 */
private fun KatydidFlowContentBuilder<SudokuSolverMsg>.candidates(cell: Cell) {

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

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the table of changes and candidate removals for given [applicationState] with its changes.
 */
private fun KatydidFlowContentBuilder<SudokuSolverMsg>.changes(
    applicationState: SudokuSolverAppState
) {

    section("#changes") {

        style { marginLeft(30.px) }

        table(".changes") {

            // Row of headings
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

            // One row per change
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

            // If no changes yet, some brief instructions
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

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the virtual DOM for the form for the settings of the puzzle.
 */
private fun KatydidFlowContentBuilder<SudokuSolverMsg>.notes() {

    section("#notes") {

        span {
            style { fontWeight(EFontWeight.bold) }
            text("Notes")
        }

        br {}

        text(
            "This solver can handle modest Sudoku puzzles. " +
                "Inspiration and terminology for this sample come from ",
            key = 1
        )

        a(href = "http://www.sudokuwiki.org/", target = "_blank") {
            text("SudokuWiki.org")
        }

        text(", which is highly recommended for more serious Sudoku solving.", key = 2)

    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the virtual DOM for the form for the settings of the puzzle taken from given [applicationState].
 */
private fun KatydidFlowContentBuilder<SudokuSolverMsg>.settings(
    applicationState: SudokuSolverAppState
) {

    section("#settings") {

        span {
            style { fontWeight(EFontWeight.bold) }
            text("Settings")
        }

        form(key = "settings") {

            // Radio buttons for X-Sudoku
            fieldset(key = "is-x-sudoku") {

                inputRadioButton(
                    "#is-not-x-sudoku",
                    checked = !applicationState.settings.isXSudoku,
                    name = "is-x-sudoku",
                    value = "false"
                ) {

                    onchange { event ->
                        val newValue = event.getTargetAttribute<String>("value").toBoolean()
                        console.log("RADIO: ", newValue)
                        listOf(ChangeSettingsMsg(
                            ChangeIsXSudoku(newValue)))
                    }

                }

                label(`for` = "is-not-x-sudoku") {
                    text("Regular Sudoku")
                }

                inputRadioButton(
                    "#is-x-sudoku",
                    checked = applicationState.settings.isXSudoku,
                    name = "is-x-sudoku",
                    value = "true"
                ) {

                    style { marginLeft(15.px) }

                    onchange { event ->
                        val newValue = event.getTargetAttribute<String>("value").toBoolean()
                        console.log("RADIO: ", newValue)
                        listOf(ChangeSettingsMsg(
                            ChangeIsXSudoku(newValue)))
                    }

                }

                label(`for` = "is-x-sudoku") {
                    text("X-Sudoku (unique values on diagonals)")
                }

            }

            // Checkbox for automatic solving
            fieldset(key = "is-solved-automatically") {

                inputCheckbox("#is-solved-automatically", checked = applicationState.settings.isSolvedAutomatically) {

                    onchange { event ->
                        val newValue: Boolean = event.getTargetAttribute<Boolean>("checked")
                        listOf(ChangeSettingsMsg(
                            ChangeIsSolvedAutomatically(newValue)))
                    }

                }

                label(`for` = "is-solved-automatically") {
                    text("Solve automatically")
                }

            }

            // When not auto-solving, drop down for defining/user solving
            if (!applicationState.settings.isSolvedAutomatically) {

                fieldset(key = "is-solving") {

                    span(key = 1) {
                        text("I am currently ")
                    }

                    select("#is-solving") {

                        onchange { event ->
                            val newValue: Boolean = event.getTargetAttribute<String>("value").toBoolean()
                            listOf(ChangeSettingsMsg(
                                ChangeIsUserSolving(newValue)))
                        }

                        option(key = false, label = "defining", value = "false") {}

                        option(key = true, label = "solving", value = "true") {}

                    }

                    span(key = 2) {
                        text(" the puzzle.")
                    }

                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
