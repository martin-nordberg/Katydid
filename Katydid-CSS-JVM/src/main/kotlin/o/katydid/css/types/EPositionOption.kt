//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'position' property. */
@Suppress("EnumEntryName")
enum class EPositionOption(
    private val css: String
) {

    /** The box is a normal box, laid out according to the normal flow. The 'top', 'right', 'bottom', and 'left'
     * properties do not apply. */
    static("static"),

    /** The box's position is calculated according to the normal flow (this is called the position in normal flow).
     * Then the box is offset relative to its normal position.  */
    relative("relative"),

    /** The box's position (and possibly size) is specified with the 'top', 'right', 'bottom', and 'left' properties.
     * These properties specify offsets with respect to the box's containing block. Absolutely positioned boxes are
     * taken out of the normal flow. */
    absolute("absolute"),

    /** The box's position is calculated according to the 'absolute' model, but in addition, the box is fixed with
     * respect to some reference. */
    fixed("fixed");

    ////

    /** @return the CSS attribute text for this position option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null    -> null
                "static"  -> static
                "relative" -> relative
                "absolute"  -> absolute
                "fixed"  -> fixed
                else    -> throw IllegalArgumentException("Unknown position option: '$option'.")
            }

    }

}
