//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/**Enumeration of options for the 'border-xxx-width' property. */
@Suppress("EnumEntryName")
enum class ELineWidth(
    private val css: String
) {

    /** A thin border. */
    thin("thin"),

    /** A medium border. */
    medium("medium"),

    /** A thick border. */
    thick("thick");

    ////

    /** @return the CSS attribute text for this border width option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "medium" -> medium
                "thick"  -> thick
                "thin"   -> thin
                else     -> throw IllegalArgumentException("Unknown border style option: '$option'.")
            }

    }

}