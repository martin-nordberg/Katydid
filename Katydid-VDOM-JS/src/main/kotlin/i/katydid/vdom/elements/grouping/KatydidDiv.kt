//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.grouping

import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <div> element.
 */
internal class KatydidDiv<Msg> : KatydidHtmlElementImpl<Msg> {

    /** Constructor for a usual div in flow content. */
    constructor(
        flowContent: KatydidFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        flowContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    /** Constructor for a div inside a dl element. */
    constructor(
        descriptionListContent: KatydidDescriptionListContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidDescriptionListContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        descriptionListContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "DIV"

}

//---------------------------------------------------------------------------------------------------------------------
