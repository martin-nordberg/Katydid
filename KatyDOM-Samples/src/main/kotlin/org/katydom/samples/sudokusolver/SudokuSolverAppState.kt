//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.sudokusolver


//---------------------------------------------------------------------------------------------------------------------

data class BoardChange(

    val description: String,

    val cellValueSet: String,

    val candidatesRemoved: List<String>

)

//---------------------------------------------------------------------------------------------------------------------

class Cell {

    enum class State {
        UNSET,
        DEFINED,
        GUESSED,
        SOLVED
    }

    lateinit var block: CellGroup

    val candidates = mutableSetOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

    lateinit var column: CellGroup

    var diagonal0: CellGroup? = null

    var diagonal1: CellGroup? = null

    lateinit var row: CellGroup

    var state: State = State.UNSET

    var value: Int? = null

    ////

    val name: String
        get() {
            val v = value
            return if (v != null)
                "${row.name}${column.name}#${v + 1}"
            else
                "${row.name}${column.name}"
        }

    ////

    fun removeCandidate(candidate: Int): Boolean {

        if (candidates.remove(candidate)) {
            row.removeCellCandidate(this, candidate)
            column.removeCellCandidate(this, candidate)
            block.removeCellCandidate(this, candidate)
            diagonal0?.removeCellCandidate(this, candidate)
            diagonal1?.removeCellCandidate(this, candidate)
            return true
        }

        return false

    }

    fun setValue(newValue: Int, newState: Cell.State): List<String> {

        for (c in candidates) {
            removeCandidate(c)
        }

        value = newValue
        state = newState

        val result = mutableListOf<String>()

        for (cell in row.cells) {
            if (cell.removeCandidate(newValue)) {
                result.add("${cell.name}#${newValue + 1}")
            }
        }

        for (cell in column.cells) {
            if (cell.removeCandidate(newValue)) {
                result.add("${cell.name}#${newValue + 1}")
            }
        }

        for (cell in block.cells) {
            if (cell.removeCandidate(newValue)) {
                result.add("${cell.name}#${newValue + 1}")
            }
        }

        for (cell in diagonal0?.cells ?: listOf()) {
            if (cell.removeCandidate(newValue)) {
                result.add("${cell.name}#${newValue + 1}")
            }
        }

        for (cell in diagonal1?.cells ?: listOf()) {
            if (cell.removeCandidate(newValue)) {
                result.add("${cell.name}#${newValue + 1}")
            }
        }

        return result

    }

}


//---------------------------------------------------------------------------------------------------------------------

class CellGroup(
    val type: String,
    val index: Int,
    val cells: List<Cell>
) {

    val cellsWithCandidate = listOf(
        mutableListOf<Cell>(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf()
    )

    init {
        for (cellsList in cellsWithCandidate) {
            cellsList.addAll(cells)
        }
    }

    val name
        get() = "$type${index + 1}"

    fun removeCellCandidate(cell: Cell, candidate: Int) {
        cellsWithCandidate[candidate].remove(cell)
    }

}

//---------------------------------------------------------------------------------------------------------------------

class Board(
    val isXSudoku: Boolean
) {

    private val c: List<List<Cell>> = listOf(
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell())
    )

    val rows = listOf(
        CellGroup("R", 0, listOf(c[0][0], c[0][1], c[0][2], c[0][3], c[0][4], c[0][5], c[0][6], c[0][7], c[0][8])),
        CellGroup("R", 1, listOf(c[1][0], c[1][1], c[1][2], c[1][3], c[1][4], c[1][5], c[1][6], c[1][7], c[1][8])),
        CellGroup("R", 2, listOf(c[2][0], c[2][1], c[2][2], c[2][3], c[2][4], c[2][5], c[2][6], c[2][7], c[2][8])),
        CellGroup("R", 3, listOf(c[3][0], c[3][1], c[3][2], c[3][3], c[3][4], c[3][5], c[3][6], c[3][7], c[3][8])),
        CellGroup("R", 4, listOf(c[4][0], c[4][1], c[4][2], c[4][3], c[4][4], c[4][5], c[4][6], c[4][7], c[4][8])),
        CellGroup("R", 5, listOf(c[5][0], c[5][1], c[5][2], c[5][3], c[5][4], c[5][5], c[5][6], c[5][7], c[5][8])),
        CellGroup("R", 6, listOf(c[6][0], c[6][1], c[6][2], c[6][3], c[6][4], c[6][5], c[6][6], c[6][7], c[6][8])),
        CellGroup("R", 7, listOf(c[7][0], c[7][1], c[7][2], c[7][3], c[7][4], c[7][5], c[7][6], c[7][7], c[7][8])),
        CellGroup("R", 8, listOf(c[8][0], c[8][1], c[8][2], c[8][3], c[8][4], c[8][5], c[8][6], c[8][7], c[8][8]))
    )

    val columns = listOf(
        CellGroup("C", 0, listOf(c[0][0], c[1][0], c[2][0], c[3][0], c[4][0], c[5][0], c[6][0], c[7][0], c[8][0])),
        CellGroup("C", 1, listOf(c[0][1], c[1][1], c[2][1], c[3][1], c[4][1], c[5][1], c[6][1], c[7][1], c[8][1])),
        CellGroup("C", 2, listOf(c[0][2], c[1][2], c[2][2], c[3][2], c[4][2], c[5][2], c[6][2], c[7][2], c[8][2])),
        CellGroup("C", 3, listOf(c[0][3], c[1][3], c[2][3], c[3][3], c[4][3], c[5][3], c[6][3], c[7][3], c[8][3])),
        CellGroup("C", 4, listOf(c[0][4], c[1][4], c[2][4], c[3][4], c[4][4], c[5][4], c[6][4], c[7][4], c[8][4])),
        CellGroup("C", 5, listOf(c[0][5], c[1][5], c[2][5], c[3][5], c[4][5], c[5][5], c[6][5], c[7][5], c[8][5])),
        CellGroup("C", 6, listOf(c[0][6], c[1][6], c[2][6], c[3][6], c[4][6], c[5][6], c[6][6], c[7][6], c[8][6])),
        CellGroup("C", 7, listOf(c[0][7], c[1][7], c[2][7], c[3][7], c[4][7], c[5][7], c[6][7], c[7][7], c[8][7])),
        CellGroup("C", 8, listOf(c[0][8], c[1][8], c[2][8], c[3][8], c[4][8], c[5][8], c[6][8], c[7][8], c[8][8]))
    )

    val blocks = listOf(
        CellGroup("Block", 0, listOf(c[0][0], c[0][1], c[0][2], c[1][0], c[1][1], c[1][2], c[2][0], c[2][1], c[2][2])),
        CellGroup("Block", 1, listOf(c[0][3], c[0][4], c[0][5], c[1][3], c[1][4], c[1][5], c[2][3], c[2][4], c[2][5])),
        CellGroup("Block", 2, listOf(c[0][6], c[0][7], c[0][8], c[1][6], c[1][7], c[1][8], c[2][6], c[2][7], c[2][8])),
        CellGroup("Block", 3, listOf(c[3][0], c[3][1], c[3][2], c[4][0], c[4][1], c[4][2], c[5][0], c[5][1], c[5][2])),
        CellGroup("Block", 4, listOf(c[3][3], c[3][4], c[3][5], c[4][3], c[4][4], c[4][5], c[5][3], c[5][4], c[5][5])),
        CellGroup("Block", 5, listOf(c[3][6], c[3][7], c[3][8], c[4][6], c[4][7], c[4][8], c[5][6], c[5][7], c[5][8])),
        CellGroup("Block", 6, listOf(c[6][0], c[6][1], c[6][2], c[7][0], c[7][1], c[7][2], c[8][0], c[8][1], c[8][2])),
        CellGroup("Block", 7, listOf(c[6][3], c[6][4], c[6][5], c[7][3], c[7][4], c[7][5], c[8][3], c[8][4], c[8][5])),
        CellGroup("Block", 8, listOf(c[6][6], c[6][7], c[6][8], c[7][6], c[7][7], c[7][8], c[8][6], c[8][7], c[8][8]))
    )

    val diagonals =
        if (isXSudoku)
            listOf(
                CellGroup("Diag", 0,
                          listOf(c[0][0], c[1][1], c[2][2], c[3][3], c[4][4], c[5][5], c[6][6], c[7][7], c[8][8])),
                CellGroup("Diag", 1,
                          listOf(c[8][0], c[7][1], c[6][2], c[5][3], c[4][4], c[3][5], c[2][6], c[1][7], c[0][8]))
            )
        else
            listOf()

    val units =
        if (isXSudoku)
            listOf(
                rows[0], rows[1], rows[2], rows[3], rows[4], rows[5], rows[6], rows[7], rows[8],
                columns[0], columns[1], columns[2], columns[3], columns[4], columns[5], columns[6], columns[7],
                columns[8],
                blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6], blocks[7], blocks[8],
                diagonals[0], diagonals[1]
            )
        else
            listOf(
                rows[0], rows[1], rows[2], rows[3], rows[4], rows[5], rows[6], rows[7], rows[8],
                columns[0], columns[1], columns[2], columns[3], columns[4], columns[5], columns[6], columns[7],
                columns[8],
                blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6], blocks[7], blocks[8]
            )

    init {

        for (row in rows) {
            for (cell in row.cells) {
                cell.row = row
            }
        }

        for (column in columns) {
            for (cell in column.cells) {
                cell.column = column
            }
        }

        for (block in blocks) {
            for (cell in block.cells) {
                cell.block = block
            }
        }

        if (diagonals.isNotEmpty()) {

            for (cell in diagonals[0].cells) {
                cell.diagonal0 = diagonals[0]
            }

            for (cell in diagonals[1].cells) {
                cell.diagonal1 = diagonals[1]
            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

/** Behavioral settings for how the board is defined and updated. */
data class SudokuSolverSettings(

    val isXSudoku: Boolean = false,

    val isSolvedAutomatically: Boolean = true,

    val isUserSolving: Boolean = false

)

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
data class SudokuSolverAppState(

    val board: Board = Board(false),

    val changes: List<BoardChange> = listOf(),

    val settings: SudokuSolverSettings = SudokuSolverSettings()

)

//---------------------------------------------------------------------------------------------------------------------

