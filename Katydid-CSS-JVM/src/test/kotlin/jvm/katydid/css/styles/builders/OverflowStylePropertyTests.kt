//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.overflow
import o.katydid.css.styles.builders.overflowX
import o.katydid.css.styles.builders.overflowY
import o.katydid.css.styles.style
import o.katydid.css.types.EOverflow.*
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

    }

}

//---------------------------------------------------------------------------------------------------------------------

