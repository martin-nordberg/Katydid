//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.text

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import o.org.katydom.types.EDirection
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class GlobalAttributeTests {

    @Test
    fun `A span element with all global attributes produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

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

