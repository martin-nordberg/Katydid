//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.update

import js.katydid.samples.wipcards.domain.model.Card
import js.katydid.samples.wipcards.domain.model.WipCardsDomain
import js.katydid.samples.wipcards.infrastructure.Action
import js.katydid.samples.wipcards.infrastructure.Uuid

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardDetailsAction(

    val cardUuid: Uuid<Card>,

    val newDetails: String,

    val oldDetails: String

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val oldCard = cardWithUuid(cardUuid)

        check(oldCard != null) { "Card not found." }
        check(oldDetails == oldCard.details) { "Card details have already been changed." }

        val newCard = oldCard.copy(details = newDetails)

        with(newCard).updated()

    }


    override fun compensatingAction() =
        this.copy(newDetails = oldDetails, oldDetails = newDetails)

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardTitleAction(

    val cardUuid: Uuid<Card>,

    val newTitle: String,

    val oldTitle: String

) : Action<WipCardsDomain>() {

    override fun apply(state: WipCardsDomain) = with(state) {

        val oldCard = cardWithUuid(cardUuid)

        check(oldCard != null) { "Card not found." }
        check(oldTitle == oldCard.title) { "Card title has already been changed." }

        val newCard = oldCard.copy(title = newTitle)

        with(newCard).updated()

    }

    override fun compensatingAction() =
        this.copy(newTitle = oldTitle, oldTitle = newTitle)

}

//---------------------------------------------------------------------------------------------------------------------

