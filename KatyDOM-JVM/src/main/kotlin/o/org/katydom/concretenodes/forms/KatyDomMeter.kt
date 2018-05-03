//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.forms

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a meter element.
 */
internal class KatyDomMeter<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilder<Msg>,
    selector: String?,
    key: Any?,
    accesskey: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    hidden: Boolean?,
    high: String?,
    lang: String?,
    low: String?,
    max: String?,
    min: String?,
    optimum: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    value: String?,
    defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmMeterAllowed()

        setAttribute("high", high)
        setAttribute("low", low)
        setAttribute("max", max)
        setAttribute("min", min)
        setAttribute("optimum", optimum)
        setAttribute("value", value)

        phrasingContent.withMeterNotAllowed(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "METER"

}

//---------------------------------------------------------------------------------------------------------------------

