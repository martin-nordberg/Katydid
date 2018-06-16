//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.concretenodes.interactive

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.details.KatyDomDetailsFlowContentBuilder
import o.org.katydom.internal.builders.KatyDomFlowContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <details> element.
 */
internal class KatyDomDetails<Msg>(
    flowContent: KatyDomFlowContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    dir: EDirection?,
    hidden: Boolean?,
    lang: String?,
    open: Boolean?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatyDomDetailsFlowContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        setBooleanAttribute("open", open)

        flowContent.detailsFlowContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "DETAILS"

}

//---------------------------------------------------------------------------------------------------------------------
