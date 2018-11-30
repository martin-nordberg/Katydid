//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.model.core.modifiers

import o.katydid.kotlgen.model.core.KgOriginGenerated
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.core.modifiers.KgModifier
import o.katydid.kotlgen.model.core.modifiers.KgModifierKeyword.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class KgModifierTests {

    @Test
    fun `Modifiers convert to their keyword strings`() {

        assertEquals("abstract", KgModifier(`abstract`, KgOriginUnspecified).text)
        assertEquals("actual", KgModifier(`actual`, KgOriginUnspecified).text)
        assertEquals("annotation", KgModifier(`annotation`, KgOriginUnspecified).text)
        assertEquals("const", KgModifier(`const`, KgOriginUnspecified).text)
        assertEquals("crossinline", KgModifier(`crossinline`, KgOriginUnspecified).text)
        assertEquals("data", KgModifier(`data`, KgOriginUnspecified).text)
        assertEquals("enum", KgModifier(`enum`, KgOriginUnspecified).text)
        assertEquals("expected", KgModifier(`expected`, KgOriginUnspecified).text)
        assertEquals("external", KgModifier(`external`, KgOriginUnspecified).text)
        assertEquals("final", KgModifier(`final`, KgOriginUnspecified).text)
        assertEquals("in", KgModifier(`in`, KgOriginUnspecified).text)
        assertEquals("infix", KgModifier(`infix`, KgOriginUnspecified).text)
        assertEquals("inline", KgModifier(`inline`, KgOriginUnspecified).text)
        assertEquals("internal", KgModifier(`internal`, KgOriginUnspecified).text)
        assertEquals("lateinit", KgModifier(`lateinit`, KgOriginUnspecified).text)
        assertEquals("noinline", KgModifier(`noinline`, KgOriginUnspecified).text)
        assertEquals("open", KgModifier(`open`, KgOriginUnspecified).text)
        assertEquals("operator", KgModifier(`operator`, KgOriginUnspecified).text)
        assertEquals("out", KgModifier(`out`, KgOriginUnspecified).text)
        assertEquals("override", KgModifier(`override`, KgOriginUnspecified).text)
        assertEquals("private", KgModifier(`private`, KgOriginUnspecified).text)
        assertEquals("protected", KgModifier(`protected`, KgOriginUnspecified).text)
        assertEquals("public", KgModifier(`public`, KgOriginUnspecified).text)
        assertEquals("reified", KgModifier(`reified`, KgOriginUnspecified).text)
        assertEquals("sealed", KgModifier(`sealed`, KgOriginUnspecified).text)
        assertEquals("suspend", KgModifier(`suspend`, KgOriginUnspecified).text)
        assertEquals("tailrec", KgModifier(`tailrec`, KgOriginUnspecified).text)
        assertEquals("vararg", KgModifier(`vararg`, KgOriginUnspecified).text)

    }

    @Test
    fun `Modifiers construct from their keyword strings`() {

        assertEquals("abstract", KgModifier("abstract").text)
        assertEquals("actual", KgModifier("actual").text)
        assertEquals("annotation", KgModifier("annotation").text)
        assertEquals("const", KgModifier("const").text)
        assertEquals("crossinline", KgModifier("crossinline").text)
        assertEquals("data", KgModifier("data").text)
        assertEquals("enum", KgModifier("enum").text)
        assertEquals("expected", KgModifier("expected").text)
        assertEquals("external", KgModifier("external").text)
        assertEquals("final", KgModifier("final").text)
        assertEquals("in", KgModifier("in").text)
        assertEquals("infix", KgModifier("infix").text)
        assertEquals("inline", KgModifier("inline").text)
        assertEquals("internal", KgModifier("internal").text)
        assertEquals("lateinit", KgModifier("lateinit").text)
        assertEquals("noinline", KgModifier("noinline").text)
        assertEquals("open", KgModifier("open").text)
        assertEquals("operator", KgModifier("operator").text)
        assertEquals("out", KgModifier("out").text)
        assertEquals("override", KgModifier("override").text)
        assertEquals("private", KgModifier("private").text)
        assertEquals("protected", KgModifier("protected").text)
        assertEquals("public", KgModifier("public").text)
        assertEquals("reified", KgModifier("reified").text)
        assertEquals("sealed", KgModifier("sealed").text)
        assertEquals("suspend", KgModifier("suspend").text)
        assertEquals("tailrec", KgModifier("tailrec").text)
        assertEquals("vararg", KgModifier("vararg").text)

    }

    @Test
    fun `Modifier equality ignores origin`() {

        assertEquals(KgModifier(`private`, KgOriginUnspecified), KgModifier(`private`, KgOriginGenerated))

        assertNotEquals(KgModifier(`private`, KgOriginUnspecified), KgModifier(`public`, KgOriginUnspecified))

    }

}

//---------------------------------------------------------------------------------------------------------------------

