//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of the option 'invert' for outline color.
 */
@Suppress("EnumEntryName")
enum class EOutlineColor(
    private val css: String
) {

    /** Performs a color inversion on the pixels on the screen.. */
    invert("invert");

    ////

    /** @return the CSS attribute text for this outline color option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "invert" -> invert
                else     -> throw IllegalArgumentException("Unknown outline color option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

