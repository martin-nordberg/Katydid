//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.application

import o.katydid.vdom.elements.AbstractKatyDomHtmlElement
import x.katydid.vdom.dom.Element

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface defining a Katy DOM lifecycle. Provides two methods: one to initially build a real DOM from a virtual DOM
 * and another to repeatedly update the real DOM based upon differences in two virtual DOM trees.
 */
interface KatyDomLifecycle<Msg> {

    /**
     * Builds the real DOM corresponding to given virtual DOM element. Replaces the given real DOM element by the
     * newly created result. To be called once when the application starts up.
     * @param domElement the DOM element to be the root of the application.
     * @param katyDomElement the virtual DOM root element to be built into the real DOM. Note that as a side
     *                            effect each virtual DOM element in this tree is linked to its real DOM counterpart.
     */
    fun build(domElement: Element, katyDomElement: AbstractKatyDomHtmlElement<Msg>)

    /**
     * Updates the real DOM, which was last built or patched to mirror oldKatyDomElement, with the operations needed
     * to make it mirror newKatyDomElement.
     * @param oldKatyDomElement the prior virtual DOM root node that has last been synced into the real DOM
     * @param newKatyDomElement the new root virtual DOM node with updates in itself and its children. Note that as a
     *                          side effect each virtual DOM element in this tree is linked to its real DOM counterpart
     *                          where not already so linked.
     */
    fun patch(oldKatyDomElement: AbstractKatyDomHtmlElement<Msg>, newKatyDomElement: AbstractKatyDomHtmlElement<Msg>)

}

//---------------------------------------------------------------------------------------------------------------------

