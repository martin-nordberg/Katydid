//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.stylesheets

import o.katydid.css.colors.green
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
    fun `A nested style sheet can be constructed from selectors and styles`() {

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
            |div.wider span {
            |    color: green;
            |}
            |
        """.trimMargin()+"\n"

        checkStyle(css) {
            "div" {
                height(23.px)
                width(30.px)

                "&.wider" {
                    width(45.px)

                    "span" {
                        color(green)
                    }
                }
            }
        }

    }

    @Test
    fun `Selectors can be combined with the and operator`() {

        val css = """
            |td,
            |th,
            |div {
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

    @Test
    fun `Nesting works with the and operator inside the nesting`() {

        val css = """
            |td {
            |    font-size: 10pt;
            |    font-style: italic;
            |}
            |
            |td div,
            |td span {
            |    color: green;
            |}
            |
        """.trimMargin()+"\n"

        checkStyle(css) {
            "td" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)
                "div" and "span" {
                    color(green)
                }
            }
        }

    }

    @Test
    fun `Nesting works with the and operator outside the nesting`() {

        val css = """
            |td,
            |th {
            |    font-size: 10pt;
            |    font-style: italic;
            |}
            |
            |td div,
            |th div {
            |    color: green;
            |}
            |
        """.trimMargin()+"\n"

        checkStyle(css) {
            "td" and "th" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)
                "div" {
                    color(green)
                }
            }
        }

    }

    @Test
    fun `Nesting works with the and operator at both levels`() {

        val css = """
            |nav,
            |td,
            |th {
            |    font-size: 10pt;
            |    font-style: italic;
            |}
            |
            |nav div,
            |nav span,
            |td div,
            |td span,
            |th div,
            |th span {
            |    color: green;
            |}
            |
        """.trimMargin()+"\n"

        checkStyle(css) {
            "nav" and "td" and "th" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)
                "div" and "span" {
                    color(green)
                }
            }
        }

    }

    @Test
    fun `Three layers of nesting works with the and operator`() {

        val css = """
            |nav,
            |td,
            |th {
            |    font-size: 10pt;
            |    font-style: italic;
            |}
            |
            |nav.quirky,
            |td.quirky,
            |th.quirky {
            |    max-width: 45px;
            |}
            |
            |nav.quirky div,
            |nav.quirky span,
            |td.quirky div,
            |td.quirky span,
            |th.quirky div,
            |th.quirky span {
            |    color: green;
            |}
            |
        """.trimMargin()+"\n"

        checkStyle(css) {
            "nav" and "td" and "th" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)
                "&.quirky" {
                    maxWidth(45.px)
                    "div" and "span" {
                        color(green)
                    }
                }
            }
        }

    }

}
