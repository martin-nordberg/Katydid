//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.colors

import o.katydid.css.colors.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

@Suppress("RemoveRedundantBackticks")
class RgbColorTests {

    @Test
    fun `Opaque RGB colors convert to valid CSS color strings`() {

        assertColorName("#112233", rgb(0x11, 0x22, 0x33))
        assertColorName("#112233", rgba(0x11, 0x22, 0x33, 1f))

        assertColorName("#994CB2", rgb(0.6f, 0.3f, 0.7f))
        assertColorName("#994CB2", rgba(0.6f, 0.3f, 0.7f, 1f))

    }

    @Test
    fun `Transparent RGB colors convert to valid CSS color strings`() {

        assertColorName("rgba(90,80,70,0)", rgba(90, 80, 70, 0f))
        assertColorName("rgba(90,80,70,0.009)", rgba(90, 80, 70, 0.009f))
        assertColorName("rgba(90,80,70,0.01)", rgba(90, 80, 70, 0.010f))
        assertColorName("rgba(90,80,70,0.35)", rgba(90, 80, 70, 0.350f))

        assertColorName("rgba(153,76,178,0.5)", rgba(0.6f, 0.3f, 0.7f, 0.5f))

    }

    @Test
    fun `Named colors convert to valid CSS color names`() {

        assertColorName("chocolate", chocolate)
        assertColorName("lightsteelblue", lightsteelblue)
        assertColorName("lime", lime)
        assertColorName("transparent", transparent)

    }

    @Test
    fun `Unnamed colors convert to valid CSS color names when relevant`() {

        useCssColorNames()

        assertColorName("lemonchiffon", rgb(255, 250, 205))
        assertColorName("lime", rgb(0, 255, 0))
        assertColorName("palegoldenrod", rgb(238, 232, 170))
        assertColorName("transparent", rgba(0, 0, 0, 0f))

        assertColorName("red", rgb(1f, 0f, 0f))
        assertColorName("transparent", rgba(0f, 0f, 0f, 0f))

    }

    @Test
    fun `RGB colors convert to themselves`() {

        assertSame(cadetblue, cadetblue.toRgbColor())

        val color = rgba(23, 45, 67, 0.89f)
        assertSame(color, color.toRgbColor())

    }

    @Test
    fun `RGB colors construct from hex strings`() {

        assertColorName("#0000AA", Color.fromHex("#a")!!)
        assertColorName("#0055FF", Color.fromHex("5F")!!)
        assertColorName("#112233", Color.fromHex("123")!!)
        assertColorName("#112233", Color.fromHex("123f")!!)
        assertColorName("rgba(17,34,51,0.469)", Color.fromHex("1237")!!)
        assertColorName("#012233", Color.fromHex("12233")!!)
        assertColorName("#1A2B3C", Color.fromHex("1a2b3c")!!)
        assertColorName("rgba(1,34,51,0.5)", Color.fromHex("122337F")!!)
        assertColorName("rgba(17,34,51,0.5)", Color.fromHex("1122337F")!!)

    }

    @Test
    fun `RGB colors can have their transparency changed`() {

        assertColorName(
            "rgba(1,34,51,0.75)",
            opacify(rgba(1, 34, 51, 0.5f), 0.25f)
        )
        assertColorName(
            "rgba(1,34,51,0.25)",
            transparentize(rgba(1, 34, 51, 0.5f), 0.25f)
        )

    }

    private fun assertColorName(expected: String, color: Color) {
        assertEquals(expected, color.toString())
    }

}
