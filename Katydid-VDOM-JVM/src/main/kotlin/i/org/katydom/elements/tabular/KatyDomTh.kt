//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.tabular

import i.org.katydom.builders.tables.KatyDomTableRowContentBuilderImpl
import i.org.katydom.elements.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.types.EDirection
import o.org.katydom.types.EHeadingScope

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<th>` element.
 */
internal class KatyDomTh<Msg>(
    tableRowContent: KatyDomTableRowContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    abbr: String?,
    accesskey: Char?,
    colspan: Int?,
    contenteditable: Boolean?,
    dir: EDirection?,
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
    defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
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
