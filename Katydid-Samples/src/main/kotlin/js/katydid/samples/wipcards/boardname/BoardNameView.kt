//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.boardname

import o.katydid.events.eventhandling.*
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the board name heading of the WIP Cards board.
 */
internal fun <Msg> KatydidFlowContentBuilder<Msg>.viewBoardName(
    board: WipCardsBoard,
    makeMsg: (msg: BoardNameMsg) -> Msg
) {

    if (board.isEditingInProgress) {

        dialog(".$cssClassName", open = true) {

            inputText(value = board.name, autofocus = true) {

                onblur {
                    listOf(makeMsg(BoardNameStopEditingMsg))
                }

                onchange { event ->
                    val newValue = event.getTargetAttribute<String>("value").toString()
                    listOf(
                        makeMsg(BoardNameStopEditingMsg),
                        makeMsg(BoardNameRenameMsg(board.name, newValue))
                    )
                }

            }

        }

    }
    else {

        onmouseenter {
            listOf(makeMsg(BoardNameStartHoveringMsg))
        }

        onmouseleave {
            listOf(makeMsg(BoardNameStopHoveringMsg))
        }

        h1(".$cssClassName") {

            +board.name

            if (board.isEditButtonShown) {

                button {

                    onclick {
                        listOf(makeMsg(BoardNameStartEditingMsg))
                    }

                    +"Edit"

                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
