//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.forms

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomOptGroupContentBuilder
import o.org.katydom.builders.KatyDomTextContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an option element.
 */
internal class KatyDomOption<Msg> : KatyDomHtmlElement<Msg> {

    constructor(
        optionContent: KatyDomOptGroupContentBuilder<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        hidden: Boolean?,
        label: String,
        lang: String?,
        name: String?,
        selected: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key ?: name, accesskey, contenteditable, dir, hidden, lang, spellcheck, style, tabindex, title,
              translate) {

        setAttributes(disabled, label, selected)
        setAttribute("value", value)

        optionContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    constructor(
        optionContent: KatyDomOptGroupContentBuilder<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        hidden: Boolean?,
        label: String?,
        lang: String?,
        name: String?,
        selected: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) : super(selector, key ?: name, accesskey, contenteditable, dir, hidden, lang, spellcheck, style, tabindex, title,
              translate) {

        setAttributes(disabled, label, selected)

        optionContent.textContent(this).defineContent()
        this.freeze()
    }

    ////

    private fun setAttributes(
        disabled: Boolean?,
        label: String?,
        selected: Boolean?
    ) {
        require(label == null || !label.isEmpty()) { "Attribute label may not be an empty string." }

        setBooleanAttribute("disabled", disabled)
        setAttribute("label", label)
        setBooleanAttribute("selected", selected)
    }

    ////

    override val nodeName = "OPTION"

}

//---------------------------------------------------------------------------------------------------------------------

