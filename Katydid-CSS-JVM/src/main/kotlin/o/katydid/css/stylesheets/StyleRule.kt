//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.styles.makeStyle

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@StyleBuilderDsl
class StyleRule(
    internal val parent: StyleBlock,
    private var style: Style = makeStyle {}
) : StyleBlock(), Style by style {

    /** The rules nested inside this one. */
    override val nestedBlocks: MutableList<StyleRule> = mutableListOf()

    /** The selectors of this rule. */
    internal val selectors: MutableList<String> = mutableListOf()

    /**
     * Returns a list of the full-path selectors for this rule, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple selectors (comma separated in the eventual CSS) at each level.
     */
    override val fullSelectors: List<String>
        get() {

            if (parent.fullSelectors.isEmpty()) {
                return selectors.filter { s -> !s.startsWith("%") }
            }

            val result = mutableListOf<String>()

            for (outerSelector in parent.fullSelectors) {

                for (selector in selectors) {

                    if (selector.startsWith("%")) {
                        continue
                    }

                    var fullSelector = outerSelector

                    if (selector.contains("&")) {
                        fullSelector = selector.replace("&", fullSelector)
                    }
                    else {

                        if (outerSelector.isNotEmpty()) {
                            fullSelector += " "
                        }

                        fullSelector += selector

                    }

                    result.add(fullSelector)

                }

            }

            return result

        }

    ////

    /**
     * Recursively copies this style rule. The copy has parent [copyParent].
     */
    internal fun copy(copyParent: StyleBlock): StyleRule {
        val result = StyleRule(copyParent)
        result.selectors.addAll(selectors)
        result.include(style)
        result.nestedBlocks.addAll(nestedBlocks.map { b -> b.copy(result) })
        return result
    }

    /**
     * Extends a style rule that has placeholder selector [placeholderSelector] with the selectors of this style
     * rule. The placeholder rule must be a previously occurring sibling of this rule.
     */
    fun extend(placeholderSelector: String) {

        require(placeholderSelector.startsWith("%")) {
            "Cannot extend a non-placeholder selector: '$placeholderSelector'."
        }

        val block = parent.findPlaceholder(placeholderSelector)
            ?: throw IllegalArgumentException("Unknown block to be extended: '$placeholderSelector'.")

        block.selectors.addAll(selectors)

    }

    /** Builds a style rule from a selector and the [build] function for the rule. */
    operator fun String.invoke(build: StyleRule.() -> Unit): StyleRule {

        // Create the new style block.
        val result = StyleRule(this@StyleRule)

        // Add its selectors or placeholder selectors.
        result.prependSelectors(this)

        // Nest the new block in the active block.
        this@StyleRule.nestedBlocks.add(result)

        // Build its style.
        result.build()

        return result

    }

    /** Combines a selector with another selector [that] into a comma-separated pair. */
    infix fun String.or(that: String) =
        this + ", " + that

    /** Combines a selector with an already created [styleRule] by adding the selector to the rule. */
    infix fun String.or(styleRule: StyleRule): StyleRule {

        styleRule.prependSelectors(this)

        return styleRule

    }

    /**
     * Adds the selectors (including placeholder selectors) split from the given [compoundSelector] to
     * the beginning of the selector list for this rule.
     */
    internal fun prependSelectors(compoundSelector: String) {

        // Iterate through its selectors or placeholder selectors
        // Note: the reversed() call below and the insert at index 0 is because the "or" operator is forced to
        // lower precedence than we want.
        for (selector in compoundSelector.split(",").map { s -> s.trim() }.reversed()) {

            if (selector.startsWith("%")) {
                require(parent.findPlaceholder(selector) == null) { "Duplicate placeholder name: '$selector'." }
            }

            selectors.add(0, selector)

        }

    }

    /** Converts this style rule to CSS. */
    override fun toCssString(): String {

        val result = StringBuilder("")

        if (style.isNotEmpty == true) {
            result.append(fullSelectors.joinToString(",\n"))
            result.append(" {\n")
            result.append(style.toCssString("    "), "\n")
            result.append("}\n\n")
        }

        for (nestedBlock in nestedBlocks) {
            result.append(nestedBlock.toCssString())
        }

        return result.toString()

    }

}

//---------------------------------------------------------------------------------------------------------------------

