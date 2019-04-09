//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.model

import js.katydid.samples.wipcards.infrastructure.Uuid
import js.katydid.samples.wipcards.infrastructure.addIf

// TODO: Use kotlinx.collections.immutable collections for efficiency

//---------------------------------------------------------------------------------------------------------------------

data class Concepts(

    val boards: Map<Uuid<Board>, Board> = mapOf(),

    val cards: Map<Uuid<Card>, Card> = mapOf(),

    val columns: Map<Uuid<Column>, Column> = mapOf(),

    val users: Map<Uuid<User>, User> = mapOf()

) {

    fun withBoardAdded(board: Board) =
        this.copy(boards = boards + (board.uuid to board))

    fun withBoardRemoved(boardUuid: Uuid<Board>) =
        this.copy(boards = boards - boardUuid)

    fun withBoardUpdated(board: Board) =
        this.copy(boards = boards + (board.uuid to board))

    fun withCardAdded(card: Card) =
        this.copy(cards = cards + (card.uuid to card))

    fun withCardRemoved(cardUuid: Uuid<Card>) =
        this.copy(cards = cards - cardUuid)

    fun withCardUpdated(card: Card) =
        this.copy(cards = cards + (card.uuid to card))

    fun withColumnAdded(column: Column) =
        this.copy(columns = columns + (column.uuid to column))

    fun withColumnRemoved(columnUuid: Uuid<Column>) =
        this.copy(columns = columns - columnUuid)

    fun withColumnUpdated(column: Column) =
        this.copy(columns = columns + (column.uuid to column))

    fun withUserAdded(user: User) =
        this.copy(users = users + (user.uuid to user))

    fun withUserRemoved(userUuid: Uuid<User>) =
        this.copy(users = users - userUuid)

    fun withUserUpdated(user: User) =
        this.copy(users = users + (user.uuid to user))

}

//---------------------------------------------------------------------------------------------------------------------

data class Connections(

    val containedByBoard: Map<Uuid<Column>, Uuid<Board>> = mapOf(),

    val containedByColumn: Map<Uuid<Card>, Uuid<Column>> = mapOf(),

    val containsCard: Map<Uuid<Column>, List<Uuid<Card>>> = mapOf(),

    val containsColumn: Map<Uuid<Board>, List<Uuid<Column>>> = mapOf(),

    val ownedByUser: Map<Uuid<Card>, Uuid<User>> = mapOf(),

    val ownsCard: Map<Uuid<User>, List<Uuid<Card>>> = mapOf()

) {

    fun withBoardContainsColumn(board: Board, column: Column) =
        this.copy(
            containedByBoard = containedByBoard + (column.uuid to board.uuid),
            containsColumn = containsColumn + (board.uuid to (containsColumn.getOrElse(board.uuid) { listOf() } + column.uuid))
        )

    fun withBoardNoLongerContainsColumn(boardUuid: Uuid<Board>, columnUuid: Uuid<Column>) =
        this.copy(
            containedByBoard = containedByBoard - columnUuid,
            containsColumn = containsColumn + (boardUuid to (containsColumn.getOrElse(boardUuid) { listOf() } - columnUuid))
        )

    fun withColumnContainsCard(column: Column, card: Card) =
        this.copy(
            containedByColumn = containedByColumn + (card.uuid to column.uuid),
            containsCard = containsCard + (column.uuid to (containsCard.getOrElse(column.uuid) { listOf() } + card.uuid))
        )

    fun withColumnNoLongerContainsCard(columnUuid: Uuid<Column>, cardUuid: Uuid<Card>) =
        this.copy(
            containedByColumn = containedByColumn - cardUuid,
            containsCard = containsCard + (columnUuid to (containsCard.getOrElse(columnUuid) { listOf() } - cardUuid))
        )

    fun withUserOwnsCard(user: User, card: Card) =
        this.copy(
            ownedByUser = ownedByUser + (card.uuid to user.uuid),
            ownsCard = ownsCard + (user.uuid to (ownsCard.getOrElse(user.uuid) { listOf() } + card.uuid))
        )

    fun withUserNoLongerOwnsCard(userUuid: Uuid<User>, cardUuid: Uuid<Card>) =
        this.copy(
            ownedByUser = ownedByUser - cardUuid,
            ownsCard = ownsCard + (userUuid to (ownsCard.getOrElse(userUuid) { listOf() } - cardUuid))
        )


}

//---------------------------------------------------------------------------------------------------------------------

data class WipCardsDomain(

    val concepts: Concepts = Concepts(),

    val connections: Connections = Connections()

) {

    inner class BoardChange(
        private val board: Board
    ) {

        fun added() =
            this@WipCardsDomain.copy(concepts = concepts.withBoardAdded(board))

        fun contains(column: Column) =
            this@WipCardsDomain.copy(connections = connections.withBoardContainsColumn(board,column))

        fun noLongerContains(column: Column) =
            this@WipCardsDomain.copy(connections = connections.withBoardNoLongerContainsColumn(board.uuid, column.uuid))

        fun removed() =
            this@WipCardsDomain.copy(concepts = concepts.withBoardRemoved(board.uuid))

        fun updated() =
            this@WipCardsDomain.copy(concepts = concepts.withBoardUpdated(board))

    }

    inner class CardChange(
        private val card: Card
    ) {

        fun added() =
            this@WipCardsDomain.copy(concepts = concepts.withCardAdded(card))

        fun removed() =
            this@WipCardsDomain.copy(concepts = concepts.withCardRemoved(card.uuid))

        fun updated() =
            this@WipCardsDomain.copy(concepts = concepts.withCardUpdated(card))

    }

    inner class ColumnChange(
        private val column: Column
    ) {

        fun added(): WipCardsDomain =
            this@WipCardsDomain.copy(concepts = concepts.withColumnAdded(column))

        fun contains(card: Card) =
            this@WipCardsDomain.copy(connections = connections.withColumnContainsCard(column, card))

        fun noLongerContains(card: Card) =
            this@WipCardsDomain.copy(connections = connections.withColumnNoLongerContainsCard(column.uuid, card.uuid))

        fun removed() =
            this@WipCardsDomain.copy(concepts = concepts.withColumnRemoved(column.uuid))

        fun updated() =
            this@WipCardsDomain.copy(concepts = concepts.withColumnUpdated(column))

    }

    inner class UserChange(
        private val user: User
    ) {

        fun added(): WipCardsDomain =
            this@WipCardsDomain.copy(concepts = concepts.withUserAdded(user))

        fun owns(card: Card) =
            this@WipCardsDomain.copy(connections = connections.withUserOwnsCard(user, card))

        fun noLongerOwns(card: Card) =
            this@WipCardsDomain.copy(connections = connections.withUserNoLongerOwnsCard(user.uuid, card.uuid))

        fun removed() =
            this@WipCardsDomain.copy(concepts = concepts.withUserRemoved(user.uuid))

        fun updated() =
            this@WipCardsDomain.copy(concepts = concepts.withUserUpdated(user))

    }

    val problems = listOf<String>()
        .addIf(concepts.boards.isEmpty()) {
            "No boards have been defined."
        }

    ////

    fun boardWithUuid(boardUuid: Uuid<Board>) =
        concepts.boards[boardUuid]

    fun cardWithUuid(cardUuid: Uuid<Card>) =
        concepts.cards[cardUuid]

    fun columnWithUuid(columnUuid: Uuid<Column>) =
        concepts.columns[columnUuid]

    ////

    fun Board.columns(): List<Column> =
        connections.containsColumn
            .getOrElse(this.uuid) { listOf() }
            .map { columnUuid ->
                concepts.columns[columnUuid] ?: throw IllegalStateException("Column not found")
            }

    fun Column.cards(): List<Card> =
        connections.containsCard
            .getOrElse(this.uuid) { listOf() }
            .map { cardUuid ->
                concepts.cards[cardUuid] ?: throw IllegalStateException("Card not found")
            }

    fun User.cards(): List<Card> =
        connections.ownsCard
            .getOrElse(this.uuid) { listOf() }
            .map { cardUuid ->
                concepts.cards[cardUuid] ?: throw IllegalStateException("Card not found")
            }

    ////

    fun with(board: Board) =
        BoardChange(board)

    fun with(card: Card) =
        CardChange(card)

    fun with(column: Column) =
        ColumnChange(column)

    fun with(user: User) =
        UserChange(user)

}

//---------------------------------------------------------------------------------------------------------------------



