//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.measurements

import o.katydid.css.measurements.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class BoxSizeTests {

    @Test
    fun `Box measurements convert to strings`() {

        assertEquals("0", BoxSize(0.px).toString())
        assertEquals("0", BoxSize(0.px, 0.px).toString())
        assertEquals("1px 2px", BoxSize(1.px, 2.px).toString())
        assertEquals("1px 2px", BoxSize(1.px, 2.px, 1.px, 2.px).toString())
        assertEquals("1px 2px 3px", BoxSize(1.px, 2.px, 3.px).toString())
        assertEquals("1px 2px 3px", BoxSize(1.px, 2.px, 3.px, 2.px).toString())
        assertEquals("1px 2px 3px 4px", BoxSize(1.px, 2.px, 3.px, 4.px).toString())

    }

    @Test
    fun `Box measurements convert from strings`() {

        assertEquals("0", box("0").toString())
        assertEquals("0", box("0px").toString())
        assertEquals("1em 2em", box("1em 2em").toString())
        assertEquals("1em 2em", box("1em 2em 1em 2em").toString())
        assertEquals("1px 2px 3px", box("1 2 3").toString())
        assertEquals("1px 2px 3px 4px", box("1 2 3 4").toString())

    }

    @Test
    fun `Box measurements construct from individual measurements`() {

        assertEquals("0", box(0).toString())
        assertEquals("0", box(0.px).toString())
        assertEquals("1px 2px", box(1.px, 2).toString())
        assertEquals("1px 2px 3px", box(1.px, 2.px, 3.px).toString())
        assertEquals("1px 2px 3px 4px", box(1.px, 2.px, 3.px, 4.px).toString())

    }

}
