//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.*
import o.katydid.css.styles.Style

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting padding properties of a given [style] from a nested block.
 */
class PaddingStyleBuilder(
    private val style: Style
) {

    fun bottom(value: Length) =
        style.setProperty("padding-bottom", "$value")

    fun bottom(value: Percentage) =
        style.setProperty("padding-bottom", "$value")

    fun left(value: Length) =
        style.setProperty("padding-left", "$value")

    fun left(value: Percentage) =
        style.setProperty("padding-left", "$value")

    fun right(value: Length) =
        style.setProperty("padding-right", "$value")

    fun right(value: Percentage) =
        style.setProperty("padding-right", "$value")

    fun top(value: Length) =
        style.setProperty("padding-top", "$value")

    fun top(value: Percentage) =
        style.setProperty("padding-top", "$value")

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.padding(build: PaddingStyleBuilder.() -> Unit) =
    PaddingStyleBuilder(this).build()

fun Style.padding(boxSize: BoxSize) =
    setProperty("padding", "$boxSize")

fun Style.padding(boxSize: BoxPercentages) =
    setProperty("padding", "$boxSize")

fun Style.padding(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
    padding(box(top, right, bottom, left))

fun Style.padding(top: Percentage, right: Percentage = top, bottom: Percentage = top, left: Percentage = right) =
    padding(box(top, right, bottom, left))

//---------------------------------------------------------------------------------------------------------------------

fun Style.paddingBottom(value: Length) =
    setProperty("padding-bottom", "$value")

fun Style.paddingBottom(value: Percentage) =
    setProperty("padding-bottom", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.paddingLeft(value: Length) =
    setProperty("padding-left", "$value")

fun Style.paddingLeft(value: Percentage) =
    setProperty("padding-left", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.paddingRight(value: Length) =
    setProperty("padding-right", "$value")

fun Style.paddingRight(value: Percentage) =
    setProperty("padding-right", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.paddingTop(value: Length) =
    setProperty("padding-top", "$value")

fun Style.paddingTop(value: Percentage) =
    setProperty("padding-top", "$value")

//---------------------------------------------------------------------------------------------------------------------
