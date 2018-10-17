//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.miscellaneous

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.text.KatydidComment
import i.katydid.vdom.elements.text.KatydidText
import o.katydid.vdom.builders.miscellaneous.KatydidTextContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for content that must be text.
 */
@Suppress("unused")
internal class KatydidTextContentBuilderImpl<Msg>(

    /** The element whose content is being built. */
    itsElement: KatydidHtmlElementImpl<Msg>,

    /** Dispatcher of event handling results for when we want event handling to be reactive or Elm-like. */
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit

) : KatydidAttributesContentBuilderImpl<Msg>(itsElement, itsDispatchMessages),
    KatydidTextContentBuilder<Msg> {

    override fun comment(nodeValue: String, key: Any?) {
        element.addChildNode(KatydidComment(nodeValue, key))
    }

    override fun text(nodeValue: String, key: Any?) {
        element.addChildNode(KatydidText(nodeValue, key))
    }

}

//---------------------------------------------------------------------------------------------------------------------

