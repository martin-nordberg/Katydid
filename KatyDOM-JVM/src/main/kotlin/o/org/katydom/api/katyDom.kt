//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.api

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.details.KatyDomOrderedListContentBuilder
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.builders.details.KatyDomUnorderedListContentBuilder
import o.org.katydom.concretenodes.application.KatyDomAppPseudoNode
import o.org.katydom.lifecycle.KatyDomLifecycleImpl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Primary entry point for building a virtual DOM tree.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 * @param dispatchMessages function that takes in a sequence of messages and completes a cycle in the virtual and
 *                         real DOM update circle.
 * @param defineContent function that builds one root DOM node and its contents.
 * @return the root DOM node after it has been built by the provided function.
 */
fun <Msg> katyDom(
    dispatchMessages: (Iterable<Msg>) -> Unit = {},
    defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
): KatyDomHtmlElement<Msg> {
    val pseudoParentElement = KatyDomAppPseudoNode<Msg>()
    pseudoParentElement.fill(dispatchMessages = dispatchMessages, defineContent = defineContent)
    return pseudoParentElement.soleChildNode as KatyDomHtmlElement<Msg>
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Helper function for defining a component that builds one or more child DOM nodes. This helper is for HTML that is
 * generally available anywhere in the tree (so called "flow content").
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 * @param builder the builder that will provide the context for new content within the component.
 * @param defineContent function that defines the one or more nodes of the component.
 * @return a function that builds the nodes as part of a larger tree.
 */
fun <Msg> katyDomComponent(builder: KatyDomFlowContentBuilder<Msg>,
                           defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Helper function for defining a component consisting of one or more list item elements inside an `<ol>` element.
 * @param builder the list item builder that will provide the context for new content within the component.
 * @param defineContent the function defining one or more <li> elements.
 * @return a function that builds the nodes as part of a larger tree.
 */
fun <Msg> katyDomListItemsComponent(builder: KatyDomOrderedListContentBuilder<Msg>,
                                    defineContent: KatyDomOrderedListContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Helper function for defining a component consisting of one or more list item elements inside a `<ul>` element.
 * @param builder the list item builder that will provide the context for new content within the component.
 * @param defineContent the function defining one or more <li> elements.
 * @return a function that builds the nodes as part of a larger tree.
 */
fun <Msg> katyDomListItemsComponent(builder: KatyDomUnorderedListContentBuilder<Msg>,
                                    defineContent: KatyDomUnorderedListContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Helper function for defining a component consisting of phrasing content.
 * @param builder the phrasing content builder that will provide the context for new content within the component.
 * @param defineContent the function defining one or more elements.
 * @return a function that builds the nodes as part of a larger tree.
 */
fun <Msg> katyDomPhrasingComponent(builder: KatyDomPhrasingContentBuilder<Msg>,
                                   defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Constructs an object that orchestrates the main loop of the virtual DOM build and patch sequence.
 */
fun <Msg> makeKatyDomLifecycle(/*TODO: options*/): KatyDomLifecycle<Msg> {
    return KatyDomLifecycleImpl()
}

//---------------------------------------------------------------------------------------------------------------------
