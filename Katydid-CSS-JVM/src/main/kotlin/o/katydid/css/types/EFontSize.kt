//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'font-size' property. */
@Suppress("EnumEntryName")
enum class EFontSize(
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
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null       -> null
                "large"    -> large
                "larger"   -> larger
                "medium"   -> medium
                "small"    -> small
                "smaller"  -> smaller
                "x-large"  -> xLarge
                "x-small"  -> xSmall
                "xx-large" -> xxLarge
                "xx-small" -> xxSmall
                else       -> throw IllegalArgumentException("Unknown font size option: '$option'.")
            }

    }

}
