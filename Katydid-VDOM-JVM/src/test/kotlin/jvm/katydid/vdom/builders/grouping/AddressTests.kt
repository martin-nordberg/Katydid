//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.grouping

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class AddressTests {

    @Test
    fun `A simple address produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            address("#simple") {

                p("#street") {
                    text("123 Main Street")
                }

                p("#town") {
                    text("Somewhere, XY 12345")
                }

            }

        }

        val html = """<address id="simple">
                     |  <p id="street">
                     |    123 Main Street
                     |  </p>
                     |  <p id="town">
                     |    Somewhere, XY 12345
                     |  </p>
                     |</address>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `An address limits its content`() {

        assertThrows<IllegalStateException> { katydid<Unit> { address { address {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { article {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { aside {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { footer {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { h1 {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { h2 {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { h3 {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { h4 {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { h5 {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { h6 {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { header {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { nav {} } } }
        assertThrows<IllegalStateException> { katydid<Unit> { address { section {} } } }

    }

}
