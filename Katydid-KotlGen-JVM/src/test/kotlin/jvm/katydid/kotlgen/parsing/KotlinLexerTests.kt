//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.parsing

import i.katydid.kotlgen.parsing.EKotlinTokenType
import i.katydid.kotlgen.parsing.KotlinLexer
import org.junit.jupiter.api.Test
import java.io.StringReader
import kotlin.test.assertEquals


//---------------------------------------------------------------------------------------------------------------------

class KotlinLexerTests {

    private fun checkLex(code: String, separator: String) {

        val lexer = KotlinLexer(StringReader(code))

        val output = StringBuilder()

        var delimiter = ""

        while (true) {
            val token = lexer.yylex() ?: break

            output.append(delimiter)
            delimiter = separator

            output.append(token.text)
        }

        assertEquals(code, output.toString())

    }

    @Test
    fun `A lexer scans hard keywords`() {

        val code = "as as? break class continue do else false for fun if in !in interface is !is null object " +
            "package return super this throw true try typealias val var when while"

        checkLex(code, " ")

    }

    @Test
    fun `A lexer scans soft keywords`() {

        val code = "by catch constructor delegate dynamic field file finally get import init param property " +
            "receiver set setparam where"

        checkLex(code, " ")

    }

    @Test
    fun `A lexer scans modifier keywords`() {

        val code = "actual abstract annotation companion const crossinline data enum expect external final " +
            "infix inline inner internal lateinit noinline open operator out override private protected " +
            "public reified sealed suspend tailrec varargs it"

        checkLex(code, " ")

    }

    @Test
    fun `A lexer scans operators and punctuation marks`() {

        val code = "&& -> @ : :: $ .. = == === > >= [ < <= - -= -- ! != !== !! || % %= + += ++ ? ?. ?: ] ; / /= * " +
            "*= _ , . { ( } )"

        checkLex(code, " ")

    }

    @Test
    fun `A lexer scans identifiers`() {

        val code = "x abc1 Qwer_ty alpha\$bet _underscored trailing_ `back-ticked` `spaced out`"

        checkLex(code, " ")

        var tokenCount = 0

        val lexer = KotlinLexer(StringReader(code))

        while (true) {
            val token = lexer.yylex() ?: break

            tokenCount += 1
            assertEquals(EKotlinTokenType.IDENTIFIER, token.type)
        }

        assertEquals(8, tokenCount)
    }

    @Test
    fun `A lexer scans integer literals`() {

        val code = "12323 1_000 45_678L 0xABCL 0XAB_CDE 0b01010101L 0B10110001 0"

        checkLex(code, " ")

        var tokenCount = 0

        val lexer = KotlinLexer(StringReader(code))

        while (true) {
            val token = lexer.yylex() ?: break

            tokenCount += 1
            assertEquals(EKotlinTokenType.INTEGER_LITERAL, token.type)
        }

        assertEquals(8, tokenCount)
    }

}

//---------------------------------------------------------------------------------------------------------------------

