//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.grouping

import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <dl> element.
 */
internal class KatydidDl<Msg>(
    flowContent: KatydidFlowContentBuilderImpl<Msg>,
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
    defineContent: KatydidDescriptionListContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, draggable,
    hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        flowContent.descriptionListContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "DL"

}

//---------------------------------------------------------------------------------------------------------------------
