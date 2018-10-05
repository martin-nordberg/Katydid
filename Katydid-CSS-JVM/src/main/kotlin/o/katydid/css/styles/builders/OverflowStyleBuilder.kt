//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.types.EOverflow

//---------------------------------------------------------------------------------------------------------------------

@StyleBuilderDsl
class OverflowStyleBuilder(
    private val style: Style
) {

    fun Style.x(value: EOverflow) =
        style.overflowX(value)

    fun Style.y(value: EOverflow) =
        style.overflowY(value)

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

