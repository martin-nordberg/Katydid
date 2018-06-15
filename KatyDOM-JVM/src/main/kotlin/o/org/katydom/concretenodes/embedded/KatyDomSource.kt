//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.embedded

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.media.KatyDomMediaFlowContentBuilder
import o.org.katydom.builders.media.KatyDomPictureContentBuilder
import o.org.katydom.types.EDirection
import o.org.katydom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<source>` element.
 */
internal class KatyDomSource<Msg> : KatyDomHtmlElement<Msg> {

    constructor(
        mediaContent: KatyDomMediaFlowContentBuilder<Msg>,
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
        pictureContent: KatyDomPictureContentBuilder<Msg>,
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


