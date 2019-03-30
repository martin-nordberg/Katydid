//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.boardname

import o.katydid.css.colors.lightseagreen
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.*
import o.katydid.css.stylesheets.KatydidStyleSheet
import o.katydid.css.types.EDisplay
import o.katydid.css.types.EFontWeight
import o.katydid.css.types.EPosition
import o.katydid.events.eventhandling.*
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------
// MODEL
//---------------------------------------------------------------------------------------------------------------------

/** Description of a WIP Cards board. */
data class WipCardsBoard(

    val isEditButtonShown : Boolean = false,

    val isEditingInProgress : Boolean = false,

    val name : String

)

//---------------------------------------------------------------------------------------------------------------------
// UPDATE
//---------------------------------------------------------------------------------------------------------------------

/** Message related to changing a board's name. */
sealed class BoardNameMsg

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board is to be renamed. */
private data class BoardNameRenameMsg(

    val oldName: String,
    val newName: String

) : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board name is to be edited. */
private object BoardNameStartEditingMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when the mouse is hovering over the board name. */
private object BoardNameStartHoveringMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board is no longer being edited. */
private object BoardNameStopEditingMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board name is no longer being hovered over. */
private object BoardNameStopHoveringMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

private const val cssClassName = "wipcards-board-name"

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
// VIEW
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
// STYLE
//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyleSheet.boardNameStyles() {

    /* DIALOG */
    "dialog.$cssClassName" {

        backgroundColor(lightseagreen)
        borderColor(lightseagreen)
        display(EDisplay.inlineTable)
        padding(2.px)
        position(EPosition.relative)

        "input" {
            borderColor(lightseagreen)
            fontSize(22.px)
            fontWeight(EFontWeight.bold)
        }

    }

    /* H1 */
    "h1.$cssClassName" {

        fontSize(25.px)
        margin(5.px, 0.px, 5.px, 5.px)

    }

}

//---------------------------------------------------------------------------------------------------------------------

