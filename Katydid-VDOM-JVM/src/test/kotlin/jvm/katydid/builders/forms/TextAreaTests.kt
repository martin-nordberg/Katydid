//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.forms

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katyDom
import o.katydid.vdom.types.EWrapType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class TextAreaTests {

    @Test
    fun `A textarea element with all its attributes produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            form {

                textarea(
                    autocomplete = "mystuff",
                    autofocus = true,
                    cols = 50,
                    dirname="direction",
                    disabled = true,
                    form = "myform",
                    maxlength = 50,
                    minlength = 5,
                    name = "myfield",
                    placeholder = "Enter a name",
                    readonly = true,
                    required = true,
                    rows = 3,
                    wrap = EWrapType.SOFT
                ) {
                    text("My long field value")
                }

            }

        }

        val html = """<form>
                     |  <textarea autocomplete="mystuff" autofocus="" cols="50" dirname="direction" disabled="" form="myform" maxlength="50" minlength="5" name="myfield" placeholder="Enter a name" readonly="" required="" rows="3" wrap="soft">
                     |    My long field value
                     |  </textarea>
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A textarea's minlength-maxlength range must be consistent`() {

        assertThrows<IllegalArgumentException> {

            katyDom<Unit> {
                textarea(minlength = 100, maxlength = 90) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katyDom<Unit> {
                textarea(minlength = -1) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katyDom<Unit> {
                textarea(maxlength = -1) {}
            }

        }

    }

}
