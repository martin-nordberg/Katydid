//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the 'direction' property.
 */
@Suppress("EnumEntryName")
enum class EDirectionOption(
    private val css: String
) {

    /** Left-to-right direction. */
    ltr("ltr"),

    /** Right-to-left direction. */
    rtl("rtl");

    ////

    /** @return the CSS attribute text for this direction option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null  -> null
                "ltr" -> ltr
                "rtl" -> rtl
                else  -> throw IllegalArgumentException("Unknown direction option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

