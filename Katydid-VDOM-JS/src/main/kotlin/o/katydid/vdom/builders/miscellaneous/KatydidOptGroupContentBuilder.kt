//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders.miscellaneous

import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a `<optgroup>` or `<datalist>` element.
 */
interface KatydidOptGroupContentBuilder<in Msg> : KatydidAttributesContentBuilder<Msg> {

    /**
     * Adds a comment node as the next child of the element under construction.
     * @param nodeValue the text within the node.
     * @param key unique key for this comment within its parent node.
     */
    fun comment(
        nodeValue: String,
        key: Any? = null
    )

    /**
     * Adds an `<option>` element with its attributes as the next child of the element under construction.
     * The value for the option is given in the required [value] attribute.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled true if the option is disabled within its parent `<select>` element.
     * @param draggable whether the element is draggable.
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
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        label: String,
        lang: String? = null,
        name: String? = null,
        selected: Boolean? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<option>` element with its attributes as the next child of the element under construction.
     * The value of the option is the required text inside the element.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled true if the option is disabled within its parent `<select>` element.
     * @param draggable whether the element is draggable.
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
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        draggable: Boolean? = null,
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
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------

