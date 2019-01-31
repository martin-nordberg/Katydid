//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders

import i.katydid.vdom.builders.lists.KatydidOrderedListContentBuilderImpl
import i.katydid.vdom.builders.lists.KatydidUnorderedListContentBuilderImpl
import i.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilderImpl
import i.katydid.vdom.builders.tables.KatydidTableContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.forms.KatydidFieldSet
import i.katydid.vdom.elements.forms.KatydidForm
import i.katydid.vdom.elements.forms.KatydidLegend
import i.katydid.vdom.elements.grouping.*
import i.katydid.vdom.elements.interactive.KatydidDetails
import i.katydid.vdom.elements.sections.*
import i.katydid.vdom.elements.tabular.KatydidTable
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.builders.details.KatydidDetailsFlowContentBuilder
import o.katydid.vdom.builders.lists.KatydidOrderedListContentBuilder
import o.katydid.vdom.builders.lists.KatydidUnorderedListContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EFormEncodingType
import o.katydid.vdom.types.EFormSubmissionMethod
import o.katydid.vdom.types.EOrderedListType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the normal case of HTML "flow content".
 *
 * @constructor Constructs a flow content builder for given [element] and [contentRestrictions].
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
internal open class KatydidFlowContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions,
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidPhrasingContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidFlowContentBuilder<Msg> {

    override fun address(
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
            KatydidAddress(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck,
                style, tabindex, title, translate, defineContent)
        )
    }

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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidArticle(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidAside(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidBlockQuote(this, selector, key, accesskey, cite, contenteditable, dir, hidden, lang, spellcheck,
                style, tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new description list content builder for the given child [element].
     */
    fun descriptionListContent(element: KatydidDiv<Msg>): KatydidDescriptionListContentBuilderImpl<Msg> {
        return KatydidDescriptionListContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    /**
     * Creates a new description list content builder for the given child [element].
     */
    fun descriptionListContent(element: KatydidDl<Msg>): KatydidDescriptionListContentBuilderImpl<Msg> {
        return KatydidDescriptionListContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
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
        defineContent: KatydidDetailsFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDetails(this, selector, key, accesskey, contenteditable, dir, hidden, lang, open, spellcheck,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDiv(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun dl(
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
            KatydidDl(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidFieldSet(this, selector, key, accesskey, contenteditable, dir,
                disabled, form, hidden, lang, name, spellcheck, style, tabindex, title, translate,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidFigCaption(this, selector, key, accesskey, contenteditable, dir,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidFigure(this, selector, key, accesskey, contenteditable, dir,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidFooter(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidForm(this, selector, key, acceptCharset, accesskey, action, autocomplete, contenteditable, dir,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidH1(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidH2(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidH3(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidH4(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidH5(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidH6(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidHeader(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidHr(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidLegend(this, selector, key, accesskey, contenteditable, dir,
                hidden, lang, spellcheck,
                style, tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new list content builder for the given child [element] that has the same restrictions
     * as this builder. The list items to be produced are ordered.
     */
    fun listContent(element: KatydidOl<Msg>): KatydidOrderedListContentBuilder<Msg> {
        return KatydidOrderedListContentBuilderImpl(
            this,
            element,
            dispatchMessages
        )
    }

    /**
     * Creates a new list content builder for the given child [element] that has the same restrictions
     * as this builder. The list items to be produced are unordered.
     */
    fun listContent(element: KatydidUl<Msg>): KatydidUnorderedListContentBuilder<Msg> {
        return KatydidUnorderedListContentBuilderImpl(
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidMain(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidNav(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidOrderedListContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidOl(this, selector, key, accesskey, contenteditable, dir, hidden, lang, reversed, spellcheck,
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidP(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new phrasing content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun phrasingContent(element: KatydidHtmlElementImpl<Msg>): KatydidPhrasingContentBuilderImpl<Msg> {
        return KatydidPhrasingContentBuilderImpl(
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidPre(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSection(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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
        defineContent: KatydidTableContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTable(this, selector, key, accesskey, border, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new table content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun tableContent(element: KatydidTable<Msg>): KatydidTableContentBuilderImpl<Msg> {
        return KatydidTableContentBuilderImpl(
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
        defineContent: KatydidUnorderedListContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidUl(this, selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }


    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder but figcaption elements are allowed.
     */
    fun withFigCaptionAllowed(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withFigCaptionAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no footer, header or address elements allowed.
     */
    fun withFooterHeaderAddressNotAllowed(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withFooterHeaderAddressNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no footer, header or main elements allowed.
     */
    fun withFooterHeaderMainNotAllowed(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withFooterHeaderMainNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no form element allowed.
     */
    fun withFormNotAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withFormNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder but allows one legend element.
     */
    fun withLegendAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withLegendAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no main element allowed.
     */
    fun withMainNotAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withMainNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    override fun withNoAddedRestrictions(element: KatydidHtmlElementImpl<Msg>): KatydidFlowContentBuilderImpl<Msg> {
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

