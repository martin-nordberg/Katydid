//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles

import o.katydid.css.colors.*
import o.katydid.css.measurements.*
import o.katydid.css.styles.Style
import o.katydid.css.styles.style
import o.katydid.css.types.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class StyleTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString() )
    }


    @Test
    fun `Each style property converts to the correct string`() {

        // TODO: background

        checkStyle("background-attachment: fixed;") { backgroundAttachment(fixed) }
        checkStyle("background-attachment: scroll;") { backgroundAttachment(scroll) }

        checkStyle("background-color: aquamarine;") { backgroundColor(aquamarine) }

        checkStyle("background-image: none;") { backgroundImageNone() }
        checkStyle("background-image: url(\"http://myimage.jpg\");") { backgroundImage("http://myimage.jpg") }

        checkStyle("background-position: center center;") { backgroundPosition(center) }
        checkStyle("background-position: left top;") { backgroundPosition(left, top) }
        checkStyle("background-position: right bottom;") { backgroundPosition(right, bottom) }
        checkStyle("background-position: 50% center;") { backgroundPosition(50.percent) }
        checkStyle("background-position: 50% 75%;") { backgroundPosition(50.percent, 75.percent) }
        checkStyle("background-position: 100px center;") { backgroundPosition(100.px) }
        checkStyle("background-position: 10px 20px;") { backgroundPosition(10.px, 20.px) }

        checkStyle("background-repeat: repeat;") { backgroundRepeat(repeat) }
        checkStyle("background-repeat: repeat-x;") { backgroundRepeat(repeatX) }
        checkStyle("background-repeat: repeat-y;") { backgroundRepeat(repeatY) }
        checkStyle("background-repeat: no-repeat;") { backgroundRepeat(noRepeat) }

        // TODO: border
        // TODO: border-bottom

        checkStyle("border-bottom-color: navajowhite;") { borderBottomColor(navajowhite) }


        checkStyle("color: aliceblue;") { color(aliceblue) }

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
        checkStyle("display: none;") { display(EDisplayOption.NONE) }

    }

    @Test
    fun `Styles with multiple properties construct and convert to strings`() {

        checkStyle("height: 23px; width: 45px;") {
            height(23.px)
            width(45.px)
        }

        checkStyle("width: 45px; height: 23px; color: blue;") {
            width(45.px)
            height(23.px)
            color(blue)
        }

        checkStyle("display: block; color: #172D43;") {
            display(block)
            color(rgb(23, 45, 67))
        }

    }

    @Test
    fun `Style properties can be made important`() {

        checkStyle("display: none !important; color: #172D43; height: 45px !important;") {
            display(EDisplayOption.NONE); important
            color(rgb(23, 45, 67))
            height(45.px); important
        }

    }

    @Test
    fun `Style properties can be set to inherit`() {

        checkStyle("display: inherit;") {
            inherit("display")
        }

    }

}
