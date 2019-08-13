//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EFormEncodingType
import o.katydid.vdom.types.EFormSubmissionMethod

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an input type="image" element.
 */
internal class KatydidInputImageButton<Msg>(
    phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    alt: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    draggable: Boolean?,
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
    defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key ?: name, accesskey, contenteditable, dir, draggable,
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

