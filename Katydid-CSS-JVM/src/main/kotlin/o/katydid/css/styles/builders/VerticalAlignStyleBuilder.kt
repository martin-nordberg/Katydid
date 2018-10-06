//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.Style
import o.katydid.css.types.EAlignmentBaseline
import o.katydid.css.types.EBaselineShift

//---------------------------------------------------------------------------------------------------------------------

private fun <T> Style.setVerticalAlign(baselineShift: T, alignmentBaseline: EAlignmentBaseline?) {

    var css = "$baselineShift"

    if (alignmentBaseline != null) {
        css += " $alignmentBaseline"
    }

    setProperty("vertical-align", css)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.alignmentBaseline(value: EAlignmentBaseline) =
    setProperty("alignment-baseline", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.baselineShift(value: Length) =
    setProperty("baseline-shift", "$value")

fun Style.baselineShift(value: Percentage) =
    setProperty("baseline-shift", "$value")

fun Style.baselineShift(value: EBaselineShift) =
    setProperty("baseline-shift", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.verticalAlign(baselineShift: Length, alignmentBaseline: EAlignmentBaseline? = null) =
    setVerticalAlign(baselineShift, alignmentBaseline)

fun Style.verticalAlign(baselineShift: Percentage, alignmentBaseline: EAlignmentBaseline? = null) =
    setVerticalAlign(baselineShift, alignmentBaseline)

fun Style.verticalAlign(alignmentBaseline: EAlignmentBaseline) =
    setProperty("vertical-align", "$alignmentBaseline")

fun Style.verticalAlign(baselineShift: EBaselineShift, alignmentBaseline: EAlignmentBaseline? = null) =
    setVerticalAlign(baselineShift, alignmentBaseline)

//---------------------------------------------------------------------------------------------------------------------
