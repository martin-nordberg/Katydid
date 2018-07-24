//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.text

import i.org.katydom.elements.KatyDomNode
import x.org.katydom.dom.Document
import x.org.katydom.dom.Node
import x.org.katydom.dom.Text

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM node for a plain text node.
 */
internal class KatyDomText<Msg>(

    /** The text within the node. */
    val nodeValue: String,

    key: Any?

) : KatyDomNode<Msg>(key) {

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

    override fun patchAttributes(domElement: Node, priorElement: KatyDomNode<Msg>) {

        require(domElement is Text) { "DOM node expected to be text." }
        if (priorElement !is KatyDomText) {
            throw IllegalArgumentException("KatyDOM node expected to be KatyDOM text.")
        }

        if (nodeValue != priorElement.nodeValue) {
            domElement.nodeValue = nodeValue
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
