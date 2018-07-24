//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders.tables

import i.org.katydom.builders.KatyDomAttributesContentBuilderImpl
import i.org.katydom.builders.KatyDomContentRestrictions
import i.org.katydom.builders.KatyDomFlowContentBuilderImpl
import i.org.katydom.elements.KatyDomHtmlElement
import i.org.katydom.elements.tabular.*
import i.org.katydom.elements.text.KatyDomComment
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.tables.KatyDomColGroupContentBuilder
import o.org.katydom.builders.tables.KatyDomTableBodyContentBuilder
import o.org.katydom.builders.tables.KatyDomTableContentBuilder
import o.org.katydom.builders.tables.KatyDomTableRowContentBuilder
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
internal class KatyDomTableContentBuilderImpl<Msg>(
    element: KatyDomTable<Msg>,
    val contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomTableContentBuilder<Msg> {

    /** Restrictions enforcing the order of sub-elements within the table being built. */
    val tableContentRestrictions = KatyDomTableContentRestrictions()

    ////

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    fun attributesContent(element: KatyDomColGroup<Msg>): KatyDomAttributesContentBuilderImpl<Msg> {
        return KatyDomAttributesContentBuilderImpl(element, dispatchMessages)
    }

    override fun caption(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomCaption(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                           tabindex, title, translate, defineContent)
        )
    }

    override fun colgroup(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        span: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomColGroup(this, selector, key, accesskey, contenteditable, dir, hidden, lang, span, spellcheck, style,
                            tabindex, title, translate, defineAttributes)
        )
    }

    override fun colgroup(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
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
    fun colGroupContent(element: KatyDomColGroup<Msg>): KatyDomColGroupContentBuilderImpl<Msg> {
        return KatyDomColGroupContentBuilderImpl(
            element,
            dispatchMessages
        )
    }

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    /**
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder plus a table is not allowed
     */
    fun flowContentWithTableNotAllowed(element: KatyDomCaption<Msg>): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
            element,
            contentRestrictions.withTableNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new table row content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun tableRowContent(element: KatyDomTr<Msg>): KatyDomTableRowContentBuilderImpl<Msg> {
        return KatyDomTableRowContentBuilderImpl(
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
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTBody(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    override fun tfoot(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTFoot(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    override fun thead(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTHead(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    override fun tr(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
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
    fun tableBodyContent(element: KatyDomHtmlElement<Msg>): KatyDomTableBodyContentBuilderImpl<Msg> {
        return KatyDomTableBodyContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

