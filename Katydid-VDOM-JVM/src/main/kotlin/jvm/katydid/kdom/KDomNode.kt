//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kdom

import x.katydid.vdom.dom.Node
import x.katydid.vdom.dom.events.Event


//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of DOM Node for producing HTML text (server side or testing).
 */
abstract class KDomNode : Node {

    private var _firstChild: KDomNode? = null

    private var _nextSibling: KDomNode? = null

    private var _parentNode: KDomNode? = null

    ////

    override val firstChild
        get() = _firstChild

    override val lastChild: KDomNode?
        get() {

            var result = _firstChild

            while (result != null && result._nextSibling != null) {
                result = result._nextSibling
            }

            return result

        }

    override val nextSibling: KDomNode?
        get() = _nextSibling

    override val parentNode
        get() = _parentNode

    ////

    override fun addEventListener(eventName: String, eventHandler: (Event) -> Unit) {
        // do nothing in JVM
    }

    override fun appendChild(newChild: Node): KDomNode {
        val result = newChild as KDomNode
        if (_firstChild == null) {
            _firstChild = result
        }
        else {
            lastChild!!._nextSibling = result
        }
        result.setParentNode(this)
        return result
    }

    override fun hasChildNodes(): Boolean {
        return _firstChild != null
    }

    override fun insertBefore(newChild: Node, followingChild: Node?): KDomNode {

        val result = newChild as KDomNode

        result._parentNode?.removeChild(result)

        if (followingChild == null || _firstChild == null) {
            return appendChild(newChild)
        }

        if (_firstChild == followingChild) {
            _firstChild = result
        }
        else {
            var child = _firstChild
            while (child != null && child._nextSibling != null && child._nextSibling != followingChild) {
                child = child._nextSibling
            }

            if (child == null) {
                return appendChild(newChild)
            }
            else {
                child._nextSibling = newChild
            }
        }

        result._nextSibling = followingChild as KDomNode
        result.setParentNode(this)
        return result

    }

    override fun removeChild(oldChild: Node): KDomNode {
        val result = oldChild as KDomNode
        if (_firstChild == result) {
            _firstChild = result._nextSibling
        }
        else {
            var child = _firstChild
            while (child != null && child._nextSibling != result) {
                child = child._nextSibling
            }
            if (child != null) {
                child._nextSibling = result._nextSibling
            }
        }
        result.setParentNode(null)
        return result
    }

    override fun removeEventListener(eventName: String, eventHandler: (Event) -> Unit) {
        // do nothing in JVM
    }

    private fun setParentNode(parentNode: KDomNode?) {
        _parentNode = parentNode
    }

    /**
     * Converts this element to HTML text, starting from the given level of indentation - [indent] spaces.
     */
    abstract fun toHtmlString(indent: Int = 0): String

}

//---------------------------------------------------------------------------------------------------------------------

