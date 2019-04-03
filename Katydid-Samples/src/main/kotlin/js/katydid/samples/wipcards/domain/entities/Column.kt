//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.entities

import js.katydid.samples.wipcards.infrastructure.addIf

//---------------------------------------------------------------------------------------------------------------------

data class Column(

    val cards: List<Card>,

    val heading: String,

    val uuid: String

) {

    val problems = listOf<String>()
        .addIf(heading.isEmpty()) {
            "Column heading name must not be empty."
        }
        .addIf(heading.isBlank()) {
            "Column heading must not be blank."
        }
        .addIf(heading.length > 25) {
            "Column heading limited to 25 characters."
        }

}

//---------------------------------------------------------------------------------------------------------------------


