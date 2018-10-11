//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

@StyleBuilderDsl
abstract class StyleBlock {

    /**
     * Returns a list of the full-path selectors for this block, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple selectors (comma separated in the eventual CSS) at each level.
     */
    abstract val fullSelectors: List<String>

    /** The child style blocks nested within this parent block. */
    abstract val nestedBlocks: List<StyleBlock>

    ////

    /** Makes a copy of this style block, placing the copy as a child of [parentOfCopy]. */
    abstract fun copy(parentOfCopy: StyleBlock): StyleBlock

    /** Finds the placeholder with given [placeholderName]. */
    fun findPlaceholder(placeholderName: String): PlaceholderRule? {

        for (block in nestedBlocks) {
            if (block is PlaceholderRule && block.name == placeholderName) {
                return block
            }
        }

        return null

    }

    /** Converts this style block to CSS. */
    abstract fun toCssString(): String

}

//---------------------------------------------------------------------------------------------------------------------

