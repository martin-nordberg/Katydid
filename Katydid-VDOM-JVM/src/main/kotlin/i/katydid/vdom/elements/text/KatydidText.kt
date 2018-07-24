//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.text

import i.katydid.vdom.elements.KatydidNodeImpl
import x.katydid.vdom.dom.Document
import x.katydid.vdom.dom.Node
import x.katydid.vdom.dom.Text

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM node for a plain text node.
 */
internal class KatydidText<Msg>(

    /** The text within the node. */
    val nodeValue: String,

    key: Any?

) : KatydidNodeImpl<Msg>(key) {

    init {
        this.freeze()
    }

    ////

    override val nodeName = "#text"

    ////

    override fun createDomNode(document: Document, parentDomNode: Node, followingDomChild: Node?) {
        val childText = document.createTextNode(nodeValue)
        establish(childText)
        parentDomNode.insertBefore(childText, followingDomChild)
    }

    override fun establishAttributes(domElement: Node) {
        // Nothing to establish; text already set during node creation.
    }

    override fun freezeAttributes() {
        // Nothing to freeze beyond the base node.
    }

    override fun patchAttributes(domElement: Node, priorElement: KatydidNodeImpl<Msg>) {

        require(domElement is Text) { "DOM node expected to be text." }
        if (priorElement !is KatydidText) {
            throw IllegalArgumentException("Katydid-VDOM node expected to be Katydid-VDOM text.")
        }

        if (nodeValue != priorElement.nodeValue) {
            domElement.nodeValue = nodeValue
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
