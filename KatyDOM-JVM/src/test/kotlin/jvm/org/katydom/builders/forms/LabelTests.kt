//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.forms

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class LabelTests {

    @Test
    fun `A label element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            form {

                label( `for`="input1" ) {
                    inputText("#input1", name="myinput") {}
                }

            }

        }

        val html = """<form>
                     |  <label for="input1">
                     |    <input id="input1" name="myinput" type="text">
                     |  </label>
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A label may not be nested`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                label {

                    label {}

                }

            }

        }

    }

}