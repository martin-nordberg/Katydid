//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

//---------------------------------------------------------------------------------------------------------------------

class StyleSheet {

    private val styleBlock : StyleBlock = StyleBlock(null)

    private var activeStyleBlock: StyleBlock = styleBlock

    ////

    infix fun String.and(that: String) =
        this + ", " + that

    infix fun String.and(styleBlock: StyleBlock): StyleBlock {
        for (selector in this.split(",").map { s -> s.trim() }.reversed()) {
            styleBlock.selectors.add(0,selector)
        }
        return styleBlock
    }

    operator fun String.invoke(build: Style.() -> Unit) : StyleBlock {
        val result = StyleBlock(activeStyleBlock)
        result.selectors.addAll(this.split(",").map { s -> s.trim() })
        activeStyleBlock.nestedBlocks.add(result)

        activeStyleBlock = result

        val style = Style()
        style.build()
        activeStyleBlock.style = style

        activeStyleBlock = activeStyleBlock.parent!!
        return result
    }

    override fun toString(): String {

        val result = StringBuilder("")

        for (nestedBlock in styleBlock.nestedBlocks) {
            result.append(nestedBlock.toCssString())
        }

        return result.toString()

    }

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

