//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.pageBreak
import o.katydid.css.styles.builders.pageBreakAfter
import o.katydid.css.styles.builders.pageBreakBefore
import o.katydid.css.styles.builders.pageBreakInside
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EPageBreak
import o.katydid.css.types.EPageBreakInside
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class PageBreakStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Nested page break style properties convert to correct CSS`() {

        checkStyle("page-break-after: always;") { pageBreak { after(EPageBreak.always) } }
        checkStyle("page-break-after: always; page-break-before: avoid;") { pageBreak { after(EPageBreak.always); before(EPageBreak.avoid) } }

        checkStyle("page-break-before: always;") { pageBreak { before(EPageBreak.always) } }

        checkStyle("page-break-inside: avoid;") { pageBreak { inside(EPageBreakInside.avoid) } }
    }

    @Test
    fun `Page break style properties convert to correct CSS`() {

        checkStyle("page-break-after: always;") { pageBreakAfter(EPageBreak.always) }
        checkStyle("page-break-after: auto;") { pageBreakAfter(EPageBreak.auto) }
        checkStyle("page-break-after: avoid;") { pageBreakAfter(EPageBreak.avoid) }
        checkStyle("page-break-after: left;") { pageBreakAfter(EPageBreak.left) }
        checkStyle("page-break-after: right;") { pageBreakAfter(EPageBreak.right) }

        checkStyle("page-break-before: always;") { pageBreakBefore(EPageBreak.always) }
        checkStyle("page-break-before: auto;") { pageBreakBefore(EPageBreak.auto) }
        checkStyle("page-break-before: avoid;") { pageBreakBefore(EPageBreak.avoid) }
        checkStyle("page-break-before: left;") { pageBreakBefore(EPageBreak.left) }
        checkStyle("page-break-before: right;") { pageBreakBefore(EPageBreak.right) }

        checkStyle("page-break-inside: auto;") { pageBreakInside(EPageBreakInside.auto) }
        checkStyle("page-break-inside: avoid;") { pageBreakInside(EPageBreakInside.avoid) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

