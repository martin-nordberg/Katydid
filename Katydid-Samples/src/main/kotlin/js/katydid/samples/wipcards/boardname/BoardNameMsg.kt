//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.boardname

//---------------------------------------------------------------------------------------------------------------------

/** Message related to changing a board's name. */
sealed class BoardNameMsg

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board is to be renamed. */
internal data class BoardNameRenameMsg(

    val oldName: String,
    val newName: String

) : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board name is to be edited. */
internal object BoardNameStartEditingMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when the mouse is hovering over the board name. */
internal object BoardNameStartHoveringMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board is no longer being edited. */
internal object BoardNameStopEditingMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board name is no longer being hovered over. */
internal object BoardNameStopHoveringMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------
