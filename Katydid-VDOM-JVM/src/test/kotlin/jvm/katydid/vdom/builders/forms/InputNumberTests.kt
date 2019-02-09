//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class InputNumberTests {

    @Test
    fun `A floating point number input element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {
                inputNumber(
                    autocomplete = "mystuff",
                    autofocus = true,
                    disabled = true,
                    form = "myform",
                    list = "somelist",
                    max = 100.0,
                    min = 50.0,
                    name = "myfield",
                    placeholder = "Enter a number",
                    readonly = true,
                    required = true,
                    step = 2.0,
                    value = 40.0
                ) {}
            }

        }

        val html = """<form>
                     |  <input autocomplete="mystuff" autofocus="" disabled="" form="myform" list="somelist" max="100.0" min="50.0" name="myfield" placeholder="Enter a number" readonly="" required="" step="2.0" type="number" value="40.0">
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An integer number input element with all its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {
                inputNumber(
                    autocomplete = "mystuff",
                    autofocus = true,
                    disabled = true,
                    form = "myform",
                    list = "somelist",
                    max = 100,
                    min = 50,
                    name = "myfield",
                    placeholder = "Enter a number",
                    readonly = true,
                    required = true,
                    step = 2,
                    value = 40
                ) {}
            }

        }

        val html = """<form>
                     |  <input autocomplete="mystuff" autofocus="" disabled="" form="myform" list="somelist" max="100" min="50" name="myfield" placeholder="Enter a number" readonly="" required="" step="2" type="number" value="40">
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A number input's min-max range must be consistent`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                inputNumber(min = 100.0, max = 90.0, value = 95.0) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                inputNumber(min = 100, max = 90, value = 95) {}
            }

        }

    }

}
