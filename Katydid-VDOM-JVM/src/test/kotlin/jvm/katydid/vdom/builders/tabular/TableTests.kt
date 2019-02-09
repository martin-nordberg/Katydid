//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.tabular

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class TableTests {

    @Test
    fun `A simple table produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            table("#tabular.classy") {

                tr(key = "row1") {
                    th(key = "h1") { text("Heading1") }
                    th(key = "h2") { text("Heading2") }
                }

                tr(key = "row2") {
                    td("#c1") { text("Cell1") }
                    td("#c2") { text("Cell2") }
                }

            }

        }

        val html = """<table class="classy" id="tabular">
                     |  <tr>
                     |    <th>
                     |      Heading1
                     |    </th>
                     |    <th>
                     |      Heading2
                     |    </th>
                     |  </tr>
                     |  <tr>
                     |    <td id="c1">
                     |      Cell1
                     |    </td>
                     |    <td id="c2">
                     |      Cell2
                     |    </td>
                     |  </tr>
                     |</table>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A structured table produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            table(".classy") {

                caption {
                    text("A mighty fine table")
                }

                colgroup(key = 1, span = 1)

                colgroup(key = 2) {
                    col(key = "a", span = 2)
                    col(key = "b", span = 1)
                }

                thead {

                    tr {
                        th(key = "h1") { text("Heading1") }
                        th(key = "h2") { text("Heading2") }
                        th(key = "h3") { text("Heading3") }
                    }

                }

                tbody {

                    tr(key = "row1") {
                        td("#c11") { text("Cell11") }
                        td("#c12") { text("Cell12") }
                        td("#c13") { text("Cell13") }
                    }

                    tr(key = "row2") {
                        td("#c21") { text("Cell21") }
                        td("#c22") { text("Cell22") }
                        td("#c23") { text("Cell23") }
                    }

                }

                tfoot {

                    tr {
                        td(colspan = 3) {
                            text("Footnote")
                        }
                    }

                }

            }

        }

        val html = """<table class="classy">
                     |  <caption>
                     |    A mighty fine table
                     |  </caption>
                     |  <colgroup span="1"></colgroup>
                     |  <colgroup>
                     |    <col span="2"></col>
                     |    <col span="1"></col>
                     |  </colgroup>
                     |  <thead>
                     |    <tr>
                     |      <th>
                     |        Heading1
                     |      </th>
                     |      <th>
                     |        Heading2
                     |      </th>
                     |      <th>
                     |        Heading3
                     |      </th>
                     |    </tr>
                     |  </thead>
                     |  <tbody>
                     |    <tr>
                     |      <td id="c11">
                     |        Cell11
                     |      </td>
                     |      <td id="c12">
                     |        Cell12
                     |      </td>
                     |      <td id="c13">
                     |        Cell13
                     |      </td>
                     |    </tr>
                     |    <tr>
                     |      <td id="c21">
                     |        Cell21
                     |      </td>
                     |      <td id="c22">
                     |        Cell22
                     |      </td>
                     |      <td id="c23">
                     |        Cell23
                     |      </td>
                     |    </tr>
                     |  </tbody>
                     |  <tfoot>
                     |    <tr>
                     |      <td colspan="3">
                     |        Footnote
                     |      </td>
                     |    </tr>
                     |  </tfoot>
                     |</table>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A caption must be the first element of a table`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    colgroup {}
                    caption {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    thead {}
                    caption {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tbody {}
                    caption {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tfoot {}
                    caption {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tr {}
                    caption {}
                }

            }

        }

    }

    @Test
    fun `A colgroup can be preceded only by a caption`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    thead {}
                    colgroup {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tbody {}
                    colgroup {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tfoot {}
                    colgroup {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tr {}
                    colgroup {}
                }

            }

        }

    }

    @Test
    fun `A thead must come before tbody, tr, or tfoot`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tbody {}
                    thead {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tfoot {}
                    thead {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tr {}
                    thead {}
                }

            }

        }

    }

    @Test
    fun `A tbody must come before tfoot`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tfoot {}
                    tbody {}
                }

            }

        }

    }

    @Test
    fun `Elements tr and tbody are mutually exclusive`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tr {}
                    tbody {}
                }

            }

        }

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                table {
                    tbody {}
                    tr {}
                }

            }

        }

    }

}
