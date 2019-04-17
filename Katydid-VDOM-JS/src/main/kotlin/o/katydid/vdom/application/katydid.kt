//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

@file:Suppress("unused")

package o.katydid.vdom.application

import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.application.KatydidAppPseudoNode
import i.katydid.vdom.lifecycle.KatydidLifecycleImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.builders.lists.KatydidOrderedListContentBuilder
import o.katydid.vdom.builders.lists.KatydidUnorderedListContentBuilder
import o.katydid.vdom.elements.KatydidHtmlElement

//---------------------------------------------------------------------------------------------------------------------

/**
 * Primary entry point for building a virtual DOM tree.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 * @param dispatchMessages function that takes in a sequence of messages and completes a cycle in the virtual and
 *                         real DOM update circle.
 * @param defineContent function that builds one root DOM node and its contents.
 * @return the root DOM node after it has been built by the provided function.
 */
fun <Msg> katydid(
    dispatchMessages: (Iterable<Msg>) -> Unit = {},
    defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
): KatydidHtmlElement<Msg> {
    val pseudoParentElement = KatydidAppPseudoNode<Msg>()
    pseudoParentElement.fill(dispatchMessages = dispatchMessages, defineContent = defineContent)
    return pseudoParentElement.soleChildNode as KatydidHtmlElementImpl<Msg>
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
fun <Msg> katydidComponent(builder: KatydidFlowContentBuilder<Msg>,
                           defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Helper function for defining a component consisting of one or more list item elements inside an `<ol>` element.
 * @param builder the list item builder that will provide the context for new content within the component.
 * @param defineContent the function defining one or more <li> elements.
 * @return a function that builds the nodes as part of a larger tree.
 */
fun <Msg> katydidListItemsComponent(builder: KatydidOrderedListContentBuilder<Msg>,
                                    defineContent: KatydidOrderedListContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Helper function for defining a component consisting of one or more list item elements inside a `<ul>` element.
 * @param builder the list item builder that will provide the context for new content within the component.
 * @param defineContent the function defining one or more <li> elements.
 * @return a function that builds the nodes as part of a larger tree.
 */
fun <Msg> katydidListItemsComponent(builder: KatydidUnorderedListContentBuilder<Msg>,
                                    defineContent: KatydidUnorderedListContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Helper function for defining a component consisting of phrasing content.
 * @param builder the phrasing content builder that will provide the context for new content within the component.
 * @param defineContent the function defining one or more elements.
 * @return a function that builds the nodes as part of a larger tree.
 */
fun <Msg> katydidPhrasingComponent(builder: KatydidPhrasingContentBuilder<Msg>,
                                   defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit) {
    return defineContent(builder)
}

//---------------------------------------------------------------------------------------------------------------------

/**
 * Constructs an object that orchestrates the main loop of the virtual DOM build and patch sequence.
 */
fun <Msg> makeKatydidLifecycle(/*TODO: options*/): KatydidLifecycle<Msg> {
    return KatydidLifecycleImpl()
}

//---------------------------------------------------------------------------------------------------------------------
