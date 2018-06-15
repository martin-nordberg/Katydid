//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.interactive

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class DetailsTests {

    @Test
    fun `A details element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

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
    fun `A details element can have only one summary`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                details {
                    summary { text("1") }
                    summary { text("2") }
                }

            }

        }

    }

}