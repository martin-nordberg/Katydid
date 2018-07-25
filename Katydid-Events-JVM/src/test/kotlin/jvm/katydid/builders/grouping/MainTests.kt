//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.grouping

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class MainTests {

    @Test
    fun `A main element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            main("#mine.stuff") {

            }

        }

        val html = """<main class="stuff" id="mine"></main>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A main element may not be nested`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                main {
                    main {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                main {

                    ol {

                        li {
                            main {}
                        }

                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                article {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                aside {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                footer {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                header {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                nav {

                    div {
                        main {}
                    }

                }

            }

        }

    }

}