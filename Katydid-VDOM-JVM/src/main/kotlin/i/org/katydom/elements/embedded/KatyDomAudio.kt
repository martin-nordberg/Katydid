//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.embedded

import i.org.katydom.builders.KatyDomEmbeddedContentBuilderImpl
import i.org.katydom.elements.KatyDomHtmlElement
import o.org.katydom.builders.media.KatyDomMediaFlowContentBuilder
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EDirection
import o.org.katydom.types.EPreloadHint

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<audio>` element.
 */
internal class KatyDomAudio<Msg>(
    embeddedContent: KatyDomEmbeddedContentBuilderImpl<Msg>,
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
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        embeddedContent.contentRestrictions.confirmMediaElementAllowed()

        setBooleanAttribute("autoplay", autoplay)
        setBooleanAttribute("controls", controls)
        setAttribute("crossorigin", crossorigin?.toHtmlString())
        setBooleanAttribute("loop", loop)
        setBooleanAttribute("muted", muted)
        setAttribute("preload", preload?.toHtmlString())
        setAttribute("src", src)

        embeddedContent.mediaFlowContent(this, src == null).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "AUDIO"

}

//---------------------------------------------------------------------------------------------------------------------


