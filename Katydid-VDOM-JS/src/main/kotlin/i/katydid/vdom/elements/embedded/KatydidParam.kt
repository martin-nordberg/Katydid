//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.objects.KatydidObjectEmbeddedContentBuilderImpl
import i.katydid.vdom.builders.objects.KatydidObjectFlowContentBuilderImpl
import i.katydid.vdom.builders.objects.KatydidObjectPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<param>` element.
 */
internal class KatydidParam<Msg>
    : KatydidHtmlElementImpl<Msg> {

    constructor(
        embeddedContent: KatydidObjectEmbeddedContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable, hidden, lang, spellcheck, style,
        tabindex, title, translate) {

        setAttributes(name, value)

        embeddedContent.paramAttributesContent(this).defineAttributes()
        this.freeze()
    }

    constructor(
        flowContent: KatydidObjectFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable, hidden, lang, spellcheck, style,
        tabindex, title, translate) {

        setAttributes(name, value)

        flowContent.paramAttributesContent(this).defineAttributes()
        this.freeze()
    }

    constructor(
        phrasingContent: KatydidObjectPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable, hidden, lang, spellcheck, style,
        tabindex, title, translate) {

        setAttributes(name, value)

        phrasingContent.paramAttributesContent(this).defineAttributes()
        this.freeze()
    }

    private fun setAttributes(name: String?, value: String?) {
        setAttribute("name", name)
        setAttribute("value", value)
    }

    ////

    override val nodeName = "PARAM"

}

//---------------------------------------------------------------------------------------------------------------------


