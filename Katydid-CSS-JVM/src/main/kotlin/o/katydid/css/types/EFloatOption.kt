//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'float' property. */
@Suppress("EnumEntryName")
enum class EFloatOption(
    private val css: String
) {

    /** The element generates a block box that is floated to the left. Content flows on the right side of the box,
     * starting at the top (subject to the 'clear' property). */
    left("left"),

    /** Similar to 'left', except the box is floated to the right, and content flows on the left side of the box,
     * starting at the top. */
    right("right"),

    /** The box is not floated. */
    none("none");

    ////

    /** @return the CSS attribute text for this clear option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null    -> null
                "left"  -> left
                "right" -> right
                "none"  -> none
                else    -> throw IllegalArgumentException("Unknown float option: '$option'.")
            }

    }

}
