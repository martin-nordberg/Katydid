//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.ruby

import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.ruby.KatydidRb
import i.katydid.vdom.elements.ruby.KatydidRp
import i.katydid.vdom.elements.ruby.KatydidRt
import i.katydid.vdom.elements.ruby.KatydidRtc
import o.katydid.vdom.builders.KatydidPhrasingContentBuilder
import o.katydid.vdom.builders.ruby.KatydidRubyContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a ruby or rtc element.
 *
 * @constructor Constructs a new builder for the contents of a `<ruby>` or `<rtc>` element.
 * @param itsElement the element whose content is being built.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidRubyContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidPhrasingContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidRubyContentBuilder<Msg> {

    override fun rb(
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidRb(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun rp(
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidRp(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun rt(
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
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidRt(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

    override fun rtc(
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
        defineContent: KatydidRubyContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidRtc(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, spellcheck, style,
                tabindex, title, translate, defineContent)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

