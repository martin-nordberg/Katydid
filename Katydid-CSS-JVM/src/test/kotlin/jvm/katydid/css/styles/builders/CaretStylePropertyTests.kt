//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.slateblue
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.caretColor
import o.katydid.css.styles.style
import o.katydid.css.types.EAuto.auto
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class CaretStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Caret color style properties convert to correct CSS`() {

        checkStyle("caret-color: slateblue;") { caretColor(slateblue) }
        checkStyle("caret-color: auto;") { caretColor(auto) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

