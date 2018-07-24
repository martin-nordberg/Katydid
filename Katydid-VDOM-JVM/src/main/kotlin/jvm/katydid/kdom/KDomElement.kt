//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//
package jvm.katydid.kdom

import jvm.katydid.infrastructure.indent
import x.katydid.vdom.dom.Element

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of DOM Element for generating HTML text for testing or server-side rendering.
 */
class KDomElement(
    override val ownerDocument: KDomDocument,
    override val nodeName: String
) : KDomNode(), Element {

    private val _attributes: MutableMap<String, String> = sortedMapOf()

    ////

    override var nodeValue: String?
        get() = null
        set(value) {}

    override val tagName: String
        get() {
            return nodeName.toLowerCase()
        }

    ////

    override fun removeAttribute(name: String) {
        _attributes.remove(name)
    }

    override fun setAttribute(name: String, value: String) {
        _attributes[name] = value
    }

    override fun toHtmlString(indent: Int): String {

        val result = StringBuilder()

        result.indent(indent)
        result.append("<", tagName)

        for (attr in _attributes) {
            result.append(" ", attr.key, "=\"", attr.value, "\"")
        }

        var child = this.firstChild

        if (child == null) {
            result.append(">")
        }
        else {
            result.appendln(">")

            while (child != null) {
                result.appendln(child.toHtmlString(indent + 2))
                child = child.nextSibling
            }

            result.indent(indent)
        }

        if (!elementsWithoutEndTags.contains(tagName)) {
            result.append("</", tagName, ">")
        }

        return result.toString()

    }

    ////

    private companion object {
        val elementsWithoutEndTags = hashSetOf(
            "br", "hr", "img", "input", "source", "track", "wbr"
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

