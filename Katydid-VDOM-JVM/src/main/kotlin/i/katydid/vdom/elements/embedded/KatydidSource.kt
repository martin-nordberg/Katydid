//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.media.KatydidMediaFlowContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidPictureContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<source>` element.
 */
internal class KatydidSource<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        mediaContent: KatydidMediaFlowContentBuilderImpl<Msg>,
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
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        mediaContent.mediaContentRestrictions.confirmSourceAllowed()

        setAttribute("media", media)
        setAttribute("sizes", sizes)
        setAttribute("src", src)
        setAttribute("srcset", srcset)
        setAttribute("type", type?.toString())

        mediaContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    constructor(
        pictureContent: KatydidPictureContentBuilderImpl<Msg>,
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
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        pictureContent.pictureContentRestrictions.confirmSourceAllowed()

        setAttribute("media", media)
        setAttribute("sizes", sizes)
        setAttribute("src", src)
        setAttribute("srcset", srcset)
        setAttribute("type", type?.toString())

        pictureContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "SOURCE"

}

//---------------------------------------------------------------------------------------------------------------------


