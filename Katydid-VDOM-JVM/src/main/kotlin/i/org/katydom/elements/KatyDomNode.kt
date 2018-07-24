//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.org.katydom.elements

import o.org.katydom.application.EventCancellationException
import o.org.katydom.application.EventHandler
import o.org.katydom.elements.AbstractKatyDomNode
import x.org.katydom.dom.Document
import x.org.katydom.dom.Node
import x.org.katydom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

/**
 * Topmost abstract base class for Katydid-VDOM virtual DOM. Corresponds to DOM Node.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 *
 * @constructor Constructs a new node with given [_key] or with the node name as key if [_key] is null.
 * @param _key a key for this Katydid-VDOM node that is unique among all the siblings of this node. If [_key]
 *             is null, then the node name becomes the key.
 */
internal abstract class KatyDomNode<Msg> (
    private val _key: Any?
) : AbstractKatyDomNode<Msg> {

    /**
     * States in the lifecycle of a node.
     */
    protected enum class EState {
        /** The node is still open for its attributes to be set by one of the Katydid-VDOM builders. */
        ADDING_ATTRIBUTES,
        /** The node is being modified for event handling. */
        ADDING_EVENT_HANDLERS,
        /** The node's children are still under construction. */
        ADDING_CHILD_NODES,
        /** The node has been fully defined and is ready to be established in the real DOM. */
        CONSTRUCTED,
        /** The node has been established in the real DOM (either the first edition or replacing a prior edition). */
        ESTABLISHED,
        /** The node has been replaced by a newer edition in the real DOM. */
        PATCHED_REPLACED,
        /** The node does not appear in a newer edition. */
        PATCHED_REMOVED
    }

    ////

    /** A map of child nodes by their key. */
    private val childNodesByKey: MutableMap<Any, KatyDomNode<Msg>> = hashMapOf()

    /** The established DOM node after this node has been established or patched. */
    private var domNode: Node? = null

    /** A map of registered event handlers. */
    private val eventHandlers: MutableMap<String, EventHandler> = mutableMapOf()

    /** The first child node within this node. Starts as Nothing, meaning no children. */
    private var firstChildNode: KatyDomNode<Msg>? = null

    /** The last child node within this node. Starts as Nothing, meaning no children. */
    private var lastChildNode: KatyDomNode<Msg>? = null

    /** The next sibling node within this node. Points to Nothing from last child in the list. */
    private var nextSiblingNode: KatyDomNode<Msg>? = null

    /** The previous sibling node within this node. Linked to Nothing for first child in the list. */
    private var prevSiblingNode: KatyDomNode<Msg>? = null

    /** Flag set to true once the node is fully constructed. */
    private var state: EState = EState.ADDING_ATTRIBUTES

    ////

    /** Whether this node is still having its attributes set. */
    protected val isAddingAttributes
        get() = state == EState.ADDING_ATTRIBUTES

    /** Whether this node is still being built. */
    protected val isAddingChildNodes
        get() = state == EState.ADDING_CHILD_NODES

    /** Whether this node is still having its event handlers set. */
    protected val isAddingEventHandlers
        get() = state == EState.ADDING_EVENT_HANDLERS

    /** Whether this node is fully constructed. */
    protected val isConstructed
        get() = state == EState.CONSTRUCTED

    /** Whether this node has been established in the real DOM. */
    protected val isEstablished
        get() = state == EState.ESTABLISHED

    /** Whether this node has been removed from a later edition in the real DOM. */
    protected val isPatchedRemoved
        get() = state == EState.PATCHED_REMOVED

    /** Whether this node has been replaced by a later edition in the real DOM. */
    protected val isPatchedReplaced
        get() = state == EState.PATCHED_REPLACED

    /** The key for this node. If none provided, uses the node name. */
    override val key: Any
        get() = _key ?: nodeName

    /** The name of this node (usually the HTML tag name, otherwise a pseudo tag name like "#text"). */
    abstract override val nodeName: String

    /** The first and only child node in this node. (Exception if there is none or more than one.) */
    override val soleChildNode: KatyDomNode<Msg>
        get() {

            check(firstChildNode != null) { "No child found." }
            check(firstChildNode == lastChildNode) { "More than one child node found." }

            return firstChildNode!!

        }

    ////

    /**
     * Adds a new child node to this node.
     * @param childNode the child node to add.
     */
    fun addChildNode(childNode: KatyDomNode<Msg>) {

        when {

            isAddingAttributes    -> {
                freezeAttributes()
                state = EState.ADDING_CHILD_NODES
            }

            isAddingEventHandlers -> {
                state = EState.ADDING_CHILD_NODES
            }

            else                  -> {
                check(isAddingChildNodes) { "Cannot modify a Katydid-VDOM node after it has been fully constructed." }
            }

        }

        require(!childNodesByKey.containsKey(childNode.key)) {
            "Duplicate key: " + childNode.key + " in parent element with key " + this.key
        }

        if (firstChildNode == null) {
            firstChildNode = childNode
            lastChildNode = childNode
        }
        else {
            childNode.prevSiblingNode = lastChildNode
            lastChildNode!!.nextSiblingNode = childNode
            lastChildNode = childNode
        }

        childNodesByKey[childNode.key] = childNode

        afterAddChildNode(childNode)

    }

    /**
     * Adds a general event handler for the given type of event.
     * @param eventName the name of the kind of event
     * @param handler the callback when the vent occurs
     */
    fun addEventHandler(eventName: String, handler: EventHandler) {

        if (isAddingAttributes) {
            freezeAttributes()
            state = EState.ADDING_EVENT_HANDLERS
        }
        else {
            check(isAddingEventHandlers) { "Katydid-VDOM node's event handlers must be defined before its child nodes." }
        }

        check(!eventHandlers.containsKey(eventName)) {
            "Only one '${eventName}' handler can be defined per element."
        }

        eventHandlers[eventName] =
            { event: Event ->
                try {
                    handler(event)
                }
                catch (exception: EventCancellationException) {
                    event.preventDefault()
                }
            }

    }

    /**
     * Performs extra handling after a [childNode] has been added.
     */
    protected open fun afterAddChildNode(childNode: KatyDomNode<Msg>) {

    }

    /**
     * Creates a new DOM node within the given [document] that is a child node of [parentDomNode] and is inserted
     * just before the given [followingDomChild] or at the end of the child list if [followingDomChild] is null.
     */
    protected abstract fun createDomNode(document: Document, parentDomNode: Node, followingDomChild: Node?)

    /**
     * Sets the attributes and child nodes of a newly created real DOM node to match this virtual DOM node.
     * @param domNode the real DOM node to be configured to mirror this virtual DOM node.
     */
    fun establish(domNode: Node) {

        check(state >= EState.CONSTRUCTED) {
            "Katydid-VDOM node must be fully constructed before establishing the real DOM."
        }
        check(state <= EState.CONSTRUCTED) {
            "Katydid-VDOM node already established."
        }

        require(domNode.nodeName == nodeName) {
            "Cannot establish a real DOM node differing in type from the Katydid-VDOM node."
        }

        if (nodeName != "#text") {
            establishAttributes(domNode)
            establishEventHandlers(domNode)
            establishChildNodes(domNode)
        }

        this.domNode = domNode

        state = EState.ESTABLISHED

    }

    /**
     * Performs the DOM element configuration needed by a derived class.
     * @param domElement the real DOM element being built.
     */
    protected abstract fun establishAttributes(domElement: Node)

    /**
     * Establishes child nodes in the given DOM node matching the child nodes of this Katydid-VDOM node.
     */
    private fun establishChildNodes(domNode: Node) {

        val document = checkNotNull(domNode.ownerDocument, { "DOM element must have an owner document." })

        var childNode = firstChildNode

        while (childNode != null) {

            childNode.createDomNode(document, domNode, null)

            childNode = childNode.nextSiblingNode

        }
    }

    /**
     * Establishes event handlers for the given domNode from the event handlers of this Katydid-VDOM node.
     */
    private fun establishEventHandlers(domNode: Node) {

        for ((key, eventHandler) in eventHandlers) {
            domNode.addEventListener(
                key,
                eventHandler
            )
        }

    }

    /**
     * Freezes the content of this node. Makes any further attempt to add child nodes or attributes fail.
     */
    protected fun freeze() {

        check(state <= EState.CONSTRUCTED) { "Katydid-VDOM node already fully constructed." }

        if (isAddingAttributes) {
            freezeAttributes()
        }

        state = EState.CONSTRUCTED

    }

    /**
     * Removes the scaffolding of a derived class. Override as needed. Base class method does nothing.
     */
    protected abstract fun freezeAttributes()

    /**
     * Whether this Katydid-VDOM node matches the given Katydid-VDOM node for purposes of patching.
     * @param otherNode the node to compare with.
     */
    private fun matches(otherNode: KatyDomNode<Msg>?): Boolean {

        if (otherNode == null) {
            return false
        }

        if (nodeName != otherNode.nodeName) {
            return false
        }

        return key == otherNode.key

    }

    /**
     * Patches a real DOM node by determining the difference between this Katydid-VDOM node and its prior edition.
     * @param priorNode the prior edition of this Katydid-VDOM node.
     */
    fun patch(priorNode: KatyDomNode<Msg>) {

        // Quit early if the node is the same (e.g. memoized).
        if (this === priorNode) {
            check(isPatchedReplaced) {
                "New Katydid-VDOM node is identical to prior node but prior node has not been patched."
            }
            return
        }

        check(state >= EState.CONSTRUCTED) {
            "Katydid-VDOM node must be fully constructed before establishing the real DOM."
        }
        check(state <= EState.CONSTRUCTED) {
            "Katydid-VDOM node already established."
        }

        check(!priorNode.isPatchedRemoved) {
            "Prior node cannot be patched after being removed."
        }
        check(!priorNode.isPatchedReplaced) {
            "Prior node cannot be patched twice."
        }
        check(priorNode.isEstablished) {
            "Prior Katydid-VDOM node must be established before patching. " + priorNode.nodeName + "." + priorNode.key
        }

        require(priorNode.nodeName == nodeName) {
            "Cannot patch a difference between two Katydid-VDOM nodes of different types."
        }

        val domNode = checkNotNull(priorNode.domNode) {
            "Prior Katydid-VDOM node is not linked to its DOM node."
        }

        // Patch the attributes.
        patchAttributes(domNode, priorNode)

        // Patch the event handlers
        patchEventHandlers(domNode, priorNode)

        // Patch the child nodes.
        when {

            priorNode.firstChildNode == null ->
                establishChildNodes(domNode)

            firstChildNode == null           ->
                while (domNode.hasChildNodes()) {
                    domNode.removeChild(domNode.firstChild!!)
                }

            else                             ->
                patchChildNodes(domNode, priorNode)

        }

        this.domNode = domNode
        state = EState.ESTABLISHED

        priorNode.state = EState.PATCHED_REPLACED

    }

    /**
     * Performs the patch needed by a derived class. Override as needed. Base class method does nothing.
     * @param domElement the real DOM node being patched.
     * @param priorElement the prior edition of this Katydid-VDOM node from which to compute the patch.
     */
    protected abstract fun patchAttributes(domElement: Node, priorElement: KatyDomNode<Msg>)

    /**
     * Patches the child nodes of the DOM with changes between this node and the prior node.
     * @param domNode the DOM node to patch changes into.
     * @param priorNode the prior edition of this Katydid-VDOM node that corresponds to the given domNode.
     */
    private fun patchChildNodes(domNode: Node, priorNode: KatyDomNode<Msg>) {

        // Shrinking interval of child nodes of this node.
        var startChild = firstChildNode
        var endChild = lastChildNode

        // Shrinking internal of child nodes of prior node.
        var priorStartChild = priorNode.firstChildNode
        var priorEndChild = priorNode.lastChildNode

        // First existing DOM node - moves forward as the interval shrinks in the front
        var domChild = domNode.firstChild

        val document = checkNotNull(domNode.ownerDocument) { "DOM element must have an owner document." }

        while (startChild != null && endChild != null && startChild != endChild.nextSiblingNode && endChild != startChild.prevSiblingNode) {

            when {

                startChild.matches(priorStartChild) -> {

                    domChild = domChild!!.nextSibling

                    startChild.patch(priorStartChild!!)

                    startChild = startChild.nextSiblingNode
                    priorStartChild = priorStartChild.nextSiblingNode

                }

                endChild.matches(priorEndChild)     -> {

                    endChild.patch(priorEndChild!!)

                    endChild = endChild.prevSiblingNode
                    priorEndChild = priorEndChild.prevSiblingNode

                }

                startChild.matches(priorEndChild)   -> {

                    domNode.insertBefore(priorEndChild!!.domNode!!, domChild)

                    startChild.patch(priorEndChild)

                    startChild = startChild.nextSiblingNode
                    priorEndChild = priorEndChild.prevSiblingNode

                }

                endChild.matches(priorStartChild)   -> {

                    if (endChild.nextSiblingNode == null) {
                        domNode.insertBefore(priorStartChild!!.domNode!!, null)
                    }
                    else {
                        domNode.insertBefore(priorStartChild!!.domNode!!, endChild.nextSiblingNode!!.domNode)
                    }

                    endChild.patch(priorStartChild)

                    endChild = endChild.prevSiblingNode
                    priorStartChild = priorStartChild.nextSiblingNode

                }

                else                                -> {

                    val priorChild = priorNode.childNodesByKey[startChild.key]
                    if (priorChild != null) {

                        domNode.insertBefore(priorChild.domNode!!, domChild)

                        startChild.patch(priorChild)

                    }
                    else {

                        startChild.createDomNode(document, domNode, domChild)

                    }

                    startChild = startChild.nextSiblingNode

                }
            }

        }

        // Delete any obsolete prior nodes.
        while (priorStartChild != null && priorEndChild != null && priorStartChild != priorEndChild.nextSiblingNode) {

            if (priorStartChild.isEstablished) {
                domNode.removeChild(priorStartChild.domNode!!)
                priorStartChild.state = EState.PATCHED_REMOVED
            }

            priorStartChild = priorStartChild.nextSiblingNode

        }

    }

    /**
     * Patches the event handlers of the DOM with changes between this node and the prior node.
     * @param domNode the DOM node to patch changes into.
     * @param priorNode the prior edition of this Katydid-VDOM node that corresponds to the given domNode.
     */
    private fun patchEventHandlers(domNode: Node, priorNode: KatyDomNode<Msg>) {

        // TODO: Need the event handlers to implement equals

        // Establish the new event listeners
        for ((key, eventHandler) in eventHandlers) {
            if (eventHandler != priorNode.eventHandlers[key]) {
                val priorEventHandler = priorNode.eventHandlers[key]
                if (priorEventHandler != null) {
                    domNode.removeEventListener(key, priorEventHandler)
                }
                domNode.addEventListener(key, eventHandler)
            }
        }

        // Kill off the old ones
        for ((key, priorEventHandler) in priorNode.eventHandlers) {
            if (!eventHandlers.contains(key)) {
                domNode.removeEventListener(key, priorEventHandler)
            }
        }


    }

    /**
     * Converts this node to a string for debugging purposes. The output looks like an HTML tag with no attributes:
     * `<sometag>`.
     */
    override fun toString(): String {
        return "<" + nodeName.toLowerCase() + ">"
    }

}

//---------------------------------------------------------------------------------------------------------------------
