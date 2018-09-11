//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.EFormEncodingType
import o.katydid.vdom.types.EFormSubmissionMethod
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class FormTests {

    @Test
    fun `A form element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form(
                acceptCharset = "utf-8",
                action = "myform/post",
                autocomplete = "mystuff",
                enctype = EFormEncodingType.TEXT_PLAIN,
                method = EFormSubmissionMethod.POST,
                name = "myform",
                novalidate = true,
                target = "_blank"
            ) {
                inputText {}
            }

        }

        val html = """<form accept-charset="utf-8" action="myform/post" autocomplete="mystuff" enctype="text/plain" method="post" name="myform" novalidate="" title="_blank">
                     |  <input type="text">
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A form may not be nested`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                form {
                    form {}
                }

            }

        }

    }

}