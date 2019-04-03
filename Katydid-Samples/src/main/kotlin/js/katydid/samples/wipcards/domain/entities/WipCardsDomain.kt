//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.entities

import js.katydid.samples.wipcards.infrastructure.addIf

//---------------------------------------------------------------------------------------------------------------------

data class WipCardsDomain(

    val boards: List<Board>

) {

    val problems = listOf<String>()
        .addIf(boards.isEmpty()) {
            "No boards have been defined."
        }
}

//---------------------------------------------------------------------------------------------------------------------



