//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
class StyleRule(
    internal val parent: StyleBlock?,
    internal val selectors: MutableList<String> = mutableListOf(),
    internal var style: Style? = null,
    override val nestedBlocks: MutableList<StyleRule> = mutableListOf()
) : StyleBlock() {

    /**
     * Returns a list of the full-path selectors for this block, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple selectors (comma separated in the eventual CSS) at each level.
     */
    override val fullSelectors: List<String>
        get() {

            if (parent == null || parent.fullSelectors.isEmpty()) {
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

    /**
     * Recursively copies this style block. The copy has parent [copyParent].
     */
    internal fun copy(copyParent: StyleRule): StyleRule {
        val result = StyleRule(copyParent, selectors.toMutableList(), style)
        result.nestedBlocks.addAll(nestedBlocks.map { b -> b.copy(result) })
        return result
    }

    ////

    /**
     * Adds the selectors (including placeholder selectors) split from the given [compoundSelector] to
     * the beginning of the selector list for this block.
     */
    internal fun prependSelectors(compoundSelector: String) {

        // Iterate through its selectors or placeholder selectors
        // Note: the reversed() call below and the insert at index 0 is because the "or" operator is forced to
        // lower precedence than we want.
        for ( selector in compoundSelector.split(",").map { s -> s.trim() }.reversed()) {

            if (selector.startsWith("%")) {
                require(parent!!.findPlaceholder(selector) == null) { "Duplicate placeholder name: '$selector'." }
            }

            selectors.add(0, selector)

        }

    }

    /** Converts this style block to CSS. */
    override fun toCssString(): String {

        val result = StringBuilder("")

        if (style?.isNotEmpty == true) {
            result.append(fullSelectors.joinToString(",\n"))
            result.append(" {\n")
            result.append(style?.toCssString("    "), "\n")
            result.append("}\n\n")
        }

        for (nestedBlock in nestedBlocks) {
            result.append(nestedBlock.toCssString())
        }

        return result.toString()

    }

}
