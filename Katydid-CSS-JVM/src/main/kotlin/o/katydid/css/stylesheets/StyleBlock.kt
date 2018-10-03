package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

data class StyleBlock(
    internal val parent: StyleBlock?,
    internal val selectors: MutableList<String> = mutableListOf(),
    internal var style: Style? = null,
    internal val nestedBlocks: MutableList<StyleBlock> = mutableListOf(),
    internal val nestedPlaceholders: MutableMap<String,StyleBlock> = mutableMapOf()
) {

    /**
     * Returns a list of the full-path selectors for this block, i.e. the CSS selectors resulting from nesting.
     * Accounts for multiple (comma separated) selectors at each level.
     */
    private val fullSelectors: List<String>
        get() {

            if (parent == null || parent.selectors.isEmpty()) {
                return selectors
            }

            val result = mutableListOf<String>()

            for (outerSelector in parent.fullSelectors) {

                for (selector in selectors) {

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
