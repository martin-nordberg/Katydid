//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.colors.Color
import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.EAuto

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting caret properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidCaretStyleBuilder(
    private val style: KatydidStyle
) {

    fun color(value: Color) =
        style.caretColor(value)

    fun color(value: EAuto) =
        style.caretColor(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.caret(build: KatydidCaretStyleBuilder.() -> Unit) =
    KatydidCaretStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.caretColor(value: Color) =
    setProperty("caret-color", "$value")

fun KatydidStyle.caretColor(value: EAuto) =
    setProperty("caret-color", "$value")

//---------------------------------------------------------------------------------------------------------------------
