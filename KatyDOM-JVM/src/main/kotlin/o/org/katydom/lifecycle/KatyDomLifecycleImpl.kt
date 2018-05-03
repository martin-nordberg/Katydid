//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.lifecycle

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.api.KatyDomLifecycle
import x.org.katydom.dom.Element

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of the KatyDOM lifecycle to build and patch a real DOM tree from an initial and changed virtual DOM
 * tree.
 */
internal class KatyDomLifecycleImpl<Msg> : KatyDomLifecycle<Msg> {

    override fun build(domElement: Element, katyDomElement: KatyDomHtmlElement<Msg>) {

        val document = domElement.ownerDocument!!

        // Create the top level element.
        val root: Element = document.createElement(katyDomElement.nodeName)

        // Fill it in from the virtual DOM.
        katyDomElement.establish(root)

        // Replace the placeholder element.
        val parent = domElement.parentNode!!
        parent.insertBefore(root, domElement)
        parent.removeChild(domElement)

    }

    override fun patch(oldKatyDomElement: KatyDomHtmlElement<Msg>, newKatyDomElement: KatyDomHtmlElement<Msg>) {
        newKatyDomElement.patch(oldKatyDomElement)
    }

}

//---------------------------------------------------------------------------------------------------------------------

