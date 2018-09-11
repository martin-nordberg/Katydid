//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

@Suppress("RemoveRedundantBackticks")
class LabelTests {

    @Test
    fun `A label element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {

                label(`for` = "input1") {
                    inputText("#input1", name = "myinput") {}
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

            katydid<Unit> {

                label {

                    label {}

                }

            }

        }

    }

    @Test
    fun `A label can have its key taken from its _for_ attribute`() {

        val element = katydid<Unit> {

            label(`for` = "sample") {}

        }

        assertEquals("sample-label", element.key)

    }

}