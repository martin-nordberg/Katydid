//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.api

import o.katydid.vdom.application.katyDom
import o.katydid.vdom.eventhandling.onclick
import o.katydid.vdom.types.EAnchorHtmlLinkType
import org.junit.jupiter.api.Test

//---------------------------------------------------------------------------------------------------------------------

/**
 * Tests for quick trials of KatyDOM DSL.
 */
@Suppress("RemoveRedundantBackticks")
class ExperimentationTests {

    @Test
    fun `Sample 1 of Katydid-VDOM DSL should produce correct HTML`() {

        val vdomNode = katyDom<Unit> {

            div("#myDiv.my-class", style = "color:red") {

                div {
                    text("a sample")

                    ul("#a-list") {
                        li(key = 1) { text("item 1") }
                        li(key = 2) { text("item 2") }
                        li(key = 3) {
                            text("item 3")
                            div {}
                        }
                    }
                }

                div(".some-class", key = 2) {
                    classes("big" to true, "small" to false, "smelly" to true)
                    attribute("class", "very-classy")
                    attributes("a1" to "v1", "a2" to "v2")

                    onclick { _ ->
                        emptyList()
                    }
                }

                p {
                    text("example")
                }

                br {}

                hr {
                    attribute("id", "me")
                }

            }

        }

        val html = """<div class="my-class" id="myDiv" style="color:red">
                     |  <div>
                     |    a sample
                     |    <ul id="a-list">
                     |      <li>
                     |        item 1
                     |      </li>
                     |      <li>
                     |        item 2
                     |      </li>
                     |      <li>
                     |        item 3
                     |        <div></div>
                     |      </li>
                     |    </ul>
                     |  </div>
                     |  <div a1="v1" a2="v2" class="big smelly some-class very-classy"></div>
                     |  <p>
                     |    example
                     |  </p>
                     |  <br>
                     |  <hr id="me">
                     |</div>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `Sample 2 of Katydid-VDOM DSL should produce correct HTML`() {

        val vdomNode = katyDom<Unit> {

            div("#myDiv.my-class", style = "color:red") {

                div(hidden = true) {
                    text("a sample")
                }

                div(".some-class", key = "x", title = "A Title") {
                    classes("big" to true, "small" to false, "smelly" to true)
                    attribute("class", "very-classy")
                    attributes("a1" to "v1", "a2" to "v2")

                    onclick { _ ->
                        emptyList()
                    }
                }

            }

        }

        val html = """<div class="my-class" id="myDiv" style="color:red">
                     |  <div hidden="">
                     |    a sample
                     |  </div>
                     |  <div a1="v1" a2="v2" class="big smelly some-class very-classy" title="A Title"></div>
                     |</div>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `Sample 3 of Katydid-VDOM DSL should produce correct HTML`() {

        val vdomNode = katyDom<Unit> {

            div("#myDiv.my-class", "div1") {

                span(".mottled") {
                    a(href = "#somewhere", rel = listOf(EAnchorHtmlLinkType.NEXT, EAnchorHtmlLinkType.NOREFERRER)) {
                        text("Go Somewhere")
                    }
                }

            }

        }

        val html = """<div class="my-class" id="myDiv">
                     |  <span class="mottled">
                     |    <a href="#somewhere" rel="next noreferrer">
                     |      Go Somewhere
                     |    </a>
                     |  </span>
                     |</div>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}

//---------------------------------------------------------------------------------------------------------------------

