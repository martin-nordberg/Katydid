//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomEmbeddedContentBuilder
import o.org.katydom.builders.details.KatyDomDetailsFlowContentBuilder
import o.org.katydom.builders.media.KatyDomMediaFlowContentBuilder
import o.org.katydom.builders.media.KatyDomPictureContentBuilder
import o.org.katydom.builders.miscellaneous.KatyDomTextContentBuilder
import i.org.katydom.builders.details.KatyDomDetailsFlowContentBuilderImpl
import i.org.katydom.builders.media.KatyDomMediaContentRestrictions
import i.org.katydom.builders.media.KatyDomMediaFlowContentBuilderImpl
import i.org.katydom.builders.media.KatyDomPictureContentBuilderImpl
import i.org.katydom.builders.media.KatyDomPictureContentRestrictions
import i.org.katydom.builders.miscellaneous.KatyDomTextContentBuilderImpl
import i.org.katydom.elements.embedded.*
import i.org.katydom.elements.interactive.KatyDomDetails
import i.org.katydom.elements.text.KatyDomComment
import o.org.katydom.types.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the case of HTML "embedded content".
 *
 * @constructor Constructs a new embedded content builder for the given [element].
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
internal open class KatyDomEmbeddedContentBuilderImpl<Msg>(
    element: KatyDomHtmlElement<Msg>,
    val contentRestrictions: KatyDomContentRestrictions,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomEmbeddedContentBuilder<Msg> {

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    fun attributesContent(element: KatyDomHtmlElement<Msg>): KatyDomAttributesContentBuilderImpl<Msg> {
        return KatyDomAttributesContentBuilderImpl(element, dispatchMessages)
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
        defineContent: KatyDomMediaFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomAudio(this, selector, key, accesskey, autoplay, contenteditable, controls,
                         crossorigin, dir, hidden, lang, loop, muted, preload, spellcheck, src, style,
                         tabindex, title, translate, defineContent)
        )
    }

    fun comment(nodeValue: String,
                key: Any?) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    /**
     * Creates a new details content builder for the given child [element].
     */
    fun detailsFlowContent(element: KatyDomDetails<Msg>): KatyDomDetailsFlowContentBuilder<Msg> {
        return KatyDomDetailsFlowContentBuilderImpl(
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
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomEmbed(this, selector, key, accesskey, contenteditable, dir, height, hidden,
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
        sandbox: List<ESandboxOptions>?,
        spellcheck: Boolean?,
        src: String,
        srcdoc: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomIframe(this, selector, key, accesskey, allowfullscreen, allowpaymentrequest,
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomImg(this, selector, key, accesskey, alt, contenteditable, crossorigin, dir, height,
                       hidden, ismap, lang, referrerpolicy, sizes, spellcheck, src, srcset, style,
                       tabindex, title, translate, usemap, width, defineAttributes)
        )
    }

    /**
     * Creates a new media content builder for the given child [element].
     */
    fun mediaFlowContent(element: KatyDomHtmlElement<Msg>,
                         sourceAllowed: Boolean): KatyDomMediaFlowContentBuilder<Msg> {
        return KatyDomMediaFlowContentBuilderImpl(
            element,
            contentRestrictions.withMediaElementNotAllowed(),
            KatyDomMediaContentRestrictions(sourceAllowed),
            dispatchMessages
        )
    }

    /**
     * Creates a new media content builder for the given child [element].
     */
    fun pictureContent(element: KatyDomPicture<Msg>): KatyDomPictureContentBuilder<Msg> {
        return KatyDomPictureContentBuilderImpl(
            element,
            KatyDomPictureContentRestrictions(),
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
        defineContent: KatyDomPictureContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomPicture(this, selector, key, accesskey, contenteditable,
                           dir, hidden, lang, spellcheck, style,
                           tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new text content builder for the given child [element].
     */
    fun textContent(element: KatyDomHtmlElement<Msg>): KatyDomTextContentBuilder<Msg> {
        return KatyDomTextContentBuilderImpl(element, dispatchMessages)
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
        defineContent: KatyDomMediaFlowContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomVideo(this, selector, key, accesskey, autoplay, contenteditable, controls,
                         crossorigin, dir, height, hidden, lang, loop, muted, poster, preload, spellcheck, src, style,
                         tabindex, title, translate, width, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

