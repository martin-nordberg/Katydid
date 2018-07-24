//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.vdom.dom

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to a DOM Element for testing or server-side templating purposes.
 */
interface Element : Node {

    /** The tag name of the element, e.g. "input" for an `<input>` element. */
    val tagName: String

    /** Removes the attributes with given [name] from this element. */
    fun removeAttribute(name: String)

    /** Sets the [value] of the attribute named [name] in this element. */
    fun setAttribute(name: String, value: String)

}

//---------------------------------------------------------------------------------------------------------------------

