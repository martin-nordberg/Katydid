//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.measurements


//---------------------------------------------------------------------------------------------------------------------

class BoxSize(
    val top: Length,
    val right: Length = top,
    val bottom: Length = top,
    val left: Length = right
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

fun box(value: String): BoxSize {
    val lengths = value.split("\\s+".toRegex())

    return when (lengths.size) {
        1    -> BoxSize(length(lengths[0]))
        2    -> BoxSize(length(lengths[0]), length(lengths[1]))
        3    -> BoxSize(length(lengths[0]), length(lengths[1]), length(lengths[2]))
        4    -> BoxSize(length(lengths[0]), length(lengths[1]), length(lengths[2]), length(lengths[3]))
        else -> throw IllegalArgumentException("Too many measurements (${lengths.size}) for box.")
    }
}

//---------------------------------------------------------------------------------------------------------------------

fun box(vararg lengths: Any) =
    when (lengths.size) {
        1    -> BoxSize(length(lengths[0]))
        2    -> BoxSize(length(lengths[0]), length(lengths[1]))
        3    -> BoxSize(length(lengths[0]), length(lengths[1]), length(lengths[2]))
        4    -> BoxSize(length(lengths[0]), length(lengths[1]), length(lengths[2]), length(lengths[3]))
        else -> throw IllegalArgumentException("Too many measurements (${lengths.size}) for box.")
    }

//---------------------------------------------------------------------------------------------------------------------

