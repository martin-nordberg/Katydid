//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.miscellaneous.KatydidOptGroupContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an option element.
 */
internal class KatydidOption<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        optionContent: KatydidOptGroupContentBuilderImpl<Msg>,
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
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key ?: name, accesskey, contenteditable, dir, hidden, lang, spellcheck, style, tabindex, title,
              translate) {

        setAttributes(disabled, label, selected)
        setAttribute("value", value)

        optionContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    constructor(
        optionContent: KatydidOptGroupContentBuilderImpl<Msg>,
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
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
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

