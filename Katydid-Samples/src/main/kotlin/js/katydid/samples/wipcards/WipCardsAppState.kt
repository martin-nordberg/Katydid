//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards




//---------------------------------------------------------------------------------------------------------------------

/** Description of a WIP Cards column. */
data class WipCardColumnState(

    val name : String

)

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
data class WipCardsAppState(

    val columns: List<WipCardColumnState>

)

//---------------------------------------------------------------------------------------------------------------------

