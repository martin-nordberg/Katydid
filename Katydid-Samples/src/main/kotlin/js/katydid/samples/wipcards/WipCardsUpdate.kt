//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards

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

        is RenameColumnMsg     ->
            applicationState.withColumnRenamed(
                message.columnIndex, message.newName
            )

    }

    return KatydidApplicationCycle(newApplicationState,commandsToExecute)

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Clones this board but removes one previously placed value in row [rowIndex] and column [colIndex].
 */
fun WipCardsAppState.withColumnRenamed(columnIndex: Int, newName: String): WipCardsAppState {

    val columns = mutableListOf<WipCardColumnState>()

    for ( colIndex in 0..this.columns.size) {
        if ( colIndex == columnIndex) {
            columns.add(WipCardColumnState(newName))
        }
        else {
            columns.add(columns[colIndex])
        }
    }

    return WipCardsAppState(columns.toList())

}

//---------------------------------------------------------------------------------------------------------------------

