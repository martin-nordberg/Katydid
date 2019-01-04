//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.codegen

import org.junit.jupiter.api.Test

//---------------------------------------------------------------------------------------------------------------------

class KotlinTypeAliasRoundTripTests
    : KotlinRoundTripTests() {

    @Test
    fun `A simple type parses and regenerates`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |public typealias x = SomeType
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

    @Test
    fun `A nullable type parses and regenerates`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |internal typealias x = SomeType?
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

    fun `A nested type parses and regenerates`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |internal typealias x = SomeType.Nested.Inner
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

    // TODO: @Test
    fun `A parenthesized type parses and regenerates`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |internal typealias x = (SomeType)
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

    // TODO: @Test
    fun `A more complicated parenthesized type parses and regenerates`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |internal typealias x = (SomeType.Nested.Inner?)
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

}

//---------------------------------------------------------------------------------------------------------------------

