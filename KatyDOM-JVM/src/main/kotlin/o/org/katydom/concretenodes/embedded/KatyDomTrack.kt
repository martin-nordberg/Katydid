//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.embedded

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.media.KatyDomMediaFlowContentBuilder
import o.org.katydom.types.EDirection
import o.org.katydom.types.ETrackKind

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<track>` element.
 */
internal class KatyDomTrack<Msg>(
    mediaContent: KatyDomMediaFlowContentBuilder<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    default: Boolean?,
    dir: EDirection?,
    hidden: Boolean?,
    kind: ETrackKind?,
    label: String?,
    lang: String?,
    spellcheck: Boolean?,
    src: String,
    srclang: String?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        mediaContent.mediaContentRestrictions.confirmTrackAllowed()

        setBooleanAttribute("default", default)
        setAttribute("kind", kind?.toHtmlString())
        setAttribute("label", label)
        setAttribute("src", src)
        setAttribute("srclang", srclang)

        mediaContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "TRACK"

}

//---------------------------------------------------------------------------------------------------------------------

