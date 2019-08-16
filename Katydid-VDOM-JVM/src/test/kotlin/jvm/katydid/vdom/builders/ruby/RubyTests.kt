//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.ruby

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test

@Suppress("RemoveRedundantBackticks")
class RubyTests {

    @Test
    fun `Ruby elements produce correct HTML`() {

        val vdomNode = katydid<Unit> {

            ruby( "#rr" ) {

                rb {
                    +"not really"
                }

                +"text"

                rp {
                    +"more"
                }

                rt {
                    +"stuff"
                }

                rtc {

                    rb{
                        +"nested"
                    }

                    +"enough!"
                }
            }

        }

        val html = """<ruby id="rr">
                     |  <rb>
                     |    not really
                     |  </rb>
                     |  text
                     |  <rp>
                     |    more
                     |  </rp>
                     |  <rt>
                     |    stuff
                     |  </rt>
                     |  <rtc>
                     |    <rb>
                     |      nested
                     |    </rb>
                     |    enough!
                     |  </rtc>
                     |</ruby>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}
