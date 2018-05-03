//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.forms

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomOptionContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an optgroup element.
 */
internal class KatyDomOptionGroup<Msg>(
    optionContent: KatyDomOptionContentBuilder<Msg>,
    selector: String?,
    key: Any?,
    accesskey: String?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    hidden: Boolean?,
    label: String?,
    lang: String?,
    name: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatyDomOptionContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key ?: name, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        optionContent.contentRestrictions.confirmOptionGroupAllowed()

        require(label == null || !label.isEmpty()) { "Attribute label may not be an empty string." }

        setBooleanAttribute("disabled", disabled)
        setAttribute("label", label)

        optionContent.withOptionGroupNotAllowed(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "OPTGROUP"

}

//---------------------------------------------------------------------------------------------------------------------

