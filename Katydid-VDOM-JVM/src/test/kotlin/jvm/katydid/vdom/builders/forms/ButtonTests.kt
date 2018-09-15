//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.types.EButtonType.*
import o.katydid.vdom.types.EFormEncodingType.*
import o.katydid.vdom.types.EFormSubmissionMethod.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `A button may not contain interactive content`() {

        fun checkInteractiveContentDisallowed(
            defineContent: KatydidPhrasingContentBuilder<Unit>.() -> Unit
        ) {

            assertThrows<IllegalStateException> {

                katydid<Unit> {
                    button(defineContent = defineContent)
                }

            }

        }

        checkInteractiveContentDisallowed {
            a(href = "https://somewhere/path") {}
        }

        checkInteractiveContentDisallowed {
            button {}
        }

        checkInteractiveContentDisallowed {
            inputButton {}
        }

        checkInteractiveContentDisallowed {
            inputCheckbox {}
        }

        checkInteractiveContentDisallowed {
            inputColor {}
        }

        checkInteractiveContentDisallowed {
            inputDate {}
        }

        checkInteractiveContentDisallowed {
            inputDateTimeLocal {}
        }

        checkInteractiveContentDisallowed {
            inputEmail {}
        }

        checkInteractiveContentDisallowed {
            inputFile {}
        }

        checkInteractiveContentDisallowed {
            inputImageButton(src = "bogus") {}
        }

        checkInteractiveContentDisallowed {
            inputMonth {}
        }

        checkInteractiveContentDisallowed {
            inputPassword {}
        }

        checkInteractiveContentDisallowed {
            inputRadioButton {}
        }

        checkInteractiveContentDisallowed {
            inputRange<Int> {}
        }

        checkInteractiveContentDisallowed {
            inputResetButton {}
        }

        checkInteractiveContentDisallowed {
            inputSearch {}
        }

        checkInteractiveContentDisallowed {
            inputSubmitButton {}
        }

        checkInteractiveContentDisallowed {
            inputTelephone {}
        }

        checkInteractiveContentDisallowed {
            inputText {}
        }

        checkInteractiveContentDisallowed {
            inputTime {}
        }

        checkInteractiveContentDisallowed {
            inputUrl {}
        }

        checkInteractiveContentDisallowed {
            inputWeek {}
        }

        checkInteractiveContentDisallowed {
            label {}
        }

        checkInteractiveContentDisallowed {
            select {}
        }

        checkInteractiveContentDisallowed {
            textarea {}
        }

    }

}