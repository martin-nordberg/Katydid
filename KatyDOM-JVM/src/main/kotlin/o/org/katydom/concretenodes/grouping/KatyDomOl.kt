//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.grouping

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.KatyDomListItemContentBuilder
import o.org.katydom.types.EDirection
import o.org.katydom.types.EOrderedListType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an ordered list <ol> element.
 */
internal class KatyDomOl<Msg>(
    flowContent: KatyDomFlowContentBuilder<Msg>,
    selector: String?,
    key: Any?,
    accesskey: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    hidden: Boolean?,
    lang: String?,
    reversed: Boolean?,
    spellcheck: Boolean?,
    start: Int?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    type: EOrderedListType?,
    defineContent: KatyDomListItemContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        setBooleanAttribute("reversed", reversed)
        setNumberAttribute("start", start)
        setAttribute("type", type?.toHtmlString())

        flowContent.listItemContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "OL"

}

//---------------------------------------------------------------------------------------------------------------------

