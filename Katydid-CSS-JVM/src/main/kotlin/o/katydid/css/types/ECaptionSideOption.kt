//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/**Enumeration of options for the 'caption-side' property. */
@Suppress("EnumEntryName")
enum class ECaptionSideOption (
    private val css : String
) {

    top( "top" ),
    /** Positions the caption box above the table box. */

    /** Positions the caption box below the table box. */
    bottom( "bottom" );

    ////

    /** @return the CSS attribute text for this caption side option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "top"    -> top
                "bottom" -> bottom
                else     -> throw IllegalArgumentException("Unknown caption side option: '$option'.")
            }

    }

}