//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.*
import o.katydid.css.styles.KatydidStyle

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting padding properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidPaddingStyleBuilder(
    private val style: KatydidStyle
) {

    fun bottom(value: Length) =
        style.paddingBottom(value)

    fun bottom(value: Percentage) =
        style.paddingBottom(value)

    fun left(value: Length) =
        style.paddingLeft(value)

    fun left(value: Percentage) =
        style.paddingLeft(value)

    fun right(value: Length) =
        style.paddingRight(value)

    fun right(value: Percentage) =
        style.paddingRight(value)

    fun top(value: Length) =
        style.paddingTop(value)

    fun top(value: Percentage) =
        style.paddingTop(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.padding(build: KatydidPaddingStyleBuilder.() -> Unit) =
    KatydidPaddingStyleBuilder(this).build()

fun KatydidStyle.padding(top: Length, right: Length = top, bottom: Length = top, left: Length = right) =
    setBoxProperty("padding", top, right, bottom, left)

fun KatydidStyle.padding(top: Percentage, right: Percentage = top, bottom: Percentage = top, left: Percentage = right) =
    setBoxProperty("padding", top, right, bottom, left)

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.paddingBottom(value: Length) =
    setProperty("padding-bottom", "$value")

fun KatydidStyle.paddingBottom(value: Percentage) =
    setProperty("padding-bottom", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.paddingLeft(value: Length) =
    setProperty("padding-left", "$value")

fun KatydidStyle.paddingLeft(value: Percentage) =
    setProperty("padding-left", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.paddingRight(value: Length) =
    setProperty("padding-right", "$value")

fun KatydidStyle.paddingRight(value: Percentage) =
    setProperty("padding-right", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.paddingTop(value: Length) =
    setProperty("padding-top", "$value")

fun KatydidStyle.paddingTop(value: Percentage) =
    setProperty("padding-top", "$value")

//---------------------------------------------------------------------------------------------------------------------
