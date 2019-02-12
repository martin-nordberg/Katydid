//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.vdom.api

import o.katydid.vdom.application.katydid
import o.katydid.vdom.application.makeKatydidLifecycle
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import kotlin.browser.document
import kotlin.browser.window

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to a "command" - a background task that results in new messages sent to the application,
 * possibly asynchronously.
 */
typealias KatydidCommand<Msg> = ( dispatchMessages: (Iterable<Msg>) -> Unit ) -> Unit

//---------------------------------------------------------------------------------------------------------------------

/**
 * The composite result of an application initialization or update. Consists of the application state plus
 * an optional list of commands to be executed after the view has been updated to the new state.
 */
data class KatydidApplicationCycle<AppState, Msg>(

    /** The new application state after the update. */
    val newApplicationState: AppState,

    /** A list of commands to execute after the update has been made. (These can also have asynchronous results). */
    val commandsToExecute: List<KatydidCommand<Msg>> = listOf()

)

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface defining a Katydid Elm-like application.
 */
interface KatydidApplication<AppState, Msg> {

    /**
     * Initializes the application state for the first time.
     */
    fun initialize(): KatydidApplicationCycle<AppState, Msg>

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    fun update(applicationState: AppState, message: Msg): KatydidApplicationCycle<AppState, Msg>

    /**
     * Constructs the Katydid virtual DOM tree for given input application state [applicationState].
     * @return the root of the application's virtual DOM tree for given application state.
     */
    fun view(applicationState: AppState): KatydidFlowContentBuilder<Msg>.() -> Unit

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Runs a given [application], putting its root DOM element in place of the existing element with
 * id=[applicationDomId]. Initializes the application state, builds the initial virtual and real DOM trees, then
 * repeatedly updates them in response to messages dispatched from view elements.
 */
fun <AppState, Msg> runApplication(
    applicationDomId: String,
    application: KatydidApplication<AppState, Msg>
) {

    // Initialize the application state.
    var (appState, initialCommands) = application.initialize()

    // Create the Katydid lifecycle for building and patching the view.
    val lifecycle = makeKatydidLifecycle<Msg>()

    // Start with an empty div just to avoid nullable node type.
    var appVdomNode = katydid<Msg> {
        div("#application") {}
    }

    // Keep a queue of messages to reduce view recomputation when multiple messages fire in sequence.
    val queuedMessages: MutableList<Msg> = mutableListOf()

    /**
     * Dispatches a sequence of [messages] triggered by an event in the latest edition of the view.
     */
    fun dispatch(messages: Iterable<Msg>) {

        val timerNeeded = queuedMessages.isEmpty()

        // Queue the messages for execution when next idle.
        queuedMessages.addAll(messages)

        // If we already had something queued, then we already triggered the processing.
        if (timerNeeded) {

            window.setTimeout(
                {

                    // State with an empty list of commands.
                    val queuedCommands = mutableListOf<KatydidCommand<Msg>>()

                    // Update the model with each of the queued messages.
                    for (queuedMessage in queuedMessages) {
                        val updateResult = application.update(appState, queuedMessage)
                        appState = updateResult.newApplicationState
                        queuedCommands.addAll(updateResult.commandsToExecute)
                    }

                    // Empty the queue.
                    queuedMessages.clear()

                    // Compute the new view (virtual DOM).
                    val oldAppVdomNode = appVdomNode
                    appVdomNode = katydid(::dispatch) {
                        this.(application.view(appState))()
                    }

                    // Patch the new view into the real DOM.
                    lifecycle.patch(oldAppVdomNode, appVdomNode)

                    // Execute the commands
                    for (cmd in queuedCommands) {
                        cmd(::dispatch)
                    }

                },
                0
            )

        }

    }

    // Create the initial virtual view. Establish dispatching of events for subsequent updates inside dispatch(..).
    appVdomNode = katydid(::dispatch) {
        this.(application.view(appState))()
    }

    // Find the root application DOM element to put the app into (failing if not found).
    val appElement = document.getElementById(applicationDomId)!!

    // Build the DOM to match the initial view.
    lifecycle.build(appElement, appVdomNode)

    // Execute the first commands
    for (cmd in initialCommands) {
        cmd(::dispatch)
    }

    // Everything else happens in callbacks to dispatch() ....

}

//---------------------------------------------------------------------------------------------------------------------

