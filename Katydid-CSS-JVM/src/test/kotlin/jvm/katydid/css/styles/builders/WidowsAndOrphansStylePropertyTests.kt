//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.orphans
import o.katydid.css.styles.builders.widows
import o.katydid.css.styles.makeStyle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class WidowsAndOrphansStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Widows properties convert to correct CSS`() {

        checkStyle("widows: 2;") { widows(2) }

        assertFailsWith<IllegalArgumentException> { checkStyle("throws") { widows(0) } }
        assertFailsWith<IllegalArgumentException> { checkStyle("throws") { widows(-1) } }

    }

    @Test
    fun `Orphans properties convert to correct CSS`() {

        checkStyle("orphans: 3;") { orphans(3) }

        assertFailsWith<IllegalArgumentException> { checkStyle("throws") { widows(0) } }
        assertFailsWith<IllegalArgumentException> { checkStyle("throws") { widows(-1) } }

    }

}

//---------------------------------------------------------------------------------------------------------------------

