//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-transform' property. */
@Suppress("EnumEntryName")
enum class ETextTransformOption(
    private val css: String
) {

    /** Puts the first character of each word in uppercase; other characters are unaffected. */
    capitalize("capitalize"),

    /** Puts all characters of each word in uppercase. */
    uppercase("uppercase"),

    /** Puts all characters of each word in lowercase. */
    lowercase("lowercase"),

    /** No capitalization effects. */
    none("none");

    ////

    /** @return the CSS attribute text for this text transform option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null    -> null
                "capitalize"  -> capitalize
                "uppercase" -> uppercase
                "lowercase"  -> lowercase
                "none"  -> none
                else    -> throw IllegalArgumentException("Unknown text transform option: '$option'.")
            }

    }

}
