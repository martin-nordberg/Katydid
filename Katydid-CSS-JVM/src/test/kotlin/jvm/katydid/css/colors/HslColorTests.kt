//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.colors

import o.katydid.css.colors.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class HslColorTests {

    @Test
    fun `HSL colors convert to strings`() {

        assertColorName("hsla(0,1,0,0.009)", hsla(0, 1f, 0f, 0.009f))
        assertColorName("hsla(0,1,0,0.099)", hsla(0, 1f, 0f, 0.099f))
        assertColorName("hsla(0,1,0,0.999)", hsla(0, 1f, 0f, 0.999f))
        assertColorName("hsl(0,0.322,0.457)", hsl(0, 0.3222f, 0.4567f))
        assertColorName("hsla(0,0.322,0.457,0.789)", hsla(0, 0.3222f, 0.4567f, 0.7891f))

    }

    @Test
    fun `HSL colors convert to name strings when relevant`() {

        useCssColorNames()

        assertColorName("black", hsl(0, 0f, 0f))
        assertColorName("white", hsl(0, 0f, 1f))
        assertColorName("red", hsl(0, 1f, 0.5f))
        assertColorName("lime", hsl(120, 1f, 0.5f))
        assertColorName("blue", hsl(240, 1f, 0.5f))
        assertColorName("yellow", hsl(60, 1f, 0.5f))
        assertColorName("silver", hsl(0, 0f, 0.752f))
        assertColorName("olive", hsl(60, 1f, 0.251f))
        assertColorName("teal", hsl(180, 1f, 0.251f))

    }

    @Test
    fun `HSL colors convert to RGB`() {

        useCssColorNames()

        assertColorName("black", hsl(0, 0f, 0f).toRgbColor())
        assertColorName("white", hsl(0, 0f, 1f).toRgbColor())
        assertColorName("red", hsl(0, 1f, 0.5f).toRgbColor())
        assertColorName("lime", hsl(120, 1f, 0.5f).toRgbColor())
        assertColorName("blue", hsl(240, 1f, 0.5f).toRgbColor())
        assertColorName("yellow", hsl(60, 1f, 0.5f).toRgbColor())
        assertColorName("silver", hsl(0, 0f, 0.752f).toRgbColor())
        assertColorName("olive", hsl(60, 1f, 0.251f).toRgbColor())
        assertColorName("teal", hsl(180, 1f, 0.251f).toRgbColor())

    }

    @Test
    fun `HSL hues are modulo 360`() {

        useCssColorNames()

        assertColorName("hsl(120,1,0.6)", hsl(480, 1f, 0.6f))
        assertColorName("hsl(240,1,0.6)", hsl(600, 1f, 0.6f))

        assertColorName("black", hsl(360, 0f, 0f).toRgbColor())
        assertColorName("white", hsl(720, 0f, 1f).toRgbColor())
        assertColorName("red", hsl(1080, 1f, 0.5f).toRgbColor())
        assertColorName("lime", hsl(480, 1f, 0.5f).toRgbColor())
        assertColorName("blue", hsl(600, 1f, 0.5f).toRgbColor())
        assertColorName("yellow", hsl(420, 1f, 0.5f).toRgbColor())
        assertColorName("silver", hsl(720, 0f, 0.752f).toRgbColor())
        assertColorName("olive", hsl(-300, 1f, 0.251f).toRgbColor())
        assertColorName("teal", hsl(-180, 1f, 0.251f).toRgbColor())

    }

    @Test
    fun `HSL colors can have their transparency changed`() {

        useCssColorNames()

        assertColorName(
            "hsla(0,1,0,0.75)",
            opacify(hsla(0, 1f, 0f, 0.5f), 0.25f)
        )
        assertColorName(
            "hsla(0,1,0,0.25)",
            transparentize(hsla(0, 1f, 0f, 0.5f), 0.25f)
        )

    }

    private fun assertColorName(expected: String, color: Color) {
        assertEquals(expected, color.toString())
    }

}
