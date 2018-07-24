//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.helloworld

import o.katydid.vdom.application.katyDom
import o.katydid.vdom.application.makeKatyDomLifecycle
import kotlin.browser.document


//---------------------------------------------------------------------------------------------------------------------

/**
 * Top-level component to build the virtual DOM for the Hello World application.
 */
val helloWorldView = katyDom<Unit> {

    // This top level element replaces the "#app" div in helloworld.html.
    div("#hello-world-app") {

        // Elements can have in-line styles ...
        h1("#heading", style = "color:blue") {
            text("Hello World")
        }

        // ... or can reference CSS classes (see helloworld.html).
        span("#greeting.span-greeting") {
            text("Greetings from a Kotlin sample application.")
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Runs the Hello World application.
 */
@Suppress("UNUSED_PARAMETER")
fun helloWorldMain(args: Array<String>) {

    // Establish a KatyDOM lifecyle (Unit means no messages from user input).
    val lifecycle = makeKatyDomLifecycle<Unit>()

    // Find the placeholder application element in helloworld.html.
    val appElement = document.getElementById("app")

    if (appElement != null) {
        // This is a minimal use of the KatyDOM lifecyle: build the virtual DOM and copy it to the real DOM just
        // once. See more advanced samples for the realistic scenario of updating the virtual and real DOMs in
        // response to user input.
        lifecycle.build(appElement, helloWorldView)
    }
    else {
        console.log("ERROR: Application element div#app not found.")
    }

    console.log("DONE")

}

//---------------------------------------------------------------------------------------------------------------------
