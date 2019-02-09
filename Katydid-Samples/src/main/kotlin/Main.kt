//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

import js.katydid.samples.greetme.greetMeMain
import js.katydid.samples.helloworld.helloWorldMain
import js.katydid.samples.sudokusolver.sudokuSolverMain
import org.w3c.dom.get
import kotlin.browser.window

//---------------------------------------------------------------------------------------------------------------------

/**
 * Main entry point for all the samples. It chooses which sample to run using a variable set in the
 * currently open HTML file.
 */
@Suppress("unused", "UnsafeCastFromDynamic")
fun main( args: Array<String> ) {

    val appName = window["appName"]

    console.log("Starting application: ", appName)

    if (appName == "Hello World") {
        helloWorldMain(args)
    }
    else if (appName == "Greet Me") {
        greetMeMain(args)
    }
    else if (appName == "Sudoku Solver") {
        sudokuSolverMain(args)
    }
    else {
        console.log("ERROR: Unknown application: ", appName)
    }

    console.log("DONE")

}

//---------------------------------------------------------------------------------------------------------------------
