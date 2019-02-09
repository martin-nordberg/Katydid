//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the ol element's type attribute.
 * See https://www.w3.org/TR/html5/grouping-content.html#attr-ol-type.
 */
@Suppress("EnumEntryName")
enum class EOrderedListType(
    private val html: String
) {

    /** Ordered list type "1" for decimal numbers. */
    decimalNumbers("1"),

    /** Ordered list type "a" for lower case letters. */
    lowerCaseLetters("a"),

    /** Ordered list type "A" for upper case letters. */
    upperCaseLetters("A"),

    /** Ordered list type "i" for lower case Roman numerals. */
    lowerCaseRomanNumerals("i"),

    /** Ordered list type "I" for upper case Roman numerals. */
    upperCaseRomanNumerals("I");

    ////

    /** @return the HTML attribute text corresponding to this ordered list type. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

