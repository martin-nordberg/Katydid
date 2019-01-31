//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.grouping

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class DlTests {

    @Test
    fun `A simple description list produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            dl("#alist") {

                dt("#term-one") {
                    text("term 1")
                }
                dd("#defn-one") {
                    text("definition 1")
                }

                dt("#term-two") {
                    text("term 2")
                }
                dd("#defn-two") {
                    text("definition 2")
                }

            }

        }

        val html = """<dl id="alist">
                     |  <dt id="term-one">
                     |    term 1
                     |  </dt>
                     |  <dd id="defn-one">
                     |    definition 1
                     |  </dd>
                     |  <dt id="term-two">
                     |    term 2
                     |  </dt>
                     |  <dd id="defn-two">
                     |    definition 2
                     |  </dd>
                     |</dl>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A div-grouped description list produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            dl("#alist") {

                div("#one") {
                    dt("#term-one") {
                        text("term 1")
                    }
                    dd("#defn-one") {
                        text("definition 1")
                    }
                }

                div("#two") {
                    dt("#term-two") {
                        text("term 2")
                    }
                    dd("#defn-two") {
                        text("definition 2")
                    }
                }

            }

        }

        val html = """<dl id="alist">
                     |  <div id="one">
                     |    <dt id="term-one">
                     |      term 1
                     |    </dt>
                     |    <dd id="defn-one">
                     |      definition 1
                     |    </dd>
                     |  </div>
                     |  <div id="two">
                     |    <dt id="term-two">
                     |      term 2
                     |    </dt>
                     |    <dd id="defn-two">
                     |      definition 2
                     |    </dd>
                     |  </div>
                     |</dl>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}