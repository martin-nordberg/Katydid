//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.EButtonType.submit
import o.katydid.vdom.types.EFormEncodingType.wwwFormUrlEncoded
import o.katydid.vdom.types.EFormSubmissionMethod.post
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class ButtonTests {

    @Test
    fun `A button element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {

                button(
                    autofocus = true,
                    disabled = true,
                    form = "SomeForm",
                    formaction = "http://myform/url",
                    formenctype = wwwFormUrlEncoded,
                    formmethod = post,
                    formnovalidate = true,
                    formtarget = "_blank",
                    name = "GreatButton",
                    type = submit,
                    value = "TheButton"
                ) {
                    span {
                        text("Press Me")
                    }
                }

            }

        }

        val html = """<form>
                     |  <button autofocus="" disabled="" form="SomeForm" formaction="http://myform/url" formenctype="application/x-www-form-urlencoded" formmethod="post" formnovalidate="" formtarget="_blank" name="GreatButton" type="submit" value="TheButton">
                     |    <span>
                     |      Press Me
                     |    </span>
                     |  </button>
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}