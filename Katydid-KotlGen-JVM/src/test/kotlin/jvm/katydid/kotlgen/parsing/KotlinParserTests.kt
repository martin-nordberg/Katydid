//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing

import o.katydid.kotlgen.model.core.KgOriginLineColumnAndSize
import o.katydid.kotlgen.model.core.modifiers.KgModifierKeyword
import o.katydid.kotlgen.model.declarations.classes.KgEnumClass
import o.katydid.kotlgen.model.declarations.declarationsOfType
import o.katydid.kotlgen.model.declarations.properties.KgEnumEntry
import o.katydid.kotlgen.model.makeSourceRoot
import o.katydid.kotlgen.model.structure.KgSourceFile
import o.katydid.kotlgen.parsing.makeKotlinParser2
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue


//---------------------------------------------------------------------------------------------------------------------

class KotlinParserTests {

    private fun parseKotlinFile(code: String): KgSourceFile {

        val parser = makeKotlinParser2(code)

        val srcRoot = makeSourceRoot(File("."))
        val srcFile = parser.parseKotlinFile(srcRoot, "test")

        assertEquals("test", srcFile.name)

        return srcFile

    }

    @Test
    fun `A parser parses a package header`() {

        val code = "package stuff.desirable"

        val srcFile = parseKotlinFile(code)

        assertEquals("stuff.desirable.test", srcFile.qualifiedName.text)

    }

    @Test
    fun `A parser parses imports`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |import sample.pkg1; import sample.pkg2.*
                    |import sample.pkg3 as three
                    |
                    |""".trimMargin()

        val srcFile = parseKotlinFile(code)

        assertEquals("example.pkg1.test", srcFile.qualifiedName.text)

        assertEquals(3, srcFile.imports.size)

        assertEquals("sample.pkg1", srcFile.imports[0].qualifiedName.text)
        assertFalse(srcFile.imports[0].all)
        assertNull(srcFile.imports[0].alias)

        assertEquals("sample.pkg2", srcFile.imports[1].qualifiedName.text)
        assertTrue(srcFile.imports[1].all)
        assertNull(srcFile.imports[1].alias)

        assertEquals("sample.pkg3", srcFile.imports[2].qualifiedName.text)
        assertFalse(srcFile.imports[2].all)
        assertEquals("three", srcFile.imports[2].alias)
    }

    // TODO @Test
    fun `A parser parses simple enums`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |import sample.pkg1
                    |
                    |internal enum class ESample {
                    |  A,
                    |  B
                    |}
                    |
                    |""".trimMargin()

        val srcFile = parseKotlinFile(code)

        val enumClasses = srcFile.declarationsOfType<KgEnumClass>()

        assertEquals(1, enumClasses.size)
        assertEquals(KgOriginLineColumnAndSize(6, 15, 5), enumClasses[0].keywordOrigin)
        assertEquals("ESample", enumClasses[0].name)
        assertEquals(KgOriginLineColumnAndSize(6, 21, 7), enumClasses[0].nameOrigin)

        val enumEntries = enumClasses[0].declarationsOfType<KgEnumEntry>()

        assertEquals(2, enumEntries.size)
        assertEquals("A", enumEntries[0].name)
        assertEquals("B", enumEntries[1].name)
        assertTrue(enumClasses[0].modifiers.contains(KgModifierKeyword.`internal`))

    }

}

//---------------------------------------------------------------------------------------------------------------------

