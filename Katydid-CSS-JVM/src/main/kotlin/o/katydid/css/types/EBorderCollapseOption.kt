//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of border collapse options. */
@Suppress("EnumEntryName")
enum class EBorderCollapseOption (
    private val css : String
) {

    /** Collapsed borders. */
    collapse("collapse"),

    /** Separate borders. */
    separate("separate");

    ////

    /** @return the CSS attribute text for this border collapse option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "collapse"   -> collapse
                "separate" -> separate
                else     -> throw IllegalArgumentException("Unknown border collapse option: '$option'.")
            }

    }

}
