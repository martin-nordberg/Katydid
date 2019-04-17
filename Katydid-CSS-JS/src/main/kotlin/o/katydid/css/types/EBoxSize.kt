package o.katydid.css.types

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage

/** Enumeration of options for width and height properties. */
@Suppress("ClassName")
sealed class EBoxSize {

    /**
     * If specified for the inline axis, use the min-content inline size; otherwise compute to the property’s
     * initial value.
     */
    object minContent : EBoxSize() {

        override fun toString() =
            "min-content"

    }

    /**
     * If specified for the inline axis, use the max-content inline size; otherwise compute to the property’s
     * initial value.
     */
    object maxContent : EBoxSize() {

        override fun toString() =
            "max-content"

    }

    /**
     * If specified for the inline axis, use the fit-content formula with the available space replaced by the
     * specified argument, i.e. min(max-content, max(min-content, <length-percentage>)); otherwise compute to
     * the property’s initial value.
     */
    class fitContent(
        private val lengthOrPercentage: String
    ) : EBoxSize() {

        constructor(length: Length) : this("$length") {
            require(length.isNotNegative) { "Fit-content length may not be negative." }
        }

        constructor(percentage: Percentage) : this("$percentage") {
            require(percentage.isNotNegative) { "Fit-content percentage may not be negative." }
        }

        override fun toString() =
            "fit-content($lengthOrPercentage)"

    }

}
