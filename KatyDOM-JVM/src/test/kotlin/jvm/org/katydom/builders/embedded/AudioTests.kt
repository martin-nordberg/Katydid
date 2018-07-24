//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.embedded

import jvm.org.katydom.api.checkBuild
import o.org.katydom.application.katyDom
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EPreloadHint
import o.org.katydom.types.ETrackKind
import o.org.katydom.types.MimeType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class AudioTests {

    @Test
    fun `An audio element with all its attributes produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            audio(
                "#myaudio.soothing",
                autoplay = true,
                controls = true,
                crossorigin = ECorsSetting.ANONYMOUS,
                loop = true,
                muted = true,
                preload = EPreloadHint.AUTO,
                src = "http://someurl/path"
            ) {}

        }

        val html = """<audio autoplay="" class="soothing" controls="" crossorigin="anonymous" id="myaudio" loop="" muted="" preload="auto" src="http://someurl/path"></audio>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An audio element with nested elements produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

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
                    kind = ETrackKind.SUBTITLES,
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

            katyDom<Unit> {

                audio {
                    audio {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                audio {
                    video {}
                }

            }

        }

    }

    @Test
    fun `An audio element with src attribute may not contain source elements`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                audio(src = "http://url") {
                    source(src = "http://url2") {}
                }

            }

        }

    }

    @Test
    fun `An audio element must have its source elements before any track elements`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                audio(src = "http://url") {
                    track(src="http://trackurl") {}
                    source(src = "http://url2") {}
                }

            }

        }

    }

}