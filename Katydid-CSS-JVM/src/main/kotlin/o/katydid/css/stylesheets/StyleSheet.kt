//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style
import o.katydid.css.styles.style

//---------------------------------------------------------------------------------------------------------------------

class StyleSheet {

    private val styleEntries = mutableMapOf<String,Style>()

    operator fun String.invoke(build: Style.() -> Unit ) {
        styleEntries[this] = style(build)
    }

    override fun toString(): String {
        val result = StringBuilder("")
        for ( styleEntry in styleEntries ) {
            result.append( styleEntry.key )
            result.append( " {\n")
            result.append( styleEntry.value.toCssString("    "), "\n")
            result.append("}\n\n")
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

