//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.builders.lists

import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.lists.KatyDomUnorderedListContentBuilder
import o.org.katydom.internal.builders.KatyDomAttributesContentBuilderImpl
import o.org.katydom.internal.builders.KatyDomFlowContentBuilderImpl
import o.org.katydom.internal.concretenodes.grouping.KatyDomLi
import o.org.katydom.internal.concretenodes.grouping.KatyDomUl
import o.org.katydom.internal.concretenodes.text.KatyDomComment
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of an unordered list (an `<ol>` element).
 *
 * @constructor Constructs a new builder for the contents of an ordered or unordered list.
 * @param flowContent The parent flow content with restrictions that can be resumed for the content inside each
 *                    `<li>` element produced by this builder.
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatyDomUnorderedListContentBuilderImpl<Msg> internal constructor(
    internal val flowContent: KatyDomFlowContentBuilderImpl<Msg>,
    element: KatyDomUl<Msg>,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomUnorderedListContentBuilder<Msg> {

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
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomLi(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

