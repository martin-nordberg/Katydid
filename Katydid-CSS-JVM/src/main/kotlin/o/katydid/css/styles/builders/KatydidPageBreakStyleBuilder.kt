//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EPageBreak
import o.katydid.css.types.EPageBreakInside

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting page break properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidPageBreakStyleBuilder(
    private val style: KatydidStyle
) {

    fun after(value: EPageBreak) =
        style.pageBreakAfter(value)

    fun before(value: EPageBreak) =
        style.pageBreakBefore(value)

    fun inside(value: EPageBreakInside) =
        style.pageBreakInside(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.pageBreak(build: KatydidPageBreakStyleBuilder.() -> Unit) =
    KatydidPageBreakStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.pageBreakAfter(value: EPageBreak) =
    setProperty("page-break-after", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.pageBreakBefore(value: EPageBreak) =
    setProperty("page-break-before", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.pageBreakInside(value: EPageBreakInside) =
    setProperty("page-break-inside", "$value")

//---------------------------------------------------------------------------------------------------------------------

