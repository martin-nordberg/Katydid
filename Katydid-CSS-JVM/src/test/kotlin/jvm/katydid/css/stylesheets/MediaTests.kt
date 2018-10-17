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

@Suppress("RemoveRedundantBackticks")
class MediaTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyleSheet.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyleSheet(build).toString())
    }

    @Test
    fun `A media rule appears in the CSS`() {

        val css = """
            |@media screen {
            |
            |    div {
            |        height: 23px;
            |        width: 30px;
            |    }
            |
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            media("screen") {

                "div" {
                    height(23.px)
                    width(30.px)
                }

            }

        }

    }

    @Test
    fun `One style sheet can include another with media rules`() {

        val css = """
            |@media screen {
            |
            |    div {
            |        color: blue;
            |    }
            |
            |}
            |
            |div {
            |    width: 30px;
            |}
            |
        """.trimMargin() + "\n"

        val styleSheet1 = makeStyleSheet {

            media("screen") {

                "div" {
                    color(blue)
                }

            }

        }

        checkStyle(css) {

            include(styleSheet1)

            "div" {
                width(30.px)
            }

        }

    }

}
