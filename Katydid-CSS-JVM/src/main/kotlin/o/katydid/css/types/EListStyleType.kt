//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'list-style-type' property. */
@Suppress("EnumEntryName")
enum class EListStyleType(
    private val css: String
) {

    /** Typical bulleted list. */
    disc("disc"),

    /** Open bulleted list. */
    circle("circle"),

    /** Squares for each list item. */
    square("square"),

    /** Decimal numbers, beginning with 1. */
    decimal("decimal"),

    /** Decimal numbers padded by initial zeros (e.g., 01, 02, 03, ..., 98, 99). */
    decimalLeadingZero("decimal-leading-zero"),

    /** Lowercase roman numerals (i, ii, iii, iv, v, etc.). */
    lowerRoman("lower-roman"),

    /** Uppercase roman numerals (I, II, III, IV, V, etc.). */
    upperRoman("upper-roman"),

    /** Traditional Georgian numbering (an, ban, gan, ..., he, tan, in, in-an, ...). */
    georgian("georgian"),

    /** Traditional uppercase Armenian numbering. */
    armenian("armenian"),

    /** Lowercase ascii letters (a, b, c, ... z). */
    lowerLatin("lower-latin"),

    /** Uppercase ascii letters (A, B, C, ... Z). */
    upperLatin("upper-latin"),

    /** Lowercase classical Greek alpha, beta, gamma, ... (α, β, γ, ...) */
    lowerGreek("lower-greek");

    // TODO: Lots more: https://www.w3.org/TR/css-counter-styles-3/#predefined-counters

    ////

    /** @return the CSS attribute text for this list style type option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null                   -> null
                "armenian"             -> armenian
                "circle"               -> circle
                "decimal"              -> decimal
                "decimal-leading-zero" -> decimalLeadingZero
                "disc"                 -> disc
                "georgian"             -> georgian
                "lower-alpha"          -> lowerLatin
                "lower-greek"          -> lowerGreek
                "lower-latin"          -> lowerLatin
                "lower-roman"          -> lowerRoman
                "square"               -> square
                "upper-alpha"          -> upperLatin
                "upper-latin"          -> upperLatin
                "upper-roman"          -> upperRoman
                else                   -> throw IllegalArgumentException("Unknown list style type option: '$option'.")
            }

        val lowerAlpha = lowerLatin

        val upperAlpha = upperLatin
    }

}
