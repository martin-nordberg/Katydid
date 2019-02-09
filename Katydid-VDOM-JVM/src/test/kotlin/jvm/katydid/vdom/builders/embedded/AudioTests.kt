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
import o.katydid.vdom.types.MimeType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class AudioTests {

    @Test
    fun `An audio element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            audio(
                "#myaudio.soothing",
                autoplay = true,
                controls = true,
                crossorigin = anonymous,
                loop = true,
                muted = true,
                preload = auto,
                src = "http://someurl/path"
            ) {}

        }

        val html =
            """<audio autoplay="" class="soothing" controls="" crossorigin="anonymous" id="myaudio" loop="" muted="" preload="auto" src="http://someurl/path"></audio>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An audio element with nested elements produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            audio {

                source(
                    media = "mediastuff",
                    sizes = "some sizes",
                    src = "http://somewhere/audiopath",
                    srcset = "sources",
                    type = MimeType.fromString("audio/mp3")
                ) {}

                track(
                    default = true,
                    kind = subtitles,
                    label = "My Track",
                    src = "http://somewhere/audiopath",
                    srclang = "EN"
                ) {}

            }

        }

        val html = """<audio>
                     |  <source media="mediastuff" sizes="some sizes" src="http://somewhere/audiopath" srcset="sources" type="audio/mp3">
                     |  <track default="" kind="subtitles" label="My Track" src="http://somewhere/audiopath" srclang="EN">
                     |</audio>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A media element may not be nested inside an audio element`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                audio {
                    audio {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                audio {
                    video {}
                }

            }

        }

    }

    @Test
    fun `An audio element with src attribute may not contain source elements`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                audio(src = "http://url") {
                    source(src = "http://url2") {}
                }

            }

        }

    }

    @Test
    fun `An audio element must have its source elements before any track elements`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                audio(src = "http://url") {
                    track(src = "http://trackurl") {}
                    source(src = "http://url2") {}
                }

            }

        }

    }

}