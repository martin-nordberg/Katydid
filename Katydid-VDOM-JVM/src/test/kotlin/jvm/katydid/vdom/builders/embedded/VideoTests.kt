//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.embedded

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.ECorsSetting.anonymous
import o.katydid.vdom.types.EPreloadHint.auto
import o.katydid.vdom.types.ETrackKind.subtitles
import o.katydid.vdom.types.FlowContent
import o.katydid.vdom.types.MimeType
import o.katydid.vdom.types.PhrasingContent
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class VideoTests {

    @Test
    fun `A video element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            video(
                "#myvideo.annoying",
                autoplay = true,
                controls = true,
                crossorigin = anonymous,
                height = 120,
                loop = true,
                muted = true,
                poster = "http://poster/path",
                preload = auto,
                src = "http://someurl/path",
                width = 99,
                contentType = PhrasingContent
            ) {}

        }

        val html =
            """<video autoplay="" class="annoying" controls="" crossorigin="anonymous" height="120" id="myvideo" loop="" muted="" poster="http://poster/path" preload="auto" src="http://someurl/path" width="99"></video>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A video element with nested elements produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            video(contentType = FlowContent) {

                source(
                    media = "mediastuff",
                    sizes = "some sizes",
                    src = "http://somewhere/audiopath",
                    srcset = "sources",
                    type = MimeType("video", "jpeg")
                ) {}

                track(
                    default = true,
                    kind = subtitles,
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

            katydid<Unit> {
                video {
                    audio {}
                }
            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {
                video {
                    video {}
                }
            }

        }

    }

    @Test
    fun `A video element with src attribute may not contain source elements`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {
                video(src = "http://url") {
                    source(src = "http://url2") {}
                }
            }

        }

    }

    @Test
    fun `A video element must have its source elements before any track elements`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                video(src = "http://url") {
                    track(src = "http://trackurl") {}
                    source(src = "http://url2") {}
                }

            }

        }

    }

}