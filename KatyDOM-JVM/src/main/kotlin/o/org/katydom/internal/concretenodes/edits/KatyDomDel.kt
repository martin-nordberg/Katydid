//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.concretenodes.edits

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.internal.builders.KatyDomPhrasingContentBuilderImpl
import o.org.katydom.types.EDirection
import x.org.katydom.types.KatyDateTime

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
