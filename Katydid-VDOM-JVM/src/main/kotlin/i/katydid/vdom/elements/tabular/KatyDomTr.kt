//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.tabular

import i.katydid.vdom.builders.tables.KatyDomTableBodyContentBuilderImpl
import i.katydid.vdom.builders.tables.KatyDomTableContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.tables.KatyDomTableRowContentBuilder
import o.katydid.vdom.types.EDirection

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
