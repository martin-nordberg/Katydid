//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.builders.tables

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.tables.KatyDomTableRowContentBuilder
import o.org.katydom.internal.builders.KatyDomAttributesContentBuilderImpl
import o.org.katydom.internal.builders.KatyDomContentRestrictions
import o.org.katydom.internal.builders.KatyDomFlowContentBuilderImpl
import o.org.katydom.internal.concretenodes.tabular.KatyDomTd
import o.org.katydom.internal.concretenodes.tabular.KatyDomTh
import o.org.katydom.internal.concretenodes.tabular.KatyDomTr
import o.org.katydom.internal.concretenodes.text.KatyDomComment
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
internal class KatyDomTableRowContentBuilderImpl<Msg> internal constructor(
    element: KatyDomTr<Msg>,
    internal val contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomTableRowContentBuilder<Msg> {

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    /**
     * Creates a new flow content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun flowContent(element: KatyDomHtmlElement<Msg>): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
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
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTd(this, selector, key, accesskey, colspan, contenteditable, dir, headers, hidden,
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
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTh(this, selector, key, abbr, accesskey, colspan, contenteditable, dir, headers, hidden,
                      lang, rowspan, scope, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

