//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements.interactive

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.KatyDomHeadingContentBuilder
import i.org.katydom.builders.details.KatyDomDetailsFlowContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <summary> element.
 */
internal class KatyDomSummary<Msg> : KatyDomHtmlElement<Msg> {

    constructor(
        detailsContent: KatyDomDetailsFlowContentBuilderImpl<Msg>,
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
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        detailsContent.detailsContentRestrictions.confirmSummaryAllowedThenDisallow()

        detailsContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()
    }

    constructor(
        detailsContent: KatyDomDetailsFlowContentBuilderImpl<Msg>,
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
        defineContent: KatyDomHeadingContentBuilder<Msg>.() -> Unit
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
