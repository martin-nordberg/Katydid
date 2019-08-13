//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders.miscellaneous

import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a `<select>` element.
 */
interface KatydidSelectContentBuilder<in Msg> : KatydidOptGroupContentBuilder<Msg> {

    /**
     * Adds an `<optgroup>` element with any global attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled true if the option is disabled within its parent `<select>` element.
     * @param draggable controls whether or not the element is draggable.
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
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        label: String,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidOptGroupContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------

