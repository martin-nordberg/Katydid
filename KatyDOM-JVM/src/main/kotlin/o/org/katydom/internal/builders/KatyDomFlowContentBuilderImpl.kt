//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.builders.details.KatyDomDetailsFlowContentBuilder
import o.org.katydom.builders.lists.KatyDomOrderedListContentBuilder
import o.org.katydom.builders.lists.KatyDomUnorderedListContentBuilder
import o.org.katydom.builders.tables.KatyDomTableContentBuilder
import o.org.katydom.internal.builders.lists.KatyDomOrderedListContentBuilderImpl
import o.org.katydom.internal.builders.lists.KatyDomUnorderedListContentBuilderImpl
import o.org.katydom.internal.builders.tables.KatyDomTableContentBuilderImpl
import o.org.katydom.internal.concretenodes.forms.KatyDomFieldSet
import o.org.katydom.internal.concretenodes.forms.KatyDomForm
import o.org.katydom.internal.concretenodes.forms.KatyDomLegend
import o.org.katydom.internal.concretenodes.grouping.*
import o.org.katydom.internal.concretenodes.interactive.KatyDomDetails
import o.org.katydom.internal.concretenodes.sections.*
import o.org.katydom.internal.concretenodes.tabular.KatyDomTable
import o.org.katydom.types.EDirection
import o.org.katydom.types.EFormEncodingType
import o.org.katydom.types.EFormSubmissionMethod
import o.org.katydom.types.EOrderedListType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the normal case of HTML "flow content".
 *
 * @constructor Constructs a flow content builder for given [element] and [contentRestrictions].
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
internal open class KatyDomFlowContentBuilderImpl<Msg>(
    element: KatyDomHtmlElement<Msg>,
    contentRestrictions: KatyDomContentRestrictions,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomPhrasingContentBuilderImpl<Msg>(element, contentRestrictions, dispatchMessages),
    KatyDomFlowContentBuilder<Msg> {

    override fun article(
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
            KatyDomArticle(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                           tabindex, title, translate, defineContent)
        )
    }

    override fun aside(
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
            KatyDomAside(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    override fun blockquote(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        cite: String?,
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
            KatyDomBlockQuote(this, selector, key, accesskey, cite, contenteditable, dir, hidden, lang, spellcheck,
                              style,
                              tabindex, title, translate, defineContent)
        )
    }

    override fun details(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        open: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomDetailsFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomDetails(this, selector, key, accesskey, contenteditable, dir, hidden, lang, open, spellcheck,
                           style, tabindex, title, translate, defineContent)
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
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomDiv(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                       tabindex, title, translate, defineContent)
        )
    }

    override fun fieldset(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        form: String?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomFieldSet(this, selector, key, accesskey, contenteditable, dir,
                            disabled, form, hidden, lang,
                            name, spellcheck, style, tabindex, title, translate,
                            defineContent)
        )
    }

    override fun figCaption(
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
            KatyDomFigCaption(this, selector, key, accesskey, contenteditable, dir,
                              hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun figure(
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
            KatyDomFigure(this, selector, key, accesskey, contenteditable, dir,
                          hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun footer(
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
            KatyDomFooter(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                          tabindex, title, translate, defineContent)
        )
    }

    override fun form(
        selector: String?,
        key: Any?,
        acceptCharset: String?,
        accesskey: Char?,
        action: String?,
        autocomplete: String?,
        contenteditable: Boolean?,
        dir: EDirection?,
        enctype: EFormEncodingType?,
        hidden: Boolean?,
        lang: String?,
        method: EFormSubmissionMethod?,
        name: String?,
        novalidate: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        target: String?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomForm(this, selector, key, acceptCharset, accesskey, action, autocomplete, contenteditable, dir,
                        enctype, hidden, lang, method, name, novalidate, spellcheck, style, tabindex, title,
                        target, translate, defineContent)
        )
    }

    override fun h1(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomH1(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    override fun h2(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomH2(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    override fun h3(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomH3(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    override fun h4(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomH4(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    override fun h5(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomH5(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    override fun h6(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomH6(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }

    override fun header(
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
            KatyDomHeader(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                          tabindex, title, translate, defineContent)
        )
    }

    override fun hr(
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomHr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineAttributes)
        )
    }

    override fun legend(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomLegend(this, selector, key, accesskey, contenteditable, dir,
                          hidden, lang, spellcheck,
                          style, tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new list content builder for the given child [element] that has the same restrictions
     * as this builder. The list items to be produced are ordered.
     */
    fun listContent(element: KatyDomOl<Msg>): KatyDomOrderedListContentBuilder<Msg> {
        return KatyDomOrderedListContentBuilderImpl(
            this,
            element,
            dispatchMessages
        )
    }

    /**
     * Creates a new list content builder for the given child [element] that has the same restrictions
     * as this builder. The list items to be produced are unordered.
     */
    fun listContent(element: KatyDomUl<Msg>): KatyDomUnorderedListContentBuilder<Msg> {
        return KatyDomUnorderedListContentBuilderImpl(
            this,
            element,
            dispatchMessages
        )
    }

    override fun main(
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
            KatyDomMain(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                        tabindex, title, translate, defineContent)
        )
    }

    override fun nav(
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
            KatyDomNav(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                       tabindex, title, translate, defineContent)
        )
    }

    override fun ol(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        reversed: Boolean?,
        spellcheck: Boolean?,
        start: Int?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: EOrderedListType?,
        defineContent: KatyDomOrderedListContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOl(this, selector, key, accesskey, contenteditable, dir, hidden, lang, reversed, spellcheck,
                      start, style, tabindex, title, translate, type, defineContent)
        )
    }

    override fun p(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomP(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                     tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new phrasing content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun phrasingContent(element: KatyDomHtmlElement<Msg>): KatyDomPhrasingContentBuilderImpl<Msg> {
        return KatyDomPhrasingContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    override fun pre(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomPre(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                       tabindex, title, translate, defineContent)
        )
    }

    override fun section(
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
            KatyDomSection(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                           tabindex, title, translate, defineContent)
        )
    }

    override fun table(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        border: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomTableContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTable(this, selector, key, accesskey, border, contenteditable, dir, hidden, lang, spellcheck, style,
                         tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new table content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun tableContent(element: KatyDomTable<Msg>): KatyDomTableContentBuilderImpl<Msg> {
        return KatyDomTableContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    override fun ul(
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
        defineContent: KatyDomUnorderedListContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomUl(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                      tabindex, title, translate, defineContent)
        )
    }


    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder but figcaption elements are allowed.
     */
    fun withFigCaptionAllowed(
        element: KatyDomHtmlElement<Msg>
    ): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
            element,
            contentRestrictions.withFigCaptionAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no footer, header or main elements allowed.
     */
    fun withFooterHeaderMainNotAllowed(
        element: KatyDomHtmlElement<Msg>
    ): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
            element,
            contentRestrictions.withFooterHeaderMainNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no form element allowed.
     */
    fun withFormNotAllowed(element: KatyDomHtmlElement<Msg>): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
            element,
            contentRestrictions.withFormNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder but allows one legend element.
     */
    fun withLegendAllowed(element: KatyDomHtmlElement<Msg>): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
            element,
            contentRestrictions.withLegendAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no main element allowed.
     */
    fun withMainNotAllowed(element: KatyDomHtmlElement<Msg>): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
            element,
            contentRestrictions.withMainNotAllowed(),
            dispatchMessages
        )
    }

    // TODO: Figure out how to map messages and element construction
//    fun <InnerMsg> withMessagesMapped(
//        mapMessage: (InnerMsg) -> Msg,
//        defineContent: KatyDomFlowContentBuilder<InnerMsg>.() -> Unit
//    ) {
//
//        val innerDispatch : (Iterable<InnerMsg>) -> Unit = { messages: Iterable<InnerMsg> ->
//            dispatchMessages( messages.map { m -> mapMessage(m) } )
//        }
//
//        // TODO: Need something like IKatyDomElement with forwarding of methods plus mapping of messages
//
//        val builder = KatyDomFlowContentBuilder<InnerMsg>(element,contentRestrictions,innerDispatch)
//
//        builder.defineContent()
//
//    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    override fun withNoAddedRestrictions(element: KatyDomHtmlElement<Msg>): KatyDomFlowContentBuilderImpl<Msg> {
        return KatyDomFlowContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

