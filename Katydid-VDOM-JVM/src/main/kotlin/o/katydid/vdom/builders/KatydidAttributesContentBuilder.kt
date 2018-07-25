//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.builders

import o.katydid.vdom.types.Event2Message


//---------------------------------------------------------------------------------------------------------------------

/**
 * Katydid content builder for attributes and event handlers available to all HTML elements. Serves as a base class
 * for more specialized content builders that also add child nodes of the right types for given context.
 */
@Suppress("unused")
@KatydidContentBuilderDsl
interface KatydidAttributesContentBuilder<in Msg> {

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
    fun attributes(
        vararg pairs: Pair<String, Any>
    )

    /**
     * Adds multiple classes to the content being built. For each pair in [pairs] the named class is added
     * to the element if the paired value is true.
     * @param pairs a list of the classes (first) and on/off flags (second) for the classes to add.
     */
    fun classes(
        vararg pairs: Pair<String, Boolean>
    )

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
    fun dataset(
        vararg pairs: Pair<String, String>
    )

    /**
     * Adds an event handler for an arbitrary named event. Specialized event handling extensions (e.g. package
     * o.org.katydid.events make use of this generic event handling mechanism. The callback takes in an event and
     * returns a list of messages. (Just use Msg=Unit in an architecture that handles events immediately without
     * Elm-like messages.)
     * @param handler the callback that listens to events.
     */
    fun onEvent(
        eventName: String,
        handler: Event2Message<Msg>
    )

}

//---------------------------------------------------------------------------------------------------------------------

