//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.ENormal
import o.katydid.css.types.EOverflowWrap

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting word style properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidWordStyleBuilder(
    private val style: KatydidStyle
) {

    fun spacing(value: Length) =
        style.wordSpacing(value)

    fun spacing(value: Percentage) =
        style.wordSpacing(value)

    fun spacing(value: ENormal) =
        style.wordSpacing(value)

    fun wrap(value: EOverflowWrap) =
        style.wordWrap(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.word(build: KatydidWordStyleBuilder.() -> Unit) =
    KatydidWordStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.wordSpacing(value: Length) =
    setProperty("word-spacing", "$value")

fun KatydidStyle.wordSpacing(value: Percentage) =
    setProperty("word-spacing", "$value")

fun KatydidStyle.wordSpacing(value: ENormal) =
    setProperty("word-spacing", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.wordWrap(value: EOverflowWrap) =
    setProperty("word-wrap", "$value")

//---------------------------------------------------------------------------------------------------------------------

