//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.red
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.ELineStyle.solid
import o.katydid.css.types.ELineWidth.thick
import o.katydid.css.types.EOutlineColor.invert
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class OutlineStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Outline nested style properties convert to correct CSS`() {

        checkStyle("outline-color: red; outline-style: solid; outline-width: thick;") { outline { color(red); style(solid); width(thick) } }
        checkStyle("outline-color: invert; outline-style: solid; outline-width: 3px;") { outline { color(invert); style(solid); width(3.px) } }

        checkStyle("outline-offset: 2px;") { outline { offset(2.px) } }

    }

    @Test
    fun `Outline style properties convert to correct CSS`() {

        checkStyle("outline: red solid thick;") { outline(red, solid, thick) }
        checkStyle("outline: invert solid thick;") { outline(invert, solid, thick) }
        checkStyle("outline: red solid 3px;") { outline(red, solid, 3.px) }
        checkStyle("outline: invert solid 3px;") { outline(invert, solid, 3.px) }

        checkStyle("outline-color: red;") { outlineColor(red) }
        checkStyle("outline-color: invert;") { outlineColor(invert) }

        checkStyle("outline-offset: 2px;") { outlineOffset(2.px) }

        checkStyle("outline-style: solid;") { outlineStyle(solid) }

        checkStyle("outline-width: thick;") { outlineWidth(thick) }
        checkStyle("outline-width: 3px;") { outlineWidth(3.px) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

