//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatyDomPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomPhrasingContentBuilder
import o.katydid.vdom.types.EButtonType
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EFormEncodingType
import o.katydid.vdom.types.EFormSubmissionMethod

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a button element.
 */
internal class KatyDomButton<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    autofocus: Boolean?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    form: String?,
    formaction: String?,
    formenctype: EFormEncodingType?,
    formmethod: EFormSubmissionMethod?,
    formnovalidate: Boolean?,
    formtarget: String?,
    hidden: Boolean?,
    lang: String?,
    name: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    type: EButtonType?,
    value: String?,
    defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key ?: name, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()

        setBooleanAttribute("autofocus", autofocus)
        setBooleanAttribute("disabled", disabled)
        setAttribute("form", form)
        setAttribute("formaction", formaction)
        setAttribute("formenctype", formenctype?.toHtmlString())
        setAttribute("formmethod", formmethod?.toHtmlString())
        setBooleanAttribute("formnovalidate", formnovalidate)
        setAttribute("formtarget", formtarget)
        setAttribute("name", name)
        setAttribute("type", type?.toHtmlString())
        setAttribute("value", value)

        phrasingContent.withInteractiveContentNotAllowed(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "BUTTON"

}

//---------------------------------------------------------------------------------------------------------------------

