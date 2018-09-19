//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'font-size' property. */
@Suppress("EnumEntryName")
enum class EFontSizeOption(
    private val css: String
) {

    xxSmall("xx-small"),
    xSmall("x-small"),
    small("small"),
    medium("medium"),
    large("large"),
    xLarge("x-large"),
    xxLarge("xx-large"),

    larger("larger"),
    smaller("smaller");

    ////

    /** @return the CSS attribute text for this font size option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null       -> null
                "xx-small" -> xxSmall
                "x-small"  -> xSmall
                "small"    -> small
                "medium"   -> medium
                "large"    -> large
                "x-large"  -> xLarge
                "xx-large" -> xxLarge
                "larger"   -> larger
                "smaller"  -> smaller
                else       -> throw IllegalArgumentException("Unknown font size option: '$option'.")
            }

    }

}
