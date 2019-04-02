//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.actions

import js.katydid.samples.wipcards.domain.entities.Column

//---------------------------------------------------------------------------------------------------------------------

sealed class ColumnAction {

    abstract fun apply(column: Column): Column

    abstract fun canApply(column: Column): Boolean

    abstract fun compensatingAction(): ColumnAction?

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeCardAction (

    val cardAction: CardAction,

    val cardUuid: String

) : ColumnAction() {

    override fun apply(column: Column): Column {

        return column.copy(
            cards = column.cards.map {
                card -> if ( card.uuid == cardUuid ) cardAction.apply(card)
                        else card
            }
        )

    }

    override fun canApply(column: Column): Boolean {
        return column.cards.find{ card -> card.uuid == cardUuid } != null
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction() : ColumnAction? {
        val compensatingCardAction = cardAction.compensatingAction()

        return if ( compensatingCardAction != null ) ChangeCardAction(compensatingCardAction,cardUuid)
               else null

    }

}

//---------------------------------------------------------------------------------------------------------------------

data class ChangeColumnHeadingAction(

    val newHeading: String,

    val oldHeading: String

): ColumnAction() {

    override fun apply(column: Column): Column {
        require(canApply(column))
        return column.copy(heading = newHeading)
    }

    override fun canApply(column: Column): Boolean {
        return oldHeading == column.heading
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction() =
        ChangeColumnHeadingAction(newHeading=oldHeading, oldHeading=newHeading)

}

//---------------------------------------------------------------------------------------------------------------------

data class DeleteCardAction(

    val cardUuid: String,

    val originalDetails: String,

    val originalIndex: Int,

    val originalTitle: String

): ColumnAction() {

    override fun apply(column: Column): Column {
        require(canApply(column))
        return column.copy(cards=column.cards.filterNot { card -> card.uuid == cardUuid })
    }

    override fun canApply(column: Column): Boolean {
        return column.cards.find{ card -> card.uuid == cardUuid } != null
        // TODO: true/false plus list of problems
    }

    override fun compensatingAction(): Nothing? =
        null

}

//---------------------------------------------------------------------------------------------------------------------

