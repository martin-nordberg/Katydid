//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kdom

import x.katydid.vdom.dom.Comment
import x.katydid.vdom.dom.Document
import x.katydid.vdom.dom.Text


//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of DOM Document for generating HTML text for testing or server-side rendering.
 */
class KDomDocument : KDomNode(), Document {

    override val nodeName = "#document"

    override var nodeValue: String?
        get() = null
        set(_) {}

    override val ownerDocument = this

    ////

    override fun createComment(data: String): Comment {
        return KDomComment(this, data)
    }

    override fun createElement(tagName: String): KDomElement {
        return KDomElement(this, tagName)
    }

    override fun createTextNode(data: String): Text {
        return KDomText(this, data)
    }

    override fun toHtmlString(indent: Int): String {
        throw UnsupportedOperationException("Whole document is not meant to be converted to HTML")
    }

}

//---------------------------------------------------------------------------------------------------------------------

