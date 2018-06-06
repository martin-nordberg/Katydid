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

}