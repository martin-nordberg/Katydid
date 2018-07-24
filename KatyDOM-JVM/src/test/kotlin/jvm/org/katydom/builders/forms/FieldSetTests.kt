//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.forms

import jvm.org.katydom.api.checkBuild
import o.org.katydom.application.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class FieldSetTests {

    @Test
    fun `A fieldset element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

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

            katyDom<Unit> {

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

            katyDom<Unit> {

                legend {}

            }

        }

    }

}