//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.interactive

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class DetailsTests {

    @Test
    fun `A details element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            details(
                "#mydetails.openable",
                open=true
            ) {
                summary {
                    span(".summary") { text("Summary") }
                }
                text( "Details" )
            }

        }

        val html = """<details class="openable" id="mydetails" open="">
                     |  <summary>
                     |    <span class="summary">
                     |      Summary
                     |    </span>
                     |  </summary>
                     |  Details
                     |</details>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A details element with summary heading produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            details(
                "#mydetails.openable",
                open=true
            ) {
                summaryHeading {
                    h1 { text("Stuff") }
                }
                text( "Details" )
            }

        }

        val html = """<details class="openable" id="mydetails" open="">
                     |  <summary>
                     |    <h1>
                     |      Stuff
                     |    </h1>
                     |  </summary>
                     |  Details
                     |</details>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A details element can have only one summary`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                details {
                    summary { text("1") }
                    summary { text("2") }
                }

            }

        }

    }

    // TODO: Disallow more than one heading inside a summaryHeading

}