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
 * Virtual node for a `<video>` element.
 */
internal class KatydidVideo<Msg>(
    embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
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
    defineContent: KatydidMediaFlowContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir,
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


