//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders.media

import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.ETrackKind
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a media element.
 * TODO: To support "transparent" content, we need embedded / phrased / flow media content builders or at least runtime checking.
 */
interface KatydidMediaFlowContentBuilder<in Msg>
    : KatydidFlowContentBuilder<Msg> {

    /**
     * Adds a `<source>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param dir the left-to-right direction of text inside this element.
     * @param draggable whether the element is draggable.
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
        draggable: Boolean? = null,
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

    /**
     * Adds a `<track>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this Katydid element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param default whether this is the default track to play.
     * @param dir the left-to-right direction of text inside this element.
     * @param draggable whether the element is draggable.
     * @param hidden true if the element is to be hidden.
     * @param kind the purpose of this track.
     * @param label user-visible label for the track.
     * @param lang the language of text within this element.
     * @param spellcheck whether the element is subject to spell checking.
     * @param src address of the resource.
     * @param srclang the language of the source.
     * @param style a string containing CSS for this element.
     * @param tabindex the tab index for the element.
     * @param title a tool tip for the element.
     * @param translate whether to translate text within this element.
     * @param defineAttributes a DSL-style lambda that builds any custom attributes of the new element.
     */
    fun track(
        selector: String? = null,
        key: Any? = null,
        accesskey: Char? = null,
        contenteditable: Boolean? = null,
        default: Boolean? = null,
        dir: EDirection? = null,
        draggable: Boolean? = null,
        hidden: Boolean? = null,
        kind: ETrackKind? = null,
        label: String? = null,
        lang: String? = null,
        spellcheck: Boolean? = null,
        src: String,
        srclang: String? = null,
        style: String? = null,
        tabindex: Int? = null,
        title: String? = null,
        translate: Boolean? = null,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    )

}

//---------------------------------------------------------------------------------------------------------------------

