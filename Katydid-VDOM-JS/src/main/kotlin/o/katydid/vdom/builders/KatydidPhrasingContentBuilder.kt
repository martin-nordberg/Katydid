//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders

import o.katydid.vdom.builders.media.KatydidMediaPhrasingContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidOptGroupContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidSelectContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.types.*
import x.katydid.vdom.types.KatyDateTime
import x.katydid.vdom.types.KatyTime

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the case of HTML "phrasing content".
 */
@Suppress("unused")
interface KatydidPhrasingContentBuilder<in Msg> : KatydidEmbeddedContentBuilder<Msg> {

    /**
     * Adds an `<a>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param download non-empty to download the resource with that file name instead of opening in the browser.
     * @param hidden true if the element is to be hidden.
     * @param href the URL linked to.
     * @param hreflang the language of the document linked to.
     * @param lang the language of text within this element.
     * @param rel the relationship of the document to the linked document.
     * @param rev the relationship of the linked document to this document.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param target the window or browsing context to open the link in.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param type the type of the linked resource.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun a(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        download: String? = null,
        hidden: Boolean? = null,
        href: String? = null,
        hreflang: String? = null,
        lang: String? = null,
        rel: Iterable<EAnchorHtmlLinkType>? = null,
        rev: Iterable<EAnchorHtmlLinkType>? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        target: String? = null,
        title: String? = null,
        translate: Boolean? = null,
        type: String? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<abbr>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun abbr(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds an `<area>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param alt - Replacement text for use when images are not available
     * @param contenteditable whether the element has editable content.
     * @param coords - Coordinates for the shape to be created in an image map
     * @param dir the left-to-right direction of text inside this element.
     * @param download - Whether to download the resource instead of navigating to it, and its file name if so
     * @param hidden true if the element is to be hidden.
     * @param href - Address of the hyperlink
     * @param hreflang - Language of the linked resource
     * @param lang the language of text within this element.
     * @param referrerpolicy - Referrer policy for fetches initiated by the element
     * @param rel - Relationship of this document (or subsection/topic) to the destination resource
     * @param shape - The kind of shape to be created in an image map
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param target - browsing context for hyperlink navigation
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param type - Hint for the type of the referenced resource
     * @param defineAttributes a DSL-style lambda that sets additional attributes of the new element.
     */
    fun area(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        alt: String? = null,
        contenteditable: Boolean? = null,
        coords: String? = null,
        dir: EDirection? = null,
        download: String? = null,
        hidden: Boolean? = null,
        href: String? = null,
        hreflang: String? = null,
        lang: String? = null,
        referrerpolicy: EReferrerPolicy? = null,
        rel: EAnchorHtmlLinkType? = null,
        spellcheck: Boolean? = null,
        shape: EAreaShape? = null,
        style: String? = null,
        tabindex: Int? = null,
        target: String? = null,
        title: String? = null,
        translate: Boolean? = null,
        type: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<audio>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autoplay hint that the media resource can be started automatically when the page is loaded.
     * @param contenteditable whether the element has editable content.
     * @param controls show user agent controls
     * @param crossorigin how the element handles crossorigin requests.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param loop whether to loop the media resource.
     * @param muted whether to mute the media resource by default.
     * @param preload hints how much buffering the media resource will likely need.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src address of the resource.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param contentType parameter to indicate what kind of transparent content is needed.
     * @param defineContent a DSL-style lambda that builds child elements of the new element.
     */
    fun audio(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autoplay: Boolean? = null,
        contenteditable: Boolean? = null,
        controls: Boolean? = null,
        crossorigin: ECorsSetting? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        loop: Boolean? = null,
        muted: Boolean? = null,
        preload: EPreloadHint? = null,
        spellcheck: Boolean? = null,
        src: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        contentType: PhrasingContent,
        defineContent: KatydidMediaPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<b>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun b(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a `<bdi>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun bdi(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection,
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
     * Adds a `<bdo>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun bdo(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection,
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
     * Adds a `<br>` (line break) element as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun br(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<button>` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autofocus true to make the element the focused control in the browser.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled true to make the element disabled in the browser display.
     * @param form the form acted upon by this button.
     * @param formaction the URL to use for form submission.
     * @param formenctype the encoding type to be used for form data submitted by this button.
     * @param formmethod the choice of GET or POST for submitting the form's data.
     * @param formnovalidate true to skip form field validation when this button is clicked.
     * @param formtarget the target window (browser context) for form submission
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this button as a form field.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param type the type of button.
     * @param value the value of the button for form field submission.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun button(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        formaction: String? = null,
        formenctype: EFormEncodingType? = null,
        formmethod: EFormSubmissionMethod? = null,
        formnovalidate: Boolean? = null,
        formtarget: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        type: EButtonType? = EButtonType.button,
        value: String? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<canvas>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param height vertical dimension.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param width horizontal dimension.
     * @param contentType flag to explicitly specify content type to support content transparency.
     * @param defineContent a DSL-style lambda that builds the content of the new element.
     */
    fun canvas(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        height: Int? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        width: Int? = null,
        contentType: PhrasingContent = PhrasingContent,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<cite>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun cite(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a `<code>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun code(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a comment node as the next child of the element under construction.
     * @param nodeValue the text within the comment.
     * @param key unique key for this comment within its parent node.
     */
    fun comment(
        nodeValue: String,
        key: Any? = null
    )

    /**
     * Adds a `<data>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the data element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun data(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<datalist>` element with its attributes as the next child of the element under construction.
     * View the specification: https://www.w3.org/TR/html5/sec-forms.html#the-datalist-element.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element (<option> elements).
     */
    fun datalist(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidOptGroupContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<datalist>` element with its attributes as the next child of the element under construction.
     * View the specification: https://www.w3.org/TR/html5/sec-forms.html#the-datalist-element.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param contentType flag to turn on phrasing content instead of <option> element content.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element (<option> elements).
     */
    fun datalist(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        contentType: PhrasingContent,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<del>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param cite a URL describing the change.
     * @param contenteditable whether the element has editable content.
     * @param datetime when the edit was made.
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
    fun del(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        cite: String? = null,
        contenteditable: Boolean? = null,
        datetime: KatyDateTime? = null,
        dir: EDirection? = null,
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
     * Adds a `<dfn>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun dfn(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds an `<em>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun em(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds an `<i>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun i(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds an `<input type="button">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the field value to submit if this button is pressed.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputButton(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="checkbox">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autofocus true if the field is to automatically receive the keyboard focus.
     * @param checked true if the checkbox is checked.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param required true if the checkbox must be checkedfor the form to validate.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field when the chekbox is checked.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputCheckbox(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autofocus: Boolean? = null,
        checked: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="color">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list the ID of a datalist of colors.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value a valid lower case color name.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputColor(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="date">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of values to pick from.
     * @param max the latest date allowed to be chosen.
     * @param min the earliest date allowed to be chosen.
     * @param name the name of this field for form submissions.
     * @param readonly true if the date field is displayed but not editable by the user.
     * @param required true if the field may not be left blank in a valid form submission.
     * @param spellcheck whether the element is subject to spell checking.
     * @param step the step value for incrementing or decrementing the date in steps.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputDate(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: String? = null,
        min: String? = null,
        name: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        step: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="datetime-local">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of values to pick from.
     * @param max the latest date allowed to be chosen.
     * @param min the earliest date allowed to be chosen.
     * @param name the name of this field for form submissions.
     * @param readonly true if the date field is displayed but not editable by the user.
     * @param required true if the field may not be left blank in a valid form submission.
     * @param spellcheck whether the element is subject to spell checking.
     * @param step the step value for incrementing or decrementing the date in steps.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputDateTimeLocal(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: String? = null,
        min: String? = null,
        name: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        step: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an input type="email" element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputEmail(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        maxlength: Int? = null,
        minlength: Int? = null,
        multiple: Boolean? = null,
        name: String? = null,
        pattern: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        size: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="file">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accept a string describing the type of files that can be uploaded.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param multiple true to allow multiple files to be uploaded; otherwise only one file can be uploaded.
     * @param name the name of this field for form submissions.
     * @param required true to indicate that a file must be uploaded for the form to validate.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the file name that has been uplaoded.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputFile(
        selector: String? = null,
        key: Any? = null,
        accept: String? = null,
        accesskey: Char? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        multiple: Boolean? = null,
        name: String? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="hidden">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the hidden field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputHidden(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="image">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param alt text to be displayed as an alternative to the image.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param formaction the URL to use for form submission.
     * @param formenctype the encoding type to be used for form data submitted by this button.
     * @param formmethod the choice of GET or POST for submitting the form's data.
     * @param formnovalidate true to skip form field validation when this button is clicked.
     * @param formtarget the target window (browser context) for form submission
     * @param height the height of the image in pixels.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src a URL from which to retrieve the image.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputImageButton(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        alt: String? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        formaction: String? = null,
        formenctype: EFormEncodingType? = null,
        formmethod: EFormSubmissionMethod? = null,
        formnovalidate: Boolean? = null,
        formtarget: String? = null,
        height: Int? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        src: String,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        width: Int? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="month">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of values to pick from.
     * @param max the latest month allowed to be chosen.
     * @param min the earliest month allowed to be chosen.
     * @param name the name of this field for form submissions.
     * @param readonly true if the month field is displayed but not editable by the user.
     * @param required true if the field may not be left blank in a valid form submission.
     * @param spellcheck whether the element is subject to spell checking.
     * @param step the step value for incrementing or decrementing the date in steps.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value for this field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputMonth(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: String? = null,
        min: String? = null,
        name: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        step: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="number">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of values to pick from.
     * @param max the largest number allowed to be chosen.
     * @param min the smallest number allowed to be chosen.
     * @param name the name of this field for form submissions.
     * @param placeholder text to show in the field when it has no user-entered value.
     * @param readonly true if the field is displayed but not editable by the user.
     * @param required true if the field may not be left blank in a valid form submission.
     * @param spellcheck whether the element is subject to spell checking.
     * @param step the increment or decrement to apply to the value when editing it in steps.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputNumber(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: Double? = null,
        min: Double? = null,
        name: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        step: Double? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: Double? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="number">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of values to pick from.
     * @param max the largest number allowed to be chosen.
     * @param min the smallest number allowed to be chosen.
     * @param name the name of this field for form submissions.
     * @param placeholder text to show in the field when it has no user-entered value.
     * @param readonly true if the field is displayed but not editable by the user.
     * @param required true if the field may not be left blank in a valid form submission.
     * @param spellcheck whether the element is subject to spell checking.
     * @param step the increment or decrement to apply to the value when editing it in steps.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputNumber(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: Int? = null,
        min: Int? = null,
        name: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        step: Int? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: Int? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="password">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param maxlength the maximum length of text that may be entered for the form to validate.
     * @param minlength the minimum length of text that must be entered for the form to validate.
     * @param name the name of this field for form submissions.
     * @param pattern a regular expression for validating this field.
     * @param placeholder text to display in the field when its value is empty.
     * @param readonly true if the field is displayed but may not be edited by a user.
     * @param required true if the filed must have a value for the form to validate.
     * @param size the number of visible characters in the field.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputPassword(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        maxlength: Int? = null,
        minlength: Int? = null,
        name: String? = null,
        pattern: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        size: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="radio">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param checked whether the button is checked.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param required true if the radio button group must have one button checked for valid form submission.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputRadioButton(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autofocus: Boolean? = null,
        checked: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="range">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of labeled values for the range.
     * @param max the maximum value for the range.
     * @param min the minimum value for the range.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param step the increment for stepping the ranged value.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the current value for the range field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun <T : Number> inputRange(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: T? = null,
        min: T? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        step: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: T? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="reset">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the label to show on the button.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputResetButton(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="search">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param dirname the name of a parameter holding the directionality when submitting the form.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of labeled values for the search field.
     * @param maxlength the maximum length of text that may be entered for the form to validate.
     * @param minlength the minimum length of text that must be entered for the form to validate.
     * @param name the name of this field for form submissions.
     * @param pattern a regular expression for validating this field.
     * @param placeholder text to display in the field when its value is empty.
     * @param readonly true if the field is displayed but may not be edited by a user.
     * @param required true if the filed must have a value for the form to validate.
     * @param size the number of visible characters in the field.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputSearch(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        dirname: String? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        maxlength: Int? = null,
        minlength: Int? = null,
        name: String? = null,
        pattern: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        size: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="submit">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param formaction the URL to use for form submission.
     * @param formenctype the encoding type to be used for form data submitted by this button.
     * @param formmethod the choice of GET or POST for submitting the form's data.
     * @param formnovalidate true to skip form field validation when this button is clicked.
     * @param formtarget the target window (browser context) for form submission
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of the field corresponding to the button when  the form is submitted.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputSubmitButton(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        formaction: String? = null,
        formenctype: EFormEncodingType? = null,
        formmethod: EFormSubmissionMethod? = null,
        formnovalidate: Boolean? = null,
        formtarget: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="tel">` element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of labeled values for the field.
     * @param maxlength the maximum length of text that may be entered for the form to validate.
     * @param minlength the minimum length of text that must be entered for the form to validate.
     * @param name the name of this field for form submissions.
     * @param pattern a regular expression for validating this field.
     * @param placeholder text to display in the field when its value is empty.
     * @param readonly true if the field is displayed but may not be edited by a user.
     * @param required true if the filed must have a value for the form to validate.
     * @param size the number of visible characters in the field.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the value of this field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputTelephone(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        maxlength: Int? = null,
        minlength: Int? = null,
        name: String? = null,
        pattern: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        size: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<input type="text"> element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param dirname the name of a parameter holding the directionality when submitting the form.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of labeled values for the field.
     * @param maxlength the maximum length of text that may be entered for the form to validate.
     * @param minlength the minimum length of text that must be entered for the form to validate.
     * @param name the name of this field for form submissions.
     * @param pattern a regular expression for validating this field.
     * @param placeholder text to display in the field when its value is empty.
     * @param readonly true if the field is displayed but may not be edited by a user.
     * @param required true if the filed must have a value for the form to validate.
     * @param size the number of visible characters in the field.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the current value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputText(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        dirname: String? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        maxlength: Int? = null,
        minlength: Int? = null,
        name: String? = null,
        pattern: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        size: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an input type="time" element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param list a list of labeled values for the field.
     * @param max the maximum value for the field.
     * @param min the minimum value for the field.
     * @param name the name of this field for form submissions.
     * @param readonly true if the field is displayed but may not be edited by a user.
     * @param required true if the filed must have a value for the form to validate.
     * @param spellcheck whether the element is subject to spell checking.
     * @param step the number of seconds to increment or decrement the time with a stepping UI.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the current value of the field.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputTime(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: String? = null,
        min: String? = null,
        name: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        step: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: KatyTime? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an input type="url" element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputUrl(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        maxlength: Int? = null,
        minlength: Int? = null,
        name: String? = null,
        pattern: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        size: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an input type="week" element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param disabled whether this field is disabled for user interaction.
     * @param form the ID of the form this field is part of.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun inputWeek(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        list: String? = null,
        max: String? = null,
        min: String? = null,
        name: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        spellcheck: Boolean? = null,
        step: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<ins>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param cite a URL describing the change.
     * @param contenteditable whether the element has editable content.
     * @param datetime when the edit was made.
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
    fun ins(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        cite: String? = null,
        contenteditable: Boolean? = null,
        datetime: KatyDateTime? = null,
        dir: EDirection? = null,
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
     * Adds a kbd element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun kbd(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a label element with its attributes as the next child of the element under construction.
     * Note: If key is not specified, the `for` attribute will be used as the key.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun label(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        `for`: String? = null,
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
     * Adds a map element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of the image map to reference from an img usemap attribute.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun map(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a mark element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun mark(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a meter element with its attributes as the next child of the element under construction. Meter readings
     * are floating point numbers
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param high the highest recorded reading for the meter.
     * @param lang the language of text within this element.
     * @param low the lowest recorded reading for the meter.
     * @param max the maximum of the meter's range.
     * @param min the minimum of the meter's range.
     * @param optimum the optimum reading for the measured value.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the current value of the meter.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun meter(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        high: Double? = null,
        lang: String? = null,
        low: Double? = null,
        max: Double? = null,
        min: Double? = null,
        optimum: Double? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: Double,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a meter element with its attributes as the next child of the element under construction. Meter readings
     * are integers.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param high the highest recorded reading for the meter.
     * @param lang the language of text within this element.
     * @param low the lowest recorded reading for the meter.
     * @param max the maximum of the meter's range.
     * @param min the minimum of the meter's range.
     * @param optimum the optimum reading for the measured value.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the current value of the meter.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun meter(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        high: Int? = null,
        lang: String? = null,
        low: Int? = null,
        max: Int,
        min: Int? = null,
        optimum: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: Int,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an output element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun output(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        `for`: String? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<progress>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param max the upper limit for the progress value.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the current degree of progress.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun progress(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        max: Double? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: Double? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<progress>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param max the upper limit for the progress value.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param value the current degree of progress.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun progress(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        max: Int,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: Int? = null,
        defineContent: KatydidPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a q element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun q(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds an s element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun s(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a samp element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun samp(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a select element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun select(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        multiple: Boolean? = null,
        name: String? = null,
        required: Boolean? = null,
        size: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        value: String? = null,
        defineContent: KatydidSelectContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a small element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun small(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a span element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun span(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a strong element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun strong(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a sub element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun sub(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a sup element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun sup(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a text node as the next child of the element under construction.
     * @param nodeValue the text within the node.
     */
    fun text(
        nodeValue: String,
        key: Any? = null
    )

    /**
     * Allows using +"some text" for text content.
     */
    operator fun String.unaryPlus() {
        this@KatydidPhrasingContentBuilder.text(this)
    }

    /**
     * Adds a textarea element with given attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autocomplete a hint describing the value that can be prefilled into this field by a browser.
     * @param autofocus true if the field is to automatically receive keyboard focus.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param name the name of this field for form submissions.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineContent a DSL-style lambda that builds the child nodes of the new element.
     */
    fun textarea(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autocomplete: String? = null,
        autofocus: Boolean? = null,
        cols: Int? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        dirname: String? = null,
        disabled: Boolean? = null,
        form: String? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        maxlength: Int? = null,
        minlength: Int? = null,
        name: String? = null,
        placeholder: String? = null,
        readonly: Boolean? = null,
        required: Boolean? = null,
        rows: Int? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        wrap: EWrapType? = null,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<time>` element with text content as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun time(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<time>` element with datetime attribute as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun time(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        datetime: KatyDateTime,
        dir: EDirection? = null,
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
     * Adds a `<u>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun u(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a var element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
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
    fun `var`(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
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
     * Adds a `<video>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param autoplay hint that the media resource can be started automatically when the page is loaded.
     * @param contenteditable whether the element has editable content.
     * @param controls show user agent controls
     * @param crossorigin how the element handles crossorigin requests.
     * @param dir the left-to-right direction of text inside this element.
     * @param height vertical dimension.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param loop whether to loop the media resource.
     * @param muted whether to mute the media resource by default.
     * @param poster poster frame to show prior to video playback.
     * @param preload hints how much buffering the media resource will likely need.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src address of the resource.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param width horizontal dimension.
     * @param contentType flag to explicitly specify content type to support content transparency.
     * @param defineContent a DSL-style lambda that builds any custom attributes of the new element.
     */
    fun video(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        autoplay: Boolean? = null,
        contenteditable: Boolean? = null,
        controls: Boolean? = null,
        crossorigin: ECorsSetting? = null,
        dir: EDirection? = null,
        height: Int? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        loop: Boolean? = null,
        muted: Boolean? = null,
        poster: String? = null,
        preload: EPreloadHint? = null,
        spellcheck: Boolean? = null,
        src: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        width: Int? = null,
        contentType: PhrasingContent,
        defineContent: KatydidMediaPhrasingContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a wbr element as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that adds any nonstandard attributes to the new element.
     */
    fun wbr(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------

