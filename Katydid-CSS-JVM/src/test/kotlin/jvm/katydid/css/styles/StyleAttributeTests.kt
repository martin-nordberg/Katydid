//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles

import jvm.katydid.kdom.KDomDocument
import o.katydid.css.colors.red
import o.katydid.css.measurements.px
import o.katydid.css.styles.style
import o.katydid.vdom.application.katydid
import o.katydid.vdom.application.makeKatydidLifecycle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class StyleAttributeTests {

    @Test
    fun `A style attribute can be built from a CSS definition`() {

        val vdomNode = katydid<Unit> {

            span {

                style {
                    color(red)
                    width(45.px)
                }

            }

        }

        val html = """<span style="color: red; width: 45px;"></span>"""

        val body = KDomDocument().createElement("body")
        val div = body.ownerDocument.createElement("div")
        body.appendChild(div)

        makeKatydidLifecycle<Unit>().build(div, vdomNode)

        assertEquals(html, body.firstChild?.toHtmlString())

    }

}

