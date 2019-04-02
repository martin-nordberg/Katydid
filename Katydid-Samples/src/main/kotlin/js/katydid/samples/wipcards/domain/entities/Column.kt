//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.entities

//---------------------------------------------------------------------------------------------------------------------

data class Column(

    val cards: List<Card>,

    val heading: String,

    val uuid: String

) {

    fun validate(): List<String> {

        val result = mutableListOf<String>()

        if (heading.isEmpty()) {
            result.add("Column heading name must not be empty.")
        }

        if (heading.isBlank()) {
            result.add("Column heading must not be blank.")
        }

        if (heading.length > 25) {
            result.add("Column heading limited to 25 characters.")
        }

        return result.toList()

    }

}

//---------------------------------------------------------------------------------------------------------------------


