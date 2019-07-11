//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.objects

import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.embedded.KatydidParam
import i.katydid.vdom.elements.embedded.KatydidSource
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.objects.KatydidObjectEmbeddedContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a media element.
 *
 * @constructor Constructs a new builder for the contents of a `<audio>` or `<video>` element.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidObjectEmbeddedContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidEmbeddedContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidObjectEmbeddedContentBuilder<Msg> {

    override fun param(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        contentRestrictions.confirmParamAllowed();

        element.addChildNode(
            KatydidParam(this, selector, key, accesskey, contenteditable, dir,
                hidden, lang, name, spellcheck, style,
                tabindex, title, translate, value, defineAttributes)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

