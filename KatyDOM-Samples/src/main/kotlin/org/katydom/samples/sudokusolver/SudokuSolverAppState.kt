//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.sudokusolver


//---------------------------------------------------------------------------------------------------------------------

class Cell {

    var candidates = arrayOf(true, true, true, true, true, true, true, true, true)

    var value: Int? = null

    var placedByUser: Boolean? = null

    lateinit var row: CellGroup

    lateinit var column: CellGroup

    lateinit var block: CellGroup

}

//---------------------------------------------------------------------------------------------------------------------

data class CellGroup(

    val index: Int,
    val cells: List<Cell> = listOf()

)

//---------------------------------------------------------------------------------------------------------------------

class Board {

    var cells: List<List<Cell>> = listOf(
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

    var rows = listOf(
        CellGroup(0, listOf(cells[0][0], cells[0][1], cells[0][2], cells[0][3], cells[0][4], cells[0][5], cells[0][6],
                         cells[0][7], cells[0][8])),
        CellGroup(1, listOf(cells[1][0], cells[1][1], cells[1][2], cells[1][3], cells[1][4], cells[1][5], cells[1][6],
                         cells[1][7], cells[1][8])),
        CellGroup(2, listOf(cells[2][0], cells[2][1], cells[2][2], cells[2][3], cells[2][4], cells[2][5], cells[2][6],
                         cells[2][7], cells[2][8])),
        CellGroup(3, listOf(cells[3][0], cells[3][1], cells[3][2], cells[3][3], cells[3][4], cells[3][5], cells[3][6],
                         cells[3][7], cells[3][8])),
        CellGroup(4, listOf(cells[4][0], cells[4][1], cells[4][2], cells[4][3], cells[4][4], cells[4][5], cells[4][6],
                         cells[4][7], cells[4][8])),
        CellGroup(5, listOf(cells[5][0], cells[5][1], cells[5][2], cells[5][3], cells[5][4], cells[5][5], cells[5][6],
                         cells[5][7], cells[5][8])),
        CellGroup(6, listOf(cells[6][0], cells[6][1], cells[6][2], cells[6][3], cells[6][4], cells[6][5], cells[6][6],
                         cells[6][7], cells[6][8])),
        CellGroup(7, listOf(cells[7][0], cells[7][1], cells[7][2], cells[7][3], cells[7][4], cells[7][5], cells[7][6],
                         cells[7][7], cells[7][8])),
        CellGroup(8, listOf(cells[8][0], cells[8][1], cells[8][2], cells[8][3], cells[8][4], cells[8][5], cells[8][6],
                         cells[8][7], cells[8][8]))
    )

    var columns = listOf(
        CellGroup(0, listOf(cells[0][0], cells[1][0], cells[2][0], cells[3][0], cells[4][0], cells[5][0], cells[6][0],
                         cells[7][0], cells[8][0])),
        CellGroup(1, listOf(cells[0][1], cells[1][1], cells[2][1], cells[3][1], cells[4][1], cells[5][1], cells[6][1],
                         cells[7][1], cells[8][1])),
        CellGroup(2, listOf(cells[0][2], cells[1][2], cells[2][2], cells[3][2], cells[4][2], cells[5][2], cells[6][2],
                         cells[7][2], cells[8][2])),
        CellGroup(3, listOf(cells[0][3], cells[1][3], cells[2][3], cells[3][3], cells[4][3], cells[5][3], cells[6][3],
                         cells[7][3], cells[8][3])),
        CellGroup(4, listOf(cells[0][4], cells[1][4], cells[2][4], cells[3][4], cells[4][4], cells[5][4], cells[6][4],
                         cells[7][4], cells[8][4])),
        CellGroup(5, listOf(cells[0][5], cells[1][5], cells[2][5], cells[3][5], cells[4][5], cells[5][5], cells[6][5],
                         cells[7][5], cells[8][5])),
        CellGroup(6, listOf(cells[0][6], cells[1][6], cells[2][6], cells[3][6], cells[4][6], cells[5][6], cells[6][6],
                         cells[7][6], cells[8][6])),
        CellGroup(7, listOf(cells[0][7], cells[1][7], cells[2][7], cells[3][7], cells[4][7], cells[5][7], cells[6][7],
                         cells[7][7], cells[8][7])),
        CellGroup(8, listOf(cells[0][8], cells[1][8], cells[2][8], cells[3][8], cells[4][8], cells[5][8], cells[6][8],
                         cells[7][8], cells[8][8]))
    )

    var blocks = listOf(
        CellGroup(0, listOf(cells[0][0], cells[0][1], cells[0][2], cells[1][0], cells[1][1], cells[1][2], cells[2][0],
                         cells[2][1], cells[2][2])),
        CellGroup(1, listOf(cells[0][3], cells[0][4], cells[0][5], cells[1][3], cells[1][4], cells[1][5], cells[2][3],
                         cells[2][4], cells[2][5])),
        CellGroup(2, listOf(cells[0][6], cells[0][7], cells[0][8], cells[1][6], cells[1][7], cells[1][8], cells[2][6],
                         cells[2][7], cells[2][8])),
        CellGroup(3, listOf(cells[3][0], cells[3][1], cells[3][2], cells[4][0], cells[4][1], cells[4][2], cells[5][0],
                         cells[5][1], cells[5][2])),
        CellGroup(4, listOf(cells[3][3], cells[3][4], cells[3][5], cells[4][3], cells[4][4], cells[4][5], cells[5][3],
                         cells[5][4], cells[5][5])),
        CellGroup(5, listOf(cells[3][6], cells[3][7], cells[3][8], cells[4][6], cells[4][7], cells[4][8], cells[5][6],
                         cells[5][7], cells[5][8])),
        CellGroup(6, listOf(cells[6][0], cells[6][1], cells[6][2], cells[7][0], cells[7][1], cells[7][2], cells[8][0],
                         cells[8][1], cells[8][2])),
        CellGroup(7, listOf(cells[6][3], cells[6][4], cells[6][5], cells[7][3], cells[7][4], cells[7][5], cells[8][3],
                         cells[8][4], cells[8][5])),
        CellGroup(8, listOf(cells[6][6], cells[6][7], cells[6][8], cells[7][6], cells[7][7], cells[7][8], cells[8][6],
                         cells[8][7], cells[8][8]))
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

    }

}

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
class SudokuSolverAppState(

    val board: Board = Board()

) {

    fun withCellValueSet( row: Int, column: Int, value: Int ) : SudokuSolverAppState {
        val result = SudokuSolverAppState()
        result.board.rows[row].cells[column].value = value
        result.board.rows[row].cells[column].placedByUser = true
        return result
    }

}

//---------------------------------------------------------------------------------------------------------------------
