//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.css

import o.katydid.css.stylesheets.StyleSheet
import x.katydid.vdom.dom.Element

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builds the real DOM <style> element corresponding to given DSL-built style sheet.
 * @param domElement the DOM element to be the root of the application.
 * @param styleSheet the DSL-built style sheet to insert into the given DOM element
 */
fun buildStyleElement(
    domElement: Element,
    styleSheet: StyleSheet
) {
    domElement.innerHTML = styleSheet.toString()
}

//---------------------------------------------------------------------------------------------------------------------
