//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.media

import i.katydid.vdom.builders.KatyDomAttributesContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import i.katydid.vdom.elements.embedded.KatyDomImg
import i.katydid.vdom.elements.embedded.KatyDomPicture
import i.katydid.vdom.elements.embedded.KatyDomSource
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.builders.media.KatyDomPictureContentBuilder
import o.katydid.vdom.types.ECorsSetting
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EReferrerPolicy
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a picture element.
 *
 * @constructor Constructs a new builder for the contents of a `<picture>` element.
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatyDomPictureContentBuilderImpl<Msg>(
    element: KatyDomPicture<Msg>,
    val pictureContentRestrictions: KatyDomPictureContentRestrictions = KatyDomPictureContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomPictureContentBuilder<Msg> {

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    fun attributesContent(element: KatyDomHtmlElement<Msg>): KatyDomAttributesContentBuilder<Msg> {
        return KatyDomAttributesContentBuilderImpl(element, dispatchMessages)
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
        src: String?,
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

    override fun source(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        media: String?,
        sizes: String?,
        spellcheck: Boolean?,
        src: String,
        srcset: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: MimeType?,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSource(this, selector, key, accesskey, contenteditable, dir,
                          hidden, lang, media, sizes, spellcheck, src, srcset, style,
                          tabindex, title, translate, type, defineAttributes)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

