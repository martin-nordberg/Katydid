//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'font-variant' property. */
@Suppress("EnumEntryName")
enum class EFontVariant(
    private val css: String
) {

    /** None of the features listed below are enabled. */
    normal("normal"),

    /**
     * Enables display of small capitals (OpenType feature: smcp). Small-caps glyphs typically use the form of
     * uppercase letters but are reduced to the size of lowercase letters.
     */
    smallCaps("small-caps"),

    /** Enables display of small capitals for both upper and lowercase letters (OpenType features: c2sc, smcp). */
    allSmallCaps("all-small-caps"),

    /** Enables display of petite capitals (OpenType feature: pcap). */
    petiteCaps("petite-caps"),

    /** Enables display of petite capitals for both upper and lowercase letters (OpenType features: c2pc, pcap). */
    allPetiteCaps("all-petite-caps"),

    /**
     * Enables display of mixture of small capitals for uppercase letters with normal lowercase letters (OpenType
     * feature: unic).
     */
    unicase("unicase"),

    /**
     * Enables display of titling capitals (OpenType feature: titl). Uppercase letter glyphs are often designed
     * for use with lowercase letters. When used in all uppercase titling sequences they can appear too strong.
     * Titling capitals are designed specifically for this situation.
     */
    titlingCaps("titling-caps");

    ////

    /** @return the CSS attribute text for this font variant option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null              -> null
                "all-petite-caps" -> allPetiteCaps
                "all-small-caps"  -> allSmallCaps
                "normal"          -> normal
                "petite-caps"     -> petiteCaps
                "small-caps"      -> smallCaps
                "titling-caps"    -> titlingCaps
                "unicase"         -> unicase
                else              -> throw IllegalArgumentException("Unknown font variant option: '$option'.")
            }

    }

}
