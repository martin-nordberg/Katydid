//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.embedded

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.miscellaneous.KatyDomTextContentBuilder
import i.org.katydom.builders.KatyDomEmbeddedContentBuilderImpl
import o.org.katydom.types.EDirection
import o.org.katydom.types.EReferrerPolicy
import o.org.katydom.types.ESandboxOptions

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<iframe>` element.
 */
internal class KatyDomIframe<Msg>(
    embeddedContent: KatyDomEmbeddedContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    allowfullscreen: Boolean?,
    allowpaymentrequest: Boolean?,
    contenteditable: Boolean?,
    dir: EDirection?,
    height: Int?,
    hidden: Boolean?,
    lang: String?,
    name: String?,
    referrerpolicy: EReferrerPolicy?,
    sandbox: List<ESandboxOptions>?,
    spellcheck: Boolean?,
    src: String,
    srcdoc: String?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    width: Int?,
    defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                            tabindex, title, translate) {

    init {
        setBooleanAttribute("allowfullscreen", allowfullscreen)
        setBooleanAttribute("allowpaymentrequest", allowpaymentrequest)
        setNumberAttribute("height", height)
        setAttribute("name", name)
        setAttribute("referrerpolicy", referrerpolicy?.toHtmlString())
        if (sandbox != null) {
            setAttribute("sandbox", sandbox.joinToString(" ") { s -> s.toHtmlString() })
        }
        setAttribute("src", src)
        setAttribute("srcdoc", srcdoc)
        setNumberAttribute("width", width)

        embeddedContent.textContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "IFRAME"

}

//---------------------------------------------------------------------------------------------------------------------


