//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.stylesheets

import o.katydid.css.colors.blue
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.color
import o.katydid.css.styles.builders.height
import o.katydid.css.styles.builders.width
import o.katydid.css.stylesheets.KatydidStyleSheet
import o.katydid.css.stylesheets.makeStyleSheet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Suppress("RemoveRedundantBackticks")
class CharSetTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyleSheet.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyleSheet(build).toString())
    }

    @Test
    fun `A charset rule appears in the CSS`() {

        val css = """
            |@charset "utf-8";
            |
            |div {
            |    height: 23px;
            |    width: 30px;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            charset("utf-8")

            "div" {
                height(23.px)
                width(30.px)
            }

        }

    }

    @Test
    fun `A charset rule must be the first rule in a style sheet`() {

        assertFailsWith<IllegalArgumentException> {

            makeStyleSheet {

                "div" {
                    height(23.px)
                    width(30.px)
                }

                charset("utf-8")

            }

        }

    }

    @Test
    fun `A charset rule appears in the including style sheet when included first`() {

        val css = """
            |@charset "utf-8";
            |
            |div {
            |    color: blue;
            |}
            |
            |div {
            |    width: 30px;
            |}
            |
        """.trimMargin() + "\n"

        val commonColors = makeStyleSheet {

            charset("utf-8")

            "div" {
                color(blue)
            }

        }

        checkStyle(css) {

            include(commonColors)

            "div" {
                width(30.px)
            }

        }

    }

    @Test
    fun `A charset rule does not appear in the including style sheet when included later`() {

        val css = """
            |div {
            |    width: 30px;
            |}
            |
            |div {
            |    color: blue;
            |}
            |
        """.trimMargin() + "\n"

        val commonColors = makeStyleSheet {

            charset("utf-8")

            "div" {
                color(blue)
            }

        }

        checkStyle(css) {

            "div" {
                width(30.px)
            }

            include(commonColors)

        }

    }


}
