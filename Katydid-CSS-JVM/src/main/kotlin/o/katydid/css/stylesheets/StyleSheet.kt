//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

//---------------------------------------------------------------------------------------------------------------------

/**
 * Represents a CSS style sheet with SASS-like provisions to build style blocks from string selectors and
 * styles.
 */
class StyleSheet {

    /** The outermost style block in the tree structure of style blocks for this style sheet. */
    private val styleBlock : StyleBlock = StyleBlock(null)

    /** The style block that is currently under construction. */
    private var activeStyleBlock: StyleBlock = styleBlock

    ////

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.and(that: String) =
        this + ", " + that

    /** Combines a selector with an already created [styleBlock] by adding the selector to the block. */
    infix fun String.and(styleBlock: StyleBlock): StyleBlock {

        for (selector in this.split(",").map { s -> s.trim() }.reversed()) {
            styleBlock.selectors.add(0,selector)
        }

        return styleBlock

    }

    /** Extends a style block named [styleBlockName] with the selector of the currently active style block. */
    @Suppress("unused")
    fun Style.extend(styleBlockName:String) {

        val block = activeStyleBlock.find(styleBlockName)
            ?: throw IllegalArgumentException("Unknown block to be extended: '$styleBlockName'.")

        block.selectors.addAll(activeStyleBlock.fullSelectors)

    }

    /** Includes the contents of another [styleSheet] directly in this one. */
    fun include(styleSheet:StyleSheet) {
        activeStyleBlock.nestedBlocks.addAll(styleSheet.styleBlock.nestedBlocks)
    }

    /** Builds a style block from a selector and the [build] function for the style. */
    operator fun String.invoke(build: Style.() -> Unit) : StyleBlock {

        val result = StyleBlock(activeStyleBlock)

        if ( this.startsWith("%") ) {
            result.name = this
        }
        else {
            result.selectors.addAll(this.split(",").map { s -> s.trim() })
        }
        activeStyleBlock.nestedBlocks.add(result)

        activeStyleBlock = result

        val style = Style()
        style.build()
        activeStyleBlock.style = style

        activeStyleBlock = activeStyleBlock.parent!!
        return result

    }

    /** Converts this stylesheet to CSS. */
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

