//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/**Enumeration of options for the 'content' property. */
@Suppress("EnumEntryName")
sealed class EContent(
    private val css: String
) {

    /** The pseudo-element is not generated. */
    object none : EContent("none")

    /** Computes to 'none' for the :before and :after pseudo-elements. */
    object normal : EContent("normal")

    /** Inserts the appropriate string from the 'quotes' property. */
    object openQuote : EContent("open-quote")

    /** Inserts the appropriate string from the 'quotes' property. */
    object closeQuote : EContent("close-quote")

    /** Introduces no content, but increments the level of nesting for quotes. */
    object noOpenQuote : EContent("no-open-quote")

    /** Introduces no content, but decrements the level of nesting for quotes. */
    object noCloseQuote : EContent("no-close-quote")

    /** Introduces content from an element attribute with given name. */
    class attr(attribute: String) : EContent("attr($attribute)")

    /** Introduces content from a URL. */
    class url(attribute: String) : EContent("url(\"$attribute\")")

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
                // TODO: parse attr(..) and url(..)
                else             -> throw IllegalArgumentException("Unknown content option: '$option'.")
            }

    }

}
