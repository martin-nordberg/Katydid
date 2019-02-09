//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EReferrerPolicy
import o.katydid.vdom.types.ESandboxOption

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<iframe>` element.
 */
internal class KatydidIframe<Msg>(
    embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
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
    sandbox: List<ESandboxOption>?,
    spellcheck: Boolean?,
    src: String,
    srcdoc: String?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    width: Int?,
    defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
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


