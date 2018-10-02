//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

//---------------------------------------------------------------------------------------------------------------------

class StyleSheet {

    private val styleBlock : StyleBlock = StyleBlock(null, "")

    private var activeStyleBlock: StyleBlock = styleBlock

    ////

    infix fun String.and(that: String) =
        this + ", " + that

    infix fun String.and(styleBlock: StyleBlock): StyleBlock {
        styleBlock.selector = this + ", " + styleBlock.selector
        return styleBlock
    }

    operator fun String.invoke(build: Style.() -> Unit) : StyleBlock {
        val result = StyleBlock(activeStyleBlock, this)
        activeStyleBlock.nestedBlocks.add(result)
        activeStyleBlock = result
        val style = Style()
        style.build()
        activeStyleBlock.style = style
        activeStyleBlock = activeStyleBlock.parent!!
        return result
    }

    override fun toString(): String =
        styleBlock.toCssString()

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style sheet object.
 * @param build the callback that fills in the CSS selectors and properties.
 */
fun styleSheet(
    build: StyleSheet.() -> Unit
): StyleSheet {

    val result = StyleSheet()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

