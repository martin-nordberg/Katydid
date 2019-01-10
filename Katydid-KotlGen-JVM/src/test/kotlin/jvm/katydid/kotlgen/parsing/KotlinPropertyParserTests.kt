//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing

import o.katydid.kotlgen.model.declarations.declarationsOfType
import o.katydid.kotlgen.model.declarations.properties.KgReadOnlyProperty
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


//---------------------------------------------------------------------------------------------------------------------

class KotlinPropertyParserTests
    : KotlinParserTests() {

    @Test
    fun `A parser parses a simple property`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |val x : Int
                    |
                    |""".trimMargin()

        val srcFile = parseKotlinFile(code)

        assertEquals("example.pkg1.test", srcFile.qualifiedName.text)

        assertEquals("x", srcFile.declarationsOfType<KgReadOnlyProperty>()[0].name)
        assertEquals("Int", srcFile.declarationsOfType<KgReadOnlyProperty>()[0].type.text)

    }

}

//---------------------------------------------------------------------------------------------------------------------

