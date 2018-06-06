//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.embedded

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EPreloadHint
import org.junit.jupiter.api.Test

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

}