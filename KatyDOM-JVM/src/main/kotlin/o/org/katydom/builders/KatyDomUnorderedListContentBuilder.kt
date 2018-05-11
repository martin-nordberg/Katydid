//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

import o.org.katydom.concretenodes.grouping.KatyDomLi
import o.org.katydom.concretenodes.grouping.KatyDomUl
import o.org.katydom.concretenodes.text.KatyDomComment
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of an unordered list (an `<ol>` element).
 *
 * @constructor Constructs a new builder for the contents of an ordered or unordered list.
 * @param flowContent The parent flow content with restrictions that can be resumed for the content inside each
 *                    `<li>` element produced by this builder.
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
class KatyDomUnorderedListContentBuilder<Msg> internal constructor(
    internal val flowContent: KatyDomFlowContentBuilder<Msg>,
    element: KatyDomUl<Msg>,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilder<Msg>(element, dispatchMessages) {

    /**
     * Adds a comment node as the next child of the element under construction.
     * @param nodeValue the text within the node.
     * @param key unique key for this comment within its parent node.
     */
    fun comment(nodeValue: String,
                key: Any? = null) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    /**
     * Adds an `<li>` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun li(
        selector: String? = null,
        key: Any? = null,
        accesskey: String? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomLi(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

