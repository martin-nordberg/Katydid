//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.styles

import o.katydid.vdom.builders.KatydidAttributesContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Adds an HTML element builder extension for the style attribute.
 * @param build the callback that fills in the CSS properties.
 */
fun <Msg> KatydidAttributesContentBuilder<Msg>.style(
    build: KatydidStyle.() -> Unit
) {

    val s = makeStyle(build)
    this.attribute("style", s.toString())

}

//---------------------------------------------------------------------------------------------------------------------

