//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.media.KatydidMediaFlowContentBuilder
import o.katydid.vdom.types.ECorsSetting
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EPreloadHint

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<audio>` element.
 */
internal class KatydidAudio<Msg>(
    embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
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
    defineContent: KatydidMediaFlowContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir,
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


