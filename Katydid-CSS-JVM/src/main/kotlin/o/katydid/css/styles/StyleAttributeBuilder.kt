//
// (C) Copyright 2018 Martin E. Nordberg III
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
    build: Style.() -> Unit
) {

    val s = Style()
    s.build()
    this.attribute( "style", s.toString() )

}

//---------------------------------------------------------------------------------------------------------------------

