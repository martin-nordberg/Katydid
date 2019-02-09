//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.embedded

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.FlowContent
import o.katydid.vdom.types.PhrasingContent
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class CanvasTests {

    @Test
    fun `A canvas element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            canvas(
                "#mycanvas.drawonit",
                height = 120,
                width = 99
            ) {}

        }

        val html =
            """<canvas class="drawonit" height="120" id="mycanvas" width="99"></canvas>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A canvas element can include flow content`() {

        val vdomNode = katydid<Unit> {

            canvas(
                "#mycanvas.drawonit",
                height = 120,
                width = 99,
                contentType = FlowContent
            ) {
                div("#mydiv") {}
            }

        }

        val html =
            """
            |<canvas class="drawonit" height="120" id="mycanvas" width="99">
            |  <div id="mydiv"></div>
            |</canvas>
            """.trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A canvas element can include phrasing content`() {

        val vdomNode = katydid<Unit> {

            canvas(
                "#mycanvas.drawonit",
                height = 120,
                width = 99,
                contentType = PhrasingContent
            ) {
                a( href="http://nowhere/gone") {}
            }

        }

        val html =
            """
                |<canvas class="drawonit" height="120" id="mycanvas" width="99">
                |  <a href="http://nowhere/gone"></a>
                |</canvas>
            """.trimMargin()

        checkBuild(html, vdomNode)

    }

}