//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.api

import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test

//---------------------------------------------------------------------------------------------------------------------

/**
 * Tests of the virtual DOM patch function.
 */
@Suppress("RemoveRedundantBackticks")
class PatchTests {

    @Test
    fun `Sample 1 patches correctly`() {

        val vnode1 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "1") { text("One") }
                    li(key = "2") { text("Two") }
                    li(key = "3") { text("Three") }
                    li(key = "4") { text("Four") }

                }

            }

        }

        val html1 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li>
                      |      One
                      |    </li>
                      |    <li>
                      |      Two
                      |    </li>
                      |    <li>
                      |      Three
                      |    </li>
                      |    <li>
                      |      Four
                      |    </li>
                      |  </ul>
                      |</div>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "1") { text("One") }
                    li(key = "2") { text("Two") }
                    li(key = "4") { text("Four") }
                    li(key = "5") { text("Five") }

                }

            }

        }

        val html2 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li>
                      |      One
                      |    </li>
                      |    <li>
                      |      Two
                      |    </li>
                      |    <li>
                      |      Four
                      |    </li>
                      |    <li>
                      |      Five
                      |    </li>
                      |  </ul>
                      |</div>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)
    }

    @Test
    fun `Completely removed child nodes patch correctly`() {

        val vnode1 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "1") { text("One") }
                    li(key = "2") { text("Two") }
                    li(key = "4") { text("Four") }
                    li(key = "5") { text("Five") }

                }

            }

        }

        val html1 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li>
                      |      One
                      |    </li>
                      |    <li>
                      |      Two
                      |    </li>
                      |    <li>
                      |      Four
                      |    </li>
                      |    <li>
                      |      Five
                      |    </li>
                      |  </ul>
                      |</div>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {
                }

            }

        }

        val html2 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList"></ul>
                      |</div>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)

    }

    @Test
    fun `Completely replaced child nodes patch correctly`() {

        val vnode1 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "1") { text("One") }
                    li(key = "2") { text("Two") }
                    li(key = "4") { text("Four") }
                    li(key = "5") { text("Five") }

                }

            }

        }

        val html1 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li>
                      |      One
                      |    </li>
                      |    <li>
                      |      Two
                      |    </li>
                      |    <li>
                      |      Four
                      |    </li>
                      |    <li>
                      |      Five
                      |    </li>
                      |  </ul>
                      |</div>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "one") { text("One") }
                    li(key = "two") { text("Two") }
                    li(key = "four") { text("Four") }
                    li(key = "five") { text("Five") }

                }

            }

        }

        val html2 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li>
                      |      One
                      |    </li>
                      |    <li>
                      |      Two
                      |    </li>
                      |    <li>
                      |      Four
                      |    </li>
                      |    <li>
                      |      Five
                      |    </li>
                      |  </ul>
                      |</div>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)

    }

    @Test
    fun `Child nodes removed all but one patch correctly`() {

        val vnode1 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "1") { text("One") }
                    li(key = "2") { text("Two") }
                    li(key = "4") { text("Four") }
                    li(key = "5") { text("Five") }

                }

            }

        }

        val html1 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li>
                      |      One
                      |    </li>
                      |    <li>
                      |      Two
                      |    </li>
                      |    <li>
                      |      Four
                      |    </li>
                      |    <li>
                      |      Five
                      |    </li>
                      |  </ul>
                      |</div>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "5") { text("Five") }

                }

            }

        }

        val html2 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li>
                      |      Five
                      |    </li>
                      |  </ul>
                      |</div>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)

    }

    @Test
    fun `Child nodes removed all but one patch correctly A`() {

        val vnode1 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "1") {}
                    li(key = "2") {}
                    li(key = "4") {}
                    li(key = "5") {}

                }

            }

        }

        val html1 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li></li>
                      |    <li></li>
                      |    <li></li>
                      |    <li></li>
                      |  </ul>
                      |</div>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            div("#mydiv.funnyone") {

                ul("#theList") {

                    li(key = "5") {}

                }

            }

        }

        val html2 = """<div class="funnyone" id="mydiv">
                      |  <ul id="theList">
                      |    <li></li>
                      |  </ul>
                      |</div>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)

    }

    @Test
    fun `Sample 2 patches correctly`() {

        val vnode1 = katyDom<Unit> {

            section("#mysection") {

                h1 {
                    span(".pink") {
                        text("A Heading")
                    }
                }

                span("#theStuff") {
                    text("Stuff is here.")
                }

            }

        }

        val html1 = """<section id="mysection">
                      |  <h1>
                      |    <span class="pink">
                      |      A Heading
                      |    </span>
                      |  </h1>
                      |  <span id="theStuff">
                      |    Stuff is here.
                      |  </span>
                      |</section>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            section("#mysection") {

                h6 {
                    text("An Unstyled Heading")
                }

                span("#theStuff") {
                    text("Stuff is here.")
                }

            }

        }

        val html2 = """<section id="mysection">
                      |  <h6>
                      |    An Unstyled Heading
                      |  </h6>
                      |  <span id="theStuff">
                      |    Stuff is here.
                      |  </span>
                      |</section>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)

    }

    @Test
    fun `Reordered nodes (A) patch correctly`() {

        val vnode1 = katyDom<Unit> {

            article("#holder") {

                div("#a") {}
                div("#b") {}
                div("#c") {}
                div("#d") {}

            }

        }

        val html1 = """<article id="holder">
                      |  <div id="a"></div>
                      |  <div id="b"></div>
                      |  <div id="c"></div>
                      |  <div id="d"></div>
                      |</article>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            article("#holder") {

                div("#a") {}
                div("#c") {}
                div("#b") {}
                div("#d") {}

            }

        }

        val html2 = """<article id="holder">
                      |  <div id="a"></div>
                      |  <div id="c"></div>
                      |  <div id="b"></div>
                      |  <div id="d"></div>
                      |</article>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)

    }

    @Test
    fun `Text changes patch correctly`() {

        val vnode1 = katyDom<Unit> {

            div("#mydiv.textinside") {

                span("#sometext") {

                    text("before")

                }

            }

        }

        val html1 = """<div class="textinside" id="mydiv">
                      |  <span id="sometext">
                      |    before
                      |  </span>
                      |</div>""".trimMargin()

        val vnode2 = katyDom<Unit> {

            div("#mydiv.textinside") {

                span("#sometext") {

                    text("after")

                }

            }

        }

        val html2 = """<div class="textinside" id="mydiv">
                      |  <span id="sometext">
                      |    after
                      |  </span>
                      |</div>""".trimMargin()

        checkPatch(html2, vnode2, html1, vnode1)

    }

}

//---------------------------------------------------------------------------------------------------------------------

