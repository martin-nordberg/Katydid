//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.slateblue
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.caret
import o.katydid.css.styles.builders.caretColor
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EAuto.auto
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class CaretStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Caret color style properties convert to correct CSS`() {

        checkStyle("caret-color: slateblue;") { caretColor(slateblue) }
        checkStyle("caret-color: auto;") { caretColor(auto) }

    }

    @Test
    fun `Nested caret color style properties convert to correct CSS`() {

        checkStyle("caret-color: slateblue;") { caret { color(slateblue) } }
        checkStyle("caret-color: auto;") { caret { color(auto) } }

    }

}

//---------------------------------------------------------------------------------------------------------------------

