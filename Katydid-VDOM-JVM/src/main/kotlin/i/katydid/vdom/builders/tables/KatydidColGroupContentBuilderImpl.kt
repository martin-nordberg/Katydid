//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.tables

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.elements.tabular.KatydidCol
import i.katydid.vdom.elements.tabular.KatydidColGroup
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.tables.KatydidColGroupContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a column group.
 *
 * @constructor Constructs a new builder for the contents of a `<colgroup>` element.
 * @param itsElement the element whose content is being built.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidColGroupContentBuilderImpl<Msg>(
    itsElement: KatydidColGroup<Msg>,
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilderImpl<Msg>(itsElement, itsDispatchMessages),
    KatydidColGroupContentBuilder<Msg> {

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    internal fun attributesContent(element: KatydidCol<Msg>): KatydidAttributesContentBuilder<Msg> {
        return KatydidAttributesContentBuilderImpl(element, dispatchMessages)
    }

    override fun col(
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
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidCol(this, selector, key, accesskey, contenteditable, dir, hidden,
                       lang, span, spellcheck, style, tabindex, title, translate, defineAttributes)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

