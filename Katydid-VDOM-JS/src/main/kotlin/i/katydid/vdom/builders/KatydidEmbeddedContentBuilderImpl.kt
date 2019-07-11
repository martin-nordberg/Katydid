//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders

import i.katydid.vdom.builders.details.KatydidDetailsFlowContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidMediaContentRestrictions
import i.katydid.vdom.builders.media.KatydidMediaEmbeddedContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidPictureContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidPictureContentRestrictions
import i.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilderImpl
import i.katydid.vdom.builders.objects.KatydidObjectEmbeddedContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.embedded.*
import i.katydid.vdom.elements.interactive.KatydidDetails
import i.katydid.vdom.elements.scripting.KatydidCanvas
import i.katydid.vdom.elements.text.KatydidComment
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.KatydidEmbeddedContentBuilder
import o.katydid.vdom.builders.details.KatydidDetailsFlowContentBuilder
import o.katydid.vdom.builders.media.KatydidMediaEmbeddedContentBuilder
import o.katydid.vdom.builders.media.KatydidPictureContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.builders.objects.KatydidObjectEmbeddedContentBuilder
import o.katydid.vdom.types.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the case of HTML "embedded content".
 *
 * @constructor Constructs a new embedded content builder for the given [element].
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions the restrictions on built content to be enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
internal open class KatydidEmbeddedContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions,
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilderImpl<Msg>(itsElement, itsDispatchMessages),
    KatydidEmbeddedContentBuilder<Msg> {

    val contentRestrictions = itsContentRestrictions

    ////

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    fun attributesContent(element: KatydidHtmlElementImpl<Msg>): KatydidAttributesContentBuilderImpl<Msg> {
        return KatydidAttributesContentBuilderImpl(element, dispatchMessages)
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
        defineContent: KatydidMediaEmbeddedContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidAudio(this, selector, key, accesskey, autoplay, contenteditable, controls,
                crossorigin, dir, hidden, lang, loop, muted, preload, spellcheck, src, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun canvas(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        defineContent: KatydidEmbeddedContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidCanvas(this, selector, key, accesskey, contenteditable, dir, height,
                hidden, lang, spellcheck, style, tabindex, title, translate, width, defineContent)
        )
    }

    fun comment(nodeValue: String,
                key: Any?) {
        element.addChildNode(KatydidComment(nodeValue, key))
    }

    /**
     * Creates a new details content builder for the given child [element].
     */
    fun detailsFlowContent(element: KatydidDetails<Msg>): KatydidDetailsFlowContentBuilder<Msg> {
        return KatydidDetailsFlowContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    override fun embed(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        src: String,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: MimeType?,
        width: Int?,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidEmbed(this, selector, key, accesskey, contenteditable, dir, height, hidden,
                lang, spellcheck, src, style, tabindex, title, translate, type, width, defineContent)
        )
    }

    override fun iframe(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        allowfullscreen: Boolean?,
        allowpaymentrequest: Boolean?,
        contenteditable: Boolean?,
        dir: EDirection?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        referrerpolicy: EReferrerPolicy?,
        sandbox: List<ESandboxOption>?,
        spellcheck: Boolean?,
        src: String,
        srcdoc: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidIframe(this, selector, key, accesskey, allowfullscreen, allowpaymentrequest,
                contenteditable, dir, height, hidden, lang, name, referrerpolicy, sandbox, spellcheck,
                src, srcdoc, style, tabindex, title, translate, width, defineContent)
        )
    }

    override fun img(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        alt: String,
        contenteditable: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        height: Int?,
        hidden: Boolean?,
        ismap: Boolean?,
        lang: String?,
        referrerpolicy: EReferrerPolicy?,
        sizes: String?,
        spellcheck: Boolean?,
        src: String,
        srcset: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        usemap: String?,
        width: Int?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidImg(this, selector, key, accesskey, alt, contenteditable, crossorigin, dir, height,
                hidden, ismap, lang, referrerpolicy, sizes, spellcheck, src, srcset, style,
                tabindex, title, translate, usemap, width, defineAttributes)
        )
    }

    /**
     * Creates a new media content builder for the given child [element].
     */
    fun mediaEmbeddedContent(element: KatydidHtmlElementImpl<Msg>,
                             sourceAllowed: Boolean): KatydidMediaEmbeddedContentBuilder<Msg> {
        return KatydidMediaEmbeddedContentBuilderImpl(
            element,
            contentRestrictions.withMediaElementNotAllowed(),
            KatydidMediaContentRestrictions(sourceAllowed),
            dispatchMessages
        )
    }

    override fun `object`(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        data: String?,
        dir: EDirection?,
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
        defineContent: KatydidObjectEmbeddedContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidObject(this, selector, key, accesskey, contenteditable, data, dir, form, height,
                hidden, lang, name, spellcheck, style, tabindex, title, translate, type, typemustmatch,
                width, defineContent)
        )
    }

    /**
     * Creates a new object content builder for the given child [element].
     */
    fun objectEmbeddedContent(element: KatydidObject<Msg>): KatydidObjectEmbeddedContentBuilder<Msg> {
        return KatydidObjectEmbeddedContentBuilderImpl(
            element,
            contentRestrictions.withParamAllowed(),
            dispatchMessages
        )
    }

    /**
     * Creates a new media content builder for the given child [element].
     */
    fun pictureContent(element: KatydidPicture<Msg>): KatydidPictureContentBuilder<Msg> {
        return KatydidPictureContentBuilderImpl(
            element,
            KatydidPictureContentRestrictions(),
            dispatchMessages
        )
    }

    override fun picture(
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
        defineContent: KatydidPictureContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidPicture(this, selector, key, accesskey, contenteditable,
                dir, hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new text content builder for the given child [element].
     */
    fun textContent(element: KatydidHtmlElementImpl<Msg>): KatydidTextContentBuilder<Msg> {
        return KatydidTextContentBuilderImpl(element, dispatchMessages)
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
        defineContent: KatydidMediaEmbeddedContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidVideo(this, selector, key, accesskey, autoplay, contenteditable, controls,
                crossorigin, dir, height, hidden, lang, loop, muted, poster, preload, spellcheck, src, style,
                tabindex, title, translate, width, defineContent)
        )
    }

    /**
     * Creates a new embedded content builder for the given child [element].
     */
    open fun withNoAddedRestrictions(element: KatydidHtmlElementImpl<Msg>): KatydidEmbeddedContentBuilder<Msg> {
        return KatydidEmbeddedContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

