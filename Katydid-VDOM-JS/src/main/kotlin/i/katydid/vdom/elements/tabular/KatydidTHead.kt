//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.tabular

import i.katydid.vdom.builders.tables.KatydidTableContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.tables.KatydidTableBodyContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a table `<thead>` element.
 */
internal class KatydidTHead<Msg>(
    tableContent: KatydidTableContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    dir: EDirection?,
    draggable: Boolean?,
    hidden: Boolean?,
    lang: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatydidTableBodyContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, draggable,
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
