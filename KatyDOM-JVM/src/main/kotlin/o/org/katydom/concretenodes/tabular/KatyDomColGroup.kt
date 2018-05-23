//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.tabular

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomColGroupContentBuilder
import o.org.katydom.builders.KatyDomTableContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a table `<colgroup>` element.
 */
internal class KatyDomColGroup<Msg> : KatyDomHtmlElement<Msg> {

    internal constructor (
        tableContent: KatyDomTableContentBuilder<Msg>,
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
        defineContent: KatyDomColGroupContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        tableContent.tableContentRestrictions.confirmColGroupAllowed()

        tableContent.colGroupContent(this).defineContent()
        this.freeze()
    }

    internal constructor (
        tableContent: KatyDomTableContentBuilder<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        span: Int?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
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
