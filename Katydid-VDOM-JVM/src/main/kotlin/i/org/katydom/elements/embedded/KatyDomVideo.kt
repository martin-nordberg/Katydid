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
 * Virtual node for a `<video>` element.
 */
internal class KatyDomVideo<Msg>(
    embeddedContent: KatyDomEmbeddedContentBuilderImpl<Msg>,
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
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        embeddedContent.contentRestrictions.confirmMediaElementAllowed()

        setBooleanAttribute("autoplay", autoplay)
        setBooleanAttribute("controls", controls)
        setAttribute("crossorigin", crossorigin?.toHtmlString())
        setNumberAttribute("height", height)
        setBooleanAttribute("loop", loop)
        setBooleanAttribute("muted", muted)
        setAttribute("poster", poster)
        setAttribute("preload", preload?.toHtmlString())
        setAttribute("src", src)
        setNumberAttribute("width", width)

        embeddedContent.mediaFlowContent(this, src == null).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "VIDEO"

}

//---------------------------------------------------------------------------------------------------------------------


