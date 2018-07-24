//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.embedded

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.EReferrerPolicy
import o.katydid.vdom.types.ESandboxOptions
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class IframeTests {

    @Test
    fun `An iframe element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            iframe(
                "#myeye.framed",
                allowfullscreen = true,
                allowpaymentrequest = true,
                height = 120,
                name = "myframe",
                referrerpolicy = EReferrerPolicy.ORIGIN,
                sandbox = listOf(ESandboxOptions.ALLOW_FORMS, ESandboxOptions.ALLOW_POPUPS),
                src = "http://someurl/path",
                srcdoc = "stuff",
                width = 99
            ) {}

        }

        val html = """<iframe allowfullscreen="" allowpaymentrequest="" class="framed" height="120" id="myeye" name="myframe" referrerpolicy="origin" sandbox="allow-forms allow-popups" src="http://someurl/path" srcdoc="stuff" width="99"></iframe>"""

        checkBuild(html, vdomNode)

    }

}