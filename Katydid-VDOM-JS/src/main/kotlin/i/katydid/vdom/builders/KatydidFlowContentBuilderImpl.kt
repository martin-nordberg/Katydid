//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders

import i.katydid.vdom.builders.lists.KatydidOrderedListContentBuilderImpl
import i.katydid.vdom.builders.lists.KatydidUnorderedListContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidMediaContentRestrictions
import i.katydid.vdom.builders.media.KatydidMediaFlowContentBuilderImpl
import i.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilderImpl
import i.katydid.vdom.builders.objects.KatydidObjectFlowContentBuilderImpl
import i.katydid.vdom.builders.tables.KatydidTableContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.edits.KatydidDel
import i.katydid.vdom.elements.edits.KatydidIns
import i.katydid.vdom.elements.embedded.KatydidAudio
import i.katydid.vdom.elements.embedded.KatydidMap
import i.katydid.vdom.elements.embedded.KatydidObject
import i.katydid.vdom.elements.embedded.KatydidVideo
import i.katydid.vdom.elements.forms.KatydidFieldSet
import i.katydid.vdom.elements.forms.KatydidForm
import i.katydid.vdom.elements.forms.KatydidLegend
import i.katydid.vdom.elements.grouping.*
import i.katydid.vdom.elements.interactive.KatydidDetails
import i.katydid.vdom.elements.interactive.KatydidDialog
import i.katydid.vdom.elements.scripting.KatydidCanvas
import i.katydid.vdom.elements.sections.*
import i.katydid.vdom.elements.tabular.KatydidTable
import i.katydid.vdom.elements.text.KatydidA
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.builders.details.KatydidDetailsFlowContentBuilder
import o.katydid.vdom.builders.lists.KatydidOrderedListContentBuilder
import o.katydid.vdom.builders.lists.KatydidUnorderedListContentBuilder
import o.katydid.vdom.builders.media.KatydidMediaFlowContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilder
import o.katydid.vdom.builders.objects.KatydidObjectFlowContentBuilder
import o.katydid.vdom.builders.tables.KatydidTableContentBuilder
import o.katydid.vdom.types.*
import x.katydid.vdom.types.KatyDateTime

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

    override fun a(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        download: String?,
        draggable: Boolean?,
        hidden: Boolean?,
        href: String?,
        hreflang: String?,
        lang: String?,
        rel: Iterable<EAnchorHtmlLinkType>?,
        rev: Iterable<EAnchorHtmlLinkType>?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        target: String?,
        title: String?,
        translate: Boolean?,
        type: String?,
        contentType: FlowContent,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidA(this, selector, key, accesskey, contenteditable, dir, download, draggable, hidden,
                href, hreflang, lang, rel, rev, spellcheck, style, tabindex, target, title, translate, type, defineContent)
        )
    }

    override fun address(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidAddress(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun article(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidArticle(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun aside(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidAside(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun audio(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autoplay: Boolean?,
        contenteditable: Boolean?,
        controls: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        loop: Boolean?,
        muted: Boolean?,
        preload: EPreloadHint?,
        spellcheck: Boolean?,
        src: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        contentType: FlowContent,
        defineContent: KatydidMediaFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidAudio(this, selector, key, accesskey, autoplay, contenteditable, controls,
                crossorigin, dir, draggable, hidden, lang, loop, muted, preload, spellcheck, src, style,
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
        draggable: Boolean?,
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
            KatydidBlockQuote(this, selector, key, accesskey, cite, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun canvas(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        contentType: FlowContent,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidCanvas(this, selector, key, accesskey, contenteditable, dir, draggable, height,
                hidden, lang, spellcheck, style, tabindex, title, translate, width, defineContent)
        )
    }

    override fun del(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        cite: String?,
        contenteditable: Boolean?,
        datetime: KatyDateTime?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        contentType: FlowContent,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDel(this, selector, key, accesskey, cite, contenteditable, datetime, dir, draggable,
                hidden, lang, spellcheck, style, tabindex, title, translate, contentType, defineContent)
        )
    }

    /**
     * Creates a new description list content builder for the given child [element].
     */
    fun descriptionListContent(element: KatydidDiv<Msg>): KatydidDescriptionListContentBuilderImpl<Msg> {
        contentRestrictions.prohibitParam()
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
        contentRestrictions.prohibitParam()
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
        draggable: Boolean?,
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
            KatydidDetails(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, open, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun dialog(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        open: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidDialog(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, open, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun div(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidDiv(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun dl(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidDl(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun fieldset(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        draggable: Boolean?,
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
                disabled, draggable, form, hidden, lang, name, spellcheck, style, tabindex, title, translate,
                defineContent)
        )
    }

    override fun figCaption(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidFigCaption(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun figure(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidFigure(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun footer(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidFooter(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
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
        draggable: Boolean?,
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
            KatydidForm(this, selector, key, acceptCharset, accesskey, action, autocomplete,
                contenteditable, dir, draggable, enctype, hidden, lang, method, name, novalidate, spellcheck,
                style, tabindex, title, target, translate, defineContent)
        )
    }

    override fun h1(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidH1(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun h2(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidH2(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun h3(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidH3(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun h4(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidH4(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun h5(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidH5(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun h6(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidH6(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun header(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidHeader(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun hr(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidHr(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineAttributes)
        )
    }

    override fun ins(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        cite: String?,
        contenteditable: Boolean?,
        datetime: KatyDateTime?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        contentType: FlowContent,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidIns(this, selector, key, accesskey, cite, contenteditable, datetime, dir,
                draggable, hidden, lang, spellcheck, style, tabindex, title, translate, contentType, defineContent)
        )
    }

    override fun legend(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidLegend(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, spellcheck,
                style, tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new list content builder for the given child [element] that has the same restrictions
     * as this builder. The list items to be produced are ordered.
     */
    fun listContent(element: KatydidOl<Msg>): KatydidOrderedListContentBuilder<Msg> {
        contentRestrictions.prohibitParam()
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
        contentRestrictions.prohibitParam()
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
        draggable: Boolean?,
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
            KatydidMain(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun map(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        contentType: FlowContent,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidMap(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, name, spellcheck, style, tabindex, title, translate, contentType, defineContent)
        )
    }

    /**
     * Creates a new media content builder for the given child [element].
     */
    fun mediaFlowContent(element: KatydidHtmlElementImpl<Msg>,
                         sourceAllowed: Boolean): KatydidMediaFlowContentBuilder<Msg> {
        contentRestrictions.prohibitParam()
        return KatydidMediaFlowContentBuilderImpl(
            element,
            contentRestrictions.withMediaElementNotAllowed(),
            KatydidMediaContentRestrictions(sourceAllowed),
            dispatchMessages
        )
    }

    override fun nav(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidNav(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun `object`(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        data: String?,
        dir: EDirection?,
        draggable: Boolean?,
        form: String?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: MimeType?,
        typemustmatch: Boolean?,
        width: Int?,
        contentType: FlowContent,
        defineContent: KatydidObjectFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidObject(this, selector, key, accesskey, contenteditable, data, dir, draggable,
                form, height, hidden, lang, name, spellcheck, style, tabindex, title, translate,
                type, typemustmatch, width, defineContent)
        )
    }

    /**
     * Creates a new object content builder for the given child [element].
     */
    fun objectFlowContent(element: KatydidObject<Msg>): KatydidObjectFlowContentBuilder<Msg> {
        contentRestrictions.prohibitParam()
        return KatydidObjectFlowContentBuilderImpl(
            element,
            contentRestrictions.withParamAllowed(),
            dispatchMessages
        )
    }

    override fun ol(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidOl(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, reversed, spellcheck, start, style, tabindex, title, translate, type, defineContent)
        )
    }

    override fun p(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidP(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new phrasing content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun phrasingContent(element: KatydidHtmlElementImpl<Msg>): KatydidPhrasingContentBuilderImpl<Msg> {
        contentRestrictions.prohibitParam()
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
        draggable: Boolean?,
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
            KatydidPre(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun section(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidSection(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun table(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        border: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
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
            KatydidTable(this, selector, key, accesskey, border, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style, tabindex, title, translate, defineContent)
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
        draggable: Boolean?,
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
            KatydidUl(this, selector, key, accesskey, contenteditable, dir, draggable, hidden,
                lang, spellcheck, style, tabindex, title, translate, defineContent)
        )
    }

    override fun video(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autoplay: Boolean?,
        contenteditable: Boolean?,
        controls: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        draggable: Boolean?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        loop: Boolean?,
        muted: Boolean?,
        poster: String?,
        preload: EPreloadHint?,
        spellcheck: Boolean?,
        src: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        contentType: FlowContent,
        defineContent: KatydidMediaFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidVideo(this, selector, key, accesskey, autoplay, contenteditable, controls,
                crossorigin, dir, draggable, height, hidden, lang, loop, muted, poster, preload, spellcheck,
                src, style, tabindex, title, translate, width, defineContent)
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder but figcaption elements are allowed.
     */
    fun withFigCaptionAllowed(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidFlowContentBuilderImpl<Msg> {
        contentRestrictions.prohibitParam()
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
        contentRestrictions.prohibitParam()
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
        contentRestrictions.prohibitParam()
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
        contentRestrictions.prohibitParam()
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withFormNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no interactive content allowed.
     */
    override fun withInteractiveContentNotAllowed(
        element: KatydidHtmlElementImpl<Msg>
    ): KatydidFlowContentBuilderImpl<Msg> {
        contentRestrictions.prohibitParam()
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions.withInteractiveContentNotAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder but allows one legend element.
     */
    fun withLegendAllowed(element: KatydidHtmlElementImpl<Msg>): KatydidFlowContentBuilderImpl<Msg> {
        contentRestrictions.prohibitParam()
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
        contentRestrictions.prohibitParam()
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
        contentRestrictions.prohibitParam()
        return KatydidFlowContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

