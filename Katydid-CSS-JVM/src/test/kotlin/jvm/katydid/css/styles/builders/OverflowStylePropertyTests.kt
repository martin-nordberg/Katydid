//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.style
import o.katydid.css.types.EOverflow.*
import o.katydid.css.types.EOverflowWrap
import o.katydid.css.types.EResize
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class OverflowStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Nested overflow style properties convert to correct CSS`() {

        checkStyle("overflow-x: scroll; overflow-y: clip;") { overflow { x(scroll); y(clip) } }

        checkStyle("overflow-wrap: normal;") { overflow { wrap(EOverflowWrap.normal) } }

    }

    @Test
    fun `Overflow style properties convert to correct CSS`() {

        checkStyle("overflow: auto;") { overflow(auto) }
        checkStyle("overflow: hidden;") { overflow(hidden) }
        checkStyle("overflow: scroll;") { overflow(scroll) }
        checkStyle("overflow: clip;") { overflow(clip) }
        checkStyle("overflow: scroll hidden;") { overflow(scroll, hidden) }
        checkStyle("overflow: visible;") { overflow(visible) }

        checkStyle("overflow-x: scroll;") { overflowX(scroll) }

        checkStyle("overflow-y: scroll;") { overflowY(scroll) }

        checkStyle("overflow-wrap: break-word;") { overflowWrap(EOverflowWrap.breakWord) }
        checkStyle("overflow-wrap: normal;") { overflowWrap(EOverflowWrap.normal) }

    }

    @Test
    fun `Resize properties convert to correct CSS`() {

        checkStyle("resize: both;") { resize(EResize.both) }
        checkStyle("resize: horizontal;") { resize(EResize.horizontal) }
        checkStyle("resize: none;") { resize(EResize.none) }
        checkStyle("resize: vertical;") { resize(EResize.vertical) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

