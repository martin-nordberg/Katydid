//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.model.core.names

import o.katydid.kotlgen.model.core.names.KgPath
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class KgPathTests {

    @Test
    fun `Paths construct from delimited strings`() {

        assertEquals("a.b.c.d.e", KgPath("a.b.c.d.e").text)

        assertEquals("a/b/c/d/e", KgPath("a/b/c/d/e", '/').toString("/"))
        assertEquals("a.b.c.d.e", KgPath("a/b/c/d/e", '/').toString())

    }

    @Test
    fun `Paths hold their name and remainder`() {

        val path = KgPath("a.b.c.d.e")

        assertEquals("a", path.name)
        assertEquals("b.c.d.e", path.remainder!!.text)

    }

}

//---------------------------------------------------------------------------------------------------------------------

