//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("ClassName")

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'background-repeat' property.
 */
enum class EBackgroundRepeatOption(
    private val css: String
) {

    /** The "no-repeat" background repeat option. */
    NO_REPEAT("no-repeat"),

    /** The "repeat" background repeat option. */
    REPEAT("repeat"),

    /** The "repeat-x" background repeat option. */
    REPEAT_X("repeat-x"),

    /** The "repeat-y" background repeat option. */
    REPEAT_Y("repeat-y");

    /** @return the CSS attribute text for this background repeat option. */
    fun toCssString() =
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

val repeat = EBackgroundRepeatOption.REPEAT
val repeatX = EBackgroundRepeatOption.REPEAT_X
val repeatY = EBackgroundRepeatOption.REPEAT_Y
val noRepeat = EBackgroundRepeatOption.NO_REPEAT

//---------------------------------------------------------------------------------------------------------------------

