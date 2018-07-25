//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.sections

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class FooterTests {

    @Test
    fun `A footer element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            footer {

                span {
                    text("My Foot")
                }

            }

        }

        val html = """<footer>
                     |  <span>
                     |    My Foot
                     |  </span>
                     |</footer>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A footer element may not be nested`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                footer {
                    footer {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                footer {

                    div {
                        footer {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                header {

                    div {
                        footer {}
                    }

                }

            }

        }

    }

}