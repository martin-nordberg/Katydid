//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.builders.miscellaneous

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.miscellaneous.KatyDomOptGroupContentBuilder
import o.org.katydom.builders.miscellaneous.KatyDomTextContentBuilder
import o.org.katydom.internal.builders.KatyDomAttributesContentBuilderImpl
import o.org.katydom.internal.builders.KatyDomContentRestrictions
import o.org.katydom.internal.concretenodes.forms.KatyDomOption
import o.org.katydom.internal.concretenodes.text.KatyDomComment
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a `<optgroup>` or `<datalist>` element.
 *
 * @constructor Constructs a new option content builder.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal open class KatyDomOptGroupContentBuilderImpl<Msg> internal constructor(
    element: KatyDomHtmlElement<Msg>,
    internal val contentRestrictions: KatyDomContentRestrictions,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomOptGroupContentBuilder<Msg> {

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    internal fun attributesContent(element: KatyDomHtmlElement<Msg>): KatyDomAttributesContentBuilder<Msg> {
        return KatyDomAttributesContentBuilderImpl(element, dispatchMessages)
    }

    override fun comment(nodeValue: String,
                         key: Any?) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    override fun option(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        hidden: Boolean?,
        label: String,
        lang: String?,
        name: String?,
        selected: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOption(this, selector, key, accesskey, contenteditable, dir, disabled,
                          hidden, label, lang, name, selected, spellcheck, style,
                          tabindex, title, translate, value, defineAttributes)
        )
    }

    override fun option(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        hidden: Boolean?,
        label: String?,
        lang: String?,
        name: String?,
        selected: Boolean?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOption(this, selector, key, accesskey, contenteditable, dir, disabled,
                          hidden, label, lang, name, selected, spellcheck, style,
                          tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new text content builder for the given child [element].
     */
    internal fun textContent(element: KatyDomOption<Msg>): KatyDomTextContentBuilderImpl<Msg> {
        return KatyDomTextContentBuilderImpl(element, dispatchMessages)
    }


}

//---------------------------------------------------------------------------------------------------------------------

