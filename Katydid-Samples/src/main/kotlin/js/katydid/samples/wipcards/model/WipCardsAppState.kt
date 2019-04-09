//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.model

import js.katydid.samples.wipcards.board.BoardNameViewModel
import js.katydid.samples.wipcards.domain.model.Board
import js.katydid.samples.wipcards.domain.model.WipCardsDomain
import js.katydid.samples.wipcards.infrastructure.Uuid


//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
sealed class WipCardsUiState

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
data class WipCardsBoardUiState(

    val boardUuid: Uuid<Board>,

    val boardName: BoardNameViewModel

) : WipCardsUiState()

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
data class WipCardsAppState(

    val domain: WipCardsDomain,

    val uiState: WipCardsUiState

)

//---------------------------------------------------------------------------------------------------------------------

