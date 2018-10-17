//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.details

import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.interactive.KatydidDetails
import i.katydid.vdom.elements.interactive.KatydidSummary
import o.katydid.vdom.builders.KatydidHeadingContentBuilder
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.builders.details.KatydidDetailsFlowContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a details element.
 *
 * @constructor Constructs a new builder for the contents of a `<details>` element.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidDetailsFlowContentBuilderImpl<Msg>(
    itsElement: KatydidDetails<Msg>,
    itsContentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidFlowContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidDetailsFlowContentBuilder<Msg> {

    val detailsContentRestrictions: KatydidDetailsContentRestrictions = KatydidDetailsContentRestrictions()

    ////

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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSummary(this, selector, key, accesskey, contenteditable, dir,
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
        defineContent: KatydidHeadingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSummary(this, selector, key, accesskey, contenteditable, dir,
                           hidden, lang, spellcheck, style,
                           tabindex, title, translate, true, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

