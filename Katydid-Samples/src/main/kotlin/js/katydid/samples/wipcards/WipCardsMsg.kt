//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards

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
