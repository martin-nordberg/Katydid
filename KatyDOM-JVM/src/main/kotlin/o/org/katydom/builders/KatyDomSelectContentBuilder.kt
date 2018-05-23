//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

import o.org.katydom.concretenodes.forms.KatyDomOptGroup
import o.org.katydom.concretenodes.forms.KatyDomSelect
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
class KatyDomSelectContentBuilder<Msg> internal constructor(
    element: KatyDomSelect<Msg>,
    contentRestrictions: KatyDomContentRestrictions,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomOptGroupContentBuilder<Msg>(element, contentRestrictions, dispatchMessages) {

    /**
     * Adds an `<optgroup>` element with any global attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled true if the option is disabled within its parent `<select>` element.
     * @param hidden true if the element is to be hidden.
     * @param label the visible label for the option.
     * @param lang the language of text within this element.
     * @param name a name for the option group.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun optGroup(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        hidden: Boolean? = null,
        label: String,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
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
    internal fun optGroupContent(element: KatyDomOptGroup<Msg>): KatyDomOptGroupContentBuilder<Msg> {
        return KatyDomOptGroupContentBuilder(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

