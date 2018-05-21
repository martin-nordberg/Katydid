//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("RemoveRedundantBackticks")
class EditsTests {

    @Test
    fun `A del element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            del( cite = "http://somewhere.com/citation", datetime = Date(1000000000000L) ) {
                text("this was deleted")
            }

        }

        val html = """<del cite="http://somewhere.com/citation" datetime="2001-09-08 21:46:40.000-0400">
                     |  this was deleted
                     |</del>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An ins element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            ins( cite = "http://somewhere.com/citation", datetime = Date(1000000000000L) ) {
                text("this was deleted")
            }

        }

        val html = """<ins cite="http://somewhere.com/citation" datetime="2001-09-08 21:46:40.000-0400">
                     |  this was deleted
                     |</ins>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}