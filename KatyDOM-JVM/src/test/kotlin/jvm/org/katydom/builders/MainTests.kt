//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class MainTests {

    @Test
    fun `A main element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            main( "#mine.stuff" ) {

            }

        }

        val html = """<main class="stuff" id="mine"></main>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A main element may not be nested`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                main {
                    main {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

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

            katyDom<Unit> {

                article {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                aside {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                footer {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                header {

                    div {
                        main {}
                    }

                }

            }

        }

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                nav {

                    div {
                        main {}
                    }

                }

            }

        }

    }

}