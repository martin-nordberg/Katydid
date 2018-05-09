//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.concretenodes.tabular.*
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a table.
 *
 * @constructor Constructs a new builder for the contents of a `<table>` element.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
class KatyDomTableContentBuilder<Msg> internal constructor(
    element: KatyDomTable<Msg>,
    internal val contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilder<Msg>(element, dispatchMessages) {

    /** Restrictions enforcing the order of sub-elements within the table being built. */
    internal val tableContentRestrictions = KatyDomTableContentRestrictions()

    ////

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    internal fun attributesContent(element: KatyDomColGroup<Msg>): KatyDomAttributesContentBuilder<Msg> {
        return KatyDomAttributesContentBuilder(element, dispatchMessages)
    }

    /**
     * Adds a `<caption>` element with given attributes as the next child of the element under construction.
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
    fun caption(
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
            KatyDomCaption(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                           tabindex, title, translate, defineContent)
        )
    }

    /**
     * Adds a `<colgroup>` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param span the number of columns in the group
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that builds the attributes of the new element.
     */
    fun colgroup(
        selector: String? = null,
        key: Any? = null,
        accesskey: String? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        span: Int?,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit = {}
    ) {
        element.addChildNode(
            KatyDomColGroup(this, selector, key, accesskey, contenteditable, dir, hidden, lang, span, spellcheck, style,
                            tabindex, title, translate, defineAttributes)
        )
    }

    /**
     * Adds a `<colgroup>` element with given attributes as the next child of the element under construction.
     * The column group can contain `<col>` elements.
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
    fun colgroup(
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
        defineContent: KatyDomColGroupContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomColGroup(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                            tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder plus a table is not allowed
     */
    internal fun colGroupContent(element: KatyDomColGroup<Msg>): KatyDomColGroupContentBuilder<Msg> {
        return KatyDomColGroupContentBuilder(
            element,
            dispatchMessages
        )
    }

    /**
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder plus a table is not allowed
     */
    internal fun flowContentWithTableNotAllowed(element: KatyDomCaption<Msg>): KatyDomFlowContentBuilder<Msg> {
        return KatyDomFlowContentBuilder(
            element,
            contentRestrictions.withTableNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new table row content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    internal fun tableRowContent(element: KatyDomTr<Msg>): KatyDomTableRowContentBuilder<Msg> {
        return KatyDomTableRowContentBuilder(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    /**
     * Adds a `<tbody>` element with given attributes as the next child of the element under construction.
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
    fun tbody(
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
        defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTBody(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    /**
     * Adds a `<tfoot>` element with given attributes as the next child of the element under construction.
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
    fun tfoot(
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
        defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTFoot(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    /**
     * Adds a `<thead>` element with given attributes as the next child of the element under construction.
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
    fun thead(
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
        defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTHead(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

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
        defineContent: KatyDomTableRowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new table body content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    internal fun tableBodyContent(element: KatyDomHtmlElement<Msg>): KatyDomTableBodyContentBuilder<Msg> {
        return KatyDomTableBodyContentBuilder(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

