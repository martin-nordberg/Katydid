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
import o.katydid.css.types.ELineWidthOption.*
import o.katydid.css.types.EBoxSizingOption.borderBox
import o.katydid.css.types.EBoxSizingOption.contentBox
import o.katydid.css.types.EDisplayOption.*
import o.katydid.css.types.EOutlineColorOption.invert
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Suppress("RemoveRedundantBackticks")
class StylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Background style properties convert to correct CSS`() {

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

    }

    @Test
    fun `Border style properties convert to correct CSS`() {

        checkStyle("border: thin;") { border(thin) }
        checkStyle("border: 4px dashed green;") { border(4.px,EBorderStyleOption.dashed,green) }
        checkStyle("border: solid;") { border(EBorderStyleOption.solid) }

        checkStyle("border-bottom: thin dotted mediumslateblue;") { borderBottom(thin, dotted, mediumslateblue) }
        checkStyle("border-bottom: thin;") { borderBottom(thin) }
        checkStyle("border-bottom: 4px dashed green;") { borderBottom(4.px,EBorderStyleOption.dashed,green) }
        checkStyle("border-bottom: solid;") { borderBottom(EBorderStyleOption.solid) }

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
        checkStyle("border-left: thin;") { borderLeft(thin) }
        checkStyle("border-left: 4px dashed green;") { borderLeft(4.px,EBorderStyleOption.dashed,green) }
        checkStyle("border-left: solid;") { borderLeft(EBorderStyleOption.solid) }

        checkStyle("border-left-color: navajowhite;") { borderLeftColor(navajowhite) }

        checkStyle("border-left-style: solid;") { borderLeftStyle(solid) }

        checkStyle("border-left-width: thick;") { borderLeftWidth(thick) }
        checkStyle("border-left-width: 4px;") { borderLeftWidth(4.px) }

        checkStyle("border-right: thin dotted mediumslateblue;") { borderRight(thin, dotted, mediumslateblue) }
        checkStyle("border-right: thin;") { borderRight(thin) }
        checkStyle("border-right: 4px dashed green;") { borderRight(4.px,EBorderStyleOption.dashed,green) }
        checkStyle("border-right: solid;") { borderRight(EBorderStyleOption.solid) }

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
        checkStyle("border-top: thin;") { borderTop(thin) }
        checkStyle("border-top: 4px dashed green;") { borderTop(4.px,EBorderStyleOption.dashed,green) }
        checkStyle("border-top: solid;") { borderTop(EBorderStyleOption.solid) }

        checkStyle("border-top-color: navajowhite;") { borderTopColor(navajowhite) }

        checkStyle("border-top-style: solid;") { borderTopStyle(solid) }

        checkStyle("border-top-width: thick;") { borderTopWidth(thick) }
        checkStyle("border-top-width: 4px;") { borderTopWidth(4.px) }

        checkStyle("border-width: thick;") { borderWidth(thick) }
        checkStyle("border-width: thick thin thick medium;") { borderWidth(thick,thin,thick,medium) }
        checkStyle("border-width: 4px;") { borderWidth(4.px) }
        checkStyle("border-width: 4px 2px;") { borderWidth(4.px, 2.px) }

    }

    @Test
    fun `Box sizing style properties convert to correct CSS`() {

        checkStyle("box-sizing: content-box;") { boxSizing(contentBox) }
        checkStyle("box-sizing: border-box;") { boxSizing(borderBox) }

    }

    @Test
    fun `Caption side style properties convert to correct CSS`() {

        checkStyle("caption-side: top;") { captionSide(ECaptionSideOption.top) }
        checkStyle("caption-side: bottom;") { captionSide(ECaptionSideOption.bottom) }

    }

    @Test
    fun `Caret color style properties convert to correct CSS`() {

        checkStyle("caret-color: slateblue;") { caretColor(slateblue) }
        checkStyle("caret-color: auto;") { caretColor(auto) }

    }

    @Test
    fun `Clear and float style properties convert to correct CSS`() {

        checkStyle("clear: left;") { clear(EClearOption.left) }
        checkStyle("clear: right;") { clear(EClearOption.right) }
        checkStyle("clear: both;") { clear(EClearOption.both) }
        checkStyle("clear: none;") { clear(EClearOption.none) }

        checkStyle("float: left;") { float(EFloatOption.left) }
        checkStyle("float: right;") { float(EFloatOption.right) }
        checkStyle("float: none;") { float(EFloatOption.none) }

    }

    @Test
    fun `Color style properties convert to correct CSS`() {

        checkStyle("color: aliceblue;") { color(aliceblue) }

    }

    @Test
    fun `Content style properties convert to correct CSS`() {

        checkStyle("content: close-quote;") { content(EContentOption.closeQuote) }
        checkStyle("content: no-close-quote;") { content(EContentOption.noCloseQuote) }
        checkStyle("content: no-open-quote;") { content(EContentOption.noOpenQuote) }
        checkStyle("content: none;") { content(EContentOption.none) }
        checkStyle("content: normal;") { content(EContentOption.normal) }
        checkStyle("content: open-quote;") { content(EContentOption.openQuote) }
        checkStyle("content: \"a \\\"quoted\\\" string\";") { content("a \"quoted\" string") }
        checkStyle("content: url(\"http://somewhere\");") { contentUrl("http://somewhere") }
        checkStyle("content: attr(data-content);") { contentAttr("data-content") }

    }

    @Test
    fun `Cursor style properties convert to correct CSS`() {

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

    }

    @Test
    fun `Direction style properties convert to correct CSS`() {

        checkStyle("direction: ltr;") { direction(EDirectionOption.ltr) }
        checkStyle("direction: rtl;") { direction(EDirectionOption.rtl) }

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
        checkStyle("display: none;") { display(EDisplayOption.none) }

    }

    @Test
    fun `Empty cells style properties convert to correct CSS`() {

        checkStyle("empty-cells: show;") { emptyCells(EEmptyCellsOption.show) }
        checkStyle("empty-cells: hide;") { emptyCells(EEmptyCellsOption.hide) }

    }

    @Test
    fun `Font style properties convert to correct CSS`() {

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

    }

    @Test
    fun `Letter spacing and line height style properties convert to correct CSS`() {

        checkStyle("letter-spacing: 0.05em;") { letterSpacing(0.05.em) }
        checkStyle("letter-spacing: normal;") { letterSpacing(ENormalOption.normal) }

        checkStyle("line-height: normal;") { lineHeight(ENormalOption.normal) }
        checkStyle("line-height: 1.2em;") { lineHeight(1.2.em) }
        checkStyle("line-height: 120%;") { lineHeight(120.percent) }
        checkStyle("line-height: 1.2;") { lineHeight(1.2f) }

    }

    @Test
    fun `List style properties convert to correct CSS`() {

        checkStyle("list-style-image: none;") { listStyleImage(ENoneOption.none) }
        checkStyle("list-style-image: url(\"http://myimage.jpg\");") { listStyleImage("http://myimage.jpg") }

        checkStyle("list-style-position: inside;") { listStylePosition(EListStylePositionOption.inside) }
        checkStyle("list-style-position: outside;") { listStylePosition(EListStylePositionOption.outside) }

        checkStyle("list-style-type: armenian;") { listStyleType(EListStyleTypeOption.armenian) }
        checkStyle("list-style-type: circle;") { listStyleType(EListStyleTypeOption.circle) }
        checkStyle("list-style-type: decimal;") { listStyleType(EListStyleTypeOption.decimal) }
        checkStyle("list-style-type: decimal-leading-zero;") { listStyleType(EListStyleTypeOption.decimalLeadingZero) }
        checkStyle("list-style-type: disc;") { listStyleType(EListStyleTypeOption.disc) }
        checkStyle("list-style-type: georgian;") { listStyleType(EListStyleTypeOption.georgian) }
        checkStyle("list-style-type: lower-greek;") { listStyleType(EListStyleTypeOption.lowerGreek) }
        checkStyle("list-style-type: lower-latin;") { listStyleType(EListStyleTypeOption.lowerLatin) }
        checkStyle("list-style-type: lower-roman;") { listStyleType(EListStyleTypeOption.lowerRoman) }
        checkStyle("list-style-type: square;") { listStyleType(EListStyleTypeOption.square) }
        checkStyle("list-style-type: upper-latin;") { listStyleType(EListStyleTypeOption.upperLatin) }
        checkStyle("list-style-type: upper-roman;") { listStyleType(EListStyleTypeOption.upperRoman) }
        checkStyle("list-style-type: lower-latin;") { listStyleType(EListStyleTypeOption.lowerAlpha) }
        checkStyle("list-style-type: upper-latin;") { listStyleType(EListStyleTypeOption.upperAlpha) }

        checkStyle("list-style: square;") { listStyle(EListStyleTypeOption.square) }
        checkStyle("list-style: square outside;") { listStyle(EListStyleTypeOption.square,EListStylePositionOption.outside) }
        checkStyle("list-style: square outside url(\"images/image.jpg\");") { listStyle(EListStyleTypeOption.square,EListStylePositionOption.outside,"images/image.jpg") }

    }

    @Test
    fun `Margin style properties convert to correct CSS`() {

        checkStyle("margin: -2px;") { margin((-2).px) }
        checkStyle("margin: -2px;") { margin((-2).px,(-2).px) }
        checkStyle("margin: -2px;") { margin((-2).px,(-2).px,(-2).px) }
        checkStyle("margin: -2px -3px;") { margin((-2).px,(-3).px,(-2).px,(-3).px) }
        checkStyle("margin: 1px 2px 3px;") { margin(1.px,2.px,3.px) }
        checkStyle("margin: 1px 2px 3px 4px;") { margin(1.px,2.px,3.px,4.px) }
        checkStyle("margin: 2%;") { margin(2.percent) }
        checkStyle("margin: 2%;") { margin(2.percent,2.percent) }
        checkStyle("margin: 2%;") { margin(2.percent,2.percent,2.percent) }
        checkStyle("margin: 2% 3%;") { margin(2.percent,3.percent,2.percent,3.percent) }
        checkStyle("margin: 1% 2% 3%;") { margin(1.percent,2.percent,3.percent) }
        checkStyle("margin: 1% 2% 3% 4%;") { margin(1.percent,2.percent,3.percent,4.percent) }
        checkStyle("margin: auto;") { margin(auto) }

        checkStyle("margin-bottom: 2px;") { marginBottom(2.px) }
        checkStyle("margin-bottom: 2%;") { marginBottom(2.percent) }
        checkStyle("margin-bottom: auto;") { marginBottom(auto) }

        checkStyle("margin-left: 2px;") { marginLeft(2.px) }
        checkStyle("margin-left: 2%;") { marginLeft(2.percent) }
        checkStyle("margin-left: auto;") { marginLeft(auto) }

        checkStyle("margin-right: 2px;") { marginRight(2.px) }
        checkStyle("margin-right: 2%;") { marginRight(2.percent) }
        checkStyle("margin-right: auto;") { marginRight(auto) }

        checkStyle("margin-top: 2px;") { marginTop(2.px) }
        checkStyle("margin-top: 2%;") { marginTop(2.percent) }
        checkStyle("margin-top: auto;") { marginTop(auto) }

    }

    @Test
    fun `Min and max size style properties convert to correct CSS`() {

        checkStyle("max-height: 25px;") { maxHeight(25.px) }
        checkStyle("max-height: 50%;") { maxHeight(50.percent) }
        checkStyle("max-height: none;") { maxHeight(ENoneOption.none) }

        checkStyle("max-width: 25px;") { maxWidth(25.px) }
        checkStyle("max-width: 50%;") { maxWidth(50.percent) }
        checkStyle("max-width: none;") { maxWidth(ENoneOption.none) }

        checkStyle("min-height: 25px;") { minHeight(25.px) }
        checkStyle("min-height: 50%;") { minHeight(50.percent) }

        checkStyle("min-width: 25px;") { minWidth(25.px) }
        checkStyle("min-width: 50%;") { minWidth(50.percent) }

    }

    @Test
    fun `Opacity style properties convert to correct CSS`() {

        checkStyle("opacity: 0;") { opacity(-1f) }
        checkStyle("opacity: 0;") { opacity(0f) }
        checkStyle("opacity: 0.642;") { opacity(0.6421f) }
        checkStyle("opacity: 1;") { opacity(1f) }
        checkStyle("opacity: 1;") { opacity(3f) }

    }

    @Test
    fun `Outline style properties convert to correct CSS`() {

        checkStyle("outline: red solid thick;") { outline(red,solid,thick) }
        checkStyle("outline: invert solid thick;") { outline(invert,solid,thick) }
        checkStyle("outline: red solid 3px;") { outline(red,solid,3.px) }
        checkStyle("outline: invert solid 3px;") { outline(invert,solid,3.px) }

        checkStyle("outline-color: red;") { outlineColor(red) }
        checkStyle("outline-color: invert;") { outlineColor(invert) }

        checkStyle("outline-style: solid;") { outlineStyle(solid) }

        checkStyle("outline-width: thick;") { outlineWidth(thick) }
        checkStyle("outline-width: 3px;") { outlineWidth(3.px) }

    }

    @Test
    fun `Overflow style properties convert to correct CSS`() {

        checkStyle("overflow: auto;") { overflow(EOverflowOption.auto) }
        checkStyle("overflow: hidden;") { overflow(EOverflowOption.hidden) }
        checkStyle("overflow: scroll;") { overflow(EOverflowOption.scroll) }
        checkStyle("overflow: scroll hidden;") { overflow(EOverflowOption.scroll, EOverflowOption.hidden) }
        checkStyle("overflow: visible;") { overflow(EOverflowOption.visible) }

        checkStyle("overflow-x: scroll;") { overflowX(EOverflowOption.scroll) }

        checkStyle("overflow-y: scroll;") { overflowY(EOverflowOption.scroll) }

    }

    @Test
    fun `Padding style properties convert to correct CSS`() {

        checkStyle("padding: 2px;") { padding(2.px) }
        checkStyle("padding: 2px;") { padding(2.px,2.px) }
        checkStyle("padding: 2px;") { padding(2.px,2.px,2.px) }
        checkStyle("padding: 2px -3px;") { padding(2.px,(-3).px,2.px,(-3).px) }
        checkStyle("padding: 1px 2px 3px;") { padding(1.px,2.px,3.px) }
        checkStyle("padding: 1px 2px 3px 4px;") { padding(1.px,2.px,3.px,4.px) }
        checkStyle("padding: 2%;") { padding(2.percent) }
        checkStyle("padding: 2%;") { padding(2.percent,2.percent) }
        checkStyle("padding: 2%;") { padding(2.percent,2.percent,2.percent) }
        checkStyle("padding: 2% 3%;") { padding(2.percent,3.percent,2.percent,3.percent) }
        checkStyle("padding: 1% 2% 3%;") { padding(1.percent,2.percent,3.percent) }
        checkStyle("padding: 1% 2% 3% 4%;") { padding(1.percent,2.percent,3.percent,4.percent) }

        checkStyle("padding-bottom: 2px;") { paddingBottom(2.px) }
        checkStyle("padding-bottom: 2%;") { paddingBottom(2.percent) }

        checkStyle("padding-left: 2px;") { paddingLeft(2.px) }
        checkStyle("padding-left: 2%;") { paddingLeft(2.percent) }

        checkStyle("padding-right: 2px;") { paddingRight(2.px) }
        checkStyle("padding-right: 2%;") { paddingRight(2.percent) }

        checkStyle("padding-top: 2px;") { paddingTop(2.px) }
        checkStyle("padding-top: 2%;") { paddingTop(2.percent) }

    }

    @Test
    fun `Page break style properties convert to correct CSS`() {

        checkStyle("page-break-after: always;") { pageBreakAfter(EPageBreakOption.always) }
        checkStyle("page-break-after: auto;") { pageBreakAfter(EPageBreakOption.auto) }
        checkStyle("page-break-after: avoid;") { pageBreakAfter(EPageBreakOption.avoid) }
        checkStyle("page-break-after: left;") { pageBreakAfter(EPageBreakOption.left) }
        checkStyle("page-break-after: right;") { pageBreakAfter(EPageBreakOption.right) }

        checkStyle("page-break-before: always;") { pageBreakBefore(EPageBreakOption.always) }
        checkStyle("page-break-before: auto;") { pageBreakBefore(EPageBreakOption.auto) }
        checkStyle("page-break-before: avoid;") { pageBreakBefore(EPageBreakOption.avoid) }
        checkStyle("page-break-before: left;") { pageBreakBefore(EPageBreakOption.left) }
        checkStyle("page-break-before: right;") { pageBreakBefore(EPageBreakOption.right) }

        checkStyle("page-break-inside: auto;") { pageBreakInside(EPageBreakInsideOption.auto) }
        checkStyle("page-break-inside: avoid;") { pageBreakInside(EPageBreakInsideOption.avoid) }

    }

    @Test
    fun `Position style properties convert to correct CSS`() {

        checkStyle("bottom: 4.5ex;") { bottom(4.5.ex) }
        checkStyle("bottom: 45%;") { bottom(45.percent) }
        checkStyle("bottom: auto;") { bottom(auto) }

        checkStyle("left: 14.1px;") { left(14.1.px) }
        checkStyle("left: 3%;") { left(3.percent) }
        checkStyle("left: auto;") { left(auto) }

        checkStyle("position: absolute;") { position(EPositionOption.absolute) }
        checkStyle("position: fixed;") { position(EPositionOption.fixed) }
        checkStyle("position: relative;") { position(EPositionOption.relative) }
        checkStyle("position: static;") { position(EPositionOption.static) }

        checkStyle("right: 14.1px;") { right(14.1.px) }
        checkStyle("right: 3%;") { right(3.percent) }
        checkStyle("right: auto;") { right(auto) }

        checkStyle("top: 4.5ex;") { top(4.5.ex) }
        checkStyle("top: 45%;") { top(45.percent) }
        checkStyle("top: auto;") { top(auto) }

    }

    @Test
    fun `Resize properties convert to correct CSS`() {

        checkStyle("resize: both;") { resize(EResizeOption.both) }
        checkStyle("resize: horizontal;") { resize(EResizeOption.horizontal) }
        checkStyle("resize: none;") { resize(EResizeOption.none) }
        checkStyle("resize: vertical;") { resize(EResizeOption.vertical) }

    }

    @Test
    fun `Arbitrary properties convert to correct CSS`() {

        checkStyle("not-yet-invented: 7px;") { setProperty("not-yet-invented",7.px.toString()) }

    }

    @Test
    fun `Size style properties convert to correct CSS`() {

        checkStyle("height: 100px;") { height(100.px) }
        checkStyle("height: 90%;") { height(90.percent) }
        checkStyle("height: auto;") { height(auto) }

        checkStyle("width: 100px;") { width(100.px) }
        checkStyle("width: 90%;") { width(90.percent) }
        checkStyle("width: auto;") { width(auto) }

    }

    @Test
    fun `Table layout properties convert to correct CSS`() {

        checkStyle("table-layout: auto;") { tableLayout(ETableLayoutOption.auto) }
        checkStyle("table-layout: fixed;") { tableLayout(ETableLayoutOption.fixed) }

    }

    @Test
    fun `Text align properties convert to correct CSS`() {

        checkStyle("text-align: center;") { textAlign(ETextAlignOption.center) }
        checkStyle("text-align: justify;") { textAlign(ETextAlignOption.justify) }
        checkStyle("text-align: left;") { textAlign(ETextAlignOption.left) }
        checkStyle("text-align: right;") { textAlign(ETextAlignOption.right) }

    }

    @Test
    fun `Text decoration properties convert to correct CSS`() {

        checkStyle("text-decoration: none;") { textDecoration(ENoneOption.none) }
        checkStyle("text-decoration: blink;") { textDecoration(ETextDecorationOption.blink) }
        checkStyle("text-decoration: line-through;") { textDecoration(ETextDecorationOption.lineThrough) }
        checkStyle("text-decoration: overline;") { textDecoration(ETextDecorationOption.overline) }
        checkStyle("text-decoration: underline;") { textDecoration(ETextDecorationOption.underline) }
        checkStyle("text-decoration: underline blink;") { textDecoration(ETextDecorationOption.underline, ETextDecorationOption.blink) }

    }

    @Test
    fun `Text indent properties convert to correct CSS`() {

        checkStyle("text-indent: 3em;") { textIndent(3.em) }
        checkStyle("text-indent: 3%;") { textIndent(3.percent) }

    }

    @Test
    fun `Text overflow properties convert to correct CSS`() {

        checkStyle("text-overflow: clip;") { textOverflow(ETextOverflowOption.clip) }
        checkStyle("text-overflow: ellipsis;") { textOverflow(ETextOverflowOption.ellipsis) }

    }

    @Test
    fun `Text transform properties convert to correct CSS`() {

        checkStyle("text-transform: capitalize;") { textTransform(ETextTransformOption.capitalize) }
        checkStyle("text-transform: lowercase;") { textTransform(ETextTransformOption.lowercase) }
        checkStyle("text-transform: none;") { textTransform(ETextTransformOption.none) }
        checkStyle("text-transform: uppercase;") { textTransform(ETextTransformOption.uppercase) }

    }

    @Test
    fun `Unicode bidirectional properties convert to correct CSS`() {

        checkStyle("unicode-bidi: bidi-override;") { unicodeBidi(EUnicodeBidiOption.bidiOverride) }
        checkStyle("unicode-bidi: embed;") { unicodeBidi(EUnicodeBidiOption.embed) }
        checkStyle("unicode-bidi: normal;") { unicodeBidi(EUnicodeBidiOption.normal) }

    }

    @Test
    fun `Vertical alignment properties convert to correct CSS`() {

        checkStyle("vertical-align: 4px;") { verticalAlign(4.px) }
        checkStyle("vertical-align: 4%;") { verticalAlign(4.percent) }
        checkStyle("vertical-align: alphabetic;") { verticalAlign(EAlignmentBaselineOption.alphabetic) }
        checkStyle("vertical-align: baseline;") { verticalAlign(EAlignmentBaselineOption.baseline) }
        checkStyle("vertical-align: bottom;") { verticalAlign(EAlignmentBaselineOption.bottom) }
        checkStyle("vertical-align: center;") { verticalAlign(EAlignmentBaselineOption.center) }
        checkStyle("vertical-align: central;") { verticalAlign(EAlignmentBaselineOption.central) }
        checkStyle("vertical-align: ideographic;") { verticalAlign(EAlignmentBaselineOption.ideographic) }
        checkStyle("vertical-align: mathematical;") { verticalAlign(EAlignmentBaselineOption.mathematical) }
        checkStyle("vertical-align: middle;") { verticalAlign(EAlignmentBaselineOption.middle) }
        checkStyle("vertical-align: text-bottom;") { verticalAlign(EAlignmentBaselineOption.textBottom) }
        checkStyle("vertical-align: text-top;") { verticalAlign(EAlignmentBaselineOption.textTop) }
        checkStyle("vertical-align: top;") { verticalAlign(EAlignmentBaselineOption.top) }
        checkStyle("vertical-align: sub;") { verticalAlign(EBaselineShiftOption.sub) }
        checkStyle("vertical-align: super;") { verticalAlign(EBaselineShiftOption.`super`) }

    }

    @Test
    fun `Visibility properties convert to correct CSS`() {

        checkStyle("visibility: collapse;") { visibility(EVisibilityOption.collapse) }
        checkStyle("visibility: hidden;") { visibility(EVisibilityOption.hidden) }
        checkStyle("visibility: visible;") { visibility(EVisibilityOption.visible) }

    }

    @Test
    fun `White space properties convert to correct CSS`() {

        checkStyle("white-space: break-spaces;") { whiteSpace(EWhiteSpaceOption.breakSpaces) }
        checkStyle("white-space: normal;") { whiteSpace(EWhiteSpaceOption.normal) }
        checkStyle("white-space: nowrap;") { whiteSpace(EWhiteSpaceOption.nowrap) }
        checkStyle("white-space: pre;") { whiteSpace(EWhiteSpaceOption.pre) }
        checkStyle("white-space: pre-line;") { whiteSpace(EWhiteSpaceOption.preLine) }
        checkStyle("white-space: pre-wrap;") { whiteSpace(EWhiteSpaceOption.preWrap) }

    }

    @Test
    fun `Widows and orphans properties convert to correct CSS`() {

        checkStyle("orphans: 3;") { orphans(3) }
        checkStyle("widows: 2;") { widows(2) }

        assertFailsWith(IllegalArgumentException::class) { checkStyle("throws") { orphans(0) } }
        assertFailsWith(IllegalArgumentException::class) { checkStyle("throws") { orphans(-1) } }
        assertFailsWith(IllegalArgumentException::class) { checkStyle("throws") { widows(0) } }
        assertFailsWith(IllegalArgumentException::class) { checkStyle("throws") { widows(-1) } }

    }

    @Test
    fun `Word spacing properties convert to correct CSS`() {

        checkStyle("word-spacing: 4px;") { wordSpacing(4.px) }
        checkStyle("word-spacing: 4%;") { wordSpacing(4.percent) }
        checkStyle("word-spacing: normal;") { wordSpacing(ENormalOption.normal) }

    }

    @Test
    fun `Z index properties convert to correct CSS`() {

        checkStyle("z-index: 2;") { zIndex(2) }
        checkStyle("z-index: auto;") { zIndex(auto) }

    }

}
