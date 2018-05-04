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
class FigureTests {

    @Test
    fun `A simple figure produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            figure( "#notmuch2it") {

                pre {
                    text( "Some preformatted code\n    covering two lines")
                }

                figCaption {
                    text( "This is a figure" )
                }

            }

        }

        val html = """<figure id="notmuch2it">
                     |  <pre>
                     |    Some preformatted code
                     |    covering two lines
                     |  </pre>
                     |  <figcaption>
                     |    This is a figure
                     |  </figcaption>
                     |</figure>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A figcaption cannot appear outside a figure`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                figCaption { }

            }

        }

    }

    @Test
    fun `A figure can have only one figcaption`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                figure {

                    figCaption { }
                    figCaption { }

                }

            }

        }

    }

    @Test
    fun `A figure can have only one figcaption even if one is nested`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                figure {

                    figCaption { }

                    div {
                        figCaption { }
                    }

                }

            }

        }


    }

    @Test
    fun `A figure can have only one figcaption even if both are nested`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                figure {

                    div {
                        figCaption { }
                    }

                    div {
                        figCaption { }
                    }

                }

            }

        }

    }

    @Test
    fun `A figure can have a nested figure with a nested caption`() {

        val vdomNode = katyDom<Unit> {

            figure {

                figCaption { text( "Outer" ) }

                figure {
                    figCaption { text( "Inner") }
                }

            }

        }

        val html = """<figure>
                     |  <figcaption>
                     |    Outer
                     |  </figcaption>
                     |  <figure>
                     |    <figcaption>
                     |      Inner
                     |    </figcaption>
                     |  </figure>
                     |</figure>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}