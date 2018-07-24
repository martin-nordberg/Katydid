//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.grouping

import i.katydid.vdom.builders.KatyDomFlowContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomFlowContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <blockquote> element.
 */
internal class KatyDomBlockQuote<Msg>(
    flowContent: KatyDomFlowContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    cite: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    hidden: Boolean?,
    lang: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        setAttribute("cite", cite)

        flowContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "BLOCKQUOTE"

}

//---------------------------------------------------------------------------------------------------------------------
