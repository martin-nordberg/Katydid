//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'overflow-wrap' property. */
@Suppress("EnumEntryName")
enum class EOverflowWrap(
    private val css: String
) {

    /**
     * Lines may break only at allowed break points. However, the restrictions introduced by word-break: keep-all
     * may be relaxed to match word-break: normal if there are no otherwise-acceptable break points in the line.
     */
    normal("normal"),

    /**
     * An otherwise unbreakable sequence of characters may be broken at an arbitrary point if there are no
     * otherwise-acceptable break points in the line. Shaping characters are still shaped as if the word were not
     * broken, and grapheme clusters must stay together as one unit. No hyphenation character is inserted at the
     * break point.
     */
    breakWord("break-word");

    ////

    /** @return the CSS attribute text for this overflow wrap option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null         -> null
                "normal"     -> normal
                "break-word" -> breakWord
                else         -> throw IllegalArgumentException("Unknown overflow wrap option: '$option'.")
            }

    }

}
