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

    /**
     * Extends a style block that has placeholder selector [placeholderSelector] with the selector of the currently
     * active style block. The placeholder must be found in a previously occurring sibling of the currently active
     * block.
     */
    @Suppress("unused")
    fun Style.extend(placeholderSelector:String) {

        require(placeholderSelector.startsWith("%")) {
            "Cannot extend a non-placeholder selector: '$placeholderSelector'."
        }

        val block = activeStyleBlock.parent!!.findPlaceholder(placeholderSelector)
            ?: throw IllegalArgumentException("Unknown block to be extended: '$placeholderSelector'.")

        block.selectors.addAll(activeStyleBlock.selectors)

    }

    /** Includes the contents of another [styleSheet] directly in this one. */
    fun include(styleSheet:StyleSheet) {
        activeStyleBlock.nestedBlocks.addAll(styleSheet.styleBlock.nestedBlocks.map{b->b.copy(activeStyleBlock)})
    }

    /** Builds a style block from a selector and the [build] function for the style. */
    operator fun String.invoke(build: Style.() -> Unit) : StyleBlock {

        // Create the new style block.
        val result = StyleBlock(activeStyleBlock)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new block in the active block.
        activeStyleBlock.nestedBlocks.add(result)

        // Make the new block active while we build it.
        val priorActiveStyleBlock = activeStyleBlock
        activeStyleBlock = result

        // Build its style.
        val style = Style()
        style.build()
        activeStyleBlock.style = style

        // Make the parent block active again.
        activeStyleBlock = priorActiveStyleBlock

        return result

    }

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String) =
        this + ", " + that

    /** Combines a selector with an already created [styleBlock] by adding the selector to the block. */
    infix fun String.or(styleBlock: StyleBlock): StyleBlock {

        styleBlock.prependSelectors(this)

        return styleBlock

    }

    /** Converts this style sheet to CSS. */
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

