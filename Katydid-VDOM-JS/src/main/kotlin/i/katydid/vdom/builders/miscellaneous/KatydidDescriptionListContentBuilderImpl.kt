//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.miscellaneous

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.grouping.KatydidDd
import i.katydid.vdom.elements.grouping.KatydidDiv
import i.katydid.vdom.elements.grouping.KatydidDt
import i.katydid.vdom.elements.text.KatydidComment
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a `<dl>` element.
 *
 * @constructor Constructs a new option content builder.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal open class KatydidDescriptionListContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions,
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilderImpl<Msg>(itsElement, itsDispatchMessages),
    KatydidDescriptionListContentBuilder<Msg> {

    internal val contentRestrictions = itsContentRestrictions

    ////

    override fun comment(nodeValue: String, key: Any?) {
        element.addChildNode(KatydidComment(nodeValue, key))
    }

    override fun dd(
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDd(this, selector, key, accesskey, contenteditable, dir,
                hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun div(
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
        defineContent: KatydidDescriptionListContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDiv(this, selector, key, accesskey, contenteditable, dir,
                hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun dt(
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDt(this, selector, key, accesskey, contenteditable, dir, hidden, lang,
                spellcheck, style, tabindex, title, translate, defineContent)
        )
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

    /**
     * Creates a new description list content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun withNoAddedRestrictions(element: KatydidDiv<Msg>): KatydidDescriptionListContentBuilderImpl<Msg> {
        return KatydidDescriptionListContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

