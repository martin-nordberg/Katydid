//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders.miscellaneous

import i.org.katydom.builders.KatyDomContentRestrictions
import i.org.katydom.elements.forms.KatyDomOptGroup
import i.org.katydom.elements.forms.KatyDomSelect
import o.org.katydom.builders.miscellaneous.KatyDomOptGroupContentBuilder
import o.org.katydom.builders.miscellaneous.KatyDomSelectContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a `<select>` element.
 *
 * @constructor Constructs a new option content builder.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatyDomSelectContentBuilderImpl<Msg>(
    element: KatyDomSelect<Msg>,
    contentRestrictions: KatyDomContentRestrictions,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomOptGroupContentBuilderImpl<Msg>(element, contentRestrictions, dispatchMessages),
    KatyDomSelectContentBuilder<Msg> {

    override fun optGroup(
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
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomOptGroupContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOptGroup(this, selector, key, accesskey, contenteditable, dir, disabled,
                            hidden, label, lang, name, spellcheck, style,
                            tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun optGroupContent(element: KatyDomOptGroup<Msg>): KatyDomOptGroupContentBuilderImpl<Msg> {
        return KatyDomOptGroupContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

