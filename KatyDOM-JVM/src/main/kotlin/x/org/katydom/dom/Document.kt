//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package /*jvm*/x.org.katydom.dom

//---------------------------------------------------------------------------------------------------------------------

/**
 * Interface defining a DOM document for purposes of testing or server-side templating.
 */
interface Document : Node {

    /** Creates a new comment node with given [data] as the comment text. */
    fun createComment(data: String): Comment

    /** Creates an HTML element with given [tagName]. */
    fun createElement(tagName: String): Element

    /** Creates a new text node with given [data] as the text content. */
    fun createTextNode(data: String): Text

}

//---------------------------------------------------------------------------------------------------------------------

