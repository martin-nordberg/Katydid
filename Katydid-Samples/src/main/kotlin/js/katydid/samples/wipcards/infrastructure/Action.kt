//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.infrastructure

//---------------------------------------------------------------------------------------------------------------------

abstract class Action<State> {

    abstract fun apply(state: State): ResultWithErrors<State>

    abstract fun compensatingAction(): Action<State>

}

//---------------------------------------------------------------------------------------------------------------------
