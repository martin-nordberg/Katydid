//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an input type="password" element.
 */
internal class KatydidInputPassword<Msg>(
    phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    autocomplete: String?,
    autofocus: Boolean?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    draggable: Boolean?,
    form: String?,
    hidden: Boolean?,
    lang: String?,
    maxlength: Int?,
    minlength: Int?,
    name: String?,
    pattern: String?,
    placeholder: String?,
    readonly: Boolean?,
    required: Boolean?,
    size: Int?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    value: String?,
    defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key ?: name, accesskey, contenteditable, dir, draggable,
                                hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()

        require(maxlength == null || maxlength >= 0) { "Attribute maxlength must be non-negative." }
        require(minlength == null || minlength >= 0) { "Attribute minlength must be non-negative." }
        require(size == null || size >= 0) { "Attribute size must be non-negative." }

        setAttribute("autocomplete", autocomplete)
        setBooleanAttribute("autofocus", autofocus)
        setBooleanAttribute("disabled", disabled)
        setAttribute("form", form)
        setNumberAttribute("maxlength", maxlength)
        setNumberAttribute("minlength", minlength)
        setAttribute("name", name)
        setAttribute("pattern", pattern)
        setAttribute("placeholder", placeholder)
        setBooleanAttribute("readonly", readonly)
        setBooleanAttribute("required", required)
        setNumberAttribute("size", size)
        setAttribute("value", value)

        setAttribute("type", "password")

        phrasingContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "INPUT"

}

//---------------------------------------------------------------------------------------------------------------------

