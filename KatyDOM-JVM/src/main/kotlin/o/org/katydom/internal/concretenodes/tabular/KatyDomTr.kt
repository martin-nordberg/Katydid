//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.concretenodes.tabular

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.tables.KatyDomTableRowContentBuilder
import o.org.katydom.internal.builders.tables.KatyDomTableBodyContentBuilderImpl
import o.org.katydom.internal.builders.tables.KatyDomTableContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<tr>` element.
 */
internal class KatyDomTr<Msg> : KatyDomHtmlElement<Msg> {

    internal constructor(
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
        defineContent: KatyDomTableRowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        tableContent.tableContentRestrictions.confirmTrAllowed()

        tableContent.tableRowContent(this).defineContent()
        this.freeze()
    }

    internal constructor(
        tableBodyContent: KatyDomTableBodyContentBuilderImpl<Msg>,
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
        defineContent: KatyDomTableRowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        tableBodyContent.tableRowContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "TR"

}

//---------------------------------------------------------------------------------------------------------------------
