//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'empty-cells' property. */
@Suppress("EnumEntryName")
enum class EEmptyCells(
    private val css: String
) {

    /* Show border and background for empty cells. */
    show("show"),

    /* Hide border and background for empty cells. */
    hide("hide");

    ////

    /** @return the CSS attribute text for this empty cells option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null   -> null
                "hide" -> hide
                "show" -> show
                else   -> throw IllegalArgumentException("Unknown clear option: '$option'.")
            }

    }

}
