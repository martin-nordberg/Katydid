//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.edits

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import x.katydid.vdom.types.KatyDateTime
import java.time.ZoneOffset

@Suppress("RemoveRedundantBackticks")
class EditsTests {

    @Test
    fun `A del element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            del(cite = "http://somewhere.com/citation",
                datetime = KatyDateTime.of(2001, 9, 8, 21, 46, 40, 0, ZoneOffset.ofHours(-4))) {
                text("this was deleted")
            }

        }

        val html = """<del cite="http://somewhere.com/citation" datetime="2001-09-08T21:46:40-04:00">
                     |  this was deleted
                     |</del>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An ins element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            ins(cite = "http://somewhere.com/citation",
                datetime = KatyDateTime.of(2001, 9, 8, 21, 46, 40, 0, ZoneOffset.ofHours(-4))) {
                text("this was deleted")
            }

        }

        val html = """<ins cite="http://somewhere.com/citation" datetime="2001-09-08T21:46:40-04:00">
                     |  this was deleted
                     |</ins>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}