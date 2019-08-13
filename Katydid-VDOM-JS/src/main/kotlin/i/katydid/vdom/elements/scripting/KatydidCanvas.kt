//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.scripting

import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidEmbeddedContentBuilder
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <canvas> element.
 */
internal class KatydidCanvas<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        embeddedContent: KatydidEmbeddedContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        defineContent: KatydidEmbeddedContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        setNumberAttribute("height", height)
        setNumberAttribute("width", width)

        embeddedContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    constructor(
        flowContent: KatydidFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        setNumberAttribute("height", height)
        setNumberAttribute("width", width)

        flowContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        height: Int?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        width: Int?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        setNumberAttribute("height", height)
        setNumberAttribute("width", width)

        phrasingContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "CANVAS"

}

//---------------------------------------------------------------------------------------------------------------------
