//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.embedded

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomEmbeddedContentBuilder
import o.org.katydom.builders.media.KatyDomMediaFlowContentBuilder
import o.org.katydom.builders.media.KatyDomPictureContentBuilder
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EDirection
import o.org.katydom.types.EPreloadHint

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<picture>` element.
 */
internal class KatyDomPicture<Msg>(
    embeddedContent: KatyDomEmbeddedContentBuilder<Msg>,
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
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        embeddedContent.contentRestrictions.confirmMediaElementAllowed()

        embeddedContent.pictureContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "PICTURE"

}

//---------------------------------------------------------------------------------------------------------------------


