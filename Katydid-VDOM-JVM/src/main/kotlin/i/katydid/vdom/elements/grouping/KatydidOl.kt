//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.grouping

import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.lists.KatydidOrderedListContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EOrderedListType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an ordered list <ol> element.
 */
internal class KatydidOl<Msg>(
    flowContent: KatydidFlowContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
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
    defineContent: KatydidOrderedListContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir,
                                hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        setBooleanAttribute("reversed", reversed)
        setNumberAttribute("start", start)
        setAttribute("type", type?.toHtmlString())

        flowContent.listContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "OL"

}

//---------------------------------------------------------------------------------------------------------------------

