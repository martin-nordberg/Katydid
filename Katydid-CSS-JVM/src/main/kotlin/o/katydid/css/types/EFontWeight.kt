//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'font-weight' property. */
@Suppress("EnumEntryName")
enum class EFontWeight(
    private val css: String
) {

    normal("normal"),
    bold("bold"),
    bolder("bolder"),
    lighter("lighter"),
    weight100("100"),
    weight200("200"),
    weight300("300"),
    weight400("400"),
    weight500("500"),
    weight600("600"),
    weight700("700"),
    weight800("800"),
    weight900("900");

    ////

    /** @return the CSS attribute text for this font weight option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null      -> null
                "100"     -> weight100
                "200"     -> weight200
                "300"     -> weight300
                "400"     -> weight400
                "500"     -> weight500
                "600"     -> weight600
                "700"     -> weight700
                "800"     -> weight800
                "900"     -> weight900
                "bold"    -> bold
                "bolder"  -> bolder
                "lighter" -> lighter
                "normal"  -> normal
                else      -> throw IllegalArgumentException("Unknown font weight option: '$option'.")
            }

    }

}
