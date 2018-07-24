//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.tables

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.tabular.KatydidTr
import i.katydid.vdom.elements.text.KatydidComment
import o.katydid.vdom.builders.tables.KatydidTableBodyContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableRowContentBuilder
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
internal class KatydidTableBodyContentBuilderImpl<Msg>(
    element: KatydidHtmlElementImpl<Msg>,
    val contentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatydidTableBodyContentBuilder<Msg> {

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatydidComment(nodeValue, key))
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
        defineContent: KatydidTableRowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

