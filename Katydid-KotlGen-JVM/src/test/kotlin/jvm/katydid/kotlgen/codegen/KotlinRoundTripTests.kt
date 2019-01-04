//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.codegen

import o.katydid.kotlgen.codegen.makeKotlinCodeGenerator
import o.katydid.kotlgen.model.makeSourceRoot
import o.katydid.kotlgen.parsing.makeKotlinParser
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

abstract class KotlinRoundTripTests {

    protected fun checkParseAndCodeGen(code: String) {

        val parser = makeKotlinParser(code)

        val srcRoot = makeSourceRoot(File("."))
        val srcFile = parser.parseKotlinFile(srcRoot, "test")

        val code2 = StringWriter()
        val codeGenerator = makeKotlinCodeGenerator(srcRoot, PrintWriter(code2))

        codeGenerator.generateKotlinFile(srcFile)

        assertEquals(code, code2.toString())

    }

}

//---------------------------------------------------------------------------------------------------------------------

