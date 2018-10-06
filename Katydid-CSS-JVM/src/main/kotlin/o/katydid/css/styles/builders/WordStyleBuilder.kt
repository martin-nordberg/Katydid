//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.Style
import o.katydid.css.types.ENormal
import o.katydid.css.types.EOverflowWrap

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting margin properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class WordStyleBuilder(
    private val style: Style
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

fun Style.word(build: WordStyleBuilder.() -> Unit) =
    WordStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun Style.wordSpacing(value: Length) =
    setProperty("word-spacing", "$value")

fun Style.wordSpacing(value: Percentage) =
    setProperty("word-spacing", "$value")

fun Style.wordSpacing(value: ENormal) =
    setProperty("word-spacing", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.wordWrap(value: EOverflowWrap) =
    setProperty("word-wrap", "$value")

//---------------------------------------------------------------------------------------------------------------------

