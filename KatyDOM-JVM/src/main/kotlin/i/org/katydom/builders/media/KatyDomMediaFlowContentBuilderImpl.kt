//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders.media

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.media.KatyDomMediaFlowContentBuilder
import i.org.katydom.builders.KatyDomContentRestrictions
import i.org.katydom.builders.KatyDomFlowContentBuilderImpl
import i.org.katydom.elements.embedded.KatyDomSource
import i.org.katydom.elements.embedded.KatyDomTrack
import o.org.katydom.types.EDirection
import o.org.katydom.types.ETrackKind
import o.org.katydom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a media element.
 *
 * @constructor Constructs a new builder for the contents of a `<audio>` or `<video>` element.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 *
 * TODO: To support "transparent" content, we need embedded / phrased / flow media content builders or at least runtime checking.
 */
internal class KatyDomMediaFlowContentBuilderImpl<Msg>(
    element: KatyDomHtmlElement<Msg>,
    contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
    val mediaContentRestrictions: KatyDomMediaContentRestrictions = KatyDomMediaContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomFlowContentBuilderImpl<Msg>(element, contentRestrictions, dispatchMessages),
    KatyDomMediaFlowContentBuilder<Msg> {

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

    override fun track(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        default: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        kind: ETrackKind?,
        label: String?,
        lang: String?,
        spellcheck: Boolean?,
        src: String,
        srclang: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTrack(this, selector, key, accesskey, contenteditable, default, dir,
                         hidden, kind, label, lang, spellcheck, src, srclang, style,
                         tabindex, title, translate, defineAttributes)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

