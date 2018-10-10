//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.style
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class PaddingStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Nested padding style properties convert to correct CSS`() {

        checkStyle("padding-bottom: 2px;") { padding { bottom(2.px) } }
        checkStyle("padding-bottom: 2%;") { padding { bottom(2.percent) } }

        checkStyle("padding-left: 2px;") { padding { left(2.px) } }
        checkStyle("padding-left: 2%;") { padding { left(2.percent) } }

        checkStyle("padding-right: 2px;") { padding { right(2.px) } }
        checkStyle("padding-right: 2%;") { padding { right(2.percent) } }

        checkStyle("padding-top: 2px;") { padding { top(2.px) } }
        checkStyle("padding-top: 2%;") { padding { top(2.percent) } }

        checkStyle("padding-top: 2px; padding-right: 3%;") { padding { top(2.px); right(3.percent) } }

    }

    @Test
    fun `Padding style properties convert to correct CSS`() {

        checkStyle("padding: -2px;") { padding((-2).px) }
        checkStyle("padding: -2px;") { padding((-2).px, (-2).px) }
        checkStyle("padding: -2px;") { padding((-2).px, (-2).px, (-2).px) }
        checkStyle("padding: -2px -3px;") { padding((-2).px, (-3).px, (-2).px, (-3).px) }
        checkStyle("padding: 1px 2px 3px;") { padding(1.px, 2.px, 3.px) }
        checkStyle("padding: 1px 2px 3px 4px;") { padding(1.px, 2.px, 3.px, 4.px) }
        checkStyle("padding: 2%;") { padding(2.percent) }
        checkStyle("padding: 2%;") { padding(2.percent, 2.percent) }
        checkStyle("padding: 2%;") { padding(2.percent, 2.percent, 2.percent) }
        checkStyle("padding: 2% 3%;") { padding(2.percent, 3.percent, 2.percent, 3.percent) }
        checkStyle("padding: 1% 2% 3%;") { padding(1.percent, 2.percent, 3.percent) }
        checkStyle("padding: 1% 2% 3% 4%;") { padding(1.percent, 2.percent, 3.percent, 4.percent) }

        checkStyle("padding-bottom: 2px;") { paddingBottom(2.px) }
        checkStyle("padding-bottom: 2%;") { paddingBottom(2.percent) }

        checkStyle("padding-left: 2px;") { paddingLeft(2.px) }
        checkStyle("padding-left: 2%;") { paddingLeft(2.percent) }

        checkStyle("padding-right: 2px;") { paddingRight(2.px) }
        checkStyle("padding-right: 2%;") { paddingRight(2.percent) }

        checkStyle("padding-top: 2px;") { paddingTop(2.px) }
        checkStyle("padding-top: 2%;") { paddingTop(2.percent) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

