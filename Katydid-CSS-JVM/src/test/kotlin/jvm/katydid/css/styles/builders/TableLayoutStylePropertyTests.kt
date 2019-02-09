//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.px
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EBorderCollapse.collapse
import o.katydid.css.types.EBorderCollapse.separate
import o.katydid.css.types.ECaptionSide
import o.katydid.css.types.EEmptyCells
import o.katydid.css.types.ETableLayout
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class TableLayoutStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Border collapse properties convert to correct CSS`() {

        checkStyle("border-collapse: separate;") { borderCollapse(separate) }
        checkStyle("border-collapse: collapse;") { borderCollapse(collapse) }

    }

    @Test
    fun `Border spacing properties convert to correct CSS`() {

        checkStyle("border-spacing: 2px;") { borderSpacing(2.px) }
        checkStyle("border-spacing: 2px;") { borderSpacing(2.px, 2.px) }
        checkStyle("border-spacing: 2px 1px;") { borderSpacing(2.px, 1.px) }

    }

    @Test
    fun `Caption side style properties convert to correct CSS`() {

        checkStyle("caption-side: top;") { captionSide(ECaptionSide.top) }
        checkStyle("caption-side: bottom;") { captionSide(ECaptionSide.bottom) }

    }

    @Test
    fun `Empty cells style properties convert to correct CSS`() {

        checkStyle("empty-cells: show;") { emptyCells(EEmptyCells.show) }
        checkStyle("empty-cells: hide;") { emptyCells(EEmptyCells.hide) }

    }

    @Test
    fun `Table layout properties convert to correct CSS`() {

        checkStyle("table-layout: auto;") { tableLayout(ETableLayout.auto) }
        checkStyle("table-layout: fixed;") { tableLayout(ETableLayout.fixed) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

