//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.text

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.EDirection
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class GlobalAttributeTests {

    @Test
    fun `A span element with all global attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            span(
                selector = "#aspan.withclass",
                key = "key",
                accesskey = 'S',
                contenteditable = true,
                dir = EDirection.LEFT_TO_RIGHT,
                hidden = true,
                lang = "EN",
                spellcheck = true,
                style = "font-weight:bold;",
                tabindex = 1,
                title = "My Span",
                translate = true
            ) {

            }

        }

        val html = """<span accesskey="S" class="withclass" contenteditable="true" dir="ltr" hidden="" id="aspan" lang="EN" spellcheck="true" style="font-weight:bold;" tabindex="1" title="My Span" translate="yes"></span>"""

        checkBuild(html, vdomNode)

    }

}

