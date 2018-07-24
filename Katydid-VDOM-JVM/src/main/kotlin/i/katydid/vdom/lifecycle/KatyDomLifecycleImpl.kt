//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.lifecycle

import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.application.KatyDomLifecycle
import o.katydid.vdom.elements.AbstractKatyDomHtmlElement
import x.katydid.vdom.dom.Element

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of the KatyDOM lifecycle to build and patch a real DOM tree from an initial and changed virtual DOM
 * tree.
 */
internal class KatyDomLifecycleImpl<Msg> : KatyDomLifecycle<Msg> {

    override fun build(
        domElement: Element,
        katyDomElement: AbstractKatyDomHtmlElement<Msg>
    ) {

        val document = domElement.ownerDocument!!

        // Create the top level element.
        val root: Element = document.createElement(katyDomElement.nodeName)

        // Fill it in from the virtual DOM.
        (katyDomElement as KatyDomHtmlElement<Msg>).establish(root)

        // Replace the placeholder element.
        val parent = domElement.parentNode!!
        parent.insertBefore(root, domElement)
        parent.removeChild(domElement)

    }

    override fun patch(
        oldKatyDomElement: AbstractKatyDomHtmlElement<Msg>,
        newKatyDomElement: AbstractKatyDomHtmlElement<Msg>
    ) {
        (newKatyDomElement as KatyDomHtmlElement<Msg>).patch(oldKatyDomElement as KatyDomHtmlElement<Msg>)
    }

}

//---------------------------------------------------------------------------------------------------------------------

