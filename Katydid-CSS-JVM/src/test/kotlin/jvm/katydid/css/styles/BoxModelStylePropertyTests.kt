//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles

import o.katydid.css.measurements.box
import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.style
import o.katydid.css.types.EAuto.auto
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class BoxModelStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Margin style properties convert to correct CSS`() {

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

        checkStyle("margin: 1px;") { margin(box(1.px)) }
        checkStyle("margin: 1px 2px;") { margin(box(1.px, 2.px)) }
        checkStyle("margin: 1px 2px 3px;") { margin(box(1.px, 2.px, 3.px)) }
        checkStyle("margin: 1px 2px 3px 4px;") { margin(box(1.px, 2.px, 3.px, 4.px)) }

        checkStyle("margin: 1%;") { margin(box(1.percent)) }
        checkStyle("margin: 1% 2%;") { margin(box(1.percent, 2.percent)) }
        checkStyle("margin: 1% 2% 3%;") { margin(box(1.percent, 2.percent, 3.percent)) }
        checkStyle("margin: 1% 2% 3% 4%;") { margin(box(1.percent, 2.percent, 3.percent, 4.percent)) }

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

    @Test
    fun `Padding style properties convert to correct CSS`() {

        checkStyle("padding-bottom: 2px;") { padding { bottom(2.px) } }
        checkStyle("padding-bottom: 2%;") { padding { bottom(2.percent) } }

        checkStyle("padding-left: 2px;") { padding { left(2.px) } }
        checkStyle("padding-left: 2%;") { padding { left(2.percent) } }

        checkStyle("padding-right: 2px;") { padding { right(2.px) } }
        checkStyle("padding-right: 2%;") { padding { right(2.percent) } }

        checkStyle("padding-top: 2px;") { padding { top(2.px) } }
        checkStyle("padding-top: 2%;") { padding { top(2.percent) } }

        checkStyle("padding-top: 2px; padding-right: 3%;") { padding { top(2.px); right(3.percent) } }

        checkStyle("padding: 1px;") { padding(box(1.px)) }
        checkStyle("padding: 1px 2px;") { padding(box(1.px, 2.px)) }
        checkStyle("padding: 1px 2px 3px;") { padding(box(1.px, 2.px, 3.px)) }
        checkStyle("padding: 1px 2px 3px 4px;") { padding(box(1.px, 2.px, 3.px, 4.px)) }

        checkStyle("padding: 1%;") { padding(box(1.percent)) }
        checkStyle("padding: 1% 2%;") { padding(box(1.percent, 2.percent)) }
        checkStyle("padding: 1% 2% 3%;") { padding(box(1.percent, 2.percent, 3.percent)) }
        checkStyle("padding: 1% 2% 3% 4%;") { padding(box(1.percent, 2.percent, 3.percent, 4.percent)) }

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
