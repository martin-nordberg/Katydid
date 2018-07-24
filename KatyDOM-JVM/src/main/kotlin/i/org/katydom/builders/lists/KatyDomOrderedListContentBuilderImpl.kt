//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders.lists

import i.org.katydom.builders.KatyDomAttributesContentBuilderImpl
import i.org.katydom.builders.KatyDomFlowContentBuilderImpl
import i.org.katydom.elements.grouping.KatyDomLi
import i.org.katydom.elements.grouping.KatyDomOl
import i.org.katydom.elements.text.KatyDomComment
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.lists.KatyDomOrderedListContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of an ordered list (an `<ol>` element).
 *
 * @constructor Constructs a new builder for the contents of an ordered or unordered list.
 * @param flowContent The parent flow content with restrictions that can be resumed for the content inside each
 *                    `<li>` element produced by this builder.
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatyDomOrderedListContentBuilderImpl<Msg>(
    internal val flowContent: KatyDomFlowContentBuilderImpl<Msg>,
    element: KatyDomOl<Msg>,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomOrderedListContentBuilder<Msg> {

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    override fun li(
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
        value: Int?,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomLi(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, value, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

