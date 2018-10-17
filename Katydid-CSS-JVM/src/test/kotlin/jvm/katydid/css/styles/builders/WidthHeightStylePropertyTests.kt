//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.makeStyle
import o.katydid.css.types.EAuto.auto
import o.katydid.css.types.EBoxSize
import o.katydid.css.types.ENone
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class WidthHeightStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: KatydidStyle.() -> Unit
    ) {
        assertEquals(expectedCss, makeStyle(build).toString())
    }

    @Test
    fun `Fit-content cannot be negative`() {

        assertFailsWith<IllegalArgumentException> { makeStyle { maxHeight(EBoxSize.fitContent(-2.px)) } }
        assertFailsWith<IllegalArgumentException> { makeStyle { maxHeight(EBoxSize.fitContent(-2.percent)) } }

    }

    @Test
    fun `Max size style properties convert to correct CSS`() {

        checkStyle("max-height: 25px;") { maxHeight(25.px) }
        checkStyle("max-height: 50%;") { maxHeight(50.percent) }
        checkStyle("max-height: none;") { maxHeight(ENone.none) }
        checkStyle("max-height: max-content;") { maxHeight(EBoxSize.maxContent) }
        checkStyle("max-height: min-content;") { maxHeight(EBoxSize.minContent) }
        checkStyle("max-height: fit-content(2px);") { maxHeight(EBoxSize.fitContent(2.px)) }
        checkStyle("max-height: fit-content(2%);") { maxHeight(EBoxSize.fitContent(2.percent)) }

        checkStyle("max-width: 25px;") { maxWidth(25.px) }
        checkStyle("max-width: 50%;") { maxWidth(50.percent) }
        checkStyle("max-width: none;") { maxWidth(ENone.none) }
        checkStyle("max-width: max-content;") { maxWidth(EBoxSize.maxContent) }
        checkStyle("max-width: min-content;") { maxWidth(EBoxSize.minContent) }
        checkStyle("max-width: fit-content(2px);") { maxWidth(EBoxSize.fitContent(2.px)) }
        checkStyle("max-width: fit-content(2%);") { maxWidth(EBoxSize.fitContent(2.percent)) }

    }

    @Test
    fun `Min size style properties convert to correct CSS`() {

        checkStyle("min-height: 25px;") { minHeight(25.px) }
        checkStyle("min-height: 50%;") { minHeight(50.percent) }
        checkStyle("min-height: auto;") { minHeight(auto) }
        checkStyle("min-height: max-content;") { minHeight(EBoxSize.maxContent) }
        checkStyle("min-height: min-content;") { minHeight(EBoxSize.minContent) }
        checkStyle("min-height: fit-content(2px);") { minHeight(EBoxSize.fitContent(2.px)) }
        checkStyle("min-height: fit-content(2%);") { minHeight(EBoxSize.fitContent(2.percent)) }

        checkStyle("min-width: 25px;") { minWidth(25.px) }
        checkStyle("min-width: 50%;") { minWidth(50.percent) }
        checkStyle("min-width: auto;") { minWidth(auto) }
        checkStyle("min-width: max-content;") { minWidth(EBoxSize.maxContent) }
        checkStyle("min-width: min-content;") { minWidth(EBoxSize.minContent) }
        checkStyle("min-width: fit-content(2px);") { minWidth(EBoxSize.fitContent(2.px)) }
        checkStyle("min-width: fit-content(2%);") { minWidth(EBoxSize.fitContent(2.percent)) }

    }

    @Test
    fun `Size style properties convert to correct CSS`() {

        checkStyle("height: 100px;") { height(100.px) }
        checkStyle("height: 90%;") { height(90.percent) }
        checkStyle("height: auto;") { height(auto) }
        checkStyle("height: max-content;") { height(EBoxSize.maxContent) }
        checkStyle("height: min-content;") { height(EBoxSize.minContent) }
        checkStyle("height: fit-content(2px);") { height(EBoxSize.fitContent(2.px)) }
        checkStyle("height: fit-content(2%);") { height(EBoxSize.fitContent(2.percent)) }

        checkStyle("width: 100px;") { width(100.px) }
        checkStyle("width: 90%;") { width(90.percent) }
        checkStyle("width: auto;") { width(auto) }
        checkStyle("width: max-content;") { width(EBoxSize.maxContent) }
        checkStyle("width: min-content;") { width(EBoxSize.minContent) }
        checkStyle("width: fit-content(2px);") { width(EBoxSize.fitContent(2.px)) }
        checkStyle("width: fit-content(2%);") { width(EBoxSize.fitContent(2.percent)) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

