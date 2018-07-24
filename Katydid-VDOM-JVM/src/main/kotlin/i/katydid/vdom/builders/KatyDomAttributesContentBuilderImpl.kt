//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders

import i.katydid.vdom.elements.KatyDomHtmlElement
import o.katydid.vdom.application.Event2Message
import o.katydid.vdom.builders.KatyDomAttributesContentBuilder
import o.katydid.vdom.builders.KatyDomContentBuilderDsl
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * KatyDOM content builder for attributes and event handlers available to all HTML elements. Serves as a base class
 * for more specialized content builders that also add child nodes of the right types for given context.
 *
 * @constructor Constructs a new attribute content builder for the given element.
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
@KatyDomContentBuilderDsl
internal open class KatyDomAttributesContentBuilderImpl<Msg>(
    protected val element: KatyDomHtmlElement<Msg>,
    protected val dispatchMessages: (Iterable<Msg>) -> Unit
) : KatyDomAttributesContentBuilder<Msg> {

    override fun attribute(name: String, value: String) {

        if (name.startsWith("data-")) {
            // TODO: Warning: use data(..) instead.
            element.setData(name.substring(5), value)
        }

        element.setAttribute(name, value)

    }

    override fun attributes(vararg pairs: Pair<String, Any>) {

        pairs.forEach { pair ->
            attribute(pair.first, pair.second.toString())
        }

    }

    override fun classes(vararg pairs: Pair<String, Boolean>) {

        val classList = pairs.filter { it.second }.map { it.first }
        element.addClasses(classList)

    }

    override fun data(name: String, value: String) {

        if (name.startsWith("data-")) {
            // TODO: Warning "data-" prefix not needed.
            element.setData(name.substring(5), value)
        }
        else {
            element.setData(name, value)
        }

    }

    override fun dataset(vararg pairs: Pair<String, String>) {

        pairs.forEach { pair ->
            data(pair.first, pair.second)
        }

    }

    override fun onEvent(eventName: String, handler: Event2Message<Msg>) {

        element.addEventHandler(eventName) { e: Event ->
            dispatchMessages(handler(e))
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

