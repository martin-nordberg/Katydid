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
class ProgressTests {

    @Test
    fun `A progress element with floating point attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {

                progress(
                    max = 100.0,
                    value = 40.0
                ) {}

            }

        }

        val html = """<form>
                     |  <progress max="100.0" value="40.0"></progress>
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A progress element with integer attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {

                progress(
                    max = 100,
                    value = 40
                ) {}

            }

        }

        val html = """<form>
                     |  <progress max="100" value="40"></progress>
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A progress element may not be nested`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                progress(value = 0.5) {
                    progress(value = 0.2) {}
                }

            }

        }

    }

    @Test
    fun `A progress element's max must be greater than zero`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                progress(value = 5, max = 0) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                progress(value = 0.5, max = -100.0) {}
            }

        }

    }

    @Test
    fun `A progress element's value must be in its default range`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                progress(value = 1.1) {}
            }

        }

    }

    @Test
    fun `A progress element's value must be in range`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                progress(max = 100, value = 110) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                progress(max = 100.0, value = 101.0) {}
            }

        }

    }

}
