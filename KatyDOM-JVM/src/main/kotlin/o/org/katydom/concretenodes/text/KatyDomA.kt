//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.text

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.types.EAnchorHtmlLinkType
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an anchor <a> element.
 */
internal class KatyDomA<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilder<Msg>,
    selector: String?,
    key: Any?,
    accesskey: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    download: String?,
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
    defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmAnchorAllowed()
        if (href != null) {
            phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()
        }

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

        phrasingContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "A"

}

//---------------------------------------------------------------------------------------------------------------------
