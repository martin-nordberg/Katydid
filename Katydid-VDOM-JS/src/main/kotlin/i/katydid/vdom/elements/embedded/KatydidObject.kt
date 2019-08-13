//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.objects.KatydidObjectEmbeddedContentBuilder
import o.katydid.vdom.builders.objects.KatydidObjectFlowContentBuilder
import o.katydid.vdom.builders.objects.KatydidObjectPhrasingContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<object>` element.
 */
internal class KatydidObject<Msg>
    : KatydidHtmlElementImpl<Msg> {

    constructor(
        embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        data: String?,
        dir: EDirection?,
        draggable: Boolean?,
        form: String?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: MimeType?,
        typemustmatch: Boolean?,
        width: Int?,
        defineContent: KatydidObjectEmbeddedContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable, hidden, lang, spellcheck, style,
        tabindex, title, translate) {

        setAttributes(data, form, height, name, type, typemustmatch, width)

        embeddedContent.objectEmbeddedContent(this).defineContent()
        this.freeze()
    }

    constructor(
        flowContent: KatydidFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        data: String?,
        dir: EDirection?,
        draggable: Boolean?,
        form: String?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: MimeType?,
        typemustmatch: Boolean?,
        width: Int?,
        defineContent: KatydidObjectFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable, hidden, lang, spellcheck, style,
        tabindex, title, translate) {

        setAttributes(data, form, height, name, type, typemustmatch, width)

        flowContent.objectFlowContent(this).defineContent()
        this.freeze()
    }

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        data: String?,
        dir: EDirection?,
        draggable: Boolean?,
        form: String?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: MimeType?,
        typemustmatch: Boolean?,
        width: Int?,
        defineContent: KatydidObjectPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable, hidden, lang, spellcheck, style,
        tabindex, title, translate) {

        setAttributes(data, form, height, name, type, typemustmatch, width)

        phrasingContent.objectPhrasingContent(this).defineContent()
        this.freeze()
    }

    private fun setAttributes(
        data: String?,
        form: String?,
        height: Int?,
        name: String?,
        type: MimeType?,
        typemustmatch: Boolean?,
        width: Int?
    ) {
        setAttribute("data", data)
        setAttribute("form", form)
        setNumberAttribute("height", height)
        setAttribute("name", name)
        setAttribute("type", type?.toString())
        setBooleanAttribute("typemustmatch", typemustmatch)
        setNumberAttribute("width", width)
    }

    ////

    override val nodeName = "OBJECT"

}

//---------------------------------------------------------------------------------------------------------------------


