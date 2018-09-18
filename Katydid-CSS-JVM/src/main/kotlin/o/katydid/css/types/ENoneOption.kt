//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of the option 'none' when other options for a property are not enumerated.
 */
@Suppress("EnumEntryName")
enum class ENoneOption(
    private val css: String
) {

    /** The "none" option. */
    none("none");

    ////

    /** @return the CSS attribute text for this option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null                 -> null
                "none"               -> none
                else                 -> throw IllegalArgumentException("Unknown 'none' option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

