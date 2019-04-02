//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.actions

import js.katydid.samples.wipcards.domain.entities.Card

//---------------------------------------------------------------------------------------------------------------------

sealed class CardAction {

    abstract fun apply(card: Card): Card

    abstract fun canApply(card: Card): Boolean

    abstract fun compensatingAction(): CardAction?

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardDetailsAction(

    val newDetails: String,

    val oldDetails: String

): CardAction() {

    override fun apply(card: Card): Card {
        require(canApply(card))
        return card.copy(details = newDetails)
    }

    override fun canApply(card: Card): Boolean {
        return oldDetails == card.details
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction() =
        ChangeCardDetailsAction(oldDetails, newDetails)

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardTitleAction(

    val newTitle: String,

    val oldTitle: String

): CardAction() {

    override fun apply(card: Card): Card {
        require(canApply(card))
        return card.copy(title = newTitle)
    }

    override fun canApply(card: Card): Boolean {
        return oldTitle == card.title
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction() =
        ChangeCardTitleAction(oldTitle, newTitle)

}


//---------------------------------------------------------------------------------------------------------------------

