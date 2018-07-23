//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.text

import o.org.katydom.abstractnodes.KatyDomNode
import x.org.katydom.dom.Comment
import x.org.katydom.dom.Document
import x.org.katydom.dom.Node

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM node for a comment node.
 */
internal class KatyDomComment<Msg>(

    /** The text within the comment. */
    _nodeValue: String,

    /** Unique identifier for this comment. */
    key: Any?

) : KatyDomNode<Msg>(key) {

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

    override fun patchAttributes(domElement: Node, priorElement: KatyDomNode<Msg>) {

        require(domElement is Comment) { "DOM node expected to be comment." }
        if (priorElement !is KatyDomComment) {
            throw IllegalArgumentException("KatyDOM node expected to be KatyDOM comment.")
        }

        if (nodeValue != priorElement.nodeValue) {
            domElement.nodeValue = nodeValue
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
