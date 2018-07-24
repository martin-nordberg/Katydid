//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.tabular

import i.katydid.vdom.builders.tables.KatyDomTableContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.tables.KatyDomTableBodyContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a table `<thead>` element.
 */
internal class KatyDomTHead<Msg>(
    tableContent: KatyDomTableContentBuilderImpl<Msg>,
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
    defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        tableContent.tableContentRestrictions.confirmTHeadAllowed()

        tableContent.tableBodyContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "THEAD"

}

//---------------------------------------------------------------------------------------------------------------------
