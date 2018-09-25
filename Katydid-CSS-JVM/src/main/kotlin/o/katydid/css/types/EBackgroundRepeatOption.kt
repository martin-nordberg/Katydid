//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'background-repeat' property.
 */
@Suppress("EnumEntryName")
enum class EBackgroundRepeatOption(
    private val css: String
) {

    /** The "no-repeat" background repeat option. */
    noRepeat("no-repeat"),

    /** The "repeat" background repeat option. */
    repeat("repeat"),

    /** The "repeat-x" background repeat option. */
    repeatX("repeat-x"),

    /** The "repeat-y" background repeat option. */
    repeatY("repeat-y");

    /** @return the CSS attribute text for this background repeat option. */
    override fun toString() =
        css

    ////

    companion object {

        /** Converts a string [option] to the equivalent background-repeat option. */
        fun fromString(option: String?) =
            when (option) {
                null        -> null
                "repeat"    -> repeat
                "repeat-x"  -> repeatX
                "repeat-y"  -> repeatY
                "no-repeat" -> noRepeat
                else        -> throw IllegalArgumentException("Unknown background repeat option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

