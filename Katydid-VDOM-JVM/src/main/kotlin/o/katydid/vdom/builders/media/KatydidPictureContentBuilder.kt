//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders.media

import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.ECorsSetting
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.EReferrerPolicy
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a picture element.
 */
interface KatydidPictureContentBuilder<in Msg> : KatydidAttributesContentBuilder<Msg> {

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
        src: String? = null,
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
     * Adds a `<source>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param hidden true if the element is to be hidden.
     * @param lang the language of text within this element.
     * @param media the media descriptor for which the source applies.
     * @param sizes image sizes between breakpoints.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src address of the resource.
     * @param srcset images to use in different situations (e.g., high-resolution displays, small monitors, etc).
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param type the MIME type of the source.
     * @param defineAttributes a DSL-style lambda that builds any custom attributes of the new element.
     */
    fun source(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        dir: EDirection? = null,
        hidden: Boolean? = null,
        lang: String? = null,
        media: String? = null,
        sizes: String? = null,
        spellcheck: Boolean? = null,
        src: String,
        srcset: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        type: MimeType? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------

