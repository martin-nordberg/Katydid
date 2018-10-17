//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.stylesheets

import o.katydid.css.colors.blue
import o.katydid.css.colors.gray
import o.katydid.css.colors.green
import o.katydid.css.colors.purple
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.*
import o.katydid.css.stylesheets.KatydidStyleSheet
import o.katydid.css.stylesheets.makeStyleSheet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Suppress("RemoveRedundantBackticks")
class StyleSheetExtendTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyleSheet.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyleSheet(build).toString())
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

            placeholder(commonColors) {
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
    fun `An placeholder style block can be extended multiple times`() {

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

        checkStyle(css) {

            val commonColors = placeholder("%common-colors") {
                backgroundColor(gray)
                color(blue)
            }

            "span" {
                extend(commonColors)
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

            placeholder("%common-colors") {
                backgroundColor(gray)
                color(blue)
            }

            "span" {
                extend("%common-colors")
            }

            "div" {

                extend("%common-colors")

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

            makeStyleSheet {

                val x = "%x"

                placeholder(x) {
                    color(blue)
                }

                placeholder(x) {
                    color(green)
                }

            }

        }

    }

    @Test
    fun `Extend must occur at the start of a style block`() {

        // before any property
        assertFailsWith<IllegalArgumentException> {

            makeStyleSheet {

                placeholder("%x") {
                    color(blue)
                }

                "div" {
                    width(100.px)
                    extend("%x")
                }

            }

        }

        // before any nested block
        assertFailsWith<IllegalArgumentException> {

            makeStyleSheet {

                placeholder("%x") {
                    color(blue)
                }

                "div" {
                    "span" {
                        width(100.px)
                    }
                    extend("%x")
                }

            }

        }

    }

    @Test
    fun `Extending an unknown placeholder fails`() {

        // wrong name
        assertFailsWith<IllegalArgumentException> {

            makeStyleSheet {

                val x = "%x"

                placeholder(x) {
                    color(blue)
                }

                "div" {
                    extend("%y")
                }

            }

        }

        // right name, wrong nesting
        assertFailsWith<IllegalArgumentException> {

            makeStyleSheet {

                val x = "%x"

                placeholder(x) {
                    color(blue)
                }

                "div" {

                    "span" {
                        extend(x)
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

                placeholder(commonColors) {
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

            makeStyleSheet {

                val commonColors = "%common-colors"

                placeholder(commonColors) {
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
    fun `Extending a placeholder with nested a block extends the nesting`() {

        val css = """
            |.wider,
            |.deeper {
            |    background-color: gray;
            |    color: blue;
            |}
            |
            |.wider div,
            |.deeper div {
            |    height: 23px;
            |    width: 30px;
            |}
            |
            |.wider,
            |.deeper {
            |    width: 45px;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            val commonColors = "%common-colors"

            placeholder(commonColors) {
                backgroundColor(gray)
                color(blue)

                "div" {
                    height(23.px)
                    width(30.px)
                }
            }

            ".wider, .deeper" {
                extend(commonColors)
                width(45.px)
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

        val sheet1 = makeStyleSheet {

            placeholder(commonColors) {
                backgroundColor(gray)
                color(blue)
            }

            ".stuff" {
                extend(commonColors)
            }

        }

        assertEquals(css1, sheet1.toString())

        checkStyle(css2) {

            include(sheet1)

            "div" {

                extend(commonColors)

                height(23.px)
                width(30.px)

            }

        }

        assertEquals(css1, sheet1.toString())

    }

    @Test
    fun `A placeholder can extend another placeholder`() {

        val css = """
            |div,
            |span {
            |    color: purple;
            |}
            |
            |div,
            |span {
            |    width: 100px;
            |}
            |
            |span {
            |    padding: 2px;
            |}
            |
            |div {
            |    height: 50px;
            |}
            |
            |span {
            |    height: 30px;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            placeholder("%a") {
                color(purple)
            }

            placeholder("%b") {
                extend("%a")
                width(100.px)
            }

            placeholder("%c") {
                extend("%b")
                padding(2.px)
            }

            "div" {
                extend("%b")
                height(50.px)
            }

            "span" {
                extend("%c")
                height(30.px)
            }

        }

    }

    @Test
    fun `Unused placeholders result in no output`() {

        val css = ""

        checkStyle(css) {

            placeholder("%a") {
                color(purple)
            }

            placeholder("%b") {
                extend("%a")
                width(100.px)
            }

        }

    }

    @Test
    fun `Two placeholders cna be extended by one rule`() {

        val css = """
            |div {
            |    color: purple;
            |}
            |
            |div {
            |    width: 100px;
            |}
            |
            |div {
            |    height: 50px;
            |}
            |
        """.trimMargin() + "\n"

        checkStyle(css) {

            placeholder("%a") {
                color(purple)
            }

            placeholder("%b") {
                width(100.px)
            }

            "div" {
                extend("%a", "%b")
                height(50.px)
            }

        }

        checkStyle(css) {

            placeholder("%a") {
                color(purple)
            }

            placeholder("%b") {
                width(100.px)
            }

            "div" {
                extend("%a")
                extend("%b")
                height(50.px)
            }

        }

    }

}
