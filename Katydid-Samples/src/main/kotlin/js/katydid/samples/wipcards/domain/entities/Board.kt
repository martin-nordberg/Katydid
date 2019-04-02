//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.entities

//---------------------------------------------------------------------------------------------------------------------

data class Board(

    val columns: List<Column>,

    val name: String

) {

    fun validate(): List<String> {

        val result = mutableListOf<String>()

        if (name.isEmpty()) {
            result.add("Board name must not be empty.")
        }

        if (name.isBlank()) {
            result.add("Board name must not be blank.")
        }

        if (name.length > 100) {
            result.add("Board name limited to 100 characters.")
        }

        if (columns.size < 2) {
            result.add("Board must have at least two columns.")
        }

        if (columns.map { c -> c.heading }.toSet().size < columns.size) {
            result.add("Columns must have unique names.")
        }

        return result.toList()

    }

}

//---------------------------------------------------------------------------------------------------------------------



