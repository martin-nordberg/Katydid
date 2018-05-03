//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.concretenodes.forms.KatyDomOption
import o.org.katydom.concretenodes.forms.KatyDomOptionGroup
import o.org.katydom.concretenodes.text.KatyDomComment
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
class KatyDomOptionContentBuilder<Msg> internal constructor(
    element: KatyDomHtmlElement<Msg>,
    internal val contentRestrictions: KatyDomContentRestrictions,
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilder<Msg>(element, dispatchMessages) {

    /**
     * Creates a new attributes content builder for the given child [element].
     */
    internal fun attributesContent(element: KatyDomHtmlElement<Msg>): KatyDomAttributesContentBuilder<Msg> {
        return KatyDomAttributesContentBuilder(element, dispatchMessages)
    }

    /**
     * Adds a comment node as the next child of the element under construction.
     * @param nodeValue the text within the node.
     * @param key unique key for this comment within its parent node.
     */
    fun comment(nodeValue: String,
                key: Any? = null) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    /**
     * Adds an `<option>` element with its attributes as the next child of the element under construction.
     * The value for the option is given in the required [value] attribute.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifiying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled true if the option is disabled within its parent `<select>` element.
     * @param hidden true if the element is to be hidden.
     * @param label the visible label for the option.
     * @param lang the language of text within this element.
     * @param name a name for the option.
     * @param selected true if the option is currently selected.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value attribute for the option.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun option(
        selector: String? = null,
        key: Any? = null,
        accesskey: String? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        hidden: Boolean? = null,
        label: String? = null,
        lang: String? = null,
        name: String? = null,
        selected: Boolean? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String,
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOption(this, selector, key, accesskey, contenteditable, dir, disabled,
                          hidden, label, lang, name, selected, spellcheck, style,
                          tabindex, title, translate, value, defineAttributes)
        )
    }

    /**
     * Adds an `<option>` element with its attributes as the next child of the element under construction.
     * The value of the option is the required text inside the element.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifiying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled true if the option is disabled within its parent `<select>` element.
     * @param hidden true if the element is to be hidden.
     * @param label the visible label for the option.
     * @param lang the language of text within this element.
     * @param name a name for the option.
     * @param selected true if the option is currently selected.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun option(
        selector: String? = null,
        key: Any? = null,
        accesskey: String? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        hidden: Boolean? = null,
        label: String? = null,
        lang: String? = null,
        name: String? = null,
        selected: Boolean? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatyDomTextContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOption(this, selector, key, accesskey, contenteditable, dir, disabled,
                          hidden, label, lang, name, selected, spellcheck, style,
                          tabindex, title, translate, defineContent)
        )
    }

    /**
     * Adds an `<optgroup>` element with any global attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifiying the HTML accesskey value.
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
    fun optionGroup(
        selector: String? = null,
        key: Any? = null,
        accesskey: String? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        hidden: Boolean? = null,
        label: String? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatyDomOptionContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomOptionGroup(this, selector, key, accesskey, contenteditable, dir, disabled,
                               hidden, label, lang, name, spellcheck, style,
                               tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new text content builder for the given child [element].
     */
    internal fun textContent(element: KatyDomOption<Msg>): KatyDomTextContentBuilder<Msg> {
        return KatyDomTextContentBuilder(element, dispatchMessages)
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    internal fun withNoAddedRestrictions(element: KatyDomHtmlElement<Msg>): KatyDomOptionContentBuilder<Msg> {
        return KatyDomOptionContentBuilder(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder plus no option groups allowed.
     */
    internal fun withOptionGroupNotAllowed(element: KatyDomOptionGroup<Msg>): KatyDomOptionContentBuilder<Msg> {
        return KatyDomOptionContentBuilder(
            element,
            contentRestrictions.withOptionGroupNotAllowed(),
            dispatchMessages
        )
    }


}

//---------------------------------------------------------------------------------------------------------------------

