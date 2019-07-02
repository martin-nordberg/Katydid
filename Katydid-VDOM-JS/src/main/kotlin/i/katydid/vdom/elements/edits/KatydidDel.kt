//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.edits

import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.FlowContent
import x.katydid.vdom.types.KatyDateTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<del>` element.
 */
internal class KatydidDel<Msg>
    : KatydidHtmlElementImpl<Msg> {

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        cite: String?,
        contenteditable: Boolean?,
        datetime: KatyDateTime?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        setAttribute("cite", cite)
        setDateTimeAttribute("datetime", datetime)

        phrasingContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    @Suppress("UNUSED_PARAMETER")
    constructor(
        flowContent: KatydidFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        cite: String?,
        contenteditable: Boolean?,
        datetime: KatyDateTime?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        contentType: FlowContent,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        setAttribute("cite", cite)
        setDateTimeAttribute("datetime", datetime)

        flowContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "DEL"

}

//---------------------------------------------------------------------------------------------------------------------
