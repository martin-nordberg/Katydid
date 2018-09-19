//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'background-attachment' property.
 */
@Suppress("EnumEntryName")
enum class EBackgroundAttachmentOption(
    private val css: String
) {

    /** The "fixed" background attachment option. */
    fixed("fixed"),

    /** The "scroll" background attachment option. */
    scroll("scroll");

    /** @return the CSS attribute text for this background attachment option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "fixed"  -> fixed
                "scroll" -> scroll
                else     -> throw IllegalArgumentException("Unknown background attachment option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

