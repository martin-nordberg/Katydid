//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.forms

import jvm.org.katydom.api.checkBuild
import o.org.katydom.application.katyDom
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.types.EButtonType
import o.org.katydom.types.EFormEncodingType
import o.org.katydom.types.EFormSubmissionMethod
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class ButtonTests {

    @Test
    fun `A button element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            form {

                button(
                    autofocus=true,
                    disabled=true,
                    form="SomeForm",
                    formaction="http://myform/url",
                    formenctype=EFormEncodingType.WWW_FORM_URL_ENCODED,
                    formmethod=EFormSubmissionMethod.POST,
                    formnovalidate=true,
                    formtarget="_blank",
                    name="GreatButton",
                    type=EButtonType.SUBMIT,
                    value="TheButton"
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
            defineContent: KatyDomPhrasingContentBuilder<Unit>.() -> Unit
        ) {

            assertThrows<IllegalStateException> {

                katyDom<Unit> {
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