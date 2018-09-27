//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-transform' property. */
@Suppress("EnumEntryName")
enum class ETextTransform(
    private val css: String
) {

    /** Puts the first character of each word in uppercase; other characters are unaffected. */
    capitalize("capitalize"),

    /** Puts all characters of each word in uppercase. */
    uppercase("uppercase"),

    /** Puts all characters of each word in lowercase. */
    lowercase("lowercase"),

    /** No capitalization effects. */
    none("none"),

    /**
     * Puts all typographic character units in fullwidth form. If a character does not have a corresponding fullwidth
     * form, it is left as is. This value is typically used to typeset Latin letters and digits as if they were
     * ideographic characters.
     */
    fullWidth("full-width");

    ////

    /** @return the CSS attribute text for this text transform option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null         -> null
                "capitalize" -> capitalize
                "full-width" -> fullWidth
                "lowercase"  -> lowercase
                "none"       -> none
                "uppercase"  -> uppercase
                else         -> throw IllegalArgumentException("Unknown text transform option: '$option'.")
            }

    }

}
