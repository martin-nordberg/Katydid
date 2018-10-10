//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.percent
import o.katydid.css.measurements.pt
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.style
import o.katydid.css.types.EFontSize
import o.katydid.css.types.EFontStyle
import o.katydid.css.types.EFontVariant
import o.katydid.css.types.EFontWeight
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class FontStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Nested font style properties convert to correct CSS`() {

        checkStyle("font-family: arial, helvetica, sans-serif;") { font { family("arial", "helvetica", "sans-serif") } }

        checkStyle("font-size: large;") { font { size(EFontSize.large) } }
        checkStyle("font-size: 14pt;") { font { size(14.pt) } }
        checkStyle("font-size: 90%;") { font { size(90.percent) } }

        checkStyle("font-style: normal;") { font { style(EFontStyle.normal) } }

        checkStyle("font-variant: small-caps;") { font { variant(EFontVariant.smallCaps) } }

        checkStyle("font-weight: bold;") { font { weight(EFontWeight.bold) } }

    }

    @Test
    fun `Font style properties convert to correct CSS`() {

        checkStyle("font-family: arial, helvetica, sans-serif;") { fontFamily("arial", "helvetica", "sans-serif") }
        checkStyle("font-family: \"Courier New\", serif;") { fontFamily("Courier New", "serif") }

        checkStyle("font-size: large;") { fontSize(EFontSize.large) }
        checkStyle("font-size: larger;") { fontSize(EFontSize.larger) }
        checkStyle("font-size: medium;") { fontSize(EFontSize.medium) }
        checkStyle("font-size: small;") { fontSize(EFontSize.small) }
        checkStyle("font-size: smaller;") { fontSize(EFontSize.smaller) }
        checkStyle("font-size: x-large;") { fontSize(EFontSize.xLarge) }
        checkStyle("font-size: x-small;") { fontSize(EFontSize.xSmall) }
        checkStyle("font-size: xx-large;") { fontSize(EFontSize.xxLarge) }
        checkStyle("font-size: xx-small;") { fontSize(EFontSize.xxSmall) }
        checkStyle("font-size: 14pt;") { fontSize(14.pt) }
        checkStyle("font-size: 90%;") { fontSize(90.percent) }

        checkStyle("font-style: normal;") { fontStyle(EFontStyle.normal) }
        checkStyle("font-style: italic;") { fontStyle(EFontStyle.italic) }
        checkStyle("font-style: oblique;") { fontStyle(EFontStyle.oblique) }

        checkStyle("font-variant: all-petite-caps;") { fontVariant(EFontVariant.allPetiteCaps) }
        checkStyle("font-variant: all-small-caps;") { fontVariant(EFontVariant.allSmallCaps) }
        checkStyle("font-variant: normal;") { fontVariant(EFontVariant.normal) }
        checkStyle("font-variant: petite-caps;") { fontVariant(EFontVariant.petiteCaps) }
        checkStyle("font-variant: small-caps;") { fontVariant(EFontVariant.smallCaps) }
        checkStyle("font-variant: titling-caps;") { fontVariant(EFontVariant.titlingCaps) }
        checkStyle("font-variant: unicase;") { fontVariant(EFontVariant.unicase) }

        checkStyle("font-weight: bold;") { fontWeight(EFontWeight.bold) }
        checkStyle("font-weight: bolder;") { fontWeight(EFontWeight.bolder) }
        checkStyle("font-weight: lighter;") { fontWeight(EFontWeight.lighter) }
        checkStyle("font-weight: normal;") { fontWeight(EFontWeight.normal) }
        checkStyle("font-weight: 100;") { fontWeight(EFontWeight.weight100) }
        checkStyle("font-weight: 200;") { fontWeight(EFontWeight.weight200) }
        checkStyle("font-weight: 300;") { fontWeight(EFontWeight.weight300) }
        checkStyle("font-weight: 400;") { fontWeight(EFontWeight.weight400) }
        checkStyle("font-weight: 500;") { fontWeight(EFontWeight.weight500) }
        checkStyle("font-weight: 600;") { fontWeight(EFontWeight.weight600) }
        checkStyle("font-weight: 700;") { fontWeight(EFontWeight.weight700) }
        checkStyle("font-weight: 800;") { fontWeight(EFontWeight.weight800) }
        checkStyle("font-weight: 900;") { fontWeight(EFontWeight.weight900) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

