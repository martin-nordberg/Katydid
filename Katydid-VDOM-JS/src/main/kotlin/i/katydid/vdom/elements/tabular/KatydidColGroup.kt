//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.tabular

import i.katydid.vdom.builders.tables.KatydidTableContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.tables.KatydidColGroupContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a table `<colgroup>` element.
 */
internal class KatydidColGroup<Msg> : KatydidHtmlElementImpl<Msg> {

    internal constructor (
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
        defineContent: KatydidColGroupContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        tableContent.tableContentRestrictions.confirmColGroupAllowed()

        tableContent.colGroupContent(this).defineContent()
        this.freeze()
    }

    internal constructor (
        tableContent: KatydidTableContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        span: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        tableContent.tableContentRestrictions.confirmColGroupAllowed()

        this.setNumberAttribute("span", span)

        tableContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "COLGROUP"

}

//---------------------------------------------------------------------------------------------------------------------
