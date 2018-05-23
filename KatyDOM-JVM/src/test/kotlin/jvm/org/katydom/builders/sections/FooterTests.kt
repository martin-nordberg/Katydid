//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.sections

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class FooterTests {

    @Test
    fun `A footer element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

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

            katyDom<Unit> {

                footer {
                    footer {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                footer {

                    div {
                        footer {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                header {

                    div {
                        footer {}
                    }

                }

            }

        }

    }

}