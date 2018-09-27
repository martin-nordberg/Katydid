//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'text-decoration-style' property. */
@Suppress("EnumEntryName")
enum class ETextDecorationStyle(
    private val css: String
) {

    /** A series of round dots. */
    dotted("dotted"),

    /** A series of square-ended dashes. */
    dashed("dashed"),

    /** A single line segment. */
    solid("solid"),

    /** Two parallel solid lines with some space between them. (The thickness of the lines is not specified, but the sum of the lines and the space must equal border-width.) */
    double("double"),

    /** Indicates a wavy line. */
    wavy("wavy");

    ////

    /** @return the CSS attribute text for this text decoration style option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "dotted" -> dotted
                "dashed" -> dashed
                "solid"  -> solid
                "double" -> double
                "wavy"   -> wavy
                else     -> throw IllegalArgumentException("Unknown text decoration style option: '$option'.")
            }

    }

}
