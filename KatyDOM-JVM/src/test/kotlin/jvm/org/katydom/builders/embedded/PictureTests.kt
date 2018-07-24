//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.embedded

import jvm.org.katydom.api.checkBuild
import o.org.katydom.application.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class PictureTests {

    @Test
    fun `A picture element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            picture(
                "#mypicture.funky"
            ) {
                source(key = 1, src = "http://somewhere") {}
                source(key = 2, src = "http://elsewhere") {}
                img(alt = "Cats!") {}
            }

        }

        val html = """<picture class="funky" id="mypicture">
                     |  <source src="http://somewhere">
                     |  <source src="http://elsewhere">
                     |  <img alt="Cats!">
                     |</picture>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A picture must have a source element or img src attribute`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                picture {
                    img(alt = "Kittens") {}
                }

            }

        }

    }

    @Test
    fun `A picture must have source elements before img elements`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                picture {
                    img(alt = "Kittens", src = "myurl") {}
                    source(src = "bogus") {}
                }

            }

        }

    }

}