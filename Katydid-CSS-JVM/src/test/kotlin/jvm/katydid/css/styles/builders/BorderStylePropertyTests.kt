//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.*
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.ELineStyle
import o.katydid.css.types.ELineStyle.*
import o.katydid.css.types.ELineWidth.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class BorderStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Border style properties convert to correct CSS`() {

        checkStyle("border: thin;") { border(thin) }
        checkStyle("border: 4px dashed green;") { border(4.px, ELineStyle.dashed, green) }
        checkStyle("border: solid;") { border(ELineStyle.solid) }

        checkStyle("border-bottom: thin dotted mediumslateblue;") { borderBottom(thin, dotted, mediumslateblue) }
        checkStyle("border-bottom: thin;") { borderBottom(thin) }
        checkStyle("border-bottom: 4px dashed green;") { borderBottom(4.px, ELineStyle.dashed, green) }
        checkStyle("border-bottom: solid;") { borderBottom(ELineStyle.solid) }

        checkStyle("border-bottom-color: navajowhite;") { borderBottomColor(navajowhite) }

        checkStyle("border-bottom-style: none;") { borderBottomStyle(ELineStyle.none) }
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

        checkStyle("border-color: purple;") { borderColor(purple) }
        checkStyle("border-color: purple orange;") { borderColor(purple, orange) }
        checkStyle("border-color: purple orange;") { borderColor(purple, orange, purple, orange) }
        checkStyle("border-color: purple orange olivedrab;") { borderColor(purple, orange, olivedrab) }
        checkStyle("border-color: purple orange olivedrab salmon;") { borderColor(purple, orange, olivedrab, salmon) }

        checkStyle("border-left: thin dotted mediumslateblue;") { borderLeft(thin, dotted, mediumslateblue) }
        checkStyle("border-left: thin;") { borderLeft(thin) }
        checkStyle("border-left: 4px dashed green;") { borderLeft(4.px, ELineStyle.dashed, green) }
        checkStyle("border-left: solid;") { borderLeft(ELineStyle.solid) }

        checkStyle("border-left-color: navajowhite;") { borderLeftColor(navajowhite) }

        checkStyle("border-left-style: solid;") { borderLeftStyle(solid) }

        checkStyle("border-left-width: thick;") { borderLeftWidth(thick) }
        checkStyle("border-left-width: 4px;") { borderLeftWidth(4.px) }

        checkStyle("border-right: thin dotted mediumslateblue;") { borderRight(thin, dotted, mediumslateblue) }
        checkStyle("border-right: thin;") { borderRight(thin) }
        checkStyle("border-right: 4px dashed green;") { borderRight(4.px, ELineStyle.dashed, green) }
        checkStyle("border-right: solid;") { borderRight(ELineStyle.solid) }

        checkStyle("border-right-color: navajowhite;") { borderRightColor(navajowhite) }

        checkStyle("border-right-style: solid;") { borderRightStyle(solid) }

        checkStyle("border-right-width: thick;") { borderRightWidth(thick) }
        checkStyle("border-right-width: 4px;") { borderRightWidth(4.px) }

        checkStyle("border-style: solid;") { borderStyle(solid) }
        checkStyle("border-style: solid dotted;") { borderStyle(solid, dotted) }
        checkStyle("border-style: solid dotted ridge;") { borderStyle(solid, dotted, ridge) }
        checkStyle("border-style: solid dotted ridge dashed;") { borderStyle(solid, dotted, ridge, dashed) }

        checkStyle("border-top: thin dotted mediumslateblue;") { borderTop(thin, dotted, mediumslateblue) }
        checkStyle("border-top: thin;") { borderTop(thin) }
        checkStyle("border-top: 4px dashed green;") { borderTop(4.px, ELineStyle.dashed, green) }
        checkStyle("border-top: solid;") { borderTop(ELineStyle.solid) }

        checkStyle("border-top-color: navajowhite;") { borderTopColor(navajowhite) }

        checkStyle("border-top-style: solid;") { borderTopStyle(solid) }

        checkStyle("border-top-width: thick;") { borderTopWidth(thick) }
        checkStyle("border-top-width: 4px;") { borderTopWidth(4.px) }

        checkStyle("border-width: thick;") { borderWidth(thick) }
        checkStyle("border-width: thick thin thick medium;") { borderWidth(thick, thin, thick, medium) }
        checkStyle("border-width: 4px;") { borderWidth(4.px) }
        checkStyle("border-width: 4px 2px;") { borderWidth(4.px, 2.px) }

    }

    @Test
    fun `Nested border style properties convert to correct CSS`() {

        checkStyle("border-bottom: thin dotted mediumslateblue;") { border { bottom(thin, dotted, mediumslateblue) } }
        checkStyle("border-bottom: thin;") { border { bottom(thin) } }
        checkStyle("border-bottom: 4px dashed green;") { border { bottom(4.px, ELineStyle.dashed, green) } }
        checkStyle("border-bottom: solid;") { border { bottom(ELineStyle.solid) } }

        checkStyle("border-bottom-color: navajowhite;") { border { bottom { color(navajowhite) } } }

        checkStyle("border-bottom-style: dashed;") { border { bottom { style(dashed) } } }

        checkStyle("border-bottom-width: thin;") { border { bottom { width(thin) } } }
        checkStyle("border-bottom-width: 4px;") { border { bottom { width(4.px) } } }

        checkStyle("border-color: purple orange;") { border { color(purple, orange) } }

        checkStyle("border-left: thin dotted mediumslateblue;") { border { left(thin, dotted, mediumslateblue) } }
        checkStyle("border-left: thin;") { border { left(thin) } }
        checkStyle("border-left: 4px dashed green;") { border { left(4.px, ELineStyle.dashed, green) } }
        checkStyle("border-left: solid;") { border { left(ELineStyle.solid) } }

        checkStyle("border-left-color: navajowhite;") { border { left { color(navajowhite) } } }

        checkStyle("border-left-style: solid;") { border { left { style(solid) } } }

        checkStyle("border-left-width: thick;") { border { left { width(thick) } } }
        checkStyle("border-left-width: 4px;") { border { left { width(4.px) } } }

        checkStyle("border-right: thin dotted mediumslateblue;") { border { right(thin, dotted, mediumslateblue) } }
        checkStyle("border-right: thin;") { border { right(thin) } }
        checkStyle("border-right: 4px dashed green;") { border { right(4.px, ELineStyle.dashed, green) } }
        checkStyle("border-right: solid;") { border { right(ELineStyle.solid) } }

        checkStyle("border-right-color: navajowhite;") { border { right { color(navajowhite) } } }

        checkStyle("border-right-style: solid;") { border { right { style(solid) } } }

        checkStyle("border-right-width: thick;") { border { right { width(thick) } } }
        checkStyle("border-right-width: 4px;") { border { right { width(4.px) } } }

        checkStyle("border-style: solid dotted;") { border { style(solid, dotted) } }

        checkStyle("border-top: thin dotted mediumslateblue;") { border { top(thin, dotted, mediumslateblue) } }
        checkStyle("border-top: thin;") { border { top(thin) } }
        checkStyle("border-top: 4px dashed green;") { border { top(4.px, ELineStyle.dashed, green) } }
        checkStyle("border-top: solid;") { border { top(ELineStyle.solid) } }

        checkStyle("border-top-color: navajowhite;") { border { top { color(navajowhite) } } }

        checkStyle("border-top-style: solid;") { border { top { style(solid) } } }

        checkStyle("border-top-width: thick;") { border { top { width(thick) } } }
        checkStyle("border-top-width: 4px;") { border { top { width(4.px) } } }

        checkStyle("border-width: thick;") { border { width(thick) } }
        checkStyle("border-width: thick thin thick medium;") { border { width(thick, thin, thick, medium) } }
        checkStyle("border-width: 4px;") { border { width(4.px) } }
        checkStyle("border-width: 4px 2px;") { border { width(4.px, 2.px) } }

    }

}

//---------------------------------------------------------------------------------------------------------------------

