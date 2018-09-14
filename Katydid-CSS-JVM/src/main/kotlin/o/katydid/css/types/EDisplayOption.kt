//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'display' property.
 */
enum class EDisplayOption(
    private val css: String
) {

    /** The "block" display option. */
    BLOCK("block"),

    /** The "inline" display option. */
    INLINE("inline"),

    /** The "inline-block" display option. */
    INLINE_BLOCK("inline-block"),

    /** The "inline-table" display option. */
    INLINE_TABLE("inline-table"),

    /** The "list-item" display option. */
    LIST_ITEM("list-item"),

    /** The "none" display option. */
    NONE("none"),

    /** The "table" display option. */
    TABLE("table"),

    /** The "table-caption" display option. */
    TABLE_CAPTION("table-caption"),

    /** The "table-cell" display option. */
    TABLE_CELL("table-cell"),

    /** The "table-column" display option. */
    TABLE_COLUMN("table-column"),

    /** The "table-column-group" display option. */
    TABLE_COLUMN_GROUP("table-column-group"),

    /** The "table-footer-group" display option. */
    TABLE_FOOTER_GROUP("table-footer-group"),

    /** The "table-header-group" display option. */
    TABLE_HEADER_GROUP("table-header-group"),

    /** The "table-row" display option. */
    TABLE_ROW("table-row"),

    /** The "table-row-group" display option. */
    TABLE_ROW_GROUP("table-row-group");

    ////

    /** @return the CSS attribute text for this display option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null                 -> null
                "block"              -> BLOCK
                "inline"             -> INLINE
                "inline-block"       -> INLINE_BLOCK
                "inline-table"       -> INLINE_TABLE
                "list-item"          -> LIST_ITEM
                "none"               -> NONE
                "table"              -> TABLE
                "table-caption"      -> TABLE_CAPTION
                "table-cell"         -> TABLE_CELL
                "table-column"       -> TABLE_COLUMN
                "table-column-group" -> TABLE_COLUMN_GROUP
                "table-footer-group" -> TABLE_FOOTER_GROUP
                "table-header-group" -> TABLE_HEADER_GROUP
                "table-row"          -> TABLE_ROW
                "table-row-group"    -> TABLE_ROW_GROUP
                else                 -> throw IllegalArgumentException("Unknown display option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

val block = EDisplayOption.BLOCK
val inline = EDisplayOption.INLINE
val inlineBlock = EDisplayOption.INLINE_BLOCK
val inlineTable = EDisplayOption.INLINE_TABLE
val listItem = EDisplayOption.LIST_ITEM
// Note: "none" does odd things in Kotlin compiler
val table = EDisplayOption.TABLE
val tableCaption = EDisplayOption.TABLE_CAPTION
val tableCell = EDisplayOption.TABLE_CELL
val tableColumn = EDisplayOption.TABLE_COLUMN
val tableColumnGroup = EDisplayOption.TABLE_COLUMN_GROUP
val tableFooterGroup = EDisplayOption.TABLE_FOOTER_GROUP
val tableHeaderGroup = EDisplayOption.TABLE_HEADER_GROUP
val tableRow = EDisplayOption.TABLE_ROW
val tableRowGroup = EDisplayOption.TABLE_ROW_GROUP

//---------------------------------------------------------------------------------------------------------------------

