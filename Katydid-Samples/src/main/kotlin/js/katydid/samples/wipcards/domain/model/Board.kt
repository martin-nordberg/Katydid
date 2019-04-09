//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.model

import js.katydid.samples.wipcards.infrastructure.Uuid
import js.katydid.samples.wipcards.infrastructure.addIf

//---------------------------------------------------------------------------------------------------------------------

data class Board(

    val uuid: Uuid<Board>,

    val name: String

) {

    fun problems(domain:WipCardsDomain) = with(domain) {

        val columns = columns()

        listOf<String>()
            .addIf(name.isEmpty()) {
                "Board name must not be empty."
            }
            .addIf(name.isBlank()) {
                "Board name must not be blank."
            }
            .addIf(name.length > 100) {
                "Board name limited to 100 characters."
            }
            .addIf(columns.size < 2) {
                "Board must have at least two columns."
            }
            .addIf(columns.map { column -> column.heading }.toSet().size < columns.size) {
                "Columns must have unique headings within their board."
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------



