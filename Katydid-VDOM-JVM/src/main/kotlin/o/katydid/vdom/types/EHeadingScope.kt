//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the scope attribute of a th element.
 * See https://www.w3.org/TR/html5/tabular-data.html#elementdef-th.
 */
enum class EHeadingScope {

    /** Heading scope "col". */
    COL,

    /** Heading scope "colgroup". */
    COLGROUP,

    /** Input mode "kana-name". */
    ROW,

    /** Input mode "katakana". */
    ROWGROUP;

    /** @return the HTML attribute text corresponding to this heading scope. */
    fun toHtmlString(): String {
        return when (this) {
            COL      -> "col"
            COLGROUP -> "colgroup"
            ROW      -> "row"
            ROWGROUP -> "rowgroup"
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

