//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders

import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for "heading content".
 */
@Suppress("unused")
interface KatydidHeadingContentBuilder<in Msg> :
    KatydidAttributesContentBuilder<Msg> {

    /**
     * Adds a first level heading element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param draggable controls whether or not the element is draggable.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun h1(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a second level heading element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param draggable controls whether or not the element is draggable.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun h2(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a third level heading element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param draggable controls whether or not the element is draggable.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun h3(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a fourth level heading element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param draggable controls whether or not the element is draggable.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun h4(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a fifth level heading element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param draggable controls whether or not the element is draggable.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun h5(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a sixth level heading element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param draggable controls whether or not the element is draggable.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun h6(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------

