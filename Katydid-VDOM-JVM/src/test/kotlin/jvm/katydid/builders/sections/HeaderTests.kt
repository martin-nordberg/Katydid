//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.sections

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class HeaderTests {

    @Test
    fun `A header element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            header {

                span {
                    text("My Head")
                }

            }

        }

        val html = """<header>
                     |  <span>
                     |    My Head
                     |  </span>
                     |</header>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A header element may not be nested`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                header {
                    header {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                header {

                    div {
                        header {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                footer {

                    div {
                        header {}
                    }

                }

            }

        }

    }

}