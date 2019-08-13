//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.tables

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.tabular.*
import i.katydid.vdom.elements.text.KatydidComment
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.tables.KatydidColGroupContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableBodyContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableRowContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a table.
 *
 * @constructor Constructs a new builder for the contents of a `<table>` element.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidTableContentBuilderImpl<Msg>(
    itsElement: KatydidTable<Msg>,
    itsContentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilderImpl<Msg>(itsElement, itsDispatchMessages),
    KatydidTableContentBuilder<Msg> {

    /** Restrictions on content enforced at run time. */
    val contentRestrictions = itsContentRestrictions

    /** Restrictions enforcing the order of sub-elements within the table being built. */
    val tableContentRestrictions = KatydidTableContentRestrictions()

    ////

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    fun attributesContent(element: KatydidColGroup<Msg>): KatydidAttributesContentBuilderImpl<Msg> {
        return KatydidAttributesContentBuilderImpl(element, dispatchMessages)
    }

    override fun caption(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidCaption(this, selector, key, accesskey, contenteditable, dir,
                           draggable, hidden, lang, spellcheck, style,
                           tabindex, title, translate, defineContent)
        )
    }

    override fun colgroup(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        span: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidColGroup(this, selector, key, accesskey, contenteditable, dir,
                            draggable, hidden, lang, span, spellcheck, style,
                            tabindex, title, translate, defineAttributes)
        )
    }

    override fun colgroup(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidColGroupContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidColGroup(this, selector, key, accesskey, contenteditable, dir,
                            draggable, hidden, lang, spellcheck, style,
                            tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder plus a table is not allowed
     */
    fun colGroupContent(element: KatydidColGroup<Msg>): KatydidColGroupContentBuilderImpl<Msg> {
        return KatydidColGroupContentBuilderImpl(
            element,
            dispatchMessages
        )
    }

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatydidComment(nodeValue, key))
    }

    /**
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder plus a table is not allowed
     */
    fun flowContentWithTableNotAllowed(element: KatydidCaption<Msg>): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withTableNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new table row content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun tableRowContent(element: KatydidTr<Msg>): KatydidTableRowContentBuilderImpl<Msg> {
        return KatydidTableRowContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    override fun tbody(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTBody(this, selector, key, accesskey, contenteditable, dir,
                         draggable, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    override fun tfoot(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTFoot(this, selector, key, accesskey, contenteditable, dir,
                         draggable, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    override fun thead(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTHead(this, selector, key, accesskey, contenteditable, dir,
                         draggable, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    override fun tr(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidTableRowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTr(this, selector, key, accesskey, contenteditable, dir,
                      draggable, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new table body content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun tableBodyContent(element: KatydidHtmlElementImpl<Msg>): KatydidTableBodyContentBuilderImpl<Msg> {
        return KatydidTableBodyContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

