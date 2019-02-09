//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.embedded

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.EReferrerPolicy.origin
import o.katydid.vdom.types.ESandboxOption.allowForms
import o.katydid.vdom.types.ESandboxOption.allowPopups
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
                referrerpolicy = origin,
                sandbox = listOf(allowForms, allowPopups),
                src = "http://someurl/path",
                srcdoc = "stuff",
                width = 99
            ) {}

        }

        val html =
            """<iframe allowfullscreen="" allowpaymentrequest="" class="framed" height="120" id="myeye" name="myframe" referrerpolicy="origin" sandbox="allow-forms allow-popups" src="http://someurl/path" srcdoc="stuff" width="99"></iframe>"""

        checkBuild(html, vdomNode)

    }

}

