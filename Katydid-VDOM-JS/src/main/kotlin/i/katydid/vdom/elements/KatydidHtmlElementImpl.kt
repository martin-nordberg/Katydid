//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements

import o.katydid.vdom.elements.KatydidHtmlElement
import o.katydid.vdom.types.EDirection
import x.katydid.vdom.dom.Document
import x.katydid.vdom.dom.Node

//---------------------------------------------------------------------------------------------------------------------

/**
 * Abstract Katydid class corresponding to a DOM HTMLElement node. Accepts the global attributes available
 * to most HTML tags.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 *
 * @constructor Constructs a new HTML element with given attributes.
 * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
 * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
 * @param accesskey a string specifying the HTML accesskey value.
 * @param contenteditable whether the element has editable content.
 * @param draggable controls whether or not the element is draggable.
 * @param dir the left-to-right direction of text inside this element.
 * @param hidden true if the element is to be hidden.
 * @param lang the language of text within this element.
 * @param spellcheck whether the element is subject to spell checking.
 * @param style a string containing CSS for this element.
 * @param tabindex the tab index for the element.
 * @param title a tool tip for the element.
 * @param translate whether to translate text within this element.
 */
@Suppress("unused")
internal abstract class KatydidHtmlElementImpl<Msg>(
    selector: String?,
    key: Any?,
    accesskey: Char? = null,
    contenteditable: Boolean? = null,
    dir: EDirection? = null,
    draggable: Boolean? = null,
    hidden: Boolean? = null,
    lang: String? = null,
    spellcheck: Boolean? = null,
    style: String? = null,
    tabindex: Int? = null,
    title: String? = null,
    translate: Boolean? = null
) : KatydidElementImpl<Msg>(selector, key, style, tabindex), KatydidHtmlElement<Msg> {

    init {
        check( draggable == null || title !=null ) { "Draggable elements should have a title." }

        // TODO: need to output a string with Unicode escapes for non-ASCII characters
        setAttribute("accesskey", accesskey?.toString())
        setTrueFalseAttribute("contenteditable", contenteditable)
        setAttribute("dir", dir?.toHtmlString())
        setTrueFalseAttribute("draggable", draggable)
        setBooleanAttribute("hidden", hidden)
        setAttribute("lang", lang)
        setTrueFalseAttribute("spellcheck", spellcheck)
        setAttribute("title", title)
        setYesNoAttribute("translate", translate)
    }

    override fun createDomNode(document: Document, parentDomNode: Node, followingDomChild: Node?) {

        val childElement = document.createElement(nodeName)
        establish(childElement)
        parentDomNode.insertBefore(childElement, followingDomChild)

    }

}

//---------------------------------------------------------------------------------------------------------------------

