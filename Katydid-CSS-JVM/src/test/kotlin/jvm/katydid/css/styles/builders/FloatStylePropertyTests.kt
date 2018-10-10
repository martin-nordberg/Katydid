//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.clear
import o.katydid.css.styles.builders.float
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EClear
import o.katydid.css.types.EFloat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class FloatStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Clear style properties convert to correct CSS`() {

        checkStyle("clear: block-end;") { clear(EClear.blockEnd) }
        checkStyle("clear: block-start;") { clear(EClear.blockStart) }
        checkStyle("clear: both;") { clear(EClear.both) }
        checkStyle("clear: bottom;") { clear(EClear.bottom) }
        checkStyle("clear: inline-end;") { clear(EClear.inlineEnd) }
        checkStyle("clear: inline-start;") { clear(EClear.inlineStart) }
        checkStyle("clear: left;") { clear(EClear.left) }
        checkStyle("clear: none;") { clear(EClear.none) }
        checkStyle("clear: right;") { clear(EClear.right) }
        checkStyle("clear: top;") { clear(EClear.top) }

    }

    @Test
    fun `Float style properties convert to correct CSS`() {

        checkStyle("float: block-end;") { float(EFloat.blockEnd) }
        checkStyle("float: block-start;") { float(EFloat.blockStart) }
        checkStyle("float: bottom;") { float(EFloat.bottom) }
        checkStyle("float: inline-end;") { float(EFloat.inlineEnd) }
        checkStyle("float: inline-start;") { float(EFloat.inlineStart) }
        checkStyle("float: left;") { float(EFloat.left) }
        checkStyle("float: none;") { float(EFloat.none) }
        checkStyle("float: right;") { float(EFloat.right) }
        checkStyle("float: snap-block;") { float(EFloat.snapBlock) }
        checkStyle("float: snap-inline;") { float(EFloat.snapInline) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

