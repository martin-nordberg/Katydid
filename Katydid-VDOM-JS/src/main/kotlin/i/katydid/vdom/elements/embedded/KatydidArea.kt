//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.EAnchorHtmlLinkType
import o.katydid.vdom.types.EAreaShape
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EReferrerPolicy

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an <area> element.
 */
internal class KatydidArea<Msg>(
    phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    alt: String?,
    contenteditable: Boolean?,
    coords: String?,
    dir: EDirection?,
    download: String?,
    draggable: Boolean?,
    hidden: Boolean?,
    href: String?,
    hreflang: String?,
    lang: String?,
    referrerpolicy: EReferrerPolicy?,
    rel: EAnchorHtmlLinkType?,
    spellcheck: Boolean?,
    shape: EAreaShape?,
    style: String?,
    tabindex: Int?,
    target: String?,
    title: String?,
    translate: Boolean?,
    type: String?,
    defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, draggable,
    hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmAreaAllowed()

        setAttribute("alt", alt)
        setAttribute("coords", coords)
        setAttribute("download", download)
        setAttribute("href", href)
        setAttribute("hreflang", hreflang)
        setAttribute("referrerpolicy", referrerpolicy?.toHtmlString())
        setAttribute("rel", rel?.toHtmlString())
        setAttribute("shape", shape?.toHtmlString())
        setAttribute("target", target)
        setAttribute("type", type)

        phrasingContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "AREA"

}

//---------------------------------------------------------------------------------------------------------------------
