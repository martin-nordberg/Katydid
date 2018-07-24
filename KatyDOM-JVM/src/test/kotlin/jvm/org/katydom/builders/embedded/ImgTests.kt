//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.embedded

import jvm.org.katydom.api.checkBuild
import o.org.katydom.application.katyDom
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EReferrerPolicy
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class ImgTests {

    @Test
    fun `An img element with all its attributes produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            img(
                "#myimage.fancy",
                alt = "just testing",
                crossorigin = ECorsSetting.ANONYMOUS,
                height = 120,
                ismap = true,
                referrerpolicy = EReferrerPolicy.ORIGIN,
                sizes = "some sizes",
                src = "http://someurl/path",
                srcset = "source set",
                usemap = "the map",
                width = 99
            ) {}

        }

        val html = """<img alt="just testing" class="fancy" crossorigin="anonymous" height="120" id="myimage" ismap="" referrerpolicy="origin" sizes="some sizes" src="http://someurl/path" srcset="source set" usemap="the map" width="99">"""

        checkBuild(html, vdomNode)

    }

}