//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.grouping

import i.org.katydom.builders.KatyDomFlowContentBuilderImpl
import i.org.katydom.elements.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <figure> element.
 */
internal class KatyDomFigure<Msg>(
    flowContent: KatyDomFlowContentBuilderImpl<Msg>,
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
    defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        flowContent.withFigCaptionAllowed(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "FIGURE"

}

//---------------------------------------------------------------------------------------------------------------------
