package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

data class StyleBlock(
    internal val parent: StyleBlock?,
    internal var name: String = "",
    internal val selectors: MutableList<String> = mutableListOf(),
    internal var style: Style? = null,
    internal val nestedBlocks: MutableList<StyleBlock> = mutableListOf()
) {

    /**
     * Returns a list of the full-path selectors for this block, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple (comma separated) selectors at each level.
     */
    internal val fullSelectors: List<String>
        get() {

            if (parent == null || parent.selectors.isEmpty()) {
                return selectors
            }

            val result = mutableListOf<String>()

            for (outerSelector in parent.fullSelectors) {

                for (selector in selectors) {

                    var fullSelector = outerSelector

                    if (selector.startsWith("&")) {
                        fullSelector += selector.substring(1)
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

    /** Finds the style block at the parent scope or higher with name [styleBlockName]. */
    internal fun find(styleBlockName: String): StyleBlock? {

        if (parent == null) {
            return null
        }

        return parent.findChild(styleBlockName) ?: return parent.find(styleBlockName)

    }

    /** Finds a nested block that has the name [styleBlockName]. */
    private fun findChild(styleBlockName: String): StyleBlock? =
        nestedBlocks.find { b -> b.name == styleBlockName }

    /** Converts this style block to CSS. */
    internal fun toCssString(): String {

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
