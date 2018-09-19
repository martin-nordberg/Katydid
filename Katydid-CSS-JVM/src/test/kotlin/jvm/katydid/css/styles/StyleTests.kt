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
import o.katydid.css.types.EAutoOption.auto
import o.katydid.css.types.EBackgroundAttachmentOption.fixed
import o.katydid.css.types.EBackgroundAttachmentOption.scroll
import o.katydid.css.types.EBackgroundPositionOption.*
import o.katydid.css.types.EBackgroundRepeatOption.*
import o.katydid.css.types.EBorderCollapseOption.collapse
import o.katydid.css.types.EBorderCollapseOption.separate
import o.katydid.css.types.EBorderStyleOption.*
import o.katydid.css.types.EBorderWidthOption.*
import o.katydid.css.types.EBoxSizingOption.borderBox
import o.katydid.css.types.EBoxSizingOption.contentBox
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

        checkStyle("border-bottom: thin dotted mediumslateblue;") { borderBottom(thin, dotted, mediumslateblue) }

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
        checkStyle("border-color: purple orange;") { borderColor(purple, orange) }
        checkStyle("border-color: purple orange;") { borderColor(purple, orange, purple, orange) }
        checkStyle("border-color: purple orange olivedrab;") { borderColor(purple, orange, olivedrab) }
        checkStyle("border-color: purple orange olivedrab salmon;") { borderColor(purple, orange, olivedrab, salmon) }

        checkStyle("border-left: thin dotted mediumslateblue;") { borderLeft(thin, dotted, mediumslateblue) }

        checkStyle("border-left-color: navajowhite;") { borderLeftColor(navajowhite) }

        checkStyle("border-left-style: solid;") { borderLeftStyle(solid) }

        checkStyle("border-left-width: thick;") { borderLeftWidth(thick) }
        checkStyle("border-left-width: 4px;") { borderLeftWidth(4.px) }

        checkStyle("border-right: thin dotted mediumslateblue;") { borderRight(thin, dotted, mediumslateblue) }

        checkStyle("border-right-color: navajowhite;") { borderRightColor(navajowhite) }

        checkStyle("border-right-style: solid;") { borderRightStyle(solid) }

        checkStyle("border-right-width: thick;") { borderRightWidth(thick) }
        checkStyle("border-right-width: 4px;") { borderRightWidth(4.px) }

        checkStyle("border-spacing: 2px;") { borderSpacing(2.px) }
        checkStyle("border-spacing: 2px;") { borderSpacing(2.px, 2.px) }
        checkStyle("border-spacing: 2px 1px;") { borderSpacing(2.px, 1.px) }

        checkStyle("border-style: solid;") { borderStyle(solid) }
        checkStyle("border-style: solid dotted;") { borderStyle(solid, dotted) }
        checkStyle("border-style: solid dotted ridge;") { borderStyle(solid, dotted, ridge) }
        checkStyle("border-style: solid dotted ridge dashed;") { borderStyle(solid, dotted, ridge, dashed) }

        checkStyle("border-top: thin dotted mediumslateblue;") { borderTop(thin, dotted, mediumslateblue) }

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

        checkStyle("cursor: alias;") { cursor(ECursorOption.alias) }
        checkStyle("cursor: all-scroll;") { cursor(ECursorOption.allScroll) }
        checkStyle("cursor: auto;") { cursor(ECursorOption.auto) }
        checkStyle("cursor: cell;") { cursor(ECursorOption.cell) }
        checkStyle("cursor: col-resize;") { cursor(ECursorOption.colResize) }
        checkStyle("cursor: context-menu;") { cursor(ECursorOption.contextMenu) }
        checkStyle("cursor: copy;") { cursor(ECursorOption.copy) }
        checkStyle("cursor: crosshair;") { cursor(ECursorOption.crosshair) }
        checkStyle("cursor: default;") { cursor(ECursorOption.default) }
        checkStyle("cursor: e-resize;") { cursor(ECursorOption.eResize) }
        checkStyle("cursor: ew-resize;") { cursor(ECursorOption.ewResize) }
        checkStyle("cursor: grab;") { cursor(ECursorOption.grab) }
        checkStyle("cursor: grabbing;") { cursor(ECursorOption.grabbing) }
        checkStyle("cursor: help;") { cursor(ECursorOption.help) }
        checkStyle("cursor: move;") { cursor(ECursorOption.move) }
        checkStyle("cursor: n-resize;") { cursor(ECursorOption.nResize) }
        checkStyle("cursor: ne-resize;") { cursor(ECursorOption.neResize) }
        checkStyle("cursor: nesw-resize;") { cursor(ECursorOption.neswResize) }
        checkStyle("cursor: no-drop;") { cursor(ECursorOption.noDrop) }
        checkStyle("cursor: none;") { cursor(ECursorOption.none) }
        checkStyle("cursor: not-allowed;") { cursor(ECursorOption.notAlowed) }
        checkStyle("cursor: ns-resize;") { cursor(ECursorOption.nsResize) }
        checkStyle("cursor: nw-resize;") { cursor(ECursorOption.nwResize) }
        checkStyle("cursor: nwse-resize;") { cursor(ECursorOption.nwseResize) }
        checkStyle("cursor: pointer;") { cursor(ECursorOption.pointer) }
        checkStyle("cursor: progress;") { cursor(ECursorOption.progress) }
        checkStyle("cursor: row-resize;") { cursor(ECursorOption.rowResize) }
        checkStyle("cursor: s-resize;") { cursor(ECursorOption.sResize) }
        checkStyle("cursor: se-resize;") { cursor(ECursorOption.seResize) }
        checkStyle("cursor: sw-resize;") { cursor(ECursorOption.swResize) }
        checkStyle("cursor: text;") { cursor(ECursorOption.text) }
        checkStyle("cursor: vertical-text;") { cursor(ECursorOption.verticalText) }
        checkStyle("cursor: w-resize;") { cursor(ECursorOption.wResize) }
        checkStyle("cursor: wait;") { cursor(ECursorOption.wait) }
        checkStyle("cursor: zoom-in;") { cursor(ECursorOption.zoomIn) }
        checkStyle("cursor: zoom-out;") { cursor(ECursorOption.zoomOut) }

        checkStyle("direction: ltr;") { direction(EDirectionOption.ltr) }
        checkStyle("direction: rtl;") { direction(EDirectionOption.rtl) }

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

        checkStyle("empty-cells: show;") { emptyCells(EEmptyCellsOption.show) }
        checkStyle("empty-cells: hide;") { emptyCells(EEmptyCellsOption.hide) }

        checkStyle("float: left;") { float(EFloatOption.left) }
        checkStyle("float: right;") { float(EFloatOption.right) }
        checkStyle("float: none;") { float(EFloatOption.none) }

        // TODO: font

        checkStyle("font-family: arial, helvetica, sans-serif;") { fontFamily("arial", "helvetica", "sans-serif") }
        checkStyle("font-family: \"Courier New\", serif;") { fontFamily("Courier New", "serif") }

        checkStyle("font-size: large;") { fontSize(EFontSizeOption.large) }
        checkStyle("font-size: larger;") { fontSize(EFontSizeOption.larger) }
        checkStyle("font-size: medium;") { fontSize(EFontSizeOption.medium) }
        checkStyle("font-size: small;") { fontSize(EFontSizeOption.small) }
        checkStyle("font-size: smaller;") { fontSize(EFontSizeOption.smaller) }
        checkStyle("font-size: x-large;") { fontSize(EFontSizeOption.xLarge) }
        checkStyle("font-size: x-small;") { fontSize(EFontSizeOption.xSmall) }
        checkStyle("font-size: xx-large;") { fontSize(EFontSizeOption.xxLarge) }
        checkStyle("font-size: xx-small;") { fontSize(EFontSizeOption.xxSmall) }
        checkStyle("font-size: 14pt;") { fontSize(14.pt) }
        checkStyle("font-size: 90%;") { fontSize(90.percent) }

        checkStyle("font-style: normal;") { fontStyle(EFontStyleOption.normal) }
        checkStyle("font-style: italic;") { fontStyle(EFontStyleOption.italic) }
        checkStyle("font-style: oblique;") { fontStyle(EFontStyleOption.oblique) }

        checkStyle("font-variant: normal;") { fontVariant(EFontVariantOption.normal) }
        checkStyle("font-variant: small-caps;") { fontVariant(EFontVariantOption.smallCaps) }

        checkStyle("font-weight: bold;") { fontWeight(EFontWeightOption.bold) }
        checkStyle("font-weight: bolder;") { fontWeight(EFontWeightOption.bolder) }
        checkStyle("font-weight: lighter;") { fontWeight(EFontWeightOption.lighter) }
        checkStyle("font-weight: normal;") { fontWeight(EFontWeightOption.normal) }
        checkStyle("font-weight: 100;") { fontWeight(EFontWeightOption.weight100) }
        checkStyle("font-weight: 200;") { fontWeight(EFontWeightOption.weight200) }
        checkStyle("font-weight: 300;") { fontWeight(EFontWeightOption.weight300) }
        checkStyle("font-weight: 400;") { fontWeight(EFontWeightOption.weight400) }
        checkStyle("font-weight: 500;") { fontWeight(EFontWeightOption.weight500) }
        checkStyle("font-weight: 600;") { fontWeight(EFontWeightOption.weight600) }
        checkStyle("font-weight: 700;") { fontWeight(EFontWeightOption.weight700) }
        checkStyle("font-weight: 800;") { fontWeight(EFontWeightOption.weight800) }
        checkStyle("font-weight: 900;") { fontWeight(EFontWeightOption.weight900) }

        checkStyle("height: 100px;") { height(100.px) }
        checkStyle("height: 90%;") { height(90.percent) }
        checkStyle("height: auto;") { height(auto) }

        checkStyle("left: 14.1px;") { left(14.1.px) }
        checkStyle("left: 3%;") { left(3.percent) }
        checkStyle("left: auto;") { left(auto) }

        checkStyle("letter-spacing: 0.05em;") { letterSpacing(0.05.em) }
        checkStyle("letter-spacing: normal;") { letterSpacing(ENormalOption.normal) }

        checkStyle("line-height: normal;") { lineHeight(ENormalOption.normal) }
        checkStyle("line-height: 1.2em;") { lineHeight(1.2.em) }
        checkStyle("line-height: 120%;") { lineHeight(120.percent) }
        checkStyle("line-height: 1.2;") { lineHeight(1.2f) }
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
