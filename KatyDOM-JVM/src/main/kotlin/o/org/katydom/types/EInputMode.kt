//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the inputmode attribute of an input element.
 * See https://www.w3.org/TR/html51/sec-forms.html#element-attrdef-input-inputmode.
 */
enum class EInputMode {

    /** Input mode "full-width-latin". */
    FULL_WIDTH_LATIN,

    /** Input mode "kana". */
    KANA,

    /** Input mode "kana-name". */
    KANA_NAME,

    /** Input mode "katakana". */
    KATAKANA,

    /** Input mode "latin". */
    LATIN,

    /** Input mode "latin-name". */
    LATIN_NAME,

    /** Input mode "latin-prose". */
    LATIN_PROSE,

    /** Input mode "numeric". */
    NUMERIC,

    /** Input mode "verbatim". */
    VERBATIM;

    /** @return the HTML attribute text corresponding to this input mode. */
    fun toHtmlString(): String {
        return when (this) {
            FULL_WIDTH_LATIN -> "full-width-latin"
            KANA             -> "kana"
            KANA_NAME        -> "kana-name"
            KATAKANA         -> "katakana"
            LATIN            -> "latin"
            LATIN_NAME       -> "latin-name"
            LATIN_PROSE      -> "latin-prose"
            NUMERIC          -> "numeric"
            VERBATIM         -> "verbatim"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

