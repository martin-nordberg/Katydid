//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatyDomPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an input type=hidden element.
 */
internal class KatyDomInputHidden<Msg>(
    phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    form: String?,
    hidden: Boolean?,
    lang: String?,
    name: String?,
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
        setBooleanAttribute("disabled", disabled)
        setAttribute("form", form)
        setAttribute("name", name)
        setAttribute("value", value)

        setAttribute("type", "hidden")

        phrasingContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "INPUT"

}

//---------------------------------------------------------------------------------------------------------------------

