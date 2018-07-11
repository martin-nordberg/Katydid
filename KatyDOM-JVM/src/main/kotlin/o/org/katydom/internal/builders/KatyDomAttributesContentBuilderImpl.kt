//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.builders

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.api.*
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomContentBuilderDsl
import o.org.katydom.types.*
import x.org.katydom.dom.events.*

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

    override fun onbeforeinput(handler: InputEvent2Message<Msg>) {

        element.addInputEventHandler(EInputEventType.BEFORE_INPUT) { e: InputEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onblur(handler: FocusEvent2Message<Msg>) {

        element.addFocusEventHandler(EFocusEventType.BLUR) { e: FocusEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onchange(handler: Event2Message<Msg>) {

        element.addEventHandler(EEventType.CHANGE) { e: Event ->
            dispatchMessages(handler(e))
        }

    }

    override fun onclick(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.CLICK) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun ondblclick(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.DOUBLE_CLICK) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onevent(eventName: String, handler: Event2Message<Msg>) {

        element.addEventHandler(eventName) { e: Event ->
            dispatchMessages(handler(e))
        }

    }

    override fun onfocus(handler: FocusEvent2Message<Msg>) {

        element.addFocusEventHandler(EFocusEventType.FOCUS) { e: FocusEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun oninput(handler: InputEvent2Message<Msg>) {

        element.addInputEventHandler(EInputEventType.INPUT) { e: InputEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onkeydown(handler: KeyboardEvent2Message<Msg>) {

        element.addKeyboardEventHandler(EKeyboardEventType.KEY_DOWN) { e: KeyboardEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onkeyup(handler: KeyboardEvent2Message<Msg>) {

        element.addKeyboardEventHandler(EKeyboardEventType.KEY_UP) { e: KeyboardEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onmousedown(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.MOUSE_DOWN) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onmouseenter(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.MOUSE_ENTER) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onmouseleave(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.MOUSE_LEAVE) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onmousemove(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.MOUSE_MOVE) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onmouseout(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.MOUSE_OUT) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onmouseover(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.MOUSE_OVER) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

    override fun onmouseup(handler: MouseEvent2Message<Msg>) {

        element.addMouseEventHandler(EMouseEventType.MOUSE_UP) { e: MouseEvent ->
            dispatchMessages(handler(e))
        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

