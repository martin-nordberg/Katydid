//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'resize' property. */
@Suppress("EnumEntryName")
enum class EResizeOption(
    private val css: String
) {

    /** The UA does not present a resizing mechanism on the element, and the user is given no direct manipulation
     * mechanism to resize the element. */
    none("none"),

    /** The UA presents a bidirectional resizing mechanism to allow the user to adjust both the height and the
     * width of the element. */
    both("both"),

    /** The UA presents a unidirectional horizontal resizing mechanism to allow the user to adjust only the width
     * of the element. */
    horizontal("horizontal"),

    /** The UA presents a unidirectional vertical resizing mechanism to allow the user to adjust only the height
     * of the element. */
    vertical("vertical");

    ////

    /** @return the CSS attribute text for this resize option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null         -> null
                "horizontal" -> horizontal
                "vertical"   -> vertical
                "both"       -> both
                "none"       -> none
                else         -> throw IllegalArgumentException("Unknown resize option: '$option'.")
            }

    }

}
