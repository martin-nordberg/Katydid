//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.stylesheets

import o.katydid.css.colors.blue
import o.katydid.css.colors.gray
import o.katydid.css.colors.green
import o.katydid.css.measurements.px
import o.katydid.css.stylesheets.StyleSheet
import o.katydid.css.stylesheets.styleSheet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Suppress("RemoveRedundantBackticks")
class StyleSheetExtendTests {

    private fun checkStyle(
        expectedCss: String,
        build: StyleSheet.() -> Unit
    ) {
        assertEquals(expectedCss, styleSheet(build).toString())
    }

    @Test
    fun `Style blocks can extend other style blocks`() {

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

        checkStyle(css) {

            val commonColors = "%common-colors"

            commonColors {
                backgroundColor(gray)
                color(blue)
            }

            "div" {

                extend(commonColors)

                height(23.px)
                width(30.px)

                "&.wider" {
                    width(45.px)
                }

            }

            "span" {
                extend(commonColors)
            }

        }

    }

    @Test
    fun `An extended placeholder style block can also have a selector`() {

        val css = """
            |span,
            |div {
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

        val commonColors = "%common-colors"

        checkStyle(css) {

            "span" or commonColors {
                backgroundColor(gray)
                color(blue)
            }

            "div" {

                extend(commonColors)

                height(23.px)
                width(30.px)

                "&.wider" {
                    width(45.px)
                }

            }

        }

        checkStyle(css) {

            commonColors or "span" {
                backgroundColor(gray)
                color(blue)
            }

            "div" {

                extend(commonColors)

                height(23.px)
                width(30.px)

                "&.wider" {
                    width(45.px)
                }

            }

        }

        checkStyle(css) {

            "span, $commonColors" {
                backgroundColor(gray)
                color(blue)
            }

            "div" {

                extend(commonColors)

                height(23.px)
                width(30.px)

                "&.wider" {
                    width(45.px)
                }

            }

        }

        checkStyle(css) {

            "$commonColors, span" {
                backgroundColor(gray)
                color(blue)
            }

            "div" {

                extend(commonColors)

                height(23.px)
                width(30.px)

                "&.wider" {
                    width(45.px)
                }

            }

        }

    }

    @Test
    fun `Duplicate placeholder names are not allowed`() {

        // second instance
        assertFailsWith<IllegalArgumentException> {

            styleSheet {

                "%x" {
                    color(blue)
                }

                "%x" {
                    color(green)
                }

            }

        }

        // named twice
        assertFailsWith<IllegalArgumentException> {

            styleSheet {

                "%x" or "%x" {
                    color(green)
                }

            }

        }

    }

    @Test
    fun `Extending an unknown style block fails`() {

        // wrong name
        assertFailsWith<IllegalArgumentException> {

            styleSheet {

                "%x" {
                    color(blue)
                }

                "div" {
                    extend("%y")
                }

            }

        }

        // right name, wrong nesting
        assertFailsWith<IllegalArgumentException> {

            styleSheet {

                "%x" {
                    color(blue)
                }

                "div" {

                    "span" {
                        extend("%x")
                    }

                }

            }

        }

    }

    @Test
    fun `Nested style blocks can extend other nested style blocks`() {

        val css = """
            |div {
            |    height: 23px;
            |    width: 30px;
            |}
            |
            |div.wider,
            |div.deeper {
            |    background-color: gray;
            |    color: blue;
            |}
            |
            |div.wider,
            |div.deeper {
            |    width: 45px;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            "div" {

                height(23.px)
                width(30.px)

                val commonColors = "%common-colors"

                commonColors {
                    backgroundColor(gray)
                    color(blue)
                }

                "&.wider, &.deeper" {
                    extend(commonColors)
                    width(45.px)
                }

            }

        }

    }

    @Test
    fun `Nested style blocks cannot extend unnested style blocks`() {

        assertFailsWith<IllegalArgumentException> {

            styleSheet {

                val commonColors = "%common-colors"

                commonColors {
                    backgroundColor(gray)
                    color(blue)
                }

                "div" {

                    height(23.px)
                    width(30.px)

                    "&.wider, &.deeper" {
                        extend(commonColors)
                        width(45.px)
                    }

                }

            }

        }

    }

    @Test
    fun `Non-placeholder style blocks cannot be extended`() {

        assertFailsWith<IllegalArgumentException> {

            styleSheet {

                "span" {
                    color(blue)
                }

                "div" {
                    extend("span")
                }

            }

        }

    }

    @Test
    fun `An included style sheet can be extended without mauling the included one`() {

        val css1 = """
            |.stuff {
            |    background-color: gray;
            |    color: blue;
            |}
            |
        """.trimMargin() + "\n"

        val css2 = """
            |.stuff,
            |div {
            |    background-color: gray;
            |    color: blue;
            |}
            |
            |div {
            |    height: 23px;
            |    width: 30px;
            |}
            |
        """.trimMargin() + "\n"

        val commonColors = "%common-colors"

        val sheet1 = styleSheet {

            commonColors or ".stuff" {
                backgroundColor(gray)
                color(blue)
            }

        }

        assertEquals(css1,sheet1.toString())

        checkStyle(css2) {

            include(sheet1)

            "div" {

                height(23.px)
                width(30.px)

                extend(commonColors)

            }

        }

        assertEquals(css1,sheet1.toString())

    }

}
