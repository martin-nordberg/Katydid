//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.interactive

import o.katydid.vdom.application.katydid
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class InteractiveContentPreventionTests {

    private fun checkInteractiveContentDisallowed(
        defineContent: KatydidPhrasingContentBuilder<Unit>.() -> Unit
    ) {

        fun check(defineContentWithInteractiveContentDisallowed : KatydidFlowContentBuilder<Unit>.() -> Unit ) {

            assertThrows<IllegalStateException> {
                katydid<Unit>(defineContent = defineContentWithInteractiveContentDisallowed)
            }

        }

        check {
            a(defineContent = defineContent)
        }

        check {
            button(defineContent = defineContent)
        }

    }

    @Test
    fun `Some elements may not contain interactive content`() {

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