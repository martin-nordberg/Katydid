//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.embedded

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import o.org.katydom.types.EReferrerPolicy
import o.org.katydom.types.ESandboxOptions
import o.org.katydom.types.MimeType
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class EmbedTests {

    @Test
    fun `An embed element with all its attributes produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

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