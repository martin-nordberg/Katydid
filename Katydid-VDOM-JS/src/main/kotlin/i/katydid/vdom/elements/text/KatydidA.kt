//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.text

import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.types.EAnchorHtmlLinkType
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an anchor <a> element.
 */
internal class KatydidA<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        download: String?,
        draggable: Boolean?,
        hidden: Boolean?,
        href: String?,
        hreflang: String?,
        lang: String?,
        rel: Iterable<EAnchorHtmlLinkType>?,
        rev: Iterable<EAnchorHtmlLinkType>?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        target: String?,
        title: String?,
        translate: Boolean?,
        type: String?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.contentRestrictions.confirmAnchorAllowed()
        if (href != null) {
            phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()
        }

        setAttributes(download, href, hreflang, rel, rev, target, type)

        phrasingContent.withInteractiveContentNotAllowed(this).defineContent()
        this.freeze()
    }

    constructor(
        flowContent: KatydidFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        download: String?,
        draggable: Boolean?,
        hidden: Boolean?,
        href: String?,
        hreflang: String?,
        lang: String?,
        rel: Iterable<EAnchorHtmlLinkType>?,
        rev: Iterable<EAnchorHtmlLinkType>?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        target: String?,
        title: String?,
        translate: Boolean?,
        type: String?,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        flowContent.contentRestrictions.confirmAnchorAllowed()
        if (href != null) {
            flowContent.contentRestrictions.confirmInteractiveContentAllowed()
        }

        setAttributes(download, href, hreflang, rel, rev, target, type)

        flowContent.withInteractiveContentNotAllowed(this).defineContent()
        this.freeze()
    }

    private fun setAttributes(
        download: String?,
        href: String?,
        hreflang: String?,
        rel: Iterable<EAnchorHtmlLinkType>?,
        rev: Iterable<EAnchorHtmlLinkType>?,
        target: String?,
        type: String?
    ) {

        this.setAttribute("download", download)
        this.setAttribute("href", href)
        this.setAttribute("hreflang", hreflang)

        if (rel != null) {
            this.setAttribute("rel", rel.joinToString(" ", transform = EAnchorHtmlLinkType::toHtmlString))
        }

        if (rev != null) {
            this.setAttribute("rev", rev.joinToString(" ", transform = EAnchorHtmlLinkType::toHtmlString))
        }

        this.setAttribute("target", target)
        this.setAttribute("type", type)

    }

    ////

    override val nodeName = "A"

}

//---------------------------------------------------------------------------------------------------------------------
