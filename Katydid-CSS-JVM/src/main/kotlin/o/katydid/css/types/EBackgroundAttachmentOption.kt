//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("ClassName")

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'display' property.
 */
enum class EBackgroundAttachmentOption(
    private val css: String
) {

    /** The "fixed" background attachment option. */
    FIXED("fixed"),

    /** The "scroll" background attachment option. */
    SCROLL("scroll");

    /** @return the CSS attribute text for this display option. */
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

val fixed = EBackgroundAttachmentOption.FIXED;
val scroll = EBackgroundAttachmentOption.SCROLL;

//---------------------------------------------------------------------------------------------------------------------

