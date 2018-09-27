//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/**Enumeration of options for the 'box-sizing' property. */
@Suppress("EnumEntryName")
enum class EBoxSizing(
    private val css: String
) {

    /** Normal CSS box model. */
    contentBox("content-box"),

    /** Legacy IE type box model. */
    borderBox("border-box");

    ////

    /** @return the CSS attribute text for this box sizing option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null          -> null
                "border-box"  -> borderBox
                "content-box" -> contentBox
                else          -> throw IllegalArgumentException("Unknown box sizing option: '$option'.")
            }

    }

}