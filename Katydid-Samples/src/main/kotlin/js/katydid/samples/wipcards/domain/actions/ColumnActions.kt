//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.actions

import js.katydid.samples.wipcards.domain.entities.Card
import js.katydid.samples.wipcards.domain.entities.Column
import js.katydid.samples.wipcards.infrastructure.Action
import js.katydid.samples.wipcards.infrastructure.ResultWithErrors

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardAction(

    val cardAction: Action<Card>,

    val cardUuid: String

) : Action<Column>() {

    override fun apply(state: Column): ResultWithErrors<Column> {

        // Find the card to be changed or quit early with an error.
        val foundCard = state.cards.find { column -> column.uuid == cardUuid }
            ?: return ResultWithErrors(state, errors = listOf("Card not found."))

        // Act on the card found.
        val innerResult = cardAction.apply(foundCard)

        // Combine the results and any errors.
        return ResultWithErrors(
            state.copy(
                cards = state.cards.map { card ->
                    if (card == foundCard) innerResult.result
                    else card
                }
            ),
            errors = innerResult.errors
        )

    }

    override fun compensatingAction(): Action<Column> =
        ChangeCardAction(cardAction.compensatingAction(), cardUuid)

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeColumnHeadingAction(

    val newHeading: String,

    val oldHeading: String

) : Action<Column>() {

    override fun apply(state: Column): ResultWithErrors<Column> {

        if (oldHeading != state.heading) {
            return ResultWithErrors(state, listOf("Column heading has already been changed."))
        }

        return ResultWithErrors(state.copy(heading = newHeading))

    }

    override fun compensatingAction() =
        ChangeColumnHeadingAction(newHeading = oldHeading, oldHeading = newHeading)

}

//---------------------------------------------------------------------------------------------------------------------

data class DeleteCardAction(

    val cardUuid: String,

    val originalDetails: String,

    val originalIndex: Int,

    val originalTitle: String

) : Action<Column>() {

    override fun apply(state: Column): ResultWithErrors<Column> {

        if (state.cards.find { card -> card.uuid == cardUuid } == null) {
            return ResultWithErrors(state, listOf("Card has already been deleted."))
        }

        return ResultWithErrors(
            state.copy(cards = state.cards.filter { card -> card.uuid != cardUuid })
        )

    }

    override fun compensatingAction() =
        throw UnsupportedOperationException("TODO")

}

//---------------------------------------------------------------------------------------------------------------------

