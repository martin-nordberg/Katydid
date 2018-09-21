//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-align' property. */
@Suppress("EnumEntryName")
enum class ETextAlignOption(
    private val css: String
) {

    left("left"),
    right("right"),
    center("center"),
    justify("justify");

    ////

    /** @return the CSS attribute text for this text align option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null      -> null
                "left"    -> left
                "right"   -> right
                "center"  -> center
                "justify" -> justify
                else      -> throw IllegalArgumentException("Unknown text align option: '$option'.")
            }

    }

}
