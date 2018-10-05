//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.ex
import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.style
import o.katydid.css.types.EAuto.auto
import o.katydid.css.types.EPosition
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class PositionStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Box corner position style properties convert to correct CSS`() {

        checkStyle("bottom: 4.5ex;") { bottom(4.5.ex) }
        checkStyle("bottom: 45%;") { bottom(45.percent) }
        checkStyle("bottom: auto;") { bottom(auto) }

        checkStyle("left: 14.1px;") { left(14.1.px) }
        checkStyle("left: 3%;") { left(3.percent) }
        checkStyle("left: auto;") { left(auto) }

        checkStyle("right: 14.1px;") { right(14.1.px) }
        checkStyle("right: 3%;") { right(3.percent) }
        checkStyle("right: auto;") { right(auto) }

        checkStyle("top: 4.5ex;") { top(4.5.ex) }
        checkStyle("top: 45%;") { top(45.percent) }
        checkStyle("top: auto;") { top(auto) }

    }

    @Test
    fun `Position style properties convert to correct CSS`() {

        checkStyle("position: absolute;") { position(EPosition.absolute) }
        checkStyle("position: fixed;") { position(EPosition.fixed) }
        checkStyle("position: relative;") { position(EPosition.relative) }
        checkStyle("position: static;") { position(EPosition.static) }
        checkStyle("position: sticky;") { position(EPosition.sticky) }

    }

}

//---------------------------------------------------------------------------------------------------------------------
