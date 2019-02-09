//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EAuto.auto
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class MarginStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Nested margin style properties convert to correct CSS`() {

        checkStyle("margin-bottom: 2px;") { margin { bottom(2.px) } }
        checkStyle("margin-bottom: 2%;") { margin { bottom(2.percent) } }
        checkStyle("margin-bottom: auto;") { margin { bottom(auto) } }

        checkStyle("margin-left: 2px;") { margin { left(2.px) } }
        checkStyle("margin-left: 2%;") { margin { left(2.percent) } }
        checkStyle("margin-left: auto;") { margin { left(auto) } }

        checkStyle("margin-right: 2px;") { margin { right(2.px) } }
        checkStyle("margin-right: 2%;") { margin { right(2.percent) } }
        checkStyle("margin-right: auto;") { margin { right(auto) } }

        checkStyle("margin-top: 2px;") { margin { top(2.px) } }
        checkStyle("margin-top: 2%;") { margin { top(2.percent) } }
        checkStyle("margin-top: auto;") { margin { top(auto) } }

        checkStyle("margin-top: 2px; margin-right: 3%;") { margin { top(2.px); right(3.percent) } }

    }

    @Test
    fun `Margin style properties convert to correct CSS`() {

        checkStyle("margin: -2px;") { margin((-2).px) }
        checkStyle("margin: -2px;") { margin((-2).px, (-2).px) }
        checkStyle("margin: -2px;") { margin((-2).px, (-2).px, (-2).px) }
        checkStyle("margin: -2px -3px;") { margin((-2).px, (-3).px, (-2).px, (-3).px) }
        checkStyle("margin: 1px 2px 3px;") { margin(1.px, 2.px, 3.px) }
        checkStyle("margin: 1px 2px 3px 4px;") { margin(1.px, 2.px, 3.px, 4.px) }
        checkStyle("margin: 2%;") { margin(2.percent) }
        checkStyle("margin: 2%;") { margin(2.percent, 2.percent) }
        checkStyle("margin: 2%;") { margin(2.percent, 2.percent, 2.percent) }
        checkStyle("margin: 2% 3%;") { margin(2.percent, 3.percent, 2.percent, 3.percent) }
        checkStyle("margin: 1% 2% 3%;") { margin(1.percent, 2.percent, 3.percent) }
        checkStyle("margin: 1% 2% 3% 4%;") { margin(1.percent, 2.percent, 3.percent, 4.percent) }
        checkStyle("margin: auto;") { margin(auto) }

        checkStyle("margin-bottom: 2px;") { marginBottom(2.px) }
        checkStyle("margin-bottom: 2%;") { marginBottom(2.percent) }
        checkStyle("margin-bottom: auto;") { marginBottom(auto) }

        checkStyle("margin-left: 2px;") { marginLeft(2.px) }
        checkStyle("margin-left: 2%;") { marginLeft(2.percent) }
        checkStyle("margin-left: auto;") { marginLeft(auto) }

        checkStyle("margin-right: 2px;") { marginRight(2.px) }
        checkStyle("margin-right: 2%;") { marginRight(2.percent) }
        checkStyle("margin-right: auto;") { marginRight(auto) }

        checkStyle("margin-top: 2px;") { marginTop(2.px) }
        checkStyle("margin-top: 2%;") { marginTop(2.percent) }
        checkStyle("margin-top: auto;") { marginTop(auto) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

