//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.tables

import i.katydid.vdom.builders.KatyDomAttributesContentBuilderImpl
import i.katydid.vdom.builders.KatyDomContentRestrictions
import i.katydid.vdom.elements.KatyDomHtmlElement
import i.katydid.vdom.elements.tabular.KatyDomTr
import i.katydid.vdom.elements.text.KatyDomComment
import o.katydid.vdom.builders.tables.KatyDomTableBodyContentBuilder
import o.katydid.vdom.builders.tables.KatyDomTableRowContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a table's thead, tbody, or tfoot element.
 *
 * @constructor Constructs a new builder for the contents of a `<thead>`, `<tbody>`, or `<tfoot>` element.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatyDomTableBodyContentBuilderImpl<Msg>(
    element: KatyDomHtmlElement<Msg>,
    val contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomTableBodyContentBuilder<Msg> {

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatyDomComment(nodeValue, key))
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

}

//---------------------------------------------------------------------------------------------------------------------

