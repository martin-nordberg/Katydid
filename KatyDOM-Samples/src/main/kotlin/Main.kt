
import org.katydom.samples.helloworld.helloWorldMain
import org.w3c.dom.get
import kotlin.browser.window


//---------------------------------------------------------------------------------------------------------------------

/**
 * Main entry point for all the samples. It chooses which sample to run from a variable set in the open HTML file.
 */
@Suppress("unused", "UnsafeCastFromDynamic")
fun main( args: Array<String> ) {

    val appName = window["appName"]

    console.log("Starting application: ", appName)

    if (appName == "Hello World") {
        helloWorldMain(args)
    }
    else {
        console.log("ERROR: Unknown application: ", appName)
    }

    console.log("DONE")

}

//---------------------------------------------------------------------------------------------------------------------
