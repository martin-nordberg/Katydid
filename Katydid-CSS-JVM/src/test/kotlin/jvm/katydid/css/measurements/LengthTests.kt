//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.measurements

import o.katydid.css.measurements.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class LengthTests {

    @Test
    fun `Linear measurements convert to strings`() {

        assertEquals("0", Length(0f, LengthUnit.PIXEL).toString())
        assertEquals("1px", Length(1f, LengthUnit.PIXEL).toString())
        assertEquals("1.12em", Length(1.12004f, LengthUnit.EM).toString())

    }

    @Test
    fun `Linear measurements convert from numbers`() {

        assertEquals("0", length(0).toString())
        assertEquals("1px", length(1f).toString())
        assertEquals("1.003px", length(1.003f).toString())

    }

    @Test
    fun `Linear measurements convert from strings`() {

        for ( unit in LengthUnit.values() ) {
            assertEquals("1.12" + unit.toString(),
                         length("1.12004"+unit.toString()).toString())
        }

    }

    @Test
    fun `Linear measurements construct from number extensions`() {

        assertEquals("0.5ch", 0.5.ch.toString())
        assertEquals("23cm", 23.0.cm.toString())
        assertEquals("0.1em", 0.1.em.toString())
        assertEquals("0.5ex", 0.5.ex.toString())
        assertEquals("0.5in", 0.5.inch.toString())
        assertEquals("0.5mm", 0.5.mm.toString())
        assertEquals("0.5pc", 0.5.pc.toString())
        assertEquals("0.5%", 0.5.percent.toString())
        assertEquals("0.5pt", 0.5.pt.toString())
        assertEquals("1px", 1.px.toString())
        assertEquals("0.5Q", 0.5.Q.toString())
        assertEquals("0.123rem", 0.123.rem.toString())
        assertEquals("0.5vh", 0.5.vh.toString())
        assertEquals("0.5vmax", 0.5.vmax.toString())
        assertEquals("0.5vmin", 0.5.vmin.toString())
        assertEquals("0.5vw", 0.5.vw.toString())

    }

}
