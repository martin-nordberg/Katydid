package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

data class StyleBlock(
    val parent: StyleBlock?,
    val selectors: MutableList<String> = mutableListOf(),
    var style: Style? = null,
    val nestedBlocks: MutableList<StyleBlock> = mutableListOf()
) {

    fun toCssString(outerSelectors:List<String> = listOf("")): String {

        val result = StringBuilder("")

        val accumulatedSelectors = mutableListOf<String>()

        for (outerSelector in outerSelectors) {

            for (selector in selectors) {

                var accumulatedSelector = outerSelector

                if (selector.startsWith("&")) {
                    accumulatedSelector += selector.substring(1)
                }
                else {
                    if (outerSelector.isNotEmpty()) {
                        accumulatedSelector += " "
                    }
                    accumulatedSelector += selector
                }

                accumulatedSelectors.add(accumulatedSelector)

            }

        }

        result.append(accumulatedSelectors.joinToString(",\n"))
        result.append(" {\n")
        result.append(style?.toCssString("    "), "\n")
        result.append("}\n\n")

        for (nestedBlock in nestedBlocks) {
            result.append(nestedBlock.toCssString(accumulatedSelectors))
        }

        return result.toString()

    }

}