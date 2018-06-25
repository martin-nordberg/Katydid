//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.greetme

import js.org.katydom.api.KatyDomApplication
import js.org.katydom.api.runApplication
import o.org.katydom.builders.KatyDomFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/** Simple model for this application. */
data class GreetMeAppState (
    val myName : String
)

//---------------------------------------------------------------------------------------------------------------------

/** Simple message for user events (changed name). */
data class GreetMeMsg (
    val newName : String
)

//---------------------------------------------------------------------------------------------------------------------

/**
 * KatyDOM application.
 */
class GreetMeApplication : KatyDomApplication<GreetMeAppState, GreetMeMsg> {

    /**
     * Initializes the application state for the first time.
     */
    override fun initialize(): GreetMeAppState {
        return GreetMeAppState("KatyDOM User")
    }

    /**
     * Creates a new application state modified from given [applicationState] by the given [message].
     */
    override fun update(applicationState: GreetMeAppState, message: GreetMeMsg): GreetMeAppState {
        return GreetMeAppState(message.newName)
    }

    /**
     * Constructs the KatyDOM virtual DOM tree for given input application state [applicationState].
     * @return the root of the application's virtual DOM tree for given application state.
     */
    override fun view(applicationState: GreetMeAppState): KatyDomFlowContentBuilder<GreetMeMsg>.() -> Unit =
        {

            // This top level element replaces the "#app" div in greetme.html.
            div("#greet-me-app") {

                h1 {
                    text("Greet Me")
                }

                span {
                    text("Greetings, ${applicationState.myName}, from a Kotlin sample application.")
                }

                br {}

                form(style = "margin-top:1.5em;") {

                    label(`for` = "name-box", style = "margin-right:1.5em;") {
                        text("My Name Is:")
                    }

                    inputText(value = applicationState.myName) {

                        oninput { event ->

                            // Capture the new value out of the change event and pass it to the application
                            // lifecycle as a message (a list of one message).
                            val newValue: String = event.target.asDynamic().value as String
                            listOf(GreetMeMsg(newValue))

                        }

                    }

                }

            }

        }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Runs the Greet Me application.
 */
@Suppress("UNUSED_PARAMETER")
fun greetMeMain(args: Array<String>) {

    runApplication(
        "app",
        GreetMeApplication()
    )

}

//---------------------------------------------------------------------------------------------------------------------
