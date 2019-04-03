//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.entities

import js.katydid.samples.wipcards.infrastructure.addIf

//---------------------------------------------------------------------------------------------------------------------

data class Board(

    val columns: List<Column>,

    val name: String,

    val uuid: String

) {

    val problems = listOf<String>()
        .addIf(name.isEmpty()) {
            "Board name must not be empty."
        }
        .addIf(name.isBlank()) {
            "Board name must not be blank."
        }
        .addIf(name.length > 100) {
            "Board name limited to 100 characters."
        }
        .addIf(columns.size < 2 ) {
            "Board must have at least two columns."
        }
        .addIf(columns.map { c -> c.heading }.toSet().size < columns.size) {
            "Columns must have unique headings within their board."
        }

}

//---------------------------------------------------------------------------------------------------------------------



