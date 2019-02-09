//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'white-space' property. */
@Suppress("EnumEntryName")
enum class EWhiteSpace(
    private val css: String
) {

    /**
     * This value directs user agents to collapse sequences of white space into a single character (or in some
     * cases, no character). Lines may wrap at allowed soft wrap opportunities, as determined by the line-breaking
     * rules in effect, in order to minimize inline-axis overflow.
     */
    normal("normal"),

    /**
     * This value prevents user agents from collapsing sequences of white space. Segment breaks such as line feeds
     * are preserved as forced line breaks. Lines only break at forced line breaks; content that does not fit within
     * the block container overflows it.
     */
    pre("pre"),

    /** Like normal, this value collapses white space; but like pre, it does not allow wrapping. */
    nowrap("nowrap"),

    /** Like pre, this value preserves white space; but like normal, it allows wrapping. */
    preWrap("pre-wrap"),

    /**
     * The behavior is identical to that of pre-wrap, except that: Any sequence of preserved white space always
     * takes up space, including at the end of the line....
     */
    breakSpaces("break-spaces"),

    /**
     * Like normal, this value collapses consecutive spaces and allows wrapping, but preserves segment breaks in
     * the source as forced line breaks.
     */
    preLine("pre-line");

    ////

    /** @return the CSS attribute text for this white space option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null          -> null
                "normal"      -> normal
                "pre"         -> pre
                "nowrap"      -> nowrap
                "pre-wrap"    -> preWrap
                "break-space" -> breakSpaces
                "pre-line"    -> preLine
                else          -> throw IllegalArgumentException("Unknown white space option: '$option'.")
            }

    }

}
