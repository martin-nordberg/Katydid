//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.*
import o.katydid.css.styles.Style
import o.katydid.css.types.EAuto

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting margin properties of a given [style] from a nested block.
 */
class MarginStyleBuilder(
    private val style: Style
) {

    fun bottom(value: Length) =
        style.setProperty("margin-bottom", "$value")

    fun bottom(value: Percentage) =
        style.setProperty("margin-bottom", "$value")

    fun bottom(value: EAuto) =
        style.setProperty("margin-bottom", "$value")

    fun left(value: Length) =
        style.setProperty("margin-left", "$value")

    fun left(value: Percentage) =
        style.setProperty("margin-left", "$value")

    fun left(value: EAuto) =
        style.setProperty("margin-left", "$value")

    fun right(value: Length) =
        style.setProperty("margin-right", "$value")

    fun right(value: Percentage) =
        style.setProperty("margin-right", "$value")

    fun right(value: EAuto) =
        style.setProperty("margin-right", "$value")

    fun top(value: Length) =
        style.setProperty("margin-top", "$value")

    fun top(value: Percentage) =
        style.setProperty("margin-top", "$value")

    fun top(value: EAuto) =
        style.setProperty("margin-top", "$value")

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.margin(build: MarginStyleBuilder.() -> Unit) =
    MarginStyleBuilder(this).build()

fun Style.margin(boxSize: BoxSize) =
    setProperty("margin", "$boxSize")

fun Style.margin(boxSize: BoxPercentages) =
    setProperty("margin", "$boxSize")

fun Style.margin(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
    margin(box(top, right, bottom, left))

fun Style.margin(top: Percentage, right: Percentage = top, bottom: Percentage = top, left: Percentage = right) =
    margin(box(top, right, bottom, left))

fun Style.margin(value: EAuto) =
    setProperty("margin", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.marginBottom(value: Length) =
    setProperty("margin-bottom", "$value")

fun Style.marginBottom(value: Percentage) =
    setProperty("margin-bottom", "$value")

fun Style.marginBottom(value: EAuto) =
    setProperty("margin-bottom", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.marginLeft(value: Length) =
    setProperty("margin-left", "$value")

fun Style.marginLeft(value: Percentage) =
    setProperty("margin-left", "$value")

fun Style.marginLeft(value: EAuto) =
    setProperty("margin-left", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.marginRight(value: Length) =
    setProperty("margin-right", "$value")

fun Style.marginRight(value: Percentage) =
    setProperty("margin-right", "$value")

fun Style.marginRight(value: EAuto) =
    setProperty("margin-right", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.marginTop(value: Length) =
    setProperty("margin-top", "$value")

fun Style.marginTop(value: Percentage) =
    setProperty("margin-top", "$value")

fun Style.marginTop(value: EAuto) =
    setProperty("margin-top", "$value")

//---------------------------------------------------------------------------------------------------------------------
