//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.grouping

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class ListTests {

    @Test
    fun `An ordered list produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            ol("#alist") {

                li(key = 3, value = 3) {
                    text("Three")
                }

                li(key = 4) {
                    text("Four")
                }

            }

        }

        val html = """<ol id="alist">
                     |  <li value="3">
                     |    Three
                     |  </li>
                     |  <li>
                     |    Four
                     |  </li>
                     |</ol>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An unordered list produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            ul("#anotherlist") {

                li(key = "a") {
                    text("Aaaa")
                }

                li(key = "b") {
                    text("Bee")
                }

            }

        }

        val html = """<ul id="anotherlist">
                     |  <li>
                     |    Aaaa
                     |  </li>
                     |  <li>
                     |    Bee
                     |  </li>
                     |</ul>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}