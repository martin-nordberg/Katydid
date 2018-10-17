//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.boxSizing
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EBoxSizing.borderBox
import o.katydid.css.types.EBoxSizing.contentBox
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class BoxStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Box sizing style properties convert to correct CSS`() {

        checkStyle("box-sizing: content-box;") { boxSizing(contentBox) }
        checkStyle("box-sizing: border-box;") { boxSizing(borderBox) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

