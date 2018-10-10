//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.types.EPageBreak
import o.katydid.css.types.EPageBreakInside

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting page break properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class PageBreakStyleBuilder(
    private val style: Style
) {

    fun after(value: EPageBreak) =
        style.pageBreakAfter(value)

    fun before(value: EPageBreak) =
        style.pageBreakBefore(value)

    fun inside(value: EPageBreakInside) =
        style.pageBreakInside(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.pageBreak(build: PageBreakStyleBuilder.() -> Unit) =
    PageBreakStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun Style.pageBreakAfter(value: EPageBreak) =
    setProperty("page-break-after", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.pageBreakBefore(value: EPageBreak) =
    setProperty("page-break-before", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.pageBreakInside(value: EPageBreakInside) =
    setProperty("page-break-inside", "$value")

//---------------------------------------------------------------------------------------------------------------------

