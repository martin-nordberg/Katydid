//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.em
import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.height
import o.katydid.css.styles.builders.letterSpacing
import o.katydid.css.styles.builders.line
import o.katydid.css.styles.builders.lineHeight
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.ENormal
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class LineStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Letter spacing style properties convert to correct CSS`() {

        checkStyle("letter-spacing: 0.05em;") { letterSpacing(0.05.em) }
        checkStyle("letter-spacing: normal;") { letterSpacing(ENormal.normal) }

    }

    @Test
    fun `Nested line height style properties convert to correct CSS`() {

        checkStyle("line-height: normal;") { line { height(ENormal.normal) } }
        checkStyle("line-height: 1.2em;") { line { height(1.2.em) } }
        checkStyle("line-height: 120%;") { line { height(120.percent) } }
        checkStyle("line-height: 1.2;") { line { height(1.2f) } }

        checkStyle("height: 30px; line-height: normal;") { height(30.px); line { height(ENormal.normal) } }

    }

    @Test
    fun `Line height style properties convert to correct CSS`() {

        checkStyle("line-height: normal;") { lineHeight(ENormal.normal) }
        checkStyle("line-height: 1.2em;") { lineHeight(1.2.em) }
        checkStyle("line-height: 120%;") { lineHeight(120.percent) }
        checkStyle("line-height: 1.2;") { lineHeight(1.2f) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

