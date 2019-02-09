//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'display' property.
 */
@Suppress("EnumEntryName")
enum class EDisplay(
    private val css: String
) {

    /** The "block" display option. */
    block("block"),

    /** The "inline" display option. */
    `inline`("inline"),

    /** The "inline-block" display option. */
    inlineBlock("inline-block"),

    /** The "inline-table" display option. */
    inlineTable("inline-table"),

    /** The "list-item" display option. */
    listItem("list-item"),

    /** The "none" display option. */
    none("none"),

    /** The "table" display option. */
    table("table"),

    /** The "table-caption" display option. */
    tableCaption("table-caption"),

    /** The "table-cell" display option. */
    tableCell("table-cell"),

    /** The "table-column" display option. */
    tableColumn("table-column"),

    /** The "table-column-group" display option. */
    tableColumnGroup("table-column-group"),

    /** The "table-footer-group" display option. */
    tableFooterGroup("table-footer-group"),

    /** The "table-header-group" display option. */
    tableHeaderGroup("table-header-group"),

    /** The "table-row" display option. */
    tableRow("table-row"),

    /** The "table-row-group" display option. */
    tableRowGroup("table-row-group");

    ////

    /** @return the CSS attribute text for this display option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null                 -> null
                "block"              -> block
                "inline"             -> inline
                "inline-block"       -> inlineBlock
                "inline-table"       -> inlineTable
                "list-item"          -> listItem
                "none"               -> none
                "table"              -> table
                "table-caption"      -> tableCaption
                "table-cell"         -> tableCell
                "table-column"       -> tableColumn
                "table-column-group" -> tableColumnGroup
                "table-footer-group" -> tableFooterGroup
                "table-header-group" -> tableHeaderGroup
                "table-row"          -> tableRow
                "table-row-group"    -> tableRowGroup
                else                 -> throw IllegalArgumentException("Unknown display option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

