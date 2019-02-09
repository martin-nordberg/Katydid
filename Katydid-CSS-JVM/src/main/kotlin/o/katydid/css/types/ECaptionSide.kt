//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/**Enumeration of options for the 'caption-side' property. */
@Suppress("EnumEntryName")
enum class ECaptionSide(
    private val css: String
) {

    /** Positions the caption box above the table box. */
    top("top"),

    /** Positions the caption box below the table box. */
    bottom("bottom");

    ////

    /** @return the CSS attribute text for this caption side option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "bottom" -> bottom
                "top"    -> top
                else     -> throw IllegalArgumentException("Unknown caption side option: '$option'.")
            }

    }

}