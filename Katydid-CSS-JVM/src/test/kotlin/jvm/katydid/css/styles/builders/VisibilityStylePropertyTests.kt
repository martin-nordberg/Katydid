//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.visibility
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EVisibility
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class VisibilityStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Visibility properties convert to correct CSS`() {

        checkStyle("visibility: collapse;") { visibility(EVisibility.collapse) }
        checkStyle("visibility: hidden;") { visibility(EVisibility.hidden) }
        checkStyle("visibility: visible;") { visibility(EVisibility.visible) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

