//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.katydid.vdom.dom

import x.katydid.vdom.dom.events.Event


//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface to an HTML Node (for testing or server-side templating).
 */
interface Node {

    /** The first child node of this parent node. */
    val firstChild: Node?

    /** The last child node of this parent node. */
    val lastChild: Node?

    /** The next child node after this one in the parent's list of children. */
    val nextSibling: Node?

    /** The name of the node (generally an HTML tag name or a specialized tag name like "#text" or "#comment". */
    val nodeName: String

    /** The value of the node. The text of a text node or comment; otherwise null. */
    var nodeValue: String?

    /** The document that created this node. */
    val ownerDocument: Document?

    /** The parent node of this child. */
    val parentNode: Node?

    /** Appends a given [newChild] node to the ned of the list of child nodes within this parent node. */
    fun appendChild(newChild: Node): Node

    /** Adds an [eventHandler] that will respond to events of type [eventName]. On a JVM, does nothing. */
    fun addEventListener(eventName: String, eventHandler: (Event) -> Unit)

    /** Whether this node has any children. */
    fun hasChildNodes(): Boolean

    /**
     * Adds a [newChild] node to this parent node, just before [followingChild] or at the end of the list if
     * [followingChild] is null
     */
    fun insertBefore(newChild: Node, followingChild: Node?): Node

    /** Removes [oldChild] from this node's list of children. */
    fun removeChild(oldChild: Node): Node

    /** Removes the [eventHandler] for events of type [eventName] from this node. */
    fun removeEventListener(eventName: String, eventHandler: (Event) -> Unit)

}

//---------------------------------------------------------------------------------------------------------------------

