//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.colors

//---------------------------------------------------------------------------------------------------------------------

fun opacify(color: Color, alphaIncrement: Float): Color =
    color.opacified(alphaIncrement)

//---------------------------------------------------------------------------------------------------------------------

fun transparentize(color: Color, alphaDecrement: Float): Color =
    color.transparentized(alphaDecrement)

//---------------------------------------------------------------------------------------------------------------------

