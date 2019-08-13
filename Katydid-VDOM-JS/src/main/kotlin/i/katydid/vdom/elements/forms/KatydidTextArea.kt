//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EWrapType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a textarea element.
 */
internal class KatydidTextArea<Msg>(
    phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    autocomplete: String?,
    autofocus: Boolean?,
    cols: Int?,
    contenteditable: Boolean?,
    dir: EDirection?,
    dirname: String?,
    disabled: Boolean?,
    draggable: Boolean?,
    form: String?,
    hidden: Boolean?,
    lang: String?,
    maxlength: Int?,
    minlength: Int?,
    name: String?,
    placeholder: String?,
    readonly: Boolean?,
    required: Boolean?,
    rows: Int?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    wrap: EWrapType?,
    defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key ?: name, accesskey, contenteditable, dir, draggable,
                                hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()

        require(cols == null || cols > 0) { "Attribute cols must be greater than zero." }
        require(maxlength == null || maxlength >= 0) { "Attribute maxlength must be non-negative." }
        require(minlength == null || minlength >= 0) { "Attribute minlength must be non-negative." }
        require(
            minlength == null || maxlength == null || minlength <= maxlength) { "Input attribute minlength must be less than maxlength." }
        require(rows == null || rows > 0) { "Attribute rows must be greater than zero." }

        setAttribute("autocomplete", autocomplete)
        setBooleanAttribute("autofocus", autofocus)
        setNumberAttribute("cols", cols)
        setAttribute("dirname", dirname)
        setBooleanAttribute("disabled", disabled)
        setAttribute("form", form)
        setNumberAttribute("maxlength", maxlength)
        setNumberAttribute("minlength", minlength)
        setAttribute("name", name)
        setAttribute("placeholder", placeholder)
        setBooleanAttribute("readonly", readonly)
        setBooleanAttribute("required", required)
        setNumberAttribute("rows", rows)
        setAttribute("wrap", wrap?.toHtmlString())

        phrasingContent.textContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "TEXTAREA"

}

//---------------------------------------------------------------------------------------------------------------------

