//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders.details

import o.org.katydom.builders.KatyDomHeadingContentBuilder
import o.org.katydom.builders.KatyDomPhrasingContentBuilder
import o.org.katydom.builders.details.KatyDomDetailsFlowContentBuilder
import i.org.katydom.builders.KatyDomContentRestrictions
import i.org.katydom.builders.KatyDomFlowContentBuilderImpl
import i.org.katydom.elements.interactive.KatyDomDetails
import i.org.katydom.elements.interactive.KatyDomSummary
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a details element.
 *
 * @constructor Constructs a new builder for the contents of a `<details>` element.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatyDomDetailsFlowContentBuilderImpl<Msg>(
    element: KatyDomDetails<Msg>,
    contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomFlowContentBuilderImpl<Msg>(element, contentRestrictions, dispatchMessages),
    KatyDomDetailsFlowContentBuilder<Msg> {

    val detailsContentRestrictions: KatyDomDetailsContentRestrictions = KatyDomDetailsContentRestrictions()

    override fun summary(
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
        defineContent: KatyDomPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSummary(this, selector, key, accesskey, contenteditable, dir,
                           hidden, lang, spellcheck, style,
                           tabindex, title, translate, defineContent)
        )
    }

    override fun summaryHeading(
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
        defineContent: KatyDomHeadingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSummary(this, selector, key, accesskey, contenteditable, dir,
                           hidden, lang, spellcheck, style,
                           tabindex, title, translate, true, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

