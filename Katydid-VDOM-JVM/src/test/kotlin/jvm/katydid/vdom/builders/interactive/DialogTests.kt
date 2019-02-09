//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.interactive

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class DialogTests {

    @Test
    fun `A dialog element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            dialog(
                "#mydialog.wonderful",
                open=true
            ) {
                text( "Not much here" )
            }

        }

        val html = """<dialog class="wonderful" id="mydialog" open="">
                     |  Not much here
                     |</dialog>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}