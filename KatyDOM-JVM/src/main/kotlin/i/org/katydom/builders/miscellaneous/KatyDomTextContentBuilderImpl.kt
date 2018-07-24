//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.builders.miscellaneous

import i.org.katydom.builders.KatyDomAttributesContentBuilderImpl
import i.org.katydom.elements.KatyDomHtmlElement
import i.org.katydom.elements.text.KatyDomComment
import i.org.katydom.elements.text.KatyDomText
import o.org.katydom.builders.miscellaneous.KatyDomTextContentBuilder

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

