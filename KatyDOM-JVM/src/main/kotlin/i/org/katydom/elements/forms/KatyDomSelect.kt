//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.forms

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.miscellaneous.KatyDomSelectContentBuilder
import i.org.katydom.builders.KatyDomPhrasingContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a select element.
 */
internal class KatyDomSelect<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    autocomplete: String?,
    autofocus: Boolean?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    form: String?,
    hidden: Boolean?,
    lang: String?,
    multiple: Boolean?,
    name: String?,
    required: Boolean?,
    size: Int?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    value: String?,
    defineContent: KatyDomSelectContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key ?: name, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        phrasingContent.contentRestrictions.confirmInteractiveContentAllowed()

        require(size == null || size > 0) { "Attribute size must be greater than zero." }

        setAttribute("autocomplete", autocomplete)
        setBooleanAttribute("autofocus", autofocus)
        setBooleanAttribute("disabled", disabled)
        setAttribute("form", form)
        setBooleanAttribute("multiple", multiple)
        setAttribute("name", name)
        setBooleanAttribute("required", required)
        setNumberAttribute("size", size)
        setAttribute("value", value)

        phrasingContent.selectContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "SELECT"

}

//---------------------------------------------------------------------------------------------------------------------

