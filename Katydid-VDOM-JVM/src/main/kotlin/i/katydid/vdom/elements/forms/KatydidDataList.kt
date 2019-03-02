//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidOptGroupContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.PhrasingContent

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <datalist> element.
 */
internal class KatydidDataList<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
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
        defineContent: KatydidOptGroupContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.optGroupContent(this).defineContent()
        this.freeze()
    }

    @Suppress("UNUSED_PARAMETER")
    constructor(
        phrasingContent: KatydidPhrasingContentBuilderImpl<Msg>,
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
        contentType: PhrasingContent,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        phrasingContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "DATALIST"

}

//---------------------------------------------------------------------------------------------------------------------
