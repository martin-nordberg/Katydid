//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.KatydidStyle
import o.katydid.css.types.ENone

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting animation properties of a given [style] from a nested block.
 */
@KatydidStyleBuilderDsl
class KatydidAnimationStyleBuilder(
    private val style: KatydidStyle
) {

//    fun delay(value: KatydidDuration) =
//        style.animationDelay(value)
//
//    fun duration(value: KatydidDuration) =
//        style.animationDuration(value)

    fun name(value: ENone) =
        style.animationName(value)

    fun name(value: String) =
        style.animationName(value)

//    fun timingFunction(/*TODO*/) =
//        style.animationTimingFunction(/*TODO*/)

}

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.animation(build: KatydidAnimationStyleBuilder.() -> Unit) =
    KatydidAnimationStyleBuilder(this).build()

//---------------------------------------------------------------------------------------------------------------------

//fun KatydidStyle.animationDelay(value: KatydidDuration) =
//    setProperty("animation-delay", "$value")

//---------------------------------------------------------------------------------------------------------------------

//fun KatydidStyle.animationDuration(value: KatydidDuration) =
//    setProperty("animation-duration", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyle.animationName(value: ENone) =
    setProperty("animation-name", "$value")

fun KatydidStyle.animationName(value: String) =
    setProperty("animation-name", value)

//---------------------------------------------------------------------------------------------------------------------

//fun KatydidStyle.animationTimingFunction(/*TODO*/) =
//    setProperty("animationTimingFunction", "TODO")

//---------------------------------------------------------------------------------------------------------------------
