//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.codegen

import java.io.PrintWriter

//---------------------------------------------------------------------------------------------------------------------

internal class CodeWriterImpl(
    private val code: PrintWriter
) : CodeWriter {

    private val currentLine = StringBuilder()

    private var indentCount = 0

    ////

    override fun indented(generate: CodeWriter.() -> Unit) {
        indentCount += 1
        generate()
        indentCount -= 1
    }

    private fun indentIfNeeded() {

        if (currentLine.isEmpty()) {

            for (i in 1..indentCount) {
                currentLine.append("    ")
            }

        }

    }

    override fun print(s: String) {
        indentIfNeeded()
        currentLine.append(s)
    }

    override fun println(lineCount: Int) {
        code.write(currentLine.toString())
        for ( i in 1..lineCount ) {
            code.print("\n")
        }
        currentLine.setLength(0)
    }

    override fun println(s: String) {
        print(s)
        println()
    }

}

//---------------------------------------------------------------------------------------------------------------------

