//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.lifecycle

import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.application.KatydidLifecycle
import o.katydid.vdom.elements.KatydidHtmlElement
import x.katydid.vdom.dom.Element

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of the Katydid lifecycle to build and patch a real DOM tree from an initial and changed virtual DOM
 * tree.
 */
internal class KatydidLifecycleImpl<Msg> : KatydidLifecycle<Msg> {

    override fun build(
        domElement: Element,
        katydidElement: KatydidHtmlElement<Msg>
    ) {

        val document = domElement.ownerDocument!!

        // Create the top level element.
        val root: Element = document.createElement(katydidElement.nodeName)

        // Fill it in from the virtual DOM.
        (katydidElement as KatydidHtmlElementImpl<Msg>).establish(root)

        // Replace the placeholder element.
        val parent = domElement.parentNode!!
        parent.insertBefore(root, domElement)
        parent.removeChild(domElement)

    }

    override fun patch(
        oldKatydidElement: KatydidHtmlElement<Msg>,
        newKatydidElement: KatydidHtmlElement<Msg>
    ) {
        (newKatydidElement as KatydidHtmlElementImpl<Msg>).patch(oldKatydidElement as KatydidHtmlElementImpl<Msg>)
    }

}

//---------------------------------------------------------------------------------------------------------------------

