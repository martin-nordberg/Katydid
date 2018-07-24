//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.text

import i.katydid.vdom.builders.KatyDomPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.builders.KatyDomPhrasingContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatyDomTextContentBuilder
import o.katydid.vdom.types.EDirection
import x.katydid.vdom.types.KatyDateTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <time> element.
 */
internal class KatyDomTime<Msg> : KatyDomHtmlElement<Msg> {

    constructor(
        phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.textContent(this).defineContent()
        this.freeze()

    }

    constructor(
        phrasingContent: KatyDomPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        datetime: KatyDateTime,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        setDateTimeAttribute("datetime", datetime)

        phrasingContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()

    }

    ////

    override val nodeName = "TIME"

}

//---------------------------------------------------------------------------------------------------------------------
