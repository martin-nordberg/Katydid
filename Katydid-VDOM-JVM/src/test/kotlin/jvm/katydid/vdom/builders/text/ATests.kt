//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.text

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.EAnchorHtmlLinkType
import o.katydid.vdom.types.FlowContent
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class ATests {

    @Test
    fun `An anchor element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            a(
                download = "downloadedfile.html",
                href = "http:/somewhere/afile",
                hreflang = "EN",
                rel = listOf(EAnchorHtmlLinkType.next),
                rev = listOf(EAnchorHtmlLinkType.prev),
                target = "nastypopup",
                type = "whatever"
            ) {
                span {
                    text("Click Me")
                }
            }

        }

        val html = """
                   |<a download="downloadedfile.html" href="http:/somewhere/afile" hreflang="EN" rel="next" rev="prev" target="nastypopup" type="whatever">
                   |  <span>
                   |    Click Me
                   |  </span>
                   |</a>
                   """.trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An anchor element can have flow content`() {

        val vdomNode = katydid<Unit> {

            a(
                href = "http:/somewhere/afile",
                contentType = FlowContent
            ) {
                div {
                    +"Click Me"
                }
            }

        }

        val html = """
                   |<a href="http:/somewhere/afile">
                   |  <div>
                   |    Click Me
                   |  </div>
                   |</a>
                   """.trimMargin()

        checkBuild(html, vdomNode)

    }

}