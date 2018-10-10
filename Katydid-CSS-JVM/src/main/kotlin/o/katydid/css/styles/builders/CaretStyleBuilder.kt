//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.colors.Color
import o.katydid.css.styles.Style
import o.katydid.css.types.EAuto

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting caret properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class CaretStyleBuilder(
    private val style: Style
) {

    fun color(value: Color) =
        style.caretColor(value)

    fun color(value: EAuto) =
        style.caretColor(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.caret(build: CaretStyleBuilder.() -> Unit) =
    CaretStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun Style.caretColor(value: Color) =
    setProperty("caret-color", "$value")

fun Style.caretColor(value: EAuto) =
    setProperty("caret-color", "$value")

//---------------------------------------------------------------------------------------------------------------------
