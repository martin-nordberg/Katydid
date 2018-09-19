//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'clear' property. */
@Suppress("EnumEntryName")
enum class EClearOption(
    private val css: String
) {

    /** Requires that the top border edge of the box be below the bottom outer edge of any left-floating boxes that
     * resulted from elements earlier in the source document. */
    left("left"),

    /** Requires that the top border edge of the box be below the bottom outer edge of any right-floating boxes
     * that resulted from elements earlier in the source document. */
    right("right"),

    /** Requires that the top border edge of the box be below the bottom outer edge of any right-floating and
     * left-floating boxes that resulted from elements earlier in the source document. */
    both("both"),

    /** No constraint on the box's position with respect to floats. */
    none("none");

    ////

    /** @return the CSS attribute text for this clear option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null    -> null
                "left"  -> left
                "right" -> right
                "both"  -> both
                "none"  -> none
                else    -> throw IllegalArgumentException("Unknown clear option: '$option'.")
            }

    }

}
