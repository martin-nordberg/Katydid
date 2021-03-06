//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-overflow' property. */
@Suppress("EnumEntryName")
enum class ETextOverflow(
    private val css: String
) {

    /** Clip inline content that overflows its block container element. Characters may be only partially rendered. */
    clip("clip"),

    /** Render an ellipsis character (U+2026) to represent clipped inline content. Implementations may substitute
     * a more language, script, or writing-mode appropriate ellipsis character, or three dots "..." if the ellipsis
     * character is unavailable. */
    ellipsis("ellipsis");

    ////

    /** @return the CSS attribute text for this text overflow option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null       -> null
                "clip"     -> clip
                "ellipsis" -> ellipsis
                else       -> throw IllegalArgumentException("Unknown text overflow option: '$option'.")
            }

    }

}
