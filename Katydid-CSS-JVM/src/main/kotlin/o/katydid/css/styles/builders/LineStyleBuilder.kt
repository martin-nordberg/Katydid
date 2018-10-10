//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.Style
import o.katydid.css.types.ENormal
import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting line style properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class LineStyleBuilder(
    private val style: Style
) {

    fun height(value: Length) =
        style.lineHeight(value)

    fun height(value: Percentage) =
        style.lineHeight(value)

    fun height(value: Float) =
        style.lineHeight(value)

    fun height(value: ENormal) =
        style.lineHeight(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.letterSpacing(value: Length) =
    setProperty("letter-spacing", "$value")

fun Style.letterSpacing(value: ENormal) =
    setProperty("letter-spacing", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.line(build: LineStyleBuilder.() -> Unit) =
    LineStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun Style.lineHeight(value: Length) =
    setProperty("line-height", "$value")

fun Style.lineHeight(value: Percentage) =
    setProperty("line-height", "$value")

fun Style.lineHeight(value: Float) =
    setProperty("line-height", makeDecimalString(value))

fun Style.lineHeight(value: ENormal) =
    setProperty("line-height", "$value")

//---------------------------------------------------------------------------------------------------------------------
