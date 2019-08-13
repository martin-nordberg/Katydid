//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.media.KatydidMediaEmbeddedContentBuilder
import o.katydid.vdom.builders.media.KatydidMediaFlowContentBuilder
import o.katydid.vdom.builders.media.KatydidMediaPhrasingContentBuilder
import o.katydid.vdom.types.ECorsSetting
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EPreloadHint

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<video>` element.
 */
internal class KatydidVideo<Msg>
    : KatydidHtmlElementImpl<Msg> {

    constructor(
        embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autoplay: Boolean?,
        contenteditable: Boolean?,
        controls: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        draggable: Boolean?,
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
        defineContent: KatydidMediaEmbeddedContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

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

        embeddedContent.mediaEmbeddedContent(this, src == null).defineContent()
        this.freeze()

    }

    constructor(
        flowContent: KatydidFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autoplay: Boolean?,
        contenteditable: Boolean?,
        controls: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        draggable: Boolean?,
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
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        flowContent.contentRestrictions.confirmMediaElementAllowed()

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

        flowContent.mediaFlowContent(this, src == null).defineContent()
        this.freeze()

    }

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        autoplay: Boolean?,
        contenteditable: Boolean?,
        controls: Boolean?,
        crossorigin: ECorsSetting?,
        dir: EDirection?,
        draggable: Boolean?,
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
        defineContent: KatydidMediaPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.contentRestrictions.confirmMediaElementAllowed()

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

        phrasingContent.mediaPhrasingContent(this, src == null).defineContent()
        this.freeze()

    }

    ////

    override val nodeName = "VIDEO"

}

//---------------------------------------------------------------------------------------------------------------------


