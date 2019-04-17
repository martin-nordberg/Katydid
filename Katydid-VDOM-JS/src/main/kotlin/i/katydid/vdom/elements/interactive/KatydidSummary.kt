//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.interactive

import i.katydid.vdom.builders.details.KatydidDetailsFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.builders.KatydidHeadingContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <summary> element.
 */
internal class KatydidSummary<Msg> : KatydidHtmlElementImpl<Msg> {

    constructor(
        detailsContent: KatydidDetailsFlowContentBuilderImpl<Msg>,
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
        defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        detailsContent.detailsContentRestrictions.confirmSummaryAllowedThenDisallow()

        detailsContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    constructor(
        detailsContent: KatydidDetailsFlowContentBuilderImpl<Msg>,
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
        withHeading: Boolean,
        defineContent: KatydidHeadingContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        require(withHeading) { "Artificial 'withHeading' parameter not set." }

        detailsContent.detailsContentRestrictions.confirmSummaryAllowedThenDisallow()

        // TODO: allow only one heading
        detailsContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "SUMMARY"

}

//---------------------------------------------------------------------------------------------------------------------
