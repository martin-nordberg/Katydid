//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.text

import i.katydid.vdom.builders.KatyDomPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomPhrasingContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <mark> element.
 */
internal class KatyDomMark<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
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
    defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "MARK"

}

//---------------------------------------------------------------------------------------------------------------------
