//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-decoration' property. */
@Suppress("EnumEntryName")
enum class ETextDecorationLine(
    private val css: String
) {

    /** Each line of text is underlined. */
    underline("underline"),

    /** Each line of text has a line above it. */
    overline("overline"),

    /** Each line of text has a line through the middle. */
    lineThrough("line-through");

    ////

    /** @return the CSS attribute text for this text decoration option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null           -> null
                "line-through" -> lineThrough
                "overline"     -> overline
                "underline"    -> underline
                else           -> throw IllegalArgumentException("Unknown text decoration option: '$option'.")
            }

    }

}
