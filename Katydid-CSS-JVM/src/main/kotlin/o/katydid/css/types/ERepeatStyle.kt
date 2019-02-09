//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of options for the CSS 'background-repeat' property.
 */
@Suppress("EnumEntryName")
enum class ERepeatStyle(
    private val css: String
) {

    /** The image is repeated in this direction as often as needed to cover the background painting area. */
    repeat("repeat"),

    /**
     * The image is repeated as often as will fit within the background positioning area without being clipped and
     * then the images are spaced out to fill the area. The first and last images touch the edges of the area. If
     * the background painting area is larger than the background positioning area, then the pattern repeats to fill
     * the background painting area. The value of background-position for this direction is ignored, unless there is
     * not enough space for two copies of the image in this direction, in which case only one image is placed and
     * background-position determines its position in this direction.
     */
    space("space"),

    /**
     * The image is repeated as often as will fit within the background positioning area. If it doesn’t fit a whole
     * number of times, it is rescaled so that it does. See the formula under background-size. If the background
     * painting area is larger than the background positioning area, then the pattern repeats to fill the background
     * painting area.
     */
    round("round"),

    /** The image is placed once and not repeated in this direction. */
    noRepeat("no-repeat"),

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
                "no-repeat" -> noRepeat
                "repeat"    -> repeat
                "repeat-x"  -> repeatX
                "repeat-y"  -> repeatY
                "round"     -> round
                "space"     -> space
                else        -> throw IllegalArgumentException("Unknown background repeat option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

