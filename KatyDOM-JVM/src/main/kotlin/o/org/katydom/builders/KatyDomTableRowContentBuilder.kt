//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.concretenodes.tabular.KatyDomTd
import o.org.katydom.concretenodes.tabular.KatyDomTh
import o.org.katydom.concretenodes.tabular.KatyDomTr
import o.org.katydom.concretenodes.text.KatyDomComment
import o.org.katydom.types.EDirection
import o.org.katydom.types.EHeadingScope

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a table row.
 *
 * @constructor Constructs a new builder for the contents of a `<tr>` element.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
class KatyDomTableRowContentBuilder<Msg> internal constructor(
    element: KatyDomTr<Msg>,
    internal val contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
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
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun flowContent(element: KatyDomHtmlElement<Msg>): KatyDomFlowContentBuilder<Msg> {
        return KatyDomFlowContentBuilder(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    /**
     * Adds a `<td>` (table cell) element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param colspan the number of columns spanned by the cell.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param headers the IDs of headers cells for thies element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param rowspan the number of rows spanned by the cell.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun td(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        colspan: Int? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        headers: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        rowspan: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTd(this, selector, key, accesskey, colspan, contenteditable, dir, headers, hidden,
                      lang, rowspan, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    /**
     * Adds a `<th>` (table heading cell) element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param abbr label to use for referencing this cell from other contexts.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param colspan the number of columns spanned by the cell.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param headers the IDs of headers cells for thies element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param rowspan the number of rows spanned by the cell.
     * @param scope the scope for which the heading applies.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun th(
        selector: String? = null,
        key: Any? = null,
        abbr: String? = null,
        accesskey: Char? = null,
        colspan: Int? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        headers: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        rowspan: Int? = null,
        scope: EHeadingScope? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTh(this, selector, key, abbr, accesskey, colspan, contenteditable, dir, headers, hidden,
                      lang, rowspan, scope, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

