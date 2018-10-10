//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

import o.katydid.css.colors.Color

/**Enumeration of options for the 'content' property. */
@Suppress("ClassName")
sealed class EImage(
    private val css: String
) {

    /** No image */
    object none : EImage("none")

    /** An image from a URL. */
    class url(attribute: String) : EImage("url(\"$attribute\")")

    /** A potential list of images or a fall-back solid color. */
    class image(vararg imageList: String, color: Color? = null) :
        EImage("image(" + imageList.joinToString(", ") { i -> "\"$i\"" } + (if (color == null) "" else ", $color") + ")")

    // TODO: linear-gradient, radial-gradient, repeating-linear-gradient, repeating-radial-gradient

//    linearGradient( ... ),
//
//    [ [ <angle> | to <side-or-corner> ] ,]?
//    <color-stop>[, <color-stop>]+
//    )
//
//    <side-or-corner> = [left | right] || [top | bottom]

    ////

    /** @return the CSS attribute text for this content option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null -> null
                // TODO: parse attr(..) and url(..)
                else -> throw IllegalArgumentException("Unknown content option: '$option'.")
            }

    }

}
