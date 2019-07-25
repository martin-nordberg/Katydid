//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.embedded

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.MimeType
import o.katydid.vdom.types.PhrasingContent
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class ObjectTests {

    @Test
    fun `An object element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            `object`(
                "#myobject.oldfashioned",
                data = "http://thedata",
                form = "someform",
                height = 200,
                type = MimeType.fromString("application/special"),
                typemustmatch = true,
                width = 500
            ) {}

        }

        val html =
            """<object class="oldfashioned" data="http://thedata" form="someform" height="200" id="myobject" type="application/special" typemustmatch="" width="500"></object>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An object element with nested elements produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            `object` {

                param("#first"){}
                param("#second"){}

                img( src="http://animage", alt="an image"){}

            }

        }

        val html = """<object>
                     |  <param id="first"></param>
                     |  <param id="second"></param>
                     |  <img alt="an image" src="http://animage">
                     |</object>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An object element with nested phrasing elements produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            `object`(contentType = PhrasingContent) {

                param("#first"){}
                param("#second"){}

                a(href="http://gothere"){}

            }

        }

        val html = """<object>
                     |  <param id="first"></param>
                     |  <param id="second"></param>
                     |  <a href="http://gothere"></a>
                     |</object>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An object element must have all param elements before any other elements`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                `object` {

                    param("#first"){}

                    img( src="http://animage", alt="an image"){}

                    param("#second"){}

                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                `object`(contentType = PhrasingContent) {

                    param("#first"){}

                    a( href="http://gothere"){}

                    param("#second"){}

                }

            }

        }

    }


}
