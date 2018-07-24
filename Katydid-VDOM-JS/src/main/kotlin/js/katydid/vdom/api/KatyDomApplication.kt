//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.vdom.api

import o.katydid.vdom.application.katyDom
import o.katydid.vdom.application.makeKatyDomLifecycle
import o.katydid.vdom.builders.KatyDomFlowContentBuilder
import kotlin.browser.document
import kotlin.browser.window

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * Interface defining a KatyDOM Elm-like application.
 */
interface KatyDomApplication<AppState, Msg> {

    /**
     * Initializes the application state for the first time.
     */
    fun initialize(): AppState

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    fun update(applicationState: AppState, message: Msg): AppState

    /**
     * Constructs the KatyDOM virtual DOM tree for given input application state [applicationState].
     * @return the root of the application's virtual DOM tree for given application state.
     */
    fun view(applicationState: AppState): KatyDomFlowContentBuilder<Msg>.() -> Unit

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * Runs a given [application], putting its root DOM element in place of the existing element with
 * id=[applicationDomId]. Initializes the application state, builds the initial virtual and real DOM trees, then
 * repeatedly updates them in response to messages dispatched from view elements.
 */
fun <AppState, Msg> runApplication(
    applicationDomId: String,
    application: KatyDomApplication<AppState, Msg>
) {

    // Initialize the application state.
    var appState = application.initialize()

    // Create the KatyDOM lifecycle for building and patching the view.
    val lifecycle = makeKatyDomLifecycle<Msg>()

    // Start with an empty div just to avoid nullable node type.
    var appVdomNode = katyDom<Msg> {
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

                    // Update the model with each of the queued messages.
                    for (queuedAction in queuedMessages) {
                        appState = application.update(appState, queuedAction)
                    }

                    // Empty the queue.
                    queuedMessages.clear()

                    // Compute the new view (virtual DOM).
                    val oldAppVdomNode = appVdomNode
                    appVdomNode = katyDom(::dispatch) {
                        this.(application.view(appState))()
                    }

                    // Patch the new view into the real DOM.
                    lifecycle.patch(oldAppVdomNode, appVdomNode)

                },
                0
            )

        }

    }

    // Create the initial virtual view. Establish dispatching of events for subsequent updates inside dispatch(..).
    appVdomNode = katyDom(::dispatch) {
        this.(application.view(appState))()
    }

    // Find the root application DOM element to put the app into (failing if not found).
    val appElement = document.getElementById(applicationDomId)!!

    // Build the DOM to match the initial view.
    lifecycle.build(appElement, appVdomNode)

    // Everything else happens in callbacks to dispatch() ....

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

