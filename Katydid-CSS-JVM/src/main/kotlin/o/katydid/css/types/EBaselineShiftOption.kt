//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'baseline-shift' or 'vertical-align' property. */
@Suppress("EnumEntryName")
enum class EBaselineShiftOption(
    private val css: String
) {

    /** Lower by the offset appropriate for subscripts of the parent’s box. (The UA should use the parent’s font data
     * to find this offset whenever possible.) */
    sub("sub"),

    /** Raise by the offset appropriate for superscripts of the parent’s box. (The UA should use the parent’s font
     * data to find this offset whenever possible.) */
    `super`("super");

    ////

    /** @return the CSS attribute text for this baseline shift align option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null    -> null
                "sub"  -> sub
                "super"  -> `super`
                else    -> throw IllegalArgumentException("Unknown baseline shift align option: '$option'.")
            }

    }

}
