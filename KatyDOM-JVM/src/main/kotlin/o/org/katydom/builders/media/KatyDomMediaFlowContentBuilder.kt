//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders.media

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomContentRestrictions
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.concretenodes.embedded.KatyDomSource
import o.org.katydom.concretenodes.embedded.KatyDomTrack
import o.org.katydom.types.EDirection
import o.org.katydom.types.ETrackKind
import o.org.katydom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a media element.
 *
 * @constructor Constructs a new builder for the contents of a `<audio>` or `<video>` element.
 * @param element the element whose content is being built.
 * @param contentRestrictions restrictions on content enforced at run time.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
class KatyDomMediaFlowContentBuilder<Msg> internal constructor(
    element: KatyDomHtmlElement<Msg>,
    contentRestrictions: KatyDomContentRestrictions = KatyDomContentRestrictions(),
    internal val mediaContentRestrictions: KatyDomMediaContentRestrictions = KatyDomMediaContentRestrictions(),
    dispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatyDomFlowContentBuilder<Msg>(element, contentRestrictions, dispatchMessages) {

    /**
     * Adds a `<source>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomSource(this, selector, key, accesskey, contenteditable, dir,
                          hidden, lang, media, sizes, spellcheck, src, srcset, style,
                          tabindex, title, translate, type, defineAttributes)
        )
    }

    /**
     * Adds a `<track>` element with its attributes as the next child of the element under construction.
     * @param selector the "selector" for the element, e.g. "#myid.my-class.my-other-class".
     * @param key a non-DOM key for this KatyDOM element that is unique among all the siblings of this element.
     * @param accesskey a string specifying the HTML accesskey value.
     * @param contenteditable whether the element has editable content.
     * @param default whether this is the default track to play.
     * @param dir the left-to-right direction of text inside this element.
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
        defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatyDomTrack(this, selector, key, accesskey, contenteditable, default, dir,
                          hidden, kind, label, lang, spellcheck, src, srclang, style,
                          tabindex, title, translate, defineAttributes)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

