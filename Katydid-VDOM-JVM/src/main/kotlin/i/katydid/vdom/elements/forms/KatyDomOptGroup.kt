//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.miscellaneous.KatyDomSelectContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.miscellaneous.KatyDomOptGroupContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<optgroup>` element.
 */
internal class KatyDomOptGroup<Msg>(
    selectContent: KatyDomSelectContentBuilderImpl<Msg>,
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
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatyDomOptGroupContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key ?: name, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        require(!label.isEmpty()) { "Attribute label may not be an empty string." }

        setBooleanAttribute("disabled", disabled)
        setAttribute("label", label)

        selectContent.optGroupContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "OPTGROUP"

}

//---------------------------------------------------------------------------------------------------------------------

