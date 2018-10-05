//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.measurements


//---------------------------------------------------------------------------------------------------------------------

class BoxPercentages(
    val top: Percentage,
    val right: Percentage = top,
    val bottom: Percentage = top,
    val left: Percentage = right
) {

    override fun toString(): String =
        when {
            top == right && top == bottom && top == left -> "$top"
            top == bottom && left == right               -> "$top $right"
            left == right                                -> "$top $right $bottom"
            else                                         -> "$top $right $bottom $left"
        }

}

//---------------------------------------------------------------------------------------------------------------------

fun box(vararg lengths: Percentage) =
    when (lengths.size) {
        1    -> BoxPercentages(lengths[0])
        2    -> BoxPercentages(lengths[0], lengths[1])
        3    -> BoxPercentages(lengths[0], lengths[1], lengths[2])
        4    -> BoxPercentages(lengths[0], lengths[1], lengths[2], lengths[3])
        else -> throw IllegalArgumentException("Too many percentages (${lengths.size}) for box.")
    }

//---------------------------------------------------------------------------------------------------------------------

