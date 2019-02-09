//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders

import o.katydid.vdom.builders.media.KatydidMediaFlowContentBuilder
import o.katydid.vdom.builders.media.KatydidPictureContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder
import o.katydid.vdom.types.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for the case of HTML "embedded content".
 */
@Suppress("unused")
interface KatydidEmbeddedContentBuilder<in Msg> : KatydidAttributesContentBuilder<Msg> {

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
        defineContent: KatydidMediaFlowContentBuilder<Msg>.() -> Unit
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
        contentType: EmbeddedContent = EmbeddedContent,
        defineContent: KatydidEmbeddedContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<embed>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param height vertical dimension.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src address of the resource.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param type the MIME type of the embedded content.
     * @param width horizontal dimension.
     * @param defineContent a DSL-style lambda that builds any custom attributes or nested text of the new element.
     */
    fun embed(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        height: Int? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        src: String,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        type: MimeType? = null,
        width: Int? = null,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<iframe>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param allowfullscreen whether to allow requestFullscreen()
     * @param allowpaymentrequest whether to allow the PaymentRequest interface.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param height vertical dimension.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param referrerpolicy referrer policy for fetches initiated by the element.
     * @param sandbox restricts on content within the iframe.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src address of the resource.
     * @param srcdoc text of a document to render in the iframe.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param width horizontal dimension.
     * @param defineContent a DSL-style lambda that builds any custom attributes or nested text of the new element.
     */
    fun iframe(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        allowfullscreen: Boolean? = null,
        allowpaymentrequest: Boolean? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        height: Int? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        name: String? = null,
        referrerpolicy: EReferrerPolicy? = null,
        sandbox: List<ESandboxOption>? = null,
        spellcheck: Boolean? = null,
        src: String,
        srcdoc: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        width: Int? = null,
        defineContent: KatydidTextContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds an `<img>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param alt replacement text for use when images are not available.
     * @param contenteditable whether the element has editable content.
     * @param crossorigin how the element handles crossorigin requests.
     * @param dir the left-to-right direction of text inside this element.
     * @param height vertical dimension.
     * @param hidden true if the element is to be hidden.
     * @param ismap whether the image is a server-side image map.
     * @param lang the language of text within this element.
     * @param referrerpolicy referrer policy for fetches initiated by the element.
     * @param sizes image sizes between breakpoints.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src address of the resource.
     * @param srcset images to use in different situations (e.g., high-resolution displays, small monitors, etc).
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param usemap name of image map to use.
     * @param width horizontal dimension.
     * @param defineAttributes a DSL-style lambda that builds any custom attributes of the new element.
     */
    fun img(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        alt: String,
        contenteditable: Boolean? = null,
        crossorigin: ECorsSetting? = null,
        dir: EDirection? = null,
        height: Int? = null,
        hidden: Boolean? = null,
        ismap: Boolean? = null,
        lang: String? = null,
        referrerpolicy: EReferrerPolicy? = null,
        sizes: String? = null,
        spellcheck: Boolean? = null,
        src: String,
        srcset: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        usemap: String? = null,
        width: Int? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

    /**
     * Adds a `<picture>` element with its attributes as the next child of the element under construction.
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
     * @param defineContent a DSL-style lambda that builds any custom attributes of the new element.
     */
    fun picture(
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
        defineContent: KatydidPictureContentBuilder<Msg>.() -> Unit
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
        defineContent: KatydidMediaFlowContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------


