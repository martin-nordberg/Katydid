//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EBorderCollapse
import o.katydid.css.types.ECaptionSide
import o.katydid.css.types.EEmptyCells
import o.katydid.css.types.ETableLayout

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.borderCollapse(value: EBorderCollapse) =
    setProperty("border-collapse", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.borderSpacing(horizontal: Length, vertical: Length = horizontal) =
    setXyProperty("border-spacing", horizontal, vertical)

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.captionSide(value: ECaptionSide) =
    setProperty("caption-side", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.emptyCells(value: EEmptyCells) =
    setProperty("empty-cells", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.tableLayout(value: ETableLayout) =
    setProperty("table-layout", "$value")

//---------------------------------------------------------------------------------------------------------------------
