//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles

import o.katydid.css.colors.blue
import o.katydid.css.colors.rgb
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.height
import o.katydid.css.styles.builders.width
import o.katydid.css.styles.style
import o.katydid.css.types.EDisplay
import o.katydid.css.types.EDisplay.block
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class StyleTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Styles with multiple properties construct and convert to strings`() {

        checkStyle("height: 23px; width: 45px;") {
            height(23.px)
            width(45.px)
        }

        checkStyle("width: 45px; height: 23px; color: blue;") {
            width(45.px)
            height(23.px)
            color(blue)
        }

        checkStyle("display: block; color: #172D43;") {
            display(block)
            color(rgb(23, 45, 67))
        }

    }

    @Test
    fun `Style properties can be made important`() {

        checkStyle("display: none !important; color: #172D43; height: 45px !important;") {
            display(EDisplay.none); important
            color(rgb(23, 45, 67))
            height(45.px); important
        }

    }

    @Test
    fun `Style properties can be set to inherit`() {

        checkStyle("display: inherit;") {
            inherit("display")
        }

    }

}
