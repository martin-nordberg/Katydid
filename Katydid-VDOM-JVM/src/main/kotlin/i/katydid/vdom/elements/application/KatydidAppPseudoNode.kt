//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.application

import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.KatydidNodeImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for the parent pseudo element of an application. The pseudo element allows only one child node to be
 * created. That child node is the root element of an application.
 */
internal class KatydidAppPseudoNode<Msg> :
    KatydidHtmlElementImpl<Msg>(null, null) {

    override val nodeName = "!APPLICATION"

    ////

    override fun afterAddChildNode(childNode: KatydidNodeImpl<Msg>) {

        // Allow only one child node
        freeze()

    }

    /**
     * Fills this node with the content that is the whole application. The [defineContent] function should add
     * exactly one child node that is to become the root node of the application. This app pseudo node has no
     * corresponding real DOM node.
     */
    fun fill(
        dispatchMessages: (Iterable<Msg>) -> Unit,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {

        KatydidFlowContentBuilderImpl(this, KatydidContentRestrictions(), dispatchMessages).defineContent()

        require(this.isConstructed) {
            "Application node should be filled with exactly one child node."
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

