//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.animation
import o.katydid.css.styles.builders.animationName
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.ENone
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class AnimationStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Animation name style properties convert to correct CSS`() {

        checkStyle("animation-name: cool;") { animationName("cool") }
        checkStyle("animation-name: none;") { animationName(ENone.none) }

        checkStyle("animation-name: cool;") { animation { name("cool") } }
        checkStyle("animation-name: none;") { animation { name(ENone.none) } }

    }

}

//---------------------------------------------------------------------------------------------------------------------

