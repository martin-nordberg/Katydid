//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.concretenodes.grouping

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.lists.KatyDomUnorderedListContentBuilder
import o.org.katydom.internal.builders.KatyDomFlowContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an unordered list <ul> element.
 */
internal class KatyDomUl<Msg>(
    flowContent: KatyDomFlowContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    dir: EDirection?,
    hidden: Boolean?,
    lang: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatyDomUnorderedListContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        flowContent.listContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "UL"

}

//---------------------------------------------------------------------------------------------------------------------

