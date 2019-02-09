//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.text

import i.katydid.vdom.elements.KatydidNodeImpl
import x.katydid.vdom.dom.Comment
import x.katydid.vdom.dom.Document
import x.katydid.vdom.dom.Node

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM node for a comment node.
 */
internal class KatydidComment<Msg>(

    /** The text within the comment. */
    _nodeValue: String,

    /** Unique identifier for this comment. */
    key: Any?

) : KatydidNodeImpl<Msg>(key) {

    init {
        this.freeze()
    }

    ////

    override val nodeName = "#comment"

    val nodeValue = _nodeValue

    ////

    override fun createDomNode(document: Document, parentDomNode: Node, followingDomChild: Node?) {
        val childComment = document.createComment(nodeValue)
        establish(childComment)
        parentDomNode.insertBefore(childComment, followingDomChild)
    }

    override fun establishAttributes(domElement: Node) {
        // Nothing to establish; comments have no attributes.
    }

    override fun freezeAttributes() {
        // Nothing to freeze beyond the base node.
    }

    override fun patchAttributes(domElement: Node, priorElement: KatydidNodeImpl<Msg>) {

        require(domElement is Comment) { "DOM node expected to be comment." }
        if (priorElement !is KatydidComment) {
            throw IllegalArgumentException("Katydid-VDOM node expected to be Katydid-VDOM comment.")
        }

        if (nodeValue != priorElement.nodeValue) {
            domElement.nodeValue = nodeValue
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
