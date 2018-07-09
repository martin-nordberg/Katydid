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
    override fun update(applicationState: SudokuSolverAppState, message: SudokuSolverMsg): SudokuSolverAppState =
        updateSudokuSolver(applicationState, message)

    /**
     * Constructs the KatyDOM virtual DOM tree for given input application state [applicationState].
     * @return the root of the application's virtual DOM tree for given application state.
     */
    override fun view(applicationState: SudokuSolverAppState): KatyDomFlowContentBuilder<SudokuSolverMsg>.() -> Unit =
        viewSudokuSolver(applicationState)

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
