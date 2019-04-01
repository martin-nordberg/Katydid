//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.update

import js.katydid.samples.wipcards.board.updateBoardName
import js.katydid.samples.wipcards.messages.RenameColumnMsg
import js.katydid.samples.wipcards.messages.WipCardsBoardNameMsg
import js.katydid.samples.wipcards.messages.WipCardsMsg
import js.katydid.samples.wipcards.model.WipCardsAppState
import js.katydid.samples.wipcards.model.WipCardsColumn
import js.katydid.vdom.api.KatydidApplicationCycle
import js.katydid.vdom.api.KatydidCommand


//---------------------------------------------------------------------------------------------------------------------

/**
 * Creates a new application state modified from given [applicationState] by the given [message].
 */
fun updateWipCards(
    applicationState: WipCardsAppState,
    message: WipCardsMsg
): KatydidApplicationCycle<WipCardsAppState, WipCardsMsg> {

    val commandsToExecute = listOf<KatydidCommand<WipCardsMsg>>()

    val newApplicationState = when (message) {

        is RenameColumnMsg      ->
            applicationState.withColumnRenamed(
                message.columnIndex, message.newName
            )

        is WipCardsBoardNameMsg ->
            applicationState.copy(boardName = updateBoardName(applicationState.boardName, message.boardNameMsg))

    }

    return KatydidApplicationCycle(newApplicationState, commandsToExecute)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Clones this board but renames the given column at index [columnIndex] to [newName].
 */
fun WipCardsAppState.withColumnRenamed(columnIndex: Int, newName: String): WipCardsAppState {

    val columns = mutableListOf<WipCardsColumn>()

    for (colIndex in 0..this.columns.size) {
        if (colIndex == columnIndex) {
            columns.add(columns[colIndex].copy(name = newName))
        }
        else {
            columns.add(columns[colIndex])
        }
    }

    return this.copy(columns = columns.toList())

}

//---------------------------------------------------------------------------------------------------------------------

