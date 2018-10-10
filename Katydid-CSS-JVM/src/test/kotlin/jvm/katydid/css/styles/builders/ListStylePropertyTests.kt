//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.blue
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.listStyle
import o.katydid.css.styles.builders.listStyleImage
import o.katydid.css.styles.builders.listStylePosition
import o.katydid.css.styles.builders.listStyleType
import o.katydid.css.styles.style
import o.katydid.css.types.EImage
import o.katydid.css.types.EListStylePosition
import o.katydid.css.types.EListStyleType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class ListStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Nested list style properties convert to correct CSS`() {

        checkStyle("list-style-image: none;") { listStyle { image(EImage.none) } }
        checkStyle("list-style-image: url(\"http://myimage.jpg\");") {
            listStyle { image(EImage.url("http://myimage.jpg")) }
        }
        checkStyle("list-style-image: image(\"http://myimage.jpg\", blue);") {
            listStyle { image(EImage.image("http://myimage.jpg", color = blue)) }
        }

        checkStyle("list-style-position: inside;") { listStyle { position(EListStylePosition.inside) } }

        checkStyle("list-style-type: armenian;") { listStyle { type(EListStyleType.armenian) } }

    }

    @Test
    fun `List style properties convert to correct CSS`() {

        checkStyle("list-style-image: none;") { listStyleImage(EImage.none) }
        checkStyle("list-style-image: url(\"http://myimage.jpg\");") {
            listStyleImage(EImage.url("http://myimage.jpg"))
        }
        checkStyle("list-style-image: image(\"http://myimage.jpg\", blue);") {
            listStyleImage(EImage.image("http://myimage.jpg", color = blue))
        }

        checkStyle("list-style-position: inside;") { listStylePosition(EListStylePosition.inside) }
        checkStyle("list-style-position: outside;") { listStylePosition(EListStylePosition.outside) }

        checkStyle("list-style-type: armenian;") { listStyleType(EListStyleType.armenian) }
        checkStyle("list-style-type: circle;") { listStyleType(EListStyleType.circle) }
        checkStyle("list-style-type: decimal;") { listStyleType(EListStyleType.decimal) }
        checkStyle("list-style-type: decimal-leading-zero;") { listStyleType(EListStyleType.decimalLeadingZero) }
        checkStyle("list-style-type: disc;") { listStyleType(EListStyleType.disc) }
        checkStyle("list-style-type: georgian;") { listStyleType(EListStyleType.georgian) }
        checkStyle("list-style-type: lower-greek;") { listStyleType(EListStyleType.lowerGreek) }
        checkStyle("list-style-type: lower-latin;") { listStyleType(EListStyleType.lowerLatin) }
        checkStyle("list-style-type: lower-roman;") { listStyleType(EListStyleType.lowerRoman) }
        checkStyle("list-style-type: square;") { listStyleType(EListStyleType.square) }
        checkStyle("list-style-type: upper-latin;") { listStyleType(EListStyleType.upperLatin) }
        checkStyle("list-style-type: upper-roman;") { listStyleType(EListStyleType.upperRoman) }
        checkStyle("list-style-type: lower-latin;") { listStyleType(EListStyleType.lowerAlpha) }
        checkStyle("list-style-type: upper-latin;") { listStyleType(EListStyleType.upperAlpha) }

        checkStyle("list-style: square;") { listStyle(EListStyleType.square) }
        checkStyle("list-style: square outside;") { listStyle(EListStyleType.square, EListStylePosition.outside) }
        checkStyle("list-style: square outside url(\"images/image.jpg\");") { listStyle(EListStyleType.square, EListStylePosition.outside, "images/image.jpg") }

    }

}

//---------------------------------------------------------------------------------------------------------------------

