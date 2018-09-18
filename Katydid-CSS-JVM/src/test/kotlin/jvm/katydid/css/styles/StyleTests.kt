//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles

import o.katydid.css.colors.*
import o.katydid.css.measurements.ex
import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.style
import o.katydid.css.types.*
import o.katydid.css.types.EAutoOption.auto
import o.katydid.css.types.EBackgroundAttachmentOption.fixed
import o.katydid.css.types.EBackgroundAttachmentOption.scroll
import o.katydid.css.types.EBackgroundPositionOption.*
import o.katydid.css.types.EBackgroundRepeatOption.*
import o.katydid.css.types.EBorderCollapseOption.*
import o.katydid.css.types.EBorderStyleOption.*
import o.katydid.css.types.EBorderWidthOption.*
import o.katydid.css.types.EBoxSizingOption.*
import o.katydid.css.types.EDisplayOption.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class StyleTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }


    @Test
    fun `Each style property converts to the correct string`() {

        // TODO: background

        checkStyle("background-attachment: fixed;") { backgroundAttachment(fixed) }
        checkStyle("background-attachment: scroll;") { backgroundAttachment(scroll) }

        checkStyle("background-color: aquamarine;") { backgroundColor(aquamarine) }

        checkStyle("background-image: none;") { backgroundImage(ENoneOption.none) }
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

        checkStyle("border-bottom: thin dotted mediumslateblue;") { borderBottom(thin,dotted,mediumslateblue) }

        checkStyle("border-bottom-color: navajowhite;") { borderBottomColor(navajowhite) }

        checkStyle("border-bottom-style: none;") { borderBottomStyle(EBorderStyleOption.none) }
        checkStyle("border-bottom-style: hidden;") { borderBottomStyle(hidden) }
        checkStyle("border-bottom-style: dotted;") { borderBottomStyle(dotted) }
        checkStyle("border-bottom-style: dashed;") { borderBottomStyle(dashed) }
        checkStyle("border-bottom-style: solid;") { borderBottomStyle(solid) }
        checkStyle("border-bottom-style: double;") { borderBottomStyle(double) }
        checkStyle("border-bottom-style: groove;") { borderBottomStyle(groove) }
        checkStyle("border-bottom-style: ridge;") { borderBottomStyle(ridge) }
        checkStyle("border-bottom-style: inset;") { borderBottomStyle(inset) }
        checkStyle("border-bottom-style: outset;") { borderBottomStyle(outset) }

        checkStyle("border-bottom-width: thin;") { borderBottomWidth(thin) }
        checkStyle("border-bottom-width: medium;") { borderBottomWidth(medium) }
        checkStyle("border-bottom-width: thick;") { borderBottomWidth(thick) }
        checkStyle("border-bottom-width: 4px;") { borderBottomWidth(4.px) }

        checkStyle("border-collapse: separate;") { borderCollapse(separate) }
        checkStyle("border-collapse: collapse;") { borderCollapse(collapse) }

        checkStyle("border-color: purple;") { borderColor(purple) }
        checkStyle("border-color: purple orange;") { borderColor(purple,orange) }
        checkStyle("border-color: purple orange;") { borderColor(purple,orange,purple,orange) }
        checkStyle("border-color: purple orange olivedrab;") { borderColor(purple,orange, olivedrab) }
        checkStyle("border-color: purple orange olivedrab salmon;") { borderColor(purple,orange, olivedrab, salmon) }

        checkStyle("border-left: thin dotted mediumslateblue;") { borderLeft(thin,dotted,mediumslateblue) }

        checkStyle("border-left-color: navajowhite;") { borderLeftColor(navajowhite) }

        checkStyle("border-left-style: solid;") { borderLeftStyle(solid) }

        checkStyle("border-left-width: thick;") { borderLeftWidth(thick) }
        checkStyle("border-left-width: 4px;") { borderLeftWidth(4.px) }

        checkStyle("border-right: thin dotted mediumslateblue;") { borderRight(thin,dotted,mediumslateblue) }

        checkStyle("border-right-color: navajowhite;") { borderRightColor(navajowhite) }

        checkStyle("border-right-style: solid;") { borderRightStyle(solid) }

        checkStyle("border-right-width: thick;") { borderRightWidth(thick) }
        checkStyle("border-right-width: 4px;") { borderRightWidth(4.px) }

        checkStyle("border-spacing: 2px;") { borderSpacing(2.px) }
        checkStyle("border-spacing: 2px;") { borderSpacing(2.px,2.px) }
        checkStyle("border-spacing: 2px 1px;") { borderSpacing(2.px,1.px) }

        checkStyle("border-style: solid;") { borderStyle(solid) }
        checkStyle("border-style: solid dotted;") { borderStyle(solid, dotted) }
        checkStyle("border-style: solid dotted ridge;") { borderStyle(solid, dotted, ridge) }
        checkStyle("border-style: solid dotted ridge dashed;") { borderStyle(solid, dotted, ridge, dashed) }

        checkStyle("border-top: thin dotted mediumslateblue;") { borderTop(thin,dotted,mediumslateblue) }

        checkStyle("border-top-color: navajowhite;") { borderTopColor(navajowhite) }

        checkStyle("border-top-style: solid;") { borderTopStyle(solid) }

        checkStyle("border-top-width: thick;") { borderTopWidth(thick) }
        checkStyle("border-top-width: 4px;") { borderTopWidth(4.px) }

        checkStyle("bottom: 4.5ex;") { bottom(4.5.ex) }
        checkStyle("bottom: 45%;") { bottom(45.percent) }
        checkStyle("bottom: auto;") { bottom(auto) }

        checkStyle("box-sizing: content-box;") { boxSizing(contentBox) }
        checkStyle("box-sizing: border-box;") { boxSizing(borderBox) }

        checkStyle("caption-side: top;") { captionSide(ECaptionSideOption.top) }
        checkStyle("caption-side: bottom;") { captionSide(ECaptionSideOption.bottom) }

        checkStyle("caret-color: slateblue;") { caretColor(slateblue) }
        checkStyle("caret-color: auto;") { caretColor(auto) }

        // TODO?: chains

        checkStyle("clear: left;") { clear(EClearOption.left) }
        checkStyle("clear: right;") { clear(EClearOption.right) }
        checkStyle("clear: both;") { clear(EClearOption.both) }
        checkStyle("clear: none;") { clear(EClearOption.none) }

        // TODO: clip

        checkStyle("color: aliceblue;") { color(aliceblue) }

        checkStyle("content: close-quote;") { content(EContentOption.closeQuote) }
        checkStyle("content: no-close-quote;") { content(EContentOption.noCloseQuote) }
        checkStyle("content: no-open-quote;") { content(EContentOption.noOpenQuote) }
        checkStyle("content: none;") { content(EContentOption.none) }
        checkStyle("content: normal;") { content(EContentOption.normal) }
        checkStyle("content: open-quote;") { content(EContentOption.openQuote) }
        checkStyle("content: \"a \\\"quoted\\\" string\";") { content("a \"quoted\" string") }
        checkStyle("content: url(\"http://somewhere\");") { contentUrl("http://somewhere") }
        checkStyle("content: attr(data-content);") { contentAttr("data-content") }

        // TODO: counter-increment

        // TODO: counter-reset

        // TODO next: cursor

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
        checkStyle("display: none;") { display(EDisplayOption.none) }

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
            display(EDisplayOption.none); important
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
