//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.display
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EDisplay
import o.katydid.css.types.EDisplay.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class DisplayStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Display style properties convert to correct CSS`() {

        checkStyle("display: inline;") { display(inline) }
        checkStyle("display: block;") { display(block) }
        checkStyle("display: list-item;") { display(listItem) }
        checkStyle("display: inline-block;") { display(inlineBlock) }
        checkStyle("display: table;") { display(table) }
        checkStyle("display: inline-table;") { display(inlineTable) }
        checkStyle("display: table-row-group;") { display(tableRowGroup) }
        checkStyle("display: table-header-group;") { display(tableHeaderGroup) }
        checkStyle("display: table-footer-group;") { display(tableFooterGroup) }
        checkStyle("display: table-row;") { display(tableRow) }
        checkStyle("display: table-column-group;") { display(tableColumnGroup) }
        checkStyle("display: table-column;") { display(tableColumn) }
        checkStyle("display: table-cell;") { display(tableCell) }
        checkStyle("display: table-caption;") { display(tableCaption) }
        checkStyle("display: none;") { display(EDisplay.none) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

