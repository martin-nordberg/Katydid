//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.actions

import js.katydid.samples.wipcards.domain.entities.Board

//---------------------------------------------------------------------------------------------------------------------

sealed class BoardAction {

    abstract fun apply(board: Board): Board

    abstract fun canApply(board: Board): Boolean

    abstract fun compensatingAction(): BoardAction?

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeColumnAction (

    val columnAction: ColumnAction,

    val columnUuid: String

) : BoardAction() {

    override fun apply(board: Board): Board {

        return board.copy(
            columns = board.columns.map {
                column -> if ( column.uuid == columnUuid ) columnAction.apply(column)
                          else column
            }
        )

    }

    override fun canApply(board: Board): Boolean {
        return board.columns.find{ column -> column.uuid == columnUuid } != null
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction() : BoardAction? {
        val compensatingColumnAction = columnAction.compensatingAction()

        return if ( compensatingColumnAction != null ) ChangeColumnAction(compensatingColumnAction,columnUuid)
               else null

    }

}

//---------------------------------------------------------------------------------------------------------------------

data class RenameBoardAction(

    val newName: String,

    val oldName: String

): BoardAction() {

    override fun apply(board: Board): Board {
        require(canApply(board))
        return board.copy(name = newName)
    }

    override fun canApply(board: Board): Boolean {
        return oldName == board.name
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction() =
        RenameBoardAction(newName=oldName, oldName=newName)

}

//---------------------------------------------------------------------------------------------------------------------

data class DeleteColumnAction(

    val columnUuid: String

): BoardAction() {

    override fun apply(board: Board): Board {
        require(canApply(board))
        return board.copy(columns=board.columns.filterNot { column -> column.uuid == columnUuid })
    }

    override fun canApply(board: Board): Boolean {
        return board.columns.find{ column -> column.uuid == columnUuid } != null
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction(): Nothing? =
        null

}

//---------------------------------------------------------------------------------------------------------------------

