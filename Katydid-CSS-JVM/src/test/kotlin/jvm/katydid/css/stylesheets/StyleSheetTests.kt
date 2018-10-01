//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.stylesheets

import o.katydid.css.measurements.pt
import o.katydid.css.measurements.px
import o.katydid.css.stylesheets.StyleSheet
import o.katydid.css.stylesheets.styleSheet
import o.katydid.css.types.EFontStyle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class StyleSheetTests {

    private fun checkStyle(
        expectedCss: String,
        build: StyleSheet.() -> Unit
    ) {
        assertEquals(expectedCss, styleSheet(build).toString())
    }

    @Test
    fun `A simple style sheet can be constructed from selectors and styles`() {

        val css = """
            |div {
            |    height: 23px;
            |    width: 30px;
            |}
            |
            |div.wider {
            |    width: 45px;
            |}
            |
        """.trimMargin()+"\n"

        checkStyle(css) {
            "div" {
                height(23.px)
                width(30.px)
            }
            "div.wider" {
                width(45.px)
            }
        }

    }

    @Test
    fun `Selectors and be combined with the and operator`() {

        val css = """
            |td, th, div {
            |    font-size: 10pt;
            |    font-style: italic;
            |}
            |
        """.trimMargin()+"\n"

        checkStyle(css) {
            "td" and "th" and "div" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)
            }
        }

    }

}
