//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'list-style-type' property. */
@Suppress("EnumEntryName")
enum class EListStyleTypeOption(
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

    ////

    /** @return the CSS attribute text for this list style type option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null                   -> null
                "disc"                 -> disc
                "circle"               -> circle
                "square"               -> square
                "decimal"              -> decimal
                "decimal-leading-zero" -> decimalLeadingZero
                "lower-roman"          -> lowerRoman
                "upper-roman"          -> upperRoman
                "georgian"             -> georgian
                "armenian"             -> armenian
                "lower-alpha"          -> lowerLatin
                "lower-latin"          -> lowerLatin
                "upper-alpha"          -> upperLatin
                "upper-latin"          -> upperLatin
                "lower-greek"          -> lowerGreek
                else                   -> throw IllegalArgumentException("Unknown list style type option: '$option'.")
            }

        val lowerAlpha = lowerLatin

        val upperAlpha = upperLatin
    }

}
