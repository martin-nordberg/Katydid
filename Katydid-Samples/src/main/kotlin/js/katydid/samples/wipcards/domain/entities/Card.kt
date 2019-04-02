//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.entities


//---------------------------------------------------------------------------------------------------------------------

data class Card(

    val details: String,

    val title: String,

    val uuid: String

) {

    fun validate(): List<String> {

        val result = mutableListOf<String>()

        if (title.isEmpty()) {
            result.add("Card title name must not be empty.")
        }

        if (title.isBlank()) {
            result.add("Card title must not be blank.")
        }

        if (title.length > 100) {
            result.add("Card title limited to 100 characters.")
        }

        return result.toList()

    }

}

//---------------------------------------------------------------------------------------------------------------------


