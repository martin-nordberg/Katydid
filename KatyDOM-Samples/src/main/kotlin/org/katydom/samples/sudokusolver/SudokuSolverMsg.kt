//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.sudokusolver

//---------------------------------------------------------------------------------------------------------------------

enum class SudokuSolverAction {
    PLACE_VALUE
}

//---------------------------------------------------------------------------------------------------------------------

/** Simple message for user events (clicked candidate). */
data class SudokuSolverMsg(
    val cell: Cell,
    val action: SudokuSolverAction,
    val newValue: Int
)

//---------------------------------------------------------------------------------------------------------------------
