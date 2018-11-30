//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.codegen

//---------------------------------------------------------------------------------------------------------------------

internal interface CodeWriter {

    fun indented(generate: CodeWriter.() -> Unit)

    fun print(s: String)

    fun println()

    fun println(s: String)

}

//---------------------------------------------------------------------------------------------------------------------

