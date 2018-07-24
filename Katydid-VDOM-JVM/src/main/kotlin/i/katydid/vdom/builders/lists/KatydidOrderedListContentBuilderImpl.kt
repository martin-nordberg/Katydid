//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.lists

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.grouping.KatydidLi
import i.katydid.vdom.elements.grouping.KatydidOl
import i.katydid.vdom.elements.text.KatydidComment
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.lists.KatydidOrderedListContentBuilder
import o.katydid.vdom.types.EDirection

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
internal class KatydidOrderedListContentBuilderImpl<Msg>(
    internal val flowContent: KatydidFlowContentBuilderImpl<Msg>,
    element: KatydidOl<Msg>,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatydidOrderedListContentBuilder<Msg> {

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatydidComment(nodeValue, key))
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidLi(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, value, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

