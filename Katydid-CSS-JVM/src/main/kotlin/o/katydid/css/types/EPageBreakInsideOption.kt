//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'page-break-inside' property. */
@Suppress("EnumEntryName")
enum class EPageBreakInsideOption(
    private val css: String
) {

    /** Neither force nor forbid a page break inside the generated box. */
    auto("auto"),

    /** Avoid a page break inside the generated box. */
    avoid("avoid");

    ////

    /** @return the CSS attribute text for this page break option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "auto"   -> auto
                "avoid"  -> avoid
                else     -> throw IllegalArgumentException("Unknown page break inside option: '$option'.")
            }

    }

}
