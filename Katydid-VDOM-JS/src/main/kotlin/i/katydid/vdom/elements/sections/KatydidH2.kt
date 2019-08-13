//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.sections

import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an <h2> element.
 */
internal class KatydidH2<Msg>(
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
    defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, draggable,
                                hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        flowContent.contentRestrictions.confirmHeadingsAllowed()

        flowContent.phrasingContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "H2"

}

//---------------------------------------------------------------------------------------------------------------------
