//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.embedded

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomEmbeddedContentBuilder
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EDirection
import o.org.katydom.types.EPreloadHint

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<video>` element.
 */
internal class KatyDomVideo<Msg>(
    embeddedContent: KatyDomEmbeddedContentBuilder<Msg>,
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
    defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {

        setBooleanAttribute( "autoplay", autoplay )
        setBooleanAttribute( "controls", controls )
        setAttribute("crossorigin", crossorigin?.toHtmlString())
        setNumberAttribute("height", height)
        setBooleanAttribute( "loop", loop )
        setBooleanAttribute( "muted", muted )
        setAttribute("poster", poster)
        setAttribute("preload", preload?.toHtmlString())
        setAttribute("src", src)
        setNumberAttribute("width", width)

        // TODO: <source> then <track> then transparent w/o media
        embeddedContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "VIDEO"

}

//---------------------------------------------------------------------------------------------------------------------


