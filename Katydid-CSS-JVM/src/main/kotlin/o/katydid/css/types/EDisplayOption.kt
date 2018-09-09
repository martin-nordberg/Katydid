//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'display' property.
 */
enum class EDisplayOption {

    /** The "inline" display option. */
    INLINE,

    /** The "block" display option. */
    BLOCK,

    /** The "list-item" display option. */
    LIST_ITEM,

    /** The "inline-block" display option. */
    INLINE_BLOCK,

    /** The "table" display option. */
    TABLE,

    /** The "inline-table" display option. */
    INLINE_TABLE,

    /** The "table-row-group" display option. */
    TABLE_ROW_GROUP,

    /** The "table-header-group" display option. */
    TABLE_HEADER_GROUP,

    /** The "table-footer-group" display option. */
    TABLE_FOOTER_GROUP,

    /** The "table-row" display option. */
    TABLE_ROW,

    /** The "table-column-group" display option. */
    TABLE_COLUMN_GROUP,

    /** The "table-column" display option. */
    TABLE_COLUMN,

    /** The "table-cell" display option. */
    TABLE_CELL,

    /** The "table-caption" display option. */
    TABLE_CAPTION,

    /** The "none" display option. */
    NONE;

    ////

    /** @return the CSS attribute text for this display option. */
    fun toCssString() =
        when (this) {
            INLINE             -> "inline"
            BLOCK              -> "block"
            LIST_ITEM          -> "list-item"
            INLINE_BLOCK       -> "inline-block"
            TABLE              -> "table"
            INLINE_TABLE       -> "inline-table"
            TABLE_ROW_GROUP    -> "table-row-group"
            TABLE_HEADER_GROUP -> "table-header-group"
            TABLE_FOOTER_GROUP -> "table-footer-group"
            TABLE_ROW          -> "table-row"
            TABLE_COLUMN_GROUP -> "table-column-group"
            TABLE_COLUMN       -> "table-column"
            TABLE_CELL         -> "table-cell"
            TABLE_CAPTION      -> "table-caption"
            NONE               -> "none"
        }

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null                 -> null
                "inline"             -> INLINE
                "block"              -> BLOCK
                "list-item"          -> LIST_ITEM
                "inline-block"       -> INLINE_BLOCK
                "table"              -> TABLE
                "inline-table"       -> INLINE_TABLE
                "table-row-group"    -> TABLE_ROW_GROUP
                "table-header-group" -> TABLE_HEADER_GROUP
                "table-footer-group" -> TABLE_FOOTER_GROUP
                "table-row"          -> TABLE_ROW
                "table-column-group" -> TABLE_COLUMN_GROUP
                "table-column"       -> TABLE_COLUMN
                "table-cell"         -> TABLE_CELL
                "table-caption"      -> TABLE_CAPTION
                "none"               -> NONE
                else                 -> throw IllegalArgumentException("Unknown display option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

