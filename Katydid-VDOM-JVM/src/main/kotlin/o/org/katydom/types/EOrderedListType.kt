//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the ol element's type attribute.
 * See https://www.w3.org/TR/html5/grouping-content.html#attr-ol-type.
 */
enum class EOrderedListType {

    /** Ordered list type "1" for decimal numbers. */
    DECIMAL_NUMBERS,

    /** Ordered list type "a" for lower case letters. */
    LOWER_CASE_LETTERS,

    /** Ordered list type "A" for upper case letters. */
    UPPER_CASE_LETTERS,

    /** Ordered list type "i" for lower case Roman numerals. */
    LOWER_CASE_ROMAN_NUMERALS,

    /** Ordered list type "I" for upper case Roman numerals. */
    UPPER_CASE_ROMAN_NUMERALS;

    /** @return the HTML attribute text corresponding to this ordered list type. */
    fun toHtmlString(): String {
        return when (this) {
            DECIMAL_NUMBERS           -> "1"
            LOWER_CASE_LETTERS        -> "a"
            UPPER_CASE_LETTERS        -> "A"
            LOWER_CASE_ROMAN_NUMERALS -> "i"
            UPPER_CASE_ROMAN_NUMERALS -> "I"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

