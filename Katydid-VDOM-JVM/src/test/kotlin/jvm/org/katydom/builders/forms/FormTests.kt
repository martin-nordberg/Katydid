//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.forms

import jvm.org.katydom.api.checkBuild
import o.org.katydom.application.katyDom
import o.org.katydom.types.EFormEncodingType
import o.org.katydom.types.EFormSubmissionMethod
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class FormTests {

    @Test
    fun `A form element with all its attributes produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

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

            katyDom<Unit> {

                form {
                    form {}
                }

            }

        }

    }

}