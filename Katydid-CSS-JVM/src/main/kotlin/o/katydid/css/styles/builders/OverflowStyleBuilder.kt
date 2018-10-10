//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.types.EOverflow
import o.katydid.css.types.EOverflowWrap
import o.katydid.css.types.EResize

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting overflow properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class OverflowStyleBuilder(
    private val style: Style
) {

    fun x(value: EOverflow) =
        style.overflowX(value)

    fun y(value: EOverflow) =
        style.overflowY(value)

    fun wrap(value: EOverflowWrap) =
        style.overflowWrap(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.overflow(build: OverflowStyleBuilder.() -> Unit) =
    OverflowStyleBuilder(this).build()

fun Style.overflow(x: EOverflow, y: EOverflow = x) =
    setXyProperty("overflow", x, y)

//---------------------------------------------------------------------------------------------------------------------

fun Style.overflowX(value: EOverflow) =
    setProperty("overflow-x", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.overflowY(value: EOverflow) =
    setProperty("overflow-y", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.overflowWrap(value: EOverflowWrap) =
    setProperty("overflow-wrap", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.resize(value: EResize) =
    setProperty("resize", "$value")

//---------------------------------------------------------------------------------------------------------------------

