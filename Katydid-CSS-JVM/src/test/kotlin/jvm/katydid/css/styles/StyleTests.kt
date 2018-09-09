//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles

import o.katydid.css.colors.blue
import o.katydid.css.colors.rgb
import o.katydid.css.measurements.*
import o.katydid.css.styles.style
import o.katydid.css.types.EDisplayOption
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class StyleTests {

    @Test
    fun `Styles construct and convert to strings`() {

        var s = style {
            height = 23.px
            width = 45.px
        }
        assertEquals("height: 23px; width: 45px;", "$s")

        s = style {
            width = 45.px
            height = 23.px
            color = blue
        }
        assertEquals("width: 45px; height: 23px; color: blue;", "$s")

        s = style {
            display = EDisplayOption.BLOCK
            color = rgb(23,45,67)
        }
        assertEquals("display: block; color: #172D43;", "$s")

        s = style {
            display = EDisplayOption.NONE; important
            color = rgb(23,45,67)
        }
        assertEquals("display: none !important; color: #172D43;", "$s")

    }


}
