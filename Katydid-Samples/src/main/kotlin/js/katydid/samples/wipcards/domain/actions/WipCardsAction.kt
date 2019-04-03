//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.actions

import js.katydid.samples.wipcards.domain.entities.Board
import js.katydid.samples.wipcards.domain.entities.WipCardsDomain
import js.katydid.samples.wipcards.infrastructure.Action
import js.katydid.samples.wipcards.infrastructure.ResultWithErrors

//---------------------------------------------------------------------------------------------------------------------

data class WipCardsBoardAction(
    val boardUuid: String,
    val boardAction: Action<Board>
) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain): ResultWithErrors<WipCardsDomain> {

        // Find the board to be changed or quit early with an error.
        val foundBoard = state.boards.find { board -> board.uuid == boardUuid }
            ?: return ResultWithErrors(state, errors = listOf("Board not found."))

        // Act on the board found.
        val innerResult = boardAction.apply(foundBoard)

        // Combine the results and any errors.
        return ResultWithErrors(
            state.copy(
                boards = state.boards.map { board ->
                    if (board == foundBoard) innerResult.result
                    else board
                }
            ),
            errors = innerResult.errors
        )
    }

    override fun compensatingAction(): Action<WipCardsDomain> =
        WipCardsBoardAction(boardUuid, boardAction.compensatingAction())

}

//---------------------------------------------------------------------------------------------------------------------

