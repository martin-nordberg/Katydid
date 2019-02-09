//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of border collapse options. */
@Suppress("EnumEntryName")
enum class EBorderCollapse(
    private val css: String
) {

    /** Collapsed borders. */
    collapse("collapse"),

    /** Separate borders. */
    separate("separate");

    ////

    /** @return the CSS attribute text for this border collapse option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null       -> null
                "collapse" -> collapse
                "separate" -> separate
                else       -> throw IllegalArgumentException("Unknown border collapse option: '$option'.")
            }

    }

}
