//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.model

import js.katydid.samples.wipcards.boardname.WipCardsBoard


//---------------------------------------------------------------------------------------------------------------------

/** Description of a WIP Cards column. */
data class WipCardsColumn(

    val name : String

)

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
data class WipCardsAppState(

    val board: WipCardsBoard,

    val columns: List<WipCardsColumn>

)

//---------------------------------------------------------------------------------------------------------------------

