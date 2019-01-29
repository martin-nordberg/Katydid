//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.embedded

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import o.katydid.vdom.types.EAnchorHtmlLinkType
import o.katydid.vdom.types.EAreaShape
import o.katydid.vdom.types.EReferrerPolicy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class MapTests {

    @Test
    fun `A map element with its attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            map("#mymap.styled", name = "myMap") {
                area("#a1", alt = "Alternate text", coords = "100,100,40", download = "http://somewhere",
                    href = "https://elsewhere", hreflang = "EN", referrerpolicy = EReferrerPolicy.sameOrigin,
                    rel = EAnchorHtmlLinkType.bookmark, shape = EAreaShape.circle, type = "A hint!") {
                    attribute("target", "popup")
                }
            }

        }

        val html = """<map class="styled" id="mymap" name="myMap">
                     |  <area alt="Alternate text" coords="100,100,40" download="http://somewhere" href="https://elsewhere" hreflang="EN" id="a1" referrerpolicy="same-origin" rel="bookmark" shape="circle" target="popup" type="A hint!"></area>
                     |</map>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An area element must fall inside a map element`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                area {}

            }

        }

    }



}


