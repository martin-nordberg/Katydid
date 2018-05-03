//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*js*/x.org.katydom.dom

import org.w3c.dom.Element


fun Element.setAttributeAndProperty(key: String, value: String) {
    this.setAttribute(key, value)
    this.asDynamic()[key] = value
}
