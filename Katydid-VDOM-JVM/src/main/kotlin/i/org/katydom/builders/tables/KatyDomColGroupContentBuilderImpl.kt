//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders.tables

import i.org.katydom.builders.KatyDomAttributesContentBuilderImpl
import i.org.katydom.elements.tabular.KatyDomCol
import i.org.katydom.elements.tabular.KatyDomColGroup
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.tables.KatyDomColGroupContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a column group.
 *
 * @constructor Constructs a new builder for the contents of a `<colgroup>` element.
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatyDomColGroupContentBuilderImpl<Msg>(
    element: KatyDomColGroup<Msg>,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomColGroupContentBuilder<Msg> {

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    internal fun attributesContent(element: KatyDomCol<Msg>): KatyDomAttributesContentBuilder<Msg> {
        return KatyDomAttributesContentBuilderImpl(element, dispatchMessages)
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomCol(this, selector, key, accesskey, contenteditable, dir, hidden,
                       lang, span, spellcheck, style, tabindex, title, translate, defineAttributes)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

