//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.infrastructure

import o.katydid.css.colors.*
import org.junit.jupiter.api.Test
import x.katydid.css.infrastructure.makeDecimalString
import kotlin.test.assertEquals
import kotlin.test.assertSame

@Suppress("RemoveRedundantBackticks")
class NumberUtilityTests {

    @Test
    fun `Floats format as expected`() {

        assertEquals("0", makeDecimalString(0f))
        assertEquals("0.1", makeDecimalString(0.1f))
        assertEquals("0.12", makeDecimalString(0.12f))
        assertEquals("0.123", makeDecimalString(0.123f))
        assertEquals("0.123", makeDecimalString(0.1234f))
        assertEquals("0.124", makeDecimalString(0.12351f))
        assertEquals("1", makeDecimalString(1f))
        assertEquals("23", makeDecimalString(23.0001f))

    }

}
