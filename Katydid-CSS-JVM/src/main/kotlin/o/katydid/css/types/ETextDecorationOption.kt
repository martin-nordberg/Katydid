//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-decoration' property. */
@Suppress("EnumEntryName")
enum class ETextDecorationOption(
    private val css: String
) {

    /** Each line of text is underlined. */
    underline("underline"),

    /** Each line of text has a line above it. */
    overline("overline"),

    /** Each line of text has a line through the middle. */
    lineThrough("line-through"),

    /** Text blinks (alternates between visible and invisible). */
    blink("blink");

    ////

    /** @return the CSS attribute text for this text decoration option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null    -> null
                "underline"  -> underline
                "overline" -> overline
                "line-through"  -> lineThrough
                "blink"  -> blink
                else    -> throw IllegalArgumentException("Unknown text decoration option: '$option'.")
            }

    }

}
