//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*js*/x.katydid.vdom.dom

import org.w3c.dom.Element


fun Element.removeAttributeAndProperty(key: String) {
    this.removeAttribute(key)
    this.asDynamic()[key] = null
}

fun Element.setAttributeAndProperty(key: String, value: String) {
    this.setAttribute(key, value)
    this.asDynamic()[key] = value
}

fun Element.setBooleanAttributeAndProperty(key: String) {
    this.setAttribute(key, "")
    this.asDynamic()[key] = true
}

