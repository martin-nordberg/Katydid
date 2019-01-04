//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.model.types

import i.katydid.kotlgen.model.types.KgTypeImpl
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

//---------------------------------------------------------------------------------------------------------------------

class KgTypeTests {

    @Test
    fun `A dynamic type outputs as expected`() {

        val type = KgTypeImpl()
        type.isDynamic = true

        assertEquals("dynamic", type.text)

    }

    @Test
    fun `A simple type outputs as expected`() {

        val type = KgTypeImpl()
        type.addTypeReference("SomeType")

        assertEquals("SomeType", type.text)

    }

    @Test
    fun `A nested type outputs as expected`() {

        val type = KgTypeImpl()
        type.addTypeReference("SomeType")
        type.addTypeReference("Nested")

        assertEquals("SomeType.Nested", type.text)

    }

    @Test
    fun `A parenthesized type outputs as expected`() {

        val type = KgTypeImpl()
        type.addTypeReference("SomeType")
        type.addTypeReference("Nested")
        type.isParenthesized = true

        assertEquals("(SomeType.Nested)", type.text)

    }

    @Test
    fun `A nullable type outputs as expected`() {

        val type = KgTypeImpl()
        type.addTypeReference("SomeType")
        type.isNullable = true

        assertEquals("SomeType?", type.text)

    }

    @Test
    fun `A type is inferred by default`() {

        val type = KgTypeImpl()

        assertTrue(type.isInferred)

    }



}

//---------------------------------------------------------------------------------------------------------------------

