//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.objects.KatydidObjectEmbeddedContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<object>` element.
 */
internal class KatydidObject<Msg>(
    embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    data: String?,
    dir: EDirection?,
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
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                                tabindex, title, translate) {

    init {
        setAttribute("data", data)
        setAttribute("form", form)
        setNumberAttribute("height", height)
        setAttribute("name", name)
        setAttribute("type", type?.toString())
        setBooleanAttribute("typemustmatch", typemustmatch)
        setNumberAttribute("width", width)

        embeddedContent.objectEmbeddedContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "OBJECT"

}

//---------------------------------------------------------------------------------------------------------------------


