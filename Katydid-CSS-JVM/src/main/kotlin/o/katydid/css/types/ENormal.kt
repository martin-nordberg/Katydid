//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of the option 'normal' when other options for a property are not enumerated.
 */
@Suppress("EnumEntryName")
enum class ENormal(
    private val css: String
) {

    /** The "normal" option. */
    normal("normal");

    ////

    /** @return the CSS attribute text for this option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "normal" -> normal
                else     -> throw IllegalArgumentException("Unknown 'normal' option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

