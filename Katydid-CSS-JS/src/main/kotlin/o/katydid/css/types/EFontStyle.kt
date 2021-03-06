//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'font-style' property. */
@Suppress("EnumEntryName")
enum class EFontStyle(
    private val css: String
) {

    normal("normal"),
    italic("italic"),
    oblique("oblique");

    ////

    /** @return the CSS attribute text for this font style option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null      -> null
                "italic"  -> italic
                "normal"  -> normal
                "oblique" -> oblique
                else      -> throw IllegalArgumentException("Unknown font style option: '$option'.")
            }

    }

}
