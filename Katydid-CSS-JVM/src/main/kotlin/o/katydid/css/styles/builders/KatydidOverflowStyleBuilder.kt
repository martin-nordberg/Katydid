//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EOverflow
import o.katydid.css.types.EOverflowWrap
import o.katydid.css.types.EResize

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting overflow properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidOverflowStyleBuilder(
    private val style: KatydidStyle
) {

    fun x(value: EOverflow) =
        style.overflowX(value)

    fun y(value: EOverflow) =
        style.overflowY(value)

    fun wrap(value: EOverflowWrap) =
        style.overflowWrap(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.overflow(build: KatydidOverflowStyleBuilder.() -> Unit) =
    KatydidOverflowStyleBuilder(this).build()

fun KatydidStyle.overflow(x: EOverflow, y: EOverflow = x) =
    setXyProperty("overflow", x, y)

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.overflowX(value: EOverflow) =
    setProperty("overflow-x", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.overflowY(value: EOverflow) =
    setProperty("overflow-y", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.overflowWrap(value: EOverflowWrap) =
    setProperty("overflow-wrap", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.resize(value: EResize) =
    setProperty("resize", "$value")

//---------------------------------------------------------------------------------------------------------------------

