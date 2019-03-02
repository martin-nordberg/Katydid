//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.text

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import x.katydid.vdom.types.KatyDateTime
import java.time.ZoneOffset

@Suppress("RemoveRedundantBackticks")
class TimeTests {

    @Test
    fun `A time element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            time(datetime = KatyDateTime.of(2018, 5, 24, 12, 10, 3, 0, ZoneOffset.ofHours(-5))) {

            }

        }

        val html = """<time datetime="2018-05-24T12:10:03-05:00"></time>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A time element with text content produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            time {
                +"2018-05-24 12:10:03.000-05:00"
            }

        }

        val html = """<time>
                     |  2018-05-24 12:10:03.000-05:00
                     |</time>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}

