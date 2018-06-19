//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.text

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import x.org.katydom.types.KatyDateTime
import java.time.ZoneOffset

@Suppress("RemoveRedundantBackticks")
class DfnTests {

    @Test
    fun `A dfn element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            dfn {

            }

        }

        val html = """<dfn></dfn>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A dfn element may not be nested`() {

        assertThrows<IllegalStateException> {

            katyDom<Unit> {

                dfn {
                    dfn {}
                }

            }

        }

    }

}

