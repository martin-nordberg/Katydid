//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders

import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.KatydidContentBuilderDsl
import o.katydid.vdom.types.Event2Message
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Katydid content builder for attributes and event handlers available to all HTML elements. Serves as a base class
 * for more specialized content builders that also add child nodes of the right types for given context.
 *
 * @constructor Constructs a new attribute content builder for the given element.
 * @param itsElement the element whose content is being built.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
@KatydidContentBuilderDsl
internal open class KatydidAttributesContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsDispatchMessages: (Iterable<Msg>) -> Unit
) : KatydidAttributesContentBuilder<Msg> {

    /** Dispatcher of event handling results for when we want event handling to be reactive or Elm-like. */
    protected val dispatchMessages = itsDispatchMessages

    /** The element whose content is being built. */
    protected val element = itsElement

    ////

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

