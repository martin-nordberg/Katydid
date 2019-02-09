//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.aliceblue
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.color
import o.katydid.css.styles.builders.opacity
import o.katydid.css.styles.makeStyle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class ColorStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Color style properties convert to correct CSS`() {

        checkStyle("color: aliceblue;") { color(aliceblue) }

    }

    @Test
    fun `Opacity style properties convert to correct CSS`() {

        checkStyle("opacity: 0;") { opacity(-1f) }
        checkStyle("opacity: 0;") { opacity(0f) }
        checkStyle("opacity: 0.642;") { opacity(0.6421f) }
        checkStyle("opacity: 1;") { opacity(1f) }
        checkStyle("opacity: 1;") { opacity(3f) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

