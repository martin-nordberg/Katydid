//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.concretenodes.forms

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.internal.builders.KatyDomPhrasingContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an input type="text" element.
 */
internal class KatyDomInputText<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    autocomplete: String?,
    autofocus: Boolean?,
    contenteditable: Boolean?,
    dir: EDirection?,
    dirname: String?,
    disabled: Boolean?,
    form: String?,
    hidden: Boolean?,
    lang: String?,
    list: String?,
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
    defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key ?: name, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()

        require(maxlength == null || maxlength >= 0) { "Input attribute maxlength must be non-negative." }
        require(minlength == null || minlength >= 0) { "Input attribute minlength must be non-negative." }
        require(
            minlength == null || maxlength == null || minlength <= maxlength) { "Input attribute minlength must be less than maxlength." }
        require(size == null || size > 0) { "Input attribute size must greater than zero." }

        setAttribute("autocomplete", autocomplete)
        setBooleanAttribute("autofocus", autofocus)
        setAttribute("dirname", dirname)
        setBooleanAttribute("disabled", disabled)
        setAttribute("form", form)
        setAttribute("list", list)
        setNumberAttribute("maxlength", maxlength)
        setNumberAttribute("minlength", minlength)
        setAttribute("name", name)
        setAttribute("pattern", pattern)
        setAttribute("placeholder", placeholder)
        setBooleanAttribute("readonly", readonly)
        setBooleanAttribute("required", required)
        setNumberAttribute("size", size)
        setAttribute("value", value)

        setAttribute("type", "text")

        phrasingContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "INPUT"

}

//---------------------------------------------------------------------------------------------------------------------

