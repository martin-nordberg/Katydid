//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.sudokusolver


//---------------------------------------------------------------------------------------------------------------------

data class BoardChange(

    val description: String,

    val candidatesRemoved: List<String>

)

//---------------------------------------------------------------------------------------------------------------------

class Cell {

    private lateinit var _block: CellGroup

    private val _candidates = mutableSetOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

    private lateinit var _column: CellGroup

    private var _solved: Boolean = false

    private lateinit var _row: CellGroup

    private var _value: Int? = null

    ////

    var block: CellGroup
        get() = _block
        internal set(b) {
            _block = b
        }

    val candidates: Set<Int>
        get() = _candidates

    var column: CellGroup
        get() = _column
        internal set(c) {
            _column = c
        }

    val name: String
        get() {
            val v = _value
            return if (v != null)
                "${row.name}${column.name}#${v + 1}"
            else
                "${row.name}${column.name}"
        }

    var solved: Boolean
        get() = _solved
        internal set(s) {
            _solved = s
        }

    var row: CellGroup
        get() = _row
        internal set(r) {
            _row = r
        }

    val value: Int?
        get() = _value


    ////

    internal fun removeCandidate(candidate: Int) : Boolean {

        if ( _candidates.remove(candidate) ) {
            row.removeCellCandidate(this,candidate)
            column.removeCellCandidate(this,candidate)
            block.removeCellCandidate(this,candidate)
            return true
        }

        return false

    }

    internal fun setValue(v: Int) : List<String> {

        for ( c in candidates ) {
            removeCandidate(c)
        }

        _value = v

        val result = mutableListOf<String>()

        for ( cell in row.cells ) {
            if (cell.removeCandidate(v)) {
                result.add("${cell.name}#${v + 1}")
            }
        }

        for ( cell in column.cells ) {
            if ( cell.removeCandidate(v) ) {
                result.add("${cell.name}#${v + 1}")
            }
        }

        for ( cell in block.cells ) {
            if ( cell.removeCandidate(v) ) {
                result.add("${cell.name}#${v + 1}")
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

    internal val cellsWithCandidate = listOf(
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
        for ( cellsList in cellsWithCandidate ) {
            cellsList.addAll(cells)
        }
    }

    val name
        get() = "$type${index+1}"

    internal fun removeCellCandidate(cell:Cell, candidate: Int) {

        // TODO: return list of actual removals

        cellsWithCandidate[candidate].remove(cell)

    }

}

//---------------------------------------------------------------------------------------------------------------------

class Board {

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

    val units = listOf(
        rows[0], rows[1], rows[2], rows[3], rows[4], rows[5], rows[6], rows[7], rows[8],
        columns[0], columns[1], columns[2], columns[3], columns[4], columns[5], columns[6], columns[7], columns[8],
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

    }

}

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
class SudokuSolverAppState(

    val board: Board = Board(),

    val changes: List<BoardChange> = listOf()

) {

    fun withCellValueRemoved(rowIndex: Int, colIndex: Int): SudokuSolverAppState {

        val newBoard = Board()
        val newChanges = mutableListOf<BoardChange>()

        for (i in 0..8) {

            for (j in 0..8) {

                val cell = board.rows[i].cells[j]

                if (cell.row.index == rowIndex && cell.column.index == colIndex) {
                    continue
                }

                val newCell = newBoard.rows[i].cells[j]

                val oldValue = cell.value
                lateinit var candidatesRemoved : List<String>
                if (oldValue != null && !cell.solved) {
                    candidatesRemoved = newCell.setValue(oldValue)
                }
                else {
                    continue
                }

                newChanges.add( BoardChange( "Cell Value Set: ${newCell.name}", candidatesRemoved ) )

            }

        }

        newChanges.addAll( solve(newBoard) )

        return SudokuSolverAppState(newBoard, newChanges)

    }

    fun withCellValueSet(rowIndex: Int, colIndex: Int, value: Int): SudokuSolverAppState {

        val newBoard = Board()
        val newChanges = mutableListOf<BoardChange>()

        for (i in 0..8) {

            for (j in 0..8) {

                val cell = board.rows[i].cells[j]
                val newCell = newBoard.rows[i].cells[j]

                val oldValue = cell.value
                lateinit var candidatesRemoved : List<String>
                if (oldValue != null && !cell.solved) {
                    candidatesRemoved = newCell.setValue(oldValue)
                }
                else if (cell.row.index == rowIndex && cell.column.index == colIndex) {
                    candidatesRemoved = newCell.setValue(value)
                }
                else {
                    continue
                }

                newChanges.add( BoardChange( "Cell Value Set: ${newCell.name}", candidatesRemoved ) )

            }

        }

        newChanges.addAll( solve(newBoard) )

        return SudokuSolverAppState(newBoard, newChanges)

    }

}

//---------------------------------------------------------------------------------------------------------------------

fun solveNakedSingles( board: Board ) : List<BoardChange> {

    val result = mutableListOf<BoardChange>()

    for (row in board.rows) {

        for (cell in row.cells) {

            if (cell.candidates.size == 1) {
                val c = cell.candidates.elementAt(0)
                val candidatesRemoved = cell.setValue(c)
                result.add( BoardChange( "Naked Single: ${cell.name}", candidatesRemoved ) )
                cell.solved = true
            }

        }

    }

    return result

}

fun solveHiddenSingles( board: Board ) : List<BoardChange> {

    val result = mutableListOf<BoardChange>()

    for (unit in board.units) {

        for (c in 0..8) {

            if (unit.cellsWithCandidate[c].size == 1) {
                val cell = unit.cellsWithCandidate[c].elementAt(0)
                val candidatesRemoved = cell.setValue(c)
                result.add(BoardChange("Hidden Single: ${cell.name} in ${unit.name}", candidatesRemoved))
                cell.solved = true
            }

        }

    }

    return result

}

fun solveNakedPairs( board: Board ) : List<BoardChange> {

    val result = mutableListOf<BoardChange>()

    for (unit in board.units) {

        for (u1 in 0..8) {

            val cell1 = unit.cells[u1]

            for ( u2 in (u1+1)..8 ) {

                val cell2 = unit.cells[u2]

                if (cell1.candidates.size == 2 && cell1.candidates == cell2.candidates) {

                    val c1 = cell1.candidates.elementAt(0)
                    val c2 = cell1.candidates.elementAt(1)

                    val candidatesRemoved = mutableListOf<String>()

                    for ( u in 0..8 ) {

                        if ( u != u1 && u != u2 ) {

                            val cell = unit.cells[u]

                            if ( cell.removeCandidate(c1) ) {
                                candidatesRemoved.add("${cell.name}#${c1 + 1}")
                            }

                            if ( cell.removeCandidate(c2) ) {
                                candidatesRemoved.add("${cell.name}#${c2 + 1}")
                            }

                        }

                    }

                    if ( candidatesRemoved.isNotEmpty()) {
                        result.add( BoardChange("Naked Pair: ${cell1.name}/${cell2.name} in ${unit.name}", candidatesRemoved))
                    }

                }

            }

        }

    }

    return result

}

fun solve( board: Board ) : List<BoardChange> {

    val result = mutableListOf<BoardChange>()

    while (true) {

        var changes = solveNakedSingles(board)

        if (changes.isNotEmpty()) {
            result.addAll(changes)
            continue
        }

        changes = solveHiddenSingles(board)

        if (changes.isNotEmpty()) {
            result.addAll(changes)
            continue
        }

        changes = solveNakedPairs(board)

        if (changes.isNotEmpty()) {
            result.addAll(changes)
            continue
        }

        break

    }

    return result

}

//---------------------------------------------------------------------------------------------------------------------

