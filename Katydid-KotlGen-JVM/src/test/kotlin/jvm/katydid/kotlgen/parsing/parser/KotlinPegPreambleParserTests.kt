//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing.parser

import org.junit.jupiter.api.Test


//---------------------------------------------------------------------------------------------------------------------

class KotlinPegPreambleParserTests
    : KotlinPegParserTests() {

    @Test
    fun `A parser parses a package preamble`() {

        val input = """

            package a.b.c

            import org.a.b as aa
            import org . xy .wz as q
            import org.xy.rst . *;

            val a
            val b

            """.trimIndent()

        val expectedSExpression = "(KotlinFile (PackageHeader (Keyword 'package') (QualifiedName (SimpleName 'a') (SimpleName 'b') (SimpleName 'c'))) (Imports (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'a') (SimpleName 'b')) (ImportAlias (Keyword 'as') (SimpleName 'aa'))) (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'xy') (SimpleName 'wz')) (ImportAlias (Keyword 'as') (SimpleName 'q'))) (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'xy') (SimpleName 'rst')) (ImportAll ' . *'))) (TopLevelObjects (Property (Keyword 'val') (SimpleName 'a')) (Property (Keyword 'val') (SimpleName 'b'))) (EOI ''))"

        checkParse(expectedSExpression, input) {
            KotlinFile()
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

