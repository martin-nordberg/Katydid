//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.cursor
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.ECursor
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class CursorStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Cursor style properties convert to correct CSS`() {

        checkStyle("cursor: alias;") { cursor(ECursor.alias) }
        checkStyle("cursor: all-scroll;") { cursor(ECursor.allScroll) }
        checkStyle("cursor: auto;") { cursor(ECursor.auto) }
        checkStyle("cursor: cell;") { cursor(ECursor.cell) }
        checkStyle("cursor: col-resize;") { cursor(ECursor.colResize) }
        checkStyle("cursor: context-menu;") { cursor(ECursor.contextMenu) }
        checkStyle("cursor: copy;") { cursor(ECursor.copy) }
        checkStyle("cursor: crosshair;") { cursor(ECursor.crosshair) }
        checkStyle("cursor: default;") { cursor(ECursor.default) }
        checkStyle("cursor: e-resize;") { cursor(ECursor.eResize) }
        checkStyle("cursor: ew-resize;") { cursor(ECursor.ewResize) }
        checkStyle("cursor: grab;") { cursor(ECursor.grab) }
        checkStyle("cursor: grabbing;") { cursor(ECursor.grabbing) }
        checkStyle("cursor: help;") { cursor(ECursor.help) }
        checkStyle("cursor: move;") { cursor(ECursor.move) }
        checkStyle("cursor: n-resize;") { cursor(ECursor.nResize) }
        checkStyle("cursor: ne-resize;") { cursor(ECursor.neResize) }
        checkStyle("cursor: nesw-resize;") { cursor(ECursor.neswResize) }
        checkStyle("cursor: no-drop;") { cursor(ECursor.noDrop) }
        checkStyle("cursor: none;") { cursor(ECursor.none) }
        checkStyle("cursor: not-allowed;") { cursor(ECursor.notAlowed) }
        checkStyle("cursor: ns-resize;") { cursor(ECursor.nsResize) }
        checkStyle("cursor: nw-resize;") { cursor(ECursor.nwResize) }
        checkStyle("cursor: nwse-resize;") { cursor(ECursor.nwseResize) }
        checkStyle("cursor: pointer;") { cursor(ECursor.pointer) }
        checkStyle("cursor: progress;") { cursor(ECursor.progress) }
        checkStyle("cursor: row-resize;") { cursor(ECursor.rowResize) }
        checkStyle("cursor: s-resize;") { cursor(ECursor.sResize) }
        checkStyle("cursor: se-resize;") { cursor(ECursor.seResize) }
        checkStyle("cursor: sw-resize;") { cursor(ECursor.swResize) }
        checkStyle("cursor: text;") { cursor(ECursor.text) }
        checkStyle("cursor: vertical-text;") { cursor(ECursor.verticalText) }
        checkStyle("cursor: w-resize;") { cursor(ECursor.wResize) }
        checkStyle("cursor: wait;") { cursor(ECursor.wait) }
        checkStyle("cursor: zoom-in;") { cursor(ECursor.zoomIn) }
        checkStyle("cursor: zoom-out;") { cursor(ECursor.zoomOut) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

