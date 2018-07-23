//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.tabular

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.tables.KatyDomTableBodyContentBuilder
import i.org.katydom.builders.tables.KatyDomTableContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a table `<tbody>` element.
 */
internal class KatyDomTBody<Msg>(
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
        tableContent.tableContentRestrictions.confirmTBodyAllowed()

        tableContent.tableBodyContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "TBODY"

}

//---------------------------------------------------------------------------------------------------------------------
