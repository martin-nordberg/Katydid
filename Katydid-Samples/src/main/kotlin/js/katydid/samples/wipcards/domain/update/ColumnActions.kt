//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.update

import js.katydid.samples.wipcards.domain.model.Card
import js.katydid.samples.wipcards.domain.model.Column
import js.katydid.samples.wipcards.domain.model.WipCardsDomain
import js.katydid.samples.wipcards.infrastructure.Action
import js.katydid.samples.wipcards.infrastructure.Uuid

//---------------------------------------------------------------------------------------------------------------------

data class ChangeColumnHeadingAction(

    val columnUuid: Uuid<Column>,

    val newHeading: String,

    val oldHeading: String

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val column = columnWithUuid(columnUuid)

        check(column != null) { "Column not found." }
        check(oldHeading == column.heading) { "Column heading has already been changed." }

        with(column).updated()

    }

    override fun compensatingAction() =
        this.copy(newHeading = oldHeading, oldHeading = newHeading)

}

//---------------------------------------------------------------------------------------------------------------------

data class DeleteCardAction(

    val columnUuid: Uuid<Column>,

    val cardUuid: Uuid<Card>,

    val originalDetails: String,

    val originalTitle: String

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val column = columnWithUuid(columnUuid)
        val card = cardWithUuid(cardUuid)

        check(column != null) { "Column not found." }
        check(card != null) { "Card not found." }

        with(column).noLongerContains(card)
            .with(card).removed()

    }

    override fun compensatingAction() =
        throw UnsupportedOperationException("TODO")

}

//---------------------------------------------------------------------------------------------------------------------

