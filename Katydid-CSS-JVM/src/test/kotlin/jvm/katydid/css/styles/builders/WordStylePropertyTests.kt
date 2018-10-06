//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.word
import o.katydid.css.styles.builders.wordSpacing
import o.katydid.css.styles.builders.wordWrap
import o.katydid.css.styles.style
import o.katydid.css.types.ENormal
import o.katydid.css.types.EOverflowWrap
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class WordStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Nested word properties convert to correct CSS`() {

        checkStyle("word-spacing: 4px;") { word { spacing(4.px) } }
        checkStyle("word-spacing: 4%;") { word { spacing(4.percent) } }
        checkStyle("word-spacing: normal;") { word { spacing(ENormal.normal) } }

        checkStyle("word-wrap: normal;") { word { wrap(EOverflowWrap.normal) } }

    }

    @Test
    fun `Word spacing properties convert to correct CSS`() {

        checkStyle("word-spacing: 4px;") { wordSpacing(4.px) }
        checkStyle("word-spacing: 4%;") { wordSpacing(4.percent) }
        checkStyle("word-spacing: normal;") { wordSpacing(ENormal.normal) }

    }

    @Test
    fun `Word wrap properties convert to correct CSS`() {

        checkStyle("word-wrap: break-word;") { wordWrap(EOverflowWrap.breakWord) }
        checkStyle("word-wrap: normal;") { wordWrap(EOverflowWrap.normal) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

