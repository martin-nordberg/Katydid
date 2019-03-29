//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.boardname


//---------------------------------------------------------------------------------------------------------------------

/**
 * Creates a new board state modified from given [board] by the given [message].
 */
fun updateBoardName(
    board: WipCardsBoard,
    message: BoardNameMsg
): WipCardsBoard {

    return when (message) {

        is BoardNameRenameMsg        -> board.copy(name = message.newName)

        is BoardNameStartEditingMsg  -> board.copy(isEditButtonShown = false, isEditingInProgress = true)

        is BoardNameStartHoveringMsg -> board.copy(isEditButtonShown = true)

        is BoardNameStopEditingMsg   -> board.copy(isEditingInProgress = false)

        is BoardNameStopHoveringMsg  -> board.copy(isEditButtonShown = false)

    }

}

//---------------------------------------------------------------------------------------------------------------------

