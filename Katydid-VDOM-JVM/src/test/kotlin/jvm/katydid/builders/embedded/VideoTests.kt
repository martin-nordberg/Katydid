//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.embedded

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katyDom
import o.katydid.vdom.types.ECorsSetting
import o.katydid.vdom.types.EPreloadHint
import o.katydid.vdom.types.ETrackKind
import o.katydid.vdom.types.MimeType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class VideoTests {

    @Test
    fun `A video element with all its attributes produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            video(
                "#myvideo.annoying",
                autoplay = true,
                controls = true,
                crossorigin = ECorsSetting.ANONYMOUS,
                height = 120,
                loop = true,
                muted = true,
                poster = "http://poster/path",
                preload = EPreloadHint.AUTO,
                src = "http://someurl/path",
                width = 99
            ) {}

        }

        val html = """<video autoplay="" class="annoying" controls="" crossorigin="anonymous" height="120" id="myvideo" loop="" muted="" poster="http://poster/path" preload="auto" src="http://someurl/path" width="99"></video>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A video element with nested elements produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            video {

                source(
                    media = "mediastuff",
                    sizes = "some sizes",
                    src = "http://somewhere/audiopath",
                    srcset = "sources",
                    type = MimeType("video", "jpeg")
                ) {}

                track(
                    default = true,
                    kind = ETrackKind.SUBTITLES,
                    label = "My Track",
                    src = "http://somewhere/videotrack",
                    srclang = "EN"
                ) {}

            }

        }

        val html = """<video>
                     |  <source media="mediastuff" sizes="some sizes" src="http://somewhere/audiopath" srcset="sources" type="video/jpeg">
                     |  <track default="" kind="subtitles" label="My Track" src="http://somewhere/videotrack" srclang="EN">
                     |</video>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A media element may not be nested inside a video element`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {
                video {
                    audio {}
                }
            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {
                video {
                    video {}
                }
            }

        }

    }

    @Test
    fun `A video element with src attribute may not contain source elements`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {
                video(src = "http://url") {
                    source(src = "http://url2") {}
                }
            }

        }

    }

    @Test
    fun `A video element must have its source elements before any track elements`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                video(src = "http://url") {
                    track(src="http://trackurl") {}
                    source(src = "http://url2") {}
                }

            }

        }

    }

}