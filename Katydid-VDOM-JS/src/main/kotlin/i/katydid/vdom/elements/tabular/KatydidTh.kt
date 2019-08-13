//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.tabular

import i.katydid.vdom.builders.tables.KatydidTableRowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EHeadingScope

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<th>` element.
 */
internal class KatydidTh<Msg>(
    tableRowContent: KatydidTableRowContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    abbr: String?,
    accesskey: Char?,
    colspan: Int?,
    contenteditable: Boolean?,
    dir: EDirection?,
    draggable: Boolean?,
    headers: String?,
    hidden: Boolean?,
    lang: String?,
    rowspan: Int?,
    scope: EHeadingScope?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, draggable,
                                hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        setAttribute("abbr", abbr)
        setNumberAttribute("colspan", colspan)
        setAttribute("headers", headers)
        setNumberAttribute("rowspan", rowspan)
        setAttribute("scope", scope?.toHtmlString())

        tableRowContent.flowContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "TH"

}

//---------------------------------------------------------------------------------------------------------------------
