//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.tables

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.tabular.KatydidTd
import i.katydid.vdom.elements.tabular.KatydidTh
import i.katydid.vdom.elements.tabular.KatydidTr
import i.katydid.vdom.elements.text.KatydidComment
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableRowContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EHeadingScope

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a table row.
 *
 * @constructor Constructs a new builder for the contents of a `<tr>` element.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidTableRowContentBuilderImpl<Msg>(
    itsElement: KatydidTr<Msg>,
    itsContentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilderImpl<Msg>(itsElement, itsDispatchMessages),
    KatydidTableRowContentBuilder<Msg> {

    val contentRestrictions = itsContentRestrictions

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatydidComment(nodeValue, key))
    }

    /**
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun flowContent(element: KatydidHtmlElementImpl<Msg>): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    override fun td(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        colspan: Int?,
        contenteditable: Boolean?,
        dir: EDirection?,
        headers: String?,
        hidden: Boolean?,
        lang: String?,
        rowspan: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTd(this, selector, key, accesskey, colspan, contenteditable, dir, headers, hidden,
                      lang, rowspan, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun th(
        selector: String?,
        key: Any?,
        abbr: String?,
        accesskey: Char?,
        colspan: Int?,
        contenteditable: Boolean?,
        dir: EDirection?,
        headers: String?,
        hidden: Boolean?,
        lang: String?,
        rowspan: Int?,
        scope: EHeadingScope?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTh(this, selector, key, abbr, accesskey, colspan, contenteditable, dir, headers, hidden,
                      lang, rowspan, scope, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

