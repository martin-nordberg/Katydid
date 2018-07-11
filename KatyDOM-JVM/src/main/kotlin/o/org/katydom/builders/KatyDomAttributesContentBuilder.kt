//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders

import o.org.katydom.api.*

//---------------------------------------------------------------------------------------------------------------------

/**
 * KatyDOM content builder for attributes and event handlers available to all HTML elements. Serves as a base class
 * for more specialized content builders that also add child nodes of the right types for given context.
 */
@Suppress("unused")
@KatyDomContentBuilderDsl
interface KatyDomAttributesContentBuilder<in Msg> {

    /**
     * Adds one attribute to the content.
     * @param name the name of the attribute.
     * @param value the string value of the attribute.
     */
    fun attribute(
        name: String,
        value: String
    )

    /**
     * Adds multiple attributes to the content being built.
     * @param pairs a list of the names (first) and values (second) for the attributes to add.
     */
    fun attributes(vararg pairs: Pair<String, Any>)

    /**
     * Adds multiple classes to the content being built. For each pair in [pairs] the named class is added
     * to the element if the paired value is true.
     * @param pairs a list of the classes (first) and on/off flags (second) for the classes to add.
     */
    fun classes(vararg pairs: Pair<String, Boolean>)

    /**
     * Adds one data attribute to the content being built.
     * @param name the name of the data attribute. May have the "data-" prefix omitted.
     * @param value the string value of the data attribute.
     */
    fun data(
        name: String,
        value: String
    )

    /**
     * Adds multiple data attributes to the content being built.
     * @param pairs a list of the names (first) and values (second) for the attributes to add. Names may have the
     * "data-" prefix omitted.
     */
    fun dataset(vararg pairs: Pair<String, String>)

    /**
     * Adds an event handler for "beforeinput" events.
     * @param handler the callback that listens to beforeinput events.
     */
    fun onbeforeinput(handler: InputEvent2Message<Msg>)

    /**
     * Adds an event handler for "blur" events.
     * @param handler the callback that listens to blur events.
     */
    fun onblur(handler: FocusEvent2Message<Msg>)

    /**
     * Adds an event handler for "change" events.
     * @param handler the callback that listens to change events.
     */
    fun onchange(handler: Event2Message<Msg>)

    /**
     * Adds an event handler for "click" events.
     * @param handler the callback that listens to click events.
     */
    fun onclick(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for "dblclick" events.
     * @param handler the callback that listens to dblclick events.
     */
    fun ondblclick(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for an arbitrary named event
     * @param handler the callback that listens to events.
     */
    fun onevent(eventName: String, handler: Event2Message<Msg>)

    /**
     * Adds an event handler for "focus" events.
     * @param handler the callback that listens to focus events.
     */
    fun onfocus(handler: FocusEvent2Message<Msg>)

    /**
     * Adds an event handler for "input" events.
     * @param handler the callback that listens to input events.
     */
    fun oninput(handler: InputEvent2Message<Msg>)

    /**
     * Adds an event handler for "keydown" events.
     * @param handler the callback that listens to keydown events.
     */
    fun onkeydown(handler: KeyboardEvent2Message<Msg>)

    /**
     * Adds an event handler for "keyup" events.
     * @param handler the callback that listens to keyup events.
     */
    fun onkeyup(handler: KeyboardEvent2Message<Msg>)

    /**
     * Adds an event handler for "mousedown" events.
     * @param handler the callback that listens to mousedown events.
     */
    fun onmousedown(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for "mouseenter" events.
     * @param handler the callback that listens to mouseenter events.
     */
    fun onmouseenter(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for "mouseleave" events.
     * @param handler the callback that listens to mouseleave events.
     */
    fun onmouseleave(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for "mousemove" events.
     * @param handler the callback that listens to mousemove events.
     */
    fun onmousemove(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for "mouseout" events.
     * @param handler the callback that listens to mouseout events.
     */
    fun onmouseout(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for "mouseover" events.
     * @param handler the callback that listens to mouseover events.
     */
    fun onmouseover(handler: MouseEvent2Message<Msg>)

    /**
     * Adds an event handler for "mouseup" events.
     * @param handler the callback that listens to mouseup events.
     */
    fun onmouseup(handler: MouseEvent2Message<Msg>)

}

//---------------------------------------------------------------------------------------------------------------------

