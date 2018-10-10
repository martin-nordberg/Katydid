//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.styles.Style
import o.katydid.css.types.EBorderCollapse
import o.katydid.css.types.ECaptionSide
import o.katydid.css.types.EEmptyCells
import o.katydid.css.types.ETableLayout

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderCollapse(value: EBorderCollapse) =
    setProperty("border-collapse", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.borderSpacing(horizontal: Length, vertical: Length = horizontal) =
    setXyProperty("border-spacing", horizontal, vertical)

//---------------------------------------------------------------------------------------------------------------------

fun Style.captionSide(value: ECaptionSide) =
    setProperty("caption-side", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.emptyCells(value: EEmptyCells) =
    setProperty("empty-cells", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.tableLayout(value: ETableLayout) =
    setProperty("table-layout", "$value")

//---------------------------------------------------------------------------------------------------------------------
