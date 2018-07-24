//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatyDomPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EFormEncodingType
import o.katydid.vdom.types.EFormSubmissionMethod

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an input type="image" element.
 */
internal class KatyDomInputImageButton<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    alt: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    form: String?,
    formaction: String?,
    formenctype: EFormEncodingType?,
    formmethod: EFormSubmissionMethod?,
    formnovalidate: Boolean?,
    formtarget: String?,
    height: Int?,
    hidden: Boolean?,
    lang: String?,
    name: String?,
    spellcheck: Boolean?,
    src: String,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    width: Int?,
    defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key ?: name, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()

        setAttribute("alt", alt)
        setBooleanAttribute("disabled", disabled)
        setAttribute("form", form)
        setAttribute("formaction", formaction)
        setAttribute("formenctype", formenctype?.toHtmlString())
        setAttribute("formmethod", formmethod?.toHtmlString())
        setBooleanAttribute("formnovalidate", formnovalidate)
        setAttribute("formtarget", formtarget)
        setNumberAttribute("height", height)
        setAttribute("name", name)
        setAttribute("src", src)
        setNumberAttribute("width", width)

        setAttribute("type", "image")

        phrasingContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "INPUT"

}

//---------------------------------------------------------------------------------------------------------------------

