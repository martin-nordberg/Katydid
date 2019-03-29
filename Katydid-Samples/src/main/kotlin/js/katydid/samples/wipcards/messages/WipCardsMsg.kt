//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.messages

import js.katydid.samples.wipcards.boardname.BoardNameMsg

//---------------------------------------------------------------------------------------------------------------------

/** Simple message for user events. */
sealed class WipCardsMsg

//---------------------------------------------------------------------------------------------------------------------

/** Message when a column is to be renamed. */
data class RenameColumnMsg(

    val columnIndex: Int,

    val newName: String

) : WipCardsMsg()

//---------------------------------------------------------------------------------------------------------------------

/** A message affecting the name of a board. */
data class WipCardsBoardNameMsg(

    val boardNameMsg: BoardNameMsg

) : WipCardsMsg()

//---------------------------------------------------------------------------------------------------------------------
