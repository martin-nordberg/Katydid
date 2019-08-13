//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidPictureContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.ECorsSetting
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EReferrerPolicy

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<img>` element.
 */
internal class KatydidImg<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        alt: String,
        contenteditable: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        draggable: Boolean?,
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
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
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
        pictureContent: KatydidPictureContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        alt: String,
        contenteditable: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        draggable: Boolean?,
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
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
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


