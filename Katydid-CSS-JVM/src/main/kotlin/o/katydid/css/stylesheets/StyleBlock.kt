package o.katydid.css.stylesheets

import o.katydid.css.styles.Style

data class StyleBlock(
    val parent: StyleBlock?,
    var selector: String,
    var style: Style? = null,
    val nestedBlocks: MutableList<StyleBlock> = mutableListOf()
) {

    fun toCssString(outerSelector:String = ""): String {

        val result = StringBuilder("")

        var accumulatedSelector = outerSelector

        if ( style != null) {

            // TODO: handle cases when outer or inner selectors have commas in them

            if ( selector.startsWith("&") ) {
                accumulatedSelector += selector.substring(1)
            }
            else {
                if ( outerSelector.isNotEmpty() ) {
                    accumulatedSelector += " "
                }
                accumulatedSelector += selector
            }

            result.append(accumulatedSelector)
            result.append(" {\n")
            result.append(style?.toCssString("    "), "\n")
            result.append("}\n\n")

        }

        for (nestedBlock in nestedBlocks) {
            result.append(nestedBlock.toCssString(accumulatedSelector))
        }

        return result.toString()

    }

}