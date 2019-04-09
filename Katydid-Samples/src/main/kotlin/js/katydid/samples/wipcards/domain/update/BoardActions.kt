//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.update

import js.katydid.samples.wipcards.domain.model.Board
import js.katydid.samples.wipcards.domain.model.Column
import js.katydid.samples.wipcards.domain.model.WipCardsDomain
import js.katydid.samples.wipcards.infrastructure.Action
import js.katydid.samples.wipcards.infrastructure.Uuid

//---------------------------------------------------------------------------------------------------------------------

data class CreateBoardAction(

    val boardUuid: Uuid<Board>,

    val name: String

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val board = Board(boardUuid, name)

        with(board).added()

    }

    override fun compensatingAction() =
        DeleteBoardAction(boardUuid)

}

//---------------------------------------------------------------------------------------------------------------------

data class RenameBoardAction(

    val boardUuid: Uuid<Board>,

    val newName: String,

    val oldName: String

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val oldBoard = boardWithUuid(boardUuid)

        check(oldBoard != null) { "Board not found." }
        check(oldName == oldBoard.name) { "Board has already been renamed." }

        val newBoard = oldBoard.copy(name = newName)

        with(newBoard).updated()

    }

    override fun compensatingAction() =
        this.copy(newName = oldName, oldName = newName)

}

//---------------------------------------------------------------------------------------------------------------------

data class DeleteBoardAction(

    val boardUuid: Uuid<Board>

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val board = boardWithUuid(boardUuid)

        check(board != null) { "Board not found." }

        with(board).removed()

    }

    override fun compensatingAction() =
        throw UnsupportedOperationException("TODO")

}

//---------------------------------------------------------------------------------------------------------------------

data class DeleteColumnAction(

    val boardUuid: Uuid<Board>,

    val columnUuid: Uuid<Column>

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val board = boardWithUuid(boardUuid)
        val column = columnWithUuid(columnUuid)

        check(board != null) { "Board not found." }
        check(column != null) { "Column has already been deleted." }

        column.cards().fold(state) { dom, card -> dom.with(column).noLongerContains(card) }
            .with(board).noLongerContains(column)
            .with(column).removed()

    }

    override fun compensatingAction() =
        throw UnsupportedOperationException("TODO")

}

//---------------------------------------------------------------------------------------------------------------------

