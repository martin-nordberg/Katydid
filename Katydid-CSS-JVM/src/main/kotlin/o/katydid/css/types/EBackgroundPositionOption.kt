//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("ClassName")

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

enum class EBackgroundPositionOption(
    private val css: String
) {

    /** The "bottom" background position option. */
    BOTTOM("bottom"),

    /** The "center" background position option. */
    CENTER("center"),

    /** The "left" background position option. */
    LEFT("left"),

    /** The "right" background position option. */
    RIGHT("right"),

    /** The "top" background position option. */
    TOP("top");

    /** @return the CSS attribute text for this background position option. */
    fun toCssString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "bottom" -> BOTTOM
                "center" -> CENTER
                "left"   -> LEFT
                "right"  -> RIGHT
                "top"    -> TOP
                else     -> throw IllegalArgumentException("Unknown display option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------

val bottom = EBackgroundPositionOption.BOTTOM
val center = EBackgroundPositionOption.CENTER
val left = EBackgroundPositionOption.LEFT
val right = EBackgroundPositionOption.RIGHT
val top = EBackgroundPositionOption.TOP

//---------------------------------------------------------------------------------------------------------------------


