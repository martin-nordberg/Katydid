//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.api.Event2Message
import o.org.katydom.api.MouseEvent2Message
import o.org.katydom.types.EEventType
import o.org.katydom.types.EMouseEventType
import x.org.katydom.dom.events.Event
import x.org.katydom.dom.events.MouseEvent

//---------------------------------------------------------------------------------------------------------------------

/**
 * KatyDOM content builder for attributes and event handlers available to all nodes. Serves as a base class for more
 * specialized content builders that also add child nodes of the right types for given context.
 *
 * @constructor Constructs a new attribute content builder for the given element.
 * @param element the element whose content is being built.
 * @param dispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
@Suppress("unused")
@KatyDomContentBuilderDsl
open class KatyDomAttributesContentBuilder<Msg> internal constructor(
    protected val element: KatyDomHtmlElement<Msg>,
    protected val dispatchMessages: (Iterable<Msg>) -> Unit
) {

    /**
     * Adds one attribute to the content.
     * @param name the name of the attribute.
     * @param value the string value of the attribute.
     */
    fun attribute(
        name: String,
        value: String
    ) {
        if (name.startsWith("data-")) {
            // TODO: Warning: use data(..) instead.
            element.setData(name.substring(5), value)
        }
        element.setAttribute(name, value)
    }

    /**
     * Adds multiple attributes to the content being built.
     * @param pairs a list of the names (first) and values (second) for the attributes to add.
     */
    fun attributes(vararg pairs: Pair<String, String>) {
        pairs.forEach { pair ->
            attribute(pair.first, pair.second)
        }
    }

    /**
     * Adds multiple classes to the content being built. For each pair in [pairs] the named class is added
     * to the element if the paired value is true.
     * @param pairs a list of the classes (first) and on/off flags (second) for the classes to add.
     */
    fun classes(vararg pairs: Pair<String, Boolean>) {
        val classList = pairs.filter { it.second }.map { it.first }
        element.addClasses(classList)
    }

    /**
     * Adds one data attribute to the content being built.
     * @param name the name of the data attribute. May have the "data-" prefix omitted.
     * @param value the string value of the data attribute.
     */
    fun data(
        name: String,
        value: String
    ) {
        if (name.startsWith("data-")) {
            // TODO: Warning "data-" prefix not needed.
            element.setData(name.substring(5), value)
        }
        else {
            element.setData(name, value)
        }
    }

    /**
     * Adds multiple data attributes to the content being built.
     * @param pairs a list of the names (first) and values (second) for the attributes to add. Names may have the
     * "data-" prefix omitted.
     */
    fun dataset(vararg pairs: Pair<String, String>) {
        pairs.forEach { pair ->
            data(pair.first, pair.second)
        }
    }

    /**
     * Adds an event handler for blur events.
     * @param handler the callback that listens to blur events.
     */
    fun onblur(handler: Event2Message<Msg>) {
        element.addEventHandler(EEventType.BLUR) { e: Event ->
            dispatchMessages(handler(e))
        }
    }

    /**
     * Adds an event handler for change events.
     * @param handler the callback that listens to change events.
     */
    fun onchange(handler: Event2Message<Msg>) {
        element.addEventHandler(EEventType.CHANGE) { e: Event ->
            dispatchMessages(handler(e))
        }
    }

    /**
     * Adds an event handler for mouse clicks.
     * @param handler the callback that listens to mouse clicks.
     */
    fun onclick(handler: MouseEvent2Message<Msg>) {
        element.addMouseEventHandler(EMouseEventType.CLICK) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------

