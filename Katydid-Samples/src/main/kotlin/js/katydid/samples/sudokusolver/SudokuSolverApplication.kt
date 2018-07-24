//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.sudokusolver

import js.katydid.vdom.api.KatydidApplication
import js.katydid.vdom.api.runApplication
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Katydid application for solving Sudoku.
 */
class SudokuSolverApplication : KatydidApplication<SudokuSolverAppState, SudokuSolverMsg> {

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
     * Constructs the Katydid virtual DOM tree for given input application state [applicationState].
     * @return a builder that builds the root of the application's virtual DOM tree for given application state.
     */
    override fun view(applicationState: SudokuSolverAppState): KatydidFlowContentBuilder<SudokuSolverMsg>.() -> Unit =
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
