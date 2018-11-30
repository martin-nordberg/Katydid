//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package jvm.katydid.kotlgen.parsing

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

//---------------------------------------------------------------------------------------------------------------------

@Suppress("unused")
class SnippetTests {

    @Test
    fun `A parser parses file annotations`() {

        val code = """
                    |
                    |@file:Suppress("unused")
                    |@file:Suppress("unused")
                    |
                   """.trimMargin()

        // TODO: parse & check

        assertNotNull(code)

    }

    @Test
    fun `A parser parses annotations`() {

        val code = """
                    |
                    |@Suppress("unused")
                    |class Gooey {}
                    |
                   """.trimMargin()

        // TODO: parse & check

        assertNotNull(code)

    }

}

//---------------------------------------------------------------------------------------------------------------------

