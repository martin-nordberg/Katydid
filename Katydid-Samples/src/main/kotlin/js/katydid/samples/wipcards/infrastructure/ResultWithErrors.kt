//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.infrastructure

//---------------------------------------------------------------------------------------------------------------------

data class ResultWithErrors<Result> (

    val result: Result,

    val errors: List<String> = listOf()

) {

    val hasErrors =
        errors.isNotEmpty()

}

//---------------------------------------------------------------------------------------------------------------------


