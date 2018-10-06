//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.measurements.percent
import o.katydid.css.measurements.px
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.alignmentBaseline
import o.katydid.css.styles.builders.baselineShift
import o.katydid.css.styles.builders.verticalAlign
import o.katydid.css.styles.style
import o.katydid.css.types.EAlignmentBaseline
import o.katydid.css.types.EBaselineShift
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class VerticalAlignPropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Alignment baseline properties convert to correct CSS`() {

        checkStyle("alignment-baseline: alphabetic;") { alignmentBaseline(EAlignmentBaseline.alphabetic) }
        checkStyle("alignment-baseline: baseline;") { alignmentBaseline(EAlignmentBaseline.baseline) }
        checkStyle("alignment-baseline: bottom;") { alignmentBaseline(EAlignmentBaseline.bottom) }
        checkStyle("alignment-baseline: center;") { alignmentBaseline(EAlignmentBaseline.center) }
        checkStyle("alignment-baseline: central;") { alignmentBaseline(EAlignmentBaseline.central) }
        checkStyle("alignment-baseline: ideographic;") { alignmentBaseline(EAlignmentBaseline.ideographic) }
        checkStyle("alignment-baseline: mathematical;") { alignmentBaseline(EAlignmentBaseline.mathematical) }
        checkStyle("alignment-baseline: middle;") { alignmentBaseline(EAlignmentBaseline.middle) }
        checkStyle("alignment-baseline: text-bottom;") { alignmentBaseline(EAlignmentBaseline.textBottom) }
        checkStyle("alignment-baseline: text-top;") { alignmentBaseline(EAlignmentBaseline.textTop) }
        checkStyle("alignment-baseline: top;") { alignmentBaseline(EAlignmentBaseline.top) }

    }

    @Test
    fun `Baseline shift properties convert to correct CSS`() {

        checkStyle("baseline-shift: 4px;") { baselineShift(4.px) }

        checkStyle("baseline-shift: 4%;") { baselineShift(4.percent) }

        checkStyle("baseline-shift: sub;") { baselineShift(EBaselineShift.sub) }
        checkStyle("baseline-shift: super;") { baselineShift(EBaselineShift.`super`) }

    }

    @Test
    fun `Vertical alignment properties convert to correct CSS`() {

        checkStyle("vertical-align: 4px;") { verticalAlign(4.px) }

        checkStyle("vertical-align: 4%;") { verticalAlign(4.percent) }

        checkStyle("vertical-align: alphabetic;") { verticalAlign(EAlignmentBaseline.alphabetic) }

        checkStyle("vertical-align: sub;") { verticalAlign(EBaselineShift.sub) }
        checkStyle("vertical-align: super;") { verticalAlign(EBaselineShift.`super`) }

        checkStyle("vertical-align: 4px alphabetic;") { verticalAlign(4.px, EAlignmentBaseline.alphabetic) }

        checkStyle("vertical-align: 4% baseline;") { verticalAlign(4.percent, EAlignmentBaseline.baseline) }

        checkStyle("vertical-align: sub baseline;") { verticalAlign(EBaselineShift.sub, EAlignmentBaseline.baseline) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

