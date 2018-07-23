//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.embedded

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import i.org.katydom.builders.KatyDomEmbeddedContentBuilderImpl
import i.org.katydom.builders.media.KatyDomPictureContentBuilderImpl
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EDirection
import o.org.katydom.types.EReferrerPolicy

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<img>` element.
 */
internal class KatyDomImg<Msg> : KatyDomHtmlElement<Msg> {

    constructor(
        embeddedContent: KatyDomEmbeddedContentBuilderImpl<Msg>,
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
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        setAttribute("alt", alt)
        setAttribute("crossorigin", crossorigin?.toHtmlString())
        setNumberAttribute("height", height)
        // TODO: ismap requires <a href> ancestor
        setBooleanAttribute("ismap", ismap)
        setAttribute("referrerpolicy", referrerpolicy?.toHtmlString())
        setAttribute("sizes", sizes)
        setAttribute("src", src)
        setAttribute("srcset", srcset)
        setAttribute("usemap", usemap)
        setNumberAttribute("width", width)

        embeddedContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    constructor(
        pictureContent: KatyDomPictureContentBuilderImpl<Msg>,
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
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        pictureContent.pictureContentRestrictions.confirmImgAllowedThenDisallow()
        if (src == null) {
            pictureContent.pictureContentRestrictions.confirmSourceElementSeen()
        }

        setAttribute("alt", alt)
        setAttribute("crossorigin", crossorigin?.toHtmlString())
        setNumberAttribute("height", height)
        // TODO: ismap requires <a href> ancestor
        setBooleanAttribute("ismap", ismap)
        setAttribute("referrerpolicy", referrerpolicy?.toHtmlString())
        setAttribute("sizes", sizes)
        setAttribute("src", src)
        setAttribute("srcset", srcset)
        setAttribute("usemap", usemap)
        setNumberAttribute("width", width)

        pictureContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "IMG"

}

//---------------------------------------------------------------------------------------------------------------------


