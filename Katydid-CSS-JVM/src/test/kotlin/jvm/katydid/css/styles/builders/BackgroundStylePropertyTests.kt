//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.aquamarine
import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EAttachment
import o.katydid.css.types.EBackgroundPosition.*
import o.katydid.css.types.EImage
import o.katydid.css.types.ERepeatStyle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class BackgroundStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Background style properties convert to correct CSS`() {

        // TODO: background

        checkStyle("background-attachment: fixed;") { backgroundAttachment(EAttachment.fixed) }
        checkStyle("background-attachment: scroll, local;") { backgroundAttachment(EAttachment.scroll, EAttachment.local) }

        checkStyle("background-color: aquamarine;") { backgroundColor(aquamarine) }

        checkStyle("background-image: none;") { backgroundImage(EImage.none) }
        checkStyle("background-image: url(\"http://myimage.jpg\");") { backgroundImage(EImage.url("http://myimage.jpg")) }
        checkStyle("background-image: url(\"images/1.jpg\"), url(\"images/2.jpg\");") { backgroundImage(EImage.url("images/1.jpg"), EImage.url("images/2.jpg")) }
        checkStyle("background-image: url(\"images/1.jpg\"), none;") { backgroundImage(EImage.url("images/1.jpg"), EImage.none) }

        checkStyle("background-position: center center;") { backgroundPosition(center) }
        checkStyle("background-position: left top;") { backgroundPosition(left, top) }
        checkStyle("background-position: right bottom;") { backgroundPosition(right, bottom) }
        checkStyle("background-position: 50% center;") { backgroundPosition(50.percent) }
        checkStyle("background-position: 50% 75%;") { backgroundPosition(50.percent, 75.percent) }
        checkStyle("background-position: 100px center;") { backgroundPosition(100.px) }
        checkStyle("background-position: 10px 20px;") { backgroundPosition(10.px, 20.px) }
        checkStyle("background-position: left 50% bottom 75%;") { backgroundPosition(left, 50.percent, bottom, 75.percent) }
        checkStyle("background-position: left 2px bottom -5px;") { backgroundPosition(left, 2.px, bottom, (-5).px) }

        checkStyle("background-repeat: repeat;") { backgroundRepeat(ERepeatStyle.repeat) }
        checkStyle("background-repeat: repeat-x;") { backgroundRepeat(ERepeatStyle.repeatX) }
        checkStyle("background-repeat: repeat-y;") { backgroundRepeat(ERepeatStyle.repeatY) }
        checkStyle("background-repeat: no-repeat;") { backgroundRepeat(ERepeatStyle.noRepeat) }
        checkStyle("background-repeat: round space;") { backgroundRepeat(ERepeatStyle.round, ERepeatStyle.space) }
        checkStyle("background-repeat: round space, repeat no-repeat;") {
            backgroundRepeat(Pair(ERepeatStyle.round, ERepeatStyle.space), Pair(ERepeatStyle.repeat, ERepeatStyle.noRepeat))
        }
        assertFailsWith<IllegalArgumentException> { checkStyle("throws") { backgroundRepeat(ERepeatStyle.repeatX, ERepeatStyle.repeat) } }
        assertFailsWith<IllegalArgumentException> { checkStyle("throws") { backgroundRepeat(ERepeatStyle.repeatY, ERepeatStyle.repeat) } }
        assertFailsWith<IllegalArgumentException> { checkStyle("throws") { backgroundRepeat(Pair(ERepeatStyle.repeatX, ERepeatStyle.repeat)) } }

    }

    @Test
    fun `Nested background style properties convert to correct CSS`() {

        checkStyle("background-attachment: fixed;") { background { attachment(EAttachment.fixed) } }

        checkStyle("background-color: aquamarine;") { background { color(aquamarine) } }

        checkStyle("background-image: none;") { background { image(EImage.none) } }
        checkStyle("background-image: url(\"images/1.jpg\"), url(\"images/2.jpg\");") { background { image(EImage.url("images/1.jpg"), EImage.url("images/2.jpg")) } }
        checkStyle("background-image: url(\"images/1.jpg\"), none;") { background { image(EImage.url("images/1.jpg"), EImage.none) } }

        checkStyle("background-position: center center;") { background { position(center) } }
        checkStyle("background-position: left top;") { background { position(left, top) } }
        checkStyle("background-position: 50% center;") { background { position(50.percent) } }
        checkStyle("background-position: 50% 75%;") { background { position(50.percent, 75.percent) } }
        checkStyle("background-position: 100px center;") { background { position(100.px) } }
        checkStyle("background-position: 10px 20px;") { background { position(10.px, 20.px) } }
        checkStyle("background-position: left 50% bottom 75%;") { background { position(left, 50.percent, bottom, 75.percent) } }
        checkStyle("background-position: left 2px bottom -5px;") { background { position(left, 2.px, bottom, (-5).px) } }

        checkStyle("background-repeat: repeat;") { background { repeat(ERepeatStyle.repeat) } }
        checkStyle("background-repeat: round space;") { background { repeat(ERepeatStyle.round, ERepeatStyle.space) } }
        checkStyle("background-repeat: round space, repeat no-repeat;") {
            background { repeat(Pair(ERepeatStyle.round, ERepeatStyle.space), Pair(ERepeatStyle.repeat, ERepeatStyle.noRepeat)) }
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

