//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.org.katydom.dom

//---------------------------------------------------------------------------------------------------------------------

/**
 * Removes both the attribute and the property of a DOM element named [key]. For the JVM, only attributes
 * are relevant. (The JavaScript code removes both).
 */
fun Element.removeAttributeAndProperty(key: String) {
    this.removeAttribute(key)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Sets both the attribute and the property of a DOM element named [key] to [value]. For the JVM, only attributes
 * are relevant. (The JavaScript code updates both).
 */
fun Element.setAttributeAndProperty(key: String, value: String) {
    this.setAttribute(key, value)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Sets both the attribute and the property of a DOM element named [key] to true (present). For the JVM, only attributes
 * are relevant. (The JavaScript code updates both).
 */
fun Element.setBooleanAttributeAndProperty(key: String) {
    this.setAttribute(key, "")
}

//---------------------------------------------------------------------------------------------------------------------

