//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of the option 'none' when other options for a property are not enumerated or are not mutually exclusive.
 */
@Suppress("EnumEntryName")
enum class ENone(
    private val css: String
) {

    /** The "none" option. */
    none("none");

    ////

    /** @return the CSS attribute text for this option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null   -> null
                "none" -> none
                else   -> null
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

