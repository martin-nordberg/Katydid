//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'font-variant' property. */
@Suppress("EnumEntryName")
enum class EFontVariantOption(
    private val css: String
) {

    normal("normal"),
    smallCaps("small-caps");

    ////

    /** @return the CSS attribute text for this font variant option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null         -> null
                "normal"     -> normal
                "small-caps" -> smallCaps
                else         -> throw IllegalArgumentException("Unknown font variant option: '$option'.")
            }

    }

}
