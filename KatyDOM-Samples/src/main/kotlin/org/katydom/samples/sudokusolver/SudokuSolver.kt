//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.sudokusolver

import js.org.katydom.api.KatyDomApplication
import js.org.katydom.api.runApplication
import o.org.katydom.builders.KatyDomFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/** Simple model for this application. */
data class SudokuSolverAppState (
    // TODO: blocks, cells, candidates
    val myName : String
)

//---------------------------------------------------------------------------------------------------------------------

/** Simple message for user events (clicked candidate). */
data class SudokuSolverMsg (
    // TODO: candidate clicked, ??
    val newName : String
)

//---------------------------------------------------------------------------------------------------------------------

/**
 * KatyDOM application.
 */
class SudokuSolverApplication : KatyDomApplication<SudokuSolverAppState, SudokuSolverMsg> {

    /**
     * Initializes the application state for the first time.
     */
    override fun initialize(): SudokuSolverAppState {
        return SudokuSolverAppState("KatyDOM User")
    }

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    override fun update(applicationState: SudokuSolverAppState, message: SudokuSolverMsg): SudokuSolverAppState {
        return SudokuSolverAppState(message.newName)
    }

    /**
     * Constructs the KatyDOM virtual DOM tree for given input application state [applicationState].
     * @return the root of the application's virtual DOM tree for given application state.
     */
    override fun view(applicationState: SudokuSolverAppState): KatyDomFlowContentBuilder<SudokuSolverMsg>.() -> Unit =
        {

            // This top level element replaces the "#app" div in greetme.html.
            main("#sudoku-solver-app") {

                h1 {
                    text("Sudoku Solver")
                }

                section(style = "margin-left: 5em;") {

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

                        for (i in 1..3) {

                            tr(key = 3*i-2) {

                                th {
                                    text("R${3*i-2}" )
                                }

                                for (j in 1..3) {

                                    td(".block", key = j, colspan = 3, rowspan=3) {

                                        table(".block") {

                                            for (k in 1..3) {

                                                tr(key = k) {

                                                    for (m in 1..3) {

                                                        td(".cell", key = m) {

                                                            text("1")

                                                        }

                                                    }

                                                }

                                            }

                                        }

                                    }

                                }

                            }

                            tr(key=3*i-1) {
                                th {
                                    text("R${3*i-1}" )
                                }
                            }

                            tr(key=3*i) {
                                th {
                                    text("R${3*i}" )
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
