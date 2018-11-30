//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.model.declarations.classes

import o.katydid.kotlgen.model.declarations.declarationsOfType
import o.katydid.kotlgen.model.declarations.properties.KgEnumEntry
import o.katydid.kotlgen.model.makeSourceRoot
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

class KgEnumClassTests {

    @Test
    fun `An enum class constructs as expected`() {

        val src = makeSourceRoot(File("."))

        val p = src.`package`("sample")

        val f = p.`source file`("sample.kt")

        val e = f.`enum class`("MyEnum") {

            documentation = "A very fine example."

            `enum entry`("A") {
                documentation = "It be a constant"
            }

            `enum entry`("B") {
                documentation = "It not be the final documentation"
            }

        }

        e {

            `enum entry`("B") {
                documentation = "It be another constant"
            }

        }

        assertEquals("MyEnum", e.name)
        assertEquals("A very fine example.", e.documentation)

        assertEquals(2, e.declarationsOfType<KgEnumEntry>().size)
        assertEquals("A", e.declarationsOfType<KgEnumEntry>()[0].name)
        assertEquals("B", e.declarationsOfType<KgEnumEntry>()[1].name)
        assertEquals("It be a constant", e.declarationsOfType<KgEnumEntry>()[0].documentation)
        assertEquals("It be another constant", e.declarationsOfType<KgEnumEntry>()[1].documentation)

    }

}

//---------------------------------------------------------------------------------------------------------------------

