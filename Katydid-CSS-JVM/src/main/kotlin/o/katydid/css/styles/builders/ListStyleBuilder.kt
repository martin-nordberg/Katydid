//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles.builders

import o.katydid.css.styles.Style
import o.katydid.css.types.EImage
import o.katydid.css.types.EListStylePosition
import o.katydid.css.types.EListStyleType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder class for setting list style properties of a given [style] from a nested block.
 */
@StyleBuilderDsl
class ListStyleBuilder(
    private val style: Style
) {

    fun image(value: EImage) =
        style.listStyleImage(value)

    fun position(value: EListStylePosition) =
        style.listStylePosition(value)

    fun type(value: EListStyleType) =
        style.listStyleType(value)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.listStyle(build: ListStyleBuilder.() -> Unit) =
    ListStyleBuilder(this).build()

fun Style.listStyle(type: EListStyleType, position: EListStylePosition? = null, imageUrl: String? = null) {

    var css = "$type"

    if (position != null) {
        css += " $position"
    }

    if (imageUrl != null) {
        // TODO: does image need to go first to be useful?
        css += " url(\"$imageUrl\")"
    }

    setProperty("list-style", css)

}

//---------------------------------------------------------------------------------------------------------------------

fun Style.listStyleImage(value: EImage) =
    setProperty("list-style-image", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.listStylePosition(value: EListStylePosition) =
    setProperty("list-style-position", "$value")

//---------------------------------------------------------------------------------------------------------------------

fun Style.listStyleType(value: EListStyleType) =
    setProperty("list-style-type", "$value")

//---------------------------------------------------------------------------------------------------------------------
