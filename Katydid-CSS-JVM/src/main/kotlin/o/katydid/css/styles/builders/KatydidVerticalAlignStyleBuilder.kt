//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EAlignmentBaseline
import o.katydid.css.types.EBaselineShift

//---------------------------------------------------------------------------------------------------------------------

private fun <T> KatydidStyle.setVerticalAlign(baselineShift: T, alignmentBaseline: EAlignmentBaseline?) {

    var css = "$baselineShift"

    if (alignmentBaseline != null) {
        css += " $alignmentBaseline"
    }

    setProperty("vertical-align", css)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.alignmentBaseline(value: EAlignmentBaseline) =
    setProperty("alignment-baseline", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.baselineShift(value: Length) =
    setProperty("baseline-shift", "$value")

fun KatydidStyle.baselineShift(value: Percentage) =
    setProperty("baseline-shift", "$value")

fun KatydidStyle.baselineShift(value: EBaselineShift) =
    setProperty("baseline-shift", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.verticalAlign(baselineShift: Length, alignmentBaseline: EAlignmentBaseline? = null) =
    setVerticalAlign(baselineShift, alignmentBaseline)

fun KatydidStyle.verticalAlign(baselineShift: Percentage, alignmentBaseline: EAlignmentBaseline? = null) =
    setVerticalAlign(baselineShift, alignmentBaseline)

fun KatydidStyle.verticalAlign(alignmentBaseline: EAlignmentBaseline) =
    setProperty("vertical-align", "$alignmentBaseline")

fun KatydidStyle.verticalAlign(baselineShift: EBaselineShift, alignmentBaseline: EAlignmentBaseline? = null) =
    setVerticalAlign(baselineShift, alignmentBaseline)

//---------------------------------------------------------------------------------------------------------------------
