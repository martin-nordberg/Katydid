//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing

import o.katydid.kotlgen.model.declarations.KgTypeAlias
import o.katydid.kotlgen.model.declarations.declarationsOfType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


//---------------------------------------------------------------------------------------------------------------------

class KotlinTypeParserTests
    : KotlinParserTests() {

    private fun checkParsePropertyWithType( type: String ) {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |typealias x = ${type}
                    |
                    |""".trimMargin()

        val srcFile = parseKotlinFile(code)

        assertEquals("example.pkg1.test", srcFile.qualifiedName.text)

        assertEquals("x", srcFile.declarationsOfType<KgTypeAlias>()[0].name)
        assertEquals(type, srcFile.declarationsOfType<KgTypeAlias>()[0].type.text)

    }

    @Test
    fun `A parser parses a simple named type`() =
        checkParsePropertyWithType( "Int" )

    @Test
    fun `A parser parses a property with qualified type name`() =
        checkParsePropertyWithType( "kotlin.String" )

    @Test
    fun `A parser parses a property with dynamic type`() =
        checkParsePropertyWithType( "dynamic" )

    @Test
    fun `A parser parses a property with nullable type`() =
        checkParsePropertyWithType( "com.example.test.Stuff?" )

    @Test
    fun `A parser parses a property with suspend modifier`() =
        checkParsePropertyWithType( "suspend TryMe" )

    @Test
    fun `A parser parses a parameterless void extension function type`() =
        checkParsePropertyWithType( "mypackage.Stuff.()" )

    @Test
    fun `A parser parses a parameterless non-void extension function type`() =
        checkParsePropertyWithType( "mypackage.Stuff.(): String" )

}

//---------------------------------------------------------------------------------------------------------------------

