//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.tabular

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomTableBodyContentBuilder
import o.org.katydom.builders.KatyDomTableContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a table `<tfoot>` element.
 */
internal class KatyDomTFoot<Msg>(
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
    defineContent: KatyDomTableBodyContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        tableContent.tableContentRestrictions.confirmTFootAllowed()

        tableContent.tableBodyContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "TFOOT"

}

//---------------------------------------------------------------------------------------------------------------------
