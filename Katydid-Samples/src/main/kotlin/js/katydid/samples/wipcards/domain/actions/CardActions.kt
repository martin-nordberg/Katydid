//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.actions

import js.katydid.samples.wipcards.domain.entities.Card
import js.katydid.samples.wipcards.infrastructure.Action
import js.katydid.samples.wipcards.infrastructure.ResultWithErrors

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardDetailsAction(

    val newDetails: String,

    val oldDetails: String

) : Action<Card>() {

    override fun apply(state: Card): ResultWithErrors<Card> {

        if (oldDetails != state.details) {
            return ResultWithErrors(
                state,
                listOf("Card details have already been changed.")
            )
        }

        return ResultWithErrors(
            state.copy(details = newDetails)
        )

    }

    override fun compensatingAction() =
        ChangeCardDetailsAction(newDetails = oldDetails, oldDetails = newDetails)

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardTitleAction(

    val newTitle: String,

    val oldTitle: String

) : Action<Card>() {

    override fun apply(state: Card): ResultWithErrors<Card> {

        if (oldTitle != state.details) {
            return ResultWithErrors(
                state,
                listOf("Card title has already been changed.")
            )
        }

        return ResultWithErrors(
            state.copy(title = newTitle)
        )

    }

    override fun compensatingAction() =
        ChangeCardTitleAction(newTitle = oldTitle, oldTitle = newTitle)

}


//---------------------------------------------------------------------------------------------------------------------

