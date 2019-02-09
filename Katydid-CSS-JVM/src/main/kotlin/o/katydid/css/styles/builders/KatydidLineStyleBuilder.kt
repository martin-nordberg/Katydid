//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.measurements.Length
import o.katydid.css.measurements.Percentage
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.ENormal
import x.katydid.css.infrastructure.makeDecimalString

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting line style properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidLineStyleBuilder(
    private val style: KatydidStyle
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

fun KatydidStyle.letterSpacing(value: Length) =
    setProperty("letter-spacing", "$value")

fun KatydidStyle.letterSpacing(value: ENormal) =
    setProperty("letter-spacing", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.line(build: KatydidLineStyleBuilder.() -> Unit) =
    KatydidLineStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.lineHeight(value: Length) =
    setProperty("line-height", "$value")

fun KatydidStyle.lineHeight(value: Percentage) =
    setProperty("line-height", "$value")

fun KatydidStyle.lineHeight(value: Float) =
    setProperty("line-height", makeDecimalString(value))

fun KatydidStyle.lineHeight(value: ENormal) =
    setProperty("line-height", "$value")

//---------------------------------------------------------------------------------------------------------------------
