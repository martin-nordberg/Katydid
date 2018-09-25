//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'list-style-position' property. */
@Suppress("EnumEntryName")
enum class EListStylePositionOption(
    private val css: String
) {

    /** The marker box is outside the principal block box. */
    outside("outside"),

    /** The marker box is placed as the first inline box in the principal block box, before the element's content
     * and before any :before pseudo-elements. */
    inside("inside");

    ////

    /** @return the CSS attribute text for this list style position option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null      -> null
                "outside" -> outside
                "inside"  -> inside
                else      -> throw IllegalArgumentException("Unknown list style position option: '$option'.")
            }

    }

}
