//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders.tables

import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a table's thead, tbody, or tfoot element.
 */
interface KatyDomTableBodyContentBuilder<in Msg> : KatyDomAttributesContentBuilder<Msg> {

    /**
     * Adds a comment node as the next child of the element under construction.
     * @param nodeValue the text within the node.
     * @param key unique key for this comment within its parent node.
     */
    fun comment(
        nodeValue: String,
        key: Any? = null
    )

    /**
     * Adds a `<tr>` element with given attributes as the next child of the element under construction.
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
    fun tr(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatyDomTableRowContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------

