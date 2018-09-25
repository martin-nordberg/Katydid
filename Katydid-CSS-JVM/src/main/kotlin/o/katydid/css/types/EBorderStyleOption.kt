//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'border-xxx-style' family of options. */
@Suppress("EnumEntryName")
enum class EBorderStyleOption(
    private val css: String
) {

    /** No border; the computed border width is zero. */
    none("none"),

    /** Same as 'none', except in terms of border conflict resolution for table elements. */
    hidden("hidden"),

    /** The border is a series of dots. */
    dotted("dotted"),

    /** The border is a series of short line segments. */
    dashed("dashed"),

    /** The border is a single line segment. */
    solid("solid"),

    /** The border is two solid lines. The sum of the two lines and the space between them equals the value of 'border-width'. */
    double("double"),

    /** The border looks as though it were carved into the canvas. */
    groove("groove"),

    /** The opposite of 'groove': the border looks as though it were coming out of the canvas. */
    ridge("ridge"),

    /** The border makes the box look as though it were embedded in the canvas. */
    inset("inset"),

    /** The opposite of 'inset': the border makes the box look as though it were coming out of the canvas. */
    outset("outset");

    ////

    /** @return the CSS attribute text for this border style option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "none"   -> none
                "hidden" -> hidden
                "dotted" -> dotted
                "dashed" -> dashed
                "solid"  -> solid
                "double" -> double
                "groove" -> groove
                "ridge"  -> ridge
                "inset"  -> inset
                "outset" -> outset
                else     -> throw IllegalArgumentException("Unknown border style option: '$option'.")
            }

    }

}
