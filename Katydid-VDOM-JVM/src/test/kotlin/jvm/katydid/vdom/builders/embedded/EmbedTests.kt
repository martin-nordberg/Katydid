//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.embedded

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.MimeType
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class EmbedTests {

    @Test
    fun `An embed element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            embed(
                "#mything.embedded",
                height = 120,
                src = "http://someurl/path",
                type = MimeType.fromString("application/whatever"),
                width = 99
            ) {}

        }

        val html = """<embed class="embedded" height="120" id="mything" src="http://someurl/path" type="application/whatever" width="99"></embed>"""

        checkBuild(html, vdomNode)

    }

}