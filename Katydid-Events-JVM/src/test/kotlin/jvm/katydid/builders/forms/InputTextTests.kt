//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.forms

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class InputTextTests {

    @Test
    fun `A text input element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {

                inputText(
                    autocomplete = "mystuff",
                    autofocus = true,
                    dirname="direction",
                    disabled = true,
                    form = "myform",
                    list = "somelist",
                    maxlength = 50,
                    minlength = 5,
                    name = "myfield",
                    pattern = ".*",
                    placeholder = "Enter a name",
                    readonly = true,
                    required = true,
                    size = 30,
                    value = "wonderful text"
                ) {}

            }

        }

        val html = """<form>
                     |  <input autocomplete="mystuff" autofocus="" dirname="direction" disabled="" form="myform" list="somelist" maxlength="50" minlength="5" name="myfield" pattern=".*" placeholder="Enter a name" readonly="" required="" size="30" type="text" value="wonderful text">
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A text input's minlength-maxlength range must be consistent`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                inputText(minlength = 100, maxlength = 90, value = "stuff") {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                inputText(minlength = -1) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                inputText(maxlength = -1) {}
            }

        }

    }

    @Test
    fun `A text input's size must be greater than zero`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                inputText(size = 0) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                inputText(size = -1) {}
            }

        }

    }

}
