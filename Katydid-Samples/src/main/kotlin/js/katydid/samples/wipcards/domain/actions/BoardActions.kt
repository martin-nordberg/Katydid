//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.domain.actions

import js.katydid.samples.wipcards.domain.entities.Board
import js.katydid.samples.wipcards.domain.entities.Column
import js.katydid.samples.wipcards.infrastructure.Action
import js.katydid.samples.wipcards.infrastructure.ResultWithErrors

//---------------------------------------------------------------------------------------------------------------------

data class ChangeColumnAction(
    val columnUuid: String,
    val columnAction: Action<Column>
) : Action<Board>() {

    override fun apply(state: Board): ResultWithErrors<Board> {

        // Find the column to be changed or quit early with an error.
        val foundColumn = state.columns.find { column -> column.uuid == columnUuid }
            ?: return ResultWithErrors(state, errors = listOf("Column not found."))

        // Act on the column found.
        val innerResult = columnAction.apply(foundColumn)

        // Combine the results and any errors.
        return ResultWithErrors(
            state.copy(
                columns = state.columns.map { column ->
                    if (column == foundColumn) innerResult.result
                    else column
                }
            ),
            errors = innerResult.errors
        )

    }

    override fun compensatingAction(): Action<Board> =
        ChangeColumnAction(columnUuid, columnAction.compensatingAction())

}

//---------------------------------------------------------------------------------------------------------------------

data class RenameBoardAction(

    val newName: String,

    val oldName: String

) : Action<Board>() {

    override fun apply(state: Board): ResultWithErrors<Board> {

        if (oldName != state.name) {
            return ResultWithErrors(state, listOf("Board has already been renamed."))
        }

        return ResultWithErrors(state.copy(name = newName))

    }

    override fun compensatingAction() =
        RenameBoardAction(newName = oldName, oldName = newName)

}

//---------------------------------------------------------------------------------------------------------------------

data class DeleteColumnAction(

    val columnUuid: String

) : Action<Board>() {

    override fun apply(state: Board): ResultWithErrors<Board> {

        if (state.columns.find { column -> column.uuid == columnUuid } == null) {
            return ResultWithErrors(state, listOf("Board has already been deleted."))
        }

        return ResultWithErrors(
            state.copy(columns = state.columns.filter { column -> column.uuid != columnUuid })
        );

    }

    override fun compensatingAction() =
        throw UnsupportedOperationException("TODO")

}

//---------------------------------------------------------------------------------------------------------------------

