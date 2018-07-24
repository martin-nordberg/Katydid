//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatyDomFlowContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomFlowContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EFormEncodingType
import o.katydid.vdom.types.EFormSubmissionMethod

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a form element.
 */
internal class KatyDomForm<Msg>(
    flowContent: KatyDomFlowContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    acceptCharset: String?,
    accesskey: Char?,
    action: String?,
    autocomplete: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    enctype: EFormEncodingType?,
    hidden: Boolean?,
    lang: String?,
    method: EFormSubmissionMethod?,
    name: String?,
    novalidate: Boolean?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    target: String?,
    title: String?,
    translate: Boolean?,
    defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir, hidden, lang,
                            spellcheck, style, tabindex, title, translate) {

    init {
        flowContent.contentRestrictions.confirmFormAllowed()

        setAttribute("accept-charset", acceptCharset)
        setAttribute("action", action)
        setAttribute("autocomplete", autocomplete)
        setAttribute("enctype", enctype?.toHtmlString())
        setAttribute("method", method?.toHtmlString())
        setAttribute("name", name)
        setBooleanAttribute("novalidate", novalidate)
        setAttribute("target", target)

        flowContent.withFormNotAllowed(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "FORM"

}

//---------------------------------------------------------------------------------------------------------------------

