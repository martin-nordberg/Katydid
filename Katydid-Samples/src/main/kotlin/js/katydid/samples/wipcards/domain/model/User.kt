//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.model

import js.katydid.samples.wipcards.infrastructure.Uuid
import js.katydid.samples.wipcards.infrastructure.addIf


//---------------------------------------------------------------------------------------------------------------------

data class User(

    val uuid: Uuid<User>,

    val name: String

) {

    fun problems(domain:WipCardsDomain) = with(domain) {

        listOf<String>()
            .addIf(name.isEmpty()) {
                "User name must not be empty."
            }
            .addIf(name.isBlank()) {
                "User name must not be blank."
            }
            .addIf(name.length > 100) {
                "User name limited to 100 characters."
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------


