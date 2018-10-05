//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.stylesheets

import o.katydid.css.colors.*
import o.katydid.css.measurements.pt
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.height
import o.katydid.css.styles.builders.maxWidth
import o.katydid.css.styles.builders.width
import o.katydid.css.styles.style
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
        """.trimMargin() + "\n"

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
        """.trimMargin() + "\n"

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
    fun `Nested styles can reference the parent selector after the nested selector`() {

        val css = """
            |a {
            |    color: honeydew;
            |}
            |
            |a:hover {
            |    color: aquamarine;
            |}
            |
            |td a {
            |    color: chartreuse;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            "a" {

                color(honeydew)

                "&:hover" {
                    color(aquamarine)
                }

                "td &" {
                    color(chartreuse)
                }

            }

        }

    }

    @Test
    fun `Comma-separated seelctors are handled`() {

        val css = """
            |td,
            |th,
            |div {
            |    font-size: 10pt;
            |    font-style: italic;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            " td,th,  div " {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)
            }

        }

    }

    @Test
    fun `Selectors can be combined with the or operator`() {

        val css = """
            |td,
            |th,
            |div {
            |    font-size: 10pt;
            |    font-style: italic;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            "td" or "th" or "div" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)
            }

        }

    }

    @Test
    fun `Nesting works with the or operator inside the nesting`() {

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
        """.trimMargin() + "\n"

        checkStyle(css) {

            "td" {

                fontSize(10.pt)
                fontStyle(EFontStyle.italic)

                "div" or "span" {
                    color(green)
                }

            }

        }

    }

    @Test
    fun `Nesting works with the or operator outside the nesting`() {

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
        """.trimMargin() + "\n"

        checkStyle(css) {

            "td" or "th" {

                fontSize(10.pt)
                fontStyle(EFontStyle.italic)

                "div" {
                    color(green)
                }

            }

        }

    }

    @Test
    fun `Nesting works with the or operator at both levels`() {

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
        """.trimMargin() + "\n"

        checkStyle(css) {

            "nav" or "td" or "th" {

                fontSize(10.pt)
                fontStyle(EFontStyle.italic)

                "div" or "span" {
                    color(green)
                }

            }

        }

    }

    @Test
    fun `Three layers of nesting works with the or operator`() {

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
        """.trimMargin() + "\n"

        checkStyle(css) {

            "nav" or "td" or "th" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)

                "&.quirky" {

                    maxWidth(45.px)

                    "div" or "span" {
                        color(green)
                    }

                }

            }

        }

    }

    @Test
    fun `Three layers of nesting works when the top level has no styles`() {

        val css = """
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
        """.trimMargin() + "\n"

        checkStyle(css) {

            "nav" or "td" or "th" {

                "&.quirky" {

                    maxWidth(45.px)

                    "div" or "span" {
                        color(green)
                    }

                }

            }

        }

    }

    @Test
    fun `Three layers of nesting works when the middle level has no styles`() {

        val css = """
            |nav,
            |td,
            |th {
            |    font-size: 10pt;
            |    font-style: italic;
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
        """.trimMargin() + "\n"

        checkStyle(css) {

            "nav" or "td" or "th" {
                fontSize(10.pt)
                fontStyle(EFontStyle.italic)

                "&.quirky" {

                    "div" or "span" {
                        color(green)
                    }

                }

            }

        }

    }

    @Test
    fun `Style blocks can include other styles`() {

        val css = """
            |div {
            |    height: 23px;
            |    background-color: gray;
            |    color: blue;
            |    width: 30px;
            |}
            |
            |div.wider {
            |    width: 45px;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            val commonColors = style {
                backgroundColor(gray)
                color(blue)
            }

            "div" {

                height(23.px)

                include(commonColors)

                width(30.px)

                "&.wider" {
                    width(45.px)
                }

            }

        }

    }

    @Test
    fun `One style sheet can include another`() {

        val css = """
            |div,
            |span {
            |    background-color: gray;
            |    color: blue;
            |}
            |
            |div {
            |    height: 23px;
            |    width: 30px;
            |}
            |
            |div.wider {
            |    width: 45px;
            |}
            |
        """.trimMargin() + "\n"

        val commonColors = styleSheet {

            "div" or "span" {
                backgroundColor(gray)
                color(blue)
            }

        }

        checkStyle(css) {

            include(commonColors)

            "div" {

                height(23.px)
                width(30.px)

                "&.wider" {
                    width(45.px)
                }

            }

        }

    }

}
