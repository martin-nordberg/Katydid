//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class FieldSetTests {

    @Test
    fun `A fieldset element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            fieldset(disabled=true,form="SomeForm",name="bunch o'fields") {

                legend {
                    text("This is the field set")
                }

            }

        }

        val html = """<fieldset disabled="" form="SomeForm" name="bunch o'fields">
                     |  <legend>
                     |    This is the field set
                     |  </legend>
                     |</fieldset>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A fieldset may not have two legends`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                fieldset {

                    legend {}

                    legend {}

                }

            }

        }

    }

    @Test
    fun `A legend must be nested inside a fieldset`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                legend {}

            }

        }

    }

}