//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.StyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Represents a CSS style sheet with SASS-like provisions to build style blocks from string selectors and
 * styles.
 */
@StyleBuilderDsl
class StyleSheet : StyleBlock() {

    /**
     * Returns a list of the full-path selectors for this block, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple selectors (comma separated in the eventual CSS) at each level.
     */
    override val fullSelectors: List<String>
        get() = emptyList()

    /** The child style blocks nested within this parent block. */
    override val nestedBlocks: MutableList<StyleRule> = mutableListOf()

    ////

    /** Includes the contents of another [styleSheet] directly in this one. */
    fun include(styleSheet: StyleSheet) {
        nestedBlocks.addAll(styleSheet.nestedBlocks.map { b -> b.copy(this) })
    }

    /** Builds a style rule from a selector and the [build] function for the style. */
    operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style block.
        val result = StyleRule(this@StyleSheet)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new block in the active block.
        this@StyleSheet.nestedBlocks.add(result)

        // Build its style.
        result.build()

        return result

    }

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String) =
        this + ", " + that

    /** Combines a selector with an already created [styleRule] by adding the selector to the block. */
    infix fun String.or(styleRule: StyleRule): StyleRule {

        styleRule.prependSelectors(this)

        return styleRule

    }

    /** Converts this style block to CSS. */
    override fun toCssString(): String {

        val result = StringBuilder("")

        for (nestedBlock in nestedBlocks) {
            result.append(nestedBlock.toCssString())
        }

        return result.toString()

    }

    /** Converts this style sheet to CSS. */
    override fun toString(): String =
        toCssString()

}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds a new style sheet object.
 * @param build the callback that fills in the CSS selectors and properties.
 */
fun makeStyleSheet(
    build: StyleSheet.() -> Unit
): StyleSheet {

    val result = StyleSheet()
    result.build()
    return result

}

//---------------------------------------------------------------------------------------------------------------------

