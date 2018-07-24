//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.edits

import i.katydid.vdom.builders.KatyDomPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomPhrasingContentBuilder
import o.katydid.vdom.types.EDirection
import x.katydid.vdom.types.KatyDateTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<del>` element.
 */
internal class KatyDomDel<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    cite: String?,
    contenteditable: Boolean?,
    datetime: KatyDateTime?,
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
        setAttribute("cite", cite)
        setDateTimeAttribute("datetime", datetime)

        // TODO: need to consider what else is needed for "transparent" content
        phrasingContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "DEL"

}

//---------------------------------------------------------------------------------------------------------------------
