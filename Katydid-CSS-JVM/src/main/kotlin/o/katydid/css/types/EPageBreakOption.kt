//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'page-break-after/before' property. */
@Suppress("EnumEntryName")
enum class EPageBreakOption(
    private val css: String
) {

    /** Neither force nor forbid a page break before or after the generated box. */
    auto("auto"),

    /** Always force a page break before or after the generated box. */
    always("always"),

    /** Avoid a page break before or after the generated box. */
    avoid("avoid"),

    /** Force one or two page breaks before or after the generated box so that the next page is formatted as a left page. */
    left("left"),

    /** Force one or two page breaks before or after the generated box so that the next page is formatted as a right page. */
    right("right");

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
                "always" -> always
                "avoid"  -> avoid
                "left"   -> left
                "right"  -> right
                else     -> throw IllegalArgumentException("Unknown page break option: '$option'.")
            }

    }

}
