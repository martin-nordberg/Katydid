//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.sections

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class HeadingTests {

    @Test
    fun `Heading elements produce correct HTML`() {

        val vdomNode = katydid<Unit> {

            article {

                h1 {
                    text("Heading 1")
                }

                h2 {
                    text("Heading 2")
                }

                h3 {
                    text("Heading 3")
                }

                h4 {
                    text("Heading 4")
                }

                h5 {
                    text("Heading 5")
                }

                h6 {
                    text("Heading 6")
                }
            }

        }

        val html = """<article>
                     |  <h1>
                     |    Heading 1
                     |  </h1>
                     |  <h2>
                     |    Heading 2
                     |  </h2>
                     |  <h3>
                     |    Heading 3
                     |  </h3>
                     |  <h4>
                     |    Heading 4
                     |  </h4>
                     |  <h5>
                     |    Heading 5
                     |  </h5>
                     |  <h6>
                     |    Heading 6
                     |  </h6>
                     |</article>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}