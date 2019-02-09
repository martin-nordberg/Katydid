//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for the scope attribute of a th element.
 * See https://www.w3.org/TR/html5/tabular-data.html#elementdef-th.
 */
@Suppress("EnumEntryName")
enum class EHeadingScope(
    private val html: String
) {

    /** Heading scope "col". */
    col("col"),

    /** Heading scope "colgroup". */
    colgroup("colgroup"),

    /** Heading scope "row". */
    row("row"),

    /** Heading scope "rowgroup". */
    rowgroup("rowgroup");

    ////

    /** @return the HTML attribute text corresponding to this heading scope. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

