//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/**Enumeration of options for the 'content' property. */
@Suppress("EnumEntryName")
enum class EContent(
    private val css: String
) {

    /** The pseudo-element is not generated. */
    none("none"),

    /** Computes to 'none' for the :before and :after pseudo-elements. */
    normal("normal"),

    /** Inserts the appropriate string from the 'quotes' property. */
    openQuote("open-quote"),

    /** Inserts the appropriate string from the 'quotes' property. */
    closeQuote("close-quote"),

    /** Introduces no content, but increments the level of nesting for quotes. */
    noOpenQuote("no-open-quote"),

    /** Introduces no content, but decrements the level of nesting for quotes. */
    noCloseQuote("no-close-quote");

    ////

    /** @return the CSS attribute text for this content option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null             -> null
                "close-quote"    -> closeQuote
                "no-close-quote" -> noCloseQuote
                "no-open-quote"  -> noOpenQuote
                "none"           -> none
                "normal"         -> normal
                "open-quote"     -> openQuote
                else             -> throw IllegalArgumentException("Unknown content option: '$option'.")
            }

    }

}
