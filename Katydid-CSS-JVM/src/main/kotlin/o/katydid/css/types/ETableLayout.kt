//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'table-layout' property. */
@Suppress("EnumEntryName")
enum class ETableLayout(
    private val css: String
) {

    /** Use the fixed table layout algorithm. */
    fixed("fixed"),

    /** Use any automatic table layout algorithm. */
    auto("auto");

    ////

    /** @return the CSS attribute text for this table layout option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null    -> null
                "auto"  -> auto
                "fixed" -> fixed
                else    -> throw IllegalArgumentException("Unknown table layout option: '$option'.")
            }

    }

}
