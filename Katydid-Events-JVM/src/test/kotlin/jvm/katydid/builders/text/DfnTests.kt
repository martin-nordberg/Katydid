//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.builders.text

import jvm.katydid.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class DfnTests {

    @Test
    fun `A dfn element produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            dfn {

            }

        }

        val html = """<dfn></dfn>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A dfn element may not be nested`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                dfn {
                    dfn {}
                }

            }

        }

    }

}

