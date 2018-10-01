//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style
import o.katydid.css.styles.style

//---------------------------------------------------------------------------------------------------------------------

class StyleSheet {

    private val styleEntries = mutableMapOf<String, Style>()

    ////

    infix fun String.and(that: String) =
        this + ", " + that

    infix fun String.and(pair: Pair<String, Style>): Pair<String, Style> {
        styleEntries.remove(pair.first)
        val selector = this + ", " + pair.first
        styleEntries[selector] = pair.second
        return Pair(selector, pair.second)
    }

    operator fun String.invoke(build: Style.() -> Unit): Pair<String, Style> {
        val style = style(build)
        styleEntries[this] = style
        return Pair(this, style)
    }

    override fun toString(): String {
        val result = StringBuilder("")
        for (styleEntry in styleEntries) {
            result.append(styleEntry.key)
            result.append(" {\n")
            result.append(styleEntry.value.toCssString("    "), "\n")
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

