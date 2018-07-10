//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.builders.miscellaneous

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.miscellaneous.KatyDomTextContentBuilder
import o.org.katydom.internal.builders.KatyDomAttributesContentBuilderImpl
import o.org.katydom.internal.concretenodes.text.KatyDomComment
import o.org.katydom.internal.concretenodes.text.KatyDomText

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for content that must be text.
 */
@Suppress("unused")
internal class KatyDomTextContentBuilderImpl<Msg>(

    /** The element whose content is being built. */
    element: KatyDomHtmlElement<Msg>,

    /** Dispatcher of event handling results for when we want event handling to be reactive or Elm-like. */
    dispatchMessages: (messages: Iterable<Msg>) -> Unit

) : KatyDomAttributesContentBuilderImpl<Msg>(element, dispatchMessages),
    KatyDomTextContentBuilder<Msg> {

    override fun comment(nodeValue: String, key: Any?) {
        element.addChildNode(KatyDomComment(nodeValue, key))
    }

    override fun text(nodeValue: String, key: Any?) {
        element.addChildNode(KatyDomText(nodeValue, key))
    }

}

//---------------------------------------------------------------------------------------------------------------------

