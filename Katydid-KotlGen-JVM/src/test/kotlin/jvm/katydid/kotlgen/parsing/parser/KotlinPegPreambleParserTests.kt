//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing.parser

import org.junit.jupiter.api.Test


//---------------------------------------------------------------------------------------------------------------------

class KotlinPegPreambleParserTests
    : KotlinPegParserTests() {

    @Test
    fun `A parser parses a package preamble of imports`() {

        val input = """

            import org.a.b
            import org . xy .wz as q
            import org.xy.rst . *;

            """.trimIndent()

        val expectedSExpression =
            "(KotlinFile (Imports (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'a') (SimpleName 'b'))) (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'xy') (SimpleName 'wz')) (ImportAlias (Keyword 'as') (SimpleName 'q'))) (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'xy') (SimpleName 'rst')) (ImportAll ' . *'))) (TopLevelObjects '') (EOI ''))"

        checkParse(expectedSExpression, input) {
            KotlinFile()
        }

    }

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

        val expectedSExpression =
            "(KotlinFile (PackageHeader (Keyword 'package') (QualifiedName (SimpleName 'a') (SimpleName 'b') (SimpleName 'c'))) (Imports (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'a') (SimpleName 'b')) (ImportAlias (Keyword 'as') (SimpleName 'aa'))) (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'xy') (SimpleName 'wz')) (ImportAlias (Keyword 'as') (SimpleName 'q'))) (Import (Keyword 'import') (QualifiedName (SimpleName 'org') (SimpleName 'xy') (SimpleName 'rst')) (ImportAll ' . *'))) (TopLevelObjects (Property (Keyword 'val') (SimpleName 'a')) (Property (Keyword 'val') (SimpleName 'b'))) (EOI ''))"

        checkParse(expectedSExpression, input) {
            KotlinFile()
        }

    }

    @Test
    fun `A parser parses a compressed package preamble`() {

        val input = """
                    |
                    |package example.pkg1
                    |
                    |import sample.pkg1; import sample.pkg2.*
                    |import sample.pkg3 as three
                    |
                    |""".trimMargin()

        val expectedSExpression =
            "(KotlinFile (PackageHeader (Keyword 'package') (QualifiedName (SimpleName 'example') (SimpleName 'pkg1'))) (Imports (Import (Keyword 'import') (QualifiedName (SimpleName 'sample') (SimpleName 'pkg1'))) (Import (Keyword 'import') (QualifiedName (SimpleName 'sample') (SimpleName 'pkg2')) (ImportAll '.*')) (Import (Keyword 'import') (QualifiedName (SimpleName 'sample') (SimpleName 'pkg3')) (ImportAlias (Keyword 'as') (SimpleName 'three')))) (TopLevelObjects '') (EOI ''))"

        checkParse(expectedSExpression, input) {
            KotlinFile()
        }

    }

    @Test
    fun `A parser parses a lone package header`() {

        val input = "package a.b.c"

        val expectedSExpression =
            "(KotlinFile (PackageHeader (Keyword 'package') (QualifiedName (SimpleName 'a') (SimpleName 'b') (SimpleName 'c'))) (Imports '') (TopLevelObjects '') (EOI ''))"

        checkParse(expectedSExpression, input) {
            KotlinFile()
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

