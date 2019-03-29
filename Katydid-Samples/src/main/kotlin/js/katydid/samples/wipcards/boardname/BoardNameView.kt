//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.boardname

import js.katydid.samples.wipcards.messages.WipCardsBoardNameMsg
import js.katydid.samples.wipcards.messages.WipCardsMsg
import o.katydid.events.eventhandling.*
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the board name heading of the WIP Cards board.
 */
internal fun KatydidFlowContentBuilder<WipCardsMsg>.viewBoardName(board: WipCardsBoard) {

    if (board.isEditingInProgress) {

        dialog(".$cssClassName", open = true) {

            inputText(value = board.name, autofocus = true) {

                onblur {
                    listOf(WipCardsBoardNameMsg(BoardNameStopEditingMsg))
                }

                onchange { event ->
                    val newValue = event.getTargetAttribute<String>("value").toString()
                    listOf(
                        WipCardsBoardNameMsg(BoardNameStopEditingMsg),
                        WipCardsBoardNameMsg(BoardNameRenameMsg(board.name, newValue))
                    )
                }

            }

        }

    }
    else {

        onmouseenter {
            listOf(WipCardsBoardNameMsg(BoardNameStartHoveringMsg))
        }

        onmouseleave {
            listOf(WipCardsBoardNameMsg(BoardNameStopHoveringMsg))
        }

        h1(".$cssClassName") {

            +board.name

            if (board.isEditButtonShown) {

                button {

                    onclick {
                        listOf(WipCardsBoardNameMsg(BoardNameStartEditingMsg))
                    }

                    +"Edit"

                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
