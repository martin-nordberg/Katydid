//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<embed>` element.
 */
internal class KatydidEmbed<Msg>(
    embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    dir: EDirection?,
    height: Int?,
    hidden: Boolean?,
    lang: String?,
    spellcheck: Boolean?,
    src: String,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    type: MimeType?,
    width: Int?,
    defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, hidden, lang, spellcheck, style,
                                tabindex, title, translate) {

    init {
        setNumberAttribute("height", height)
        setAttribute("src", src)
        setAttribute("type", type?.toString())
        setNumberAttribute("width", width)

        embeddedContent.textContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "EMBED"

}

//---------------------------------------------------------------------------------------------------------------------


