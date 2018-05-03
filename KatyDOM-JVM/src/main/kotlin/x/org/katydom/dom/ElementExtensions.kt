//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.org.katydom.dom

//---------------------------------------------------------------------------------------------------------------------

/**
 * Sets both the attribute and the property of a DOM element named [key] to [value]. For the JVM, only attributes
 * are relevant. (The JavaScript code updates both).
 */
fun Element.setAttributeAndProperty(key: String, value: String) {
    this.setAttribute(key, value)
}

//---------------------------------------------------------------------------------------------------------------------

