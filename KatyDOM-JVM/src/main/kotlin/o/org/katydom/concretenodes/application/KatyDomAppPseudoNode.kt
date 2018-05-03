//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.application

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.abstractnodes.KatyDomNode
import o.org.katydom.builders.KatyDomContentRestrictions
import o.org.katydom.builders.KatyDomFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for the parent pseudo element of an application. The pseudo element allows only one child node to be
 * created. That child node is the root element of an application.
 */
internal class KatyDomAppPseudoNode<Msg> :
    KatyDomHtmlElement<Msg>(null, null, null, null, null,
                            null, null, null, null, null, null, null) {

    override val nodeName = "!APPLICATION"

    ////

    override fun afterAddChildNode(childNode: KatyDomNode<Msg>) {

        // Allow only one child node
        freeze()

    }

    /**
     * Fills this node with the content that is the whole application. The [defineContent] function should add
     * exactly one child node that is to become the root node of the application. This pseudo node has no
     * corresponding real DOM node.
     */
    fun fill(
        dispatchMessages: (Iterable<Msg>) -> Unit,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {

        KatyDomFlowContentBuilder(this, KatyDomContentRestrictions(), dispatchMessages).defineContent()

        require(this.isConstructed) {
            "Application node should be filled with exactly one child node."
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

