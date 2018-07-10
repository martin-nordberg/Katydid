//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.builders.miscellaneous

import o.org.katydom.builders.KatyDomAttributesContentBuilder

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual DOM builder for content that must be text.
 */
@Suppress("unused")
interface KatyDomTextContentBuilder<Msg> : KatyDomAttributesContentBuilder<Msg> {

    /**
     * Adds a comment node as the next child of the element under construction.
     * @param nodeValue the text within the node.
     * @param key unique key for this comment within its parent node.
     */
    fun comment(
        nodeValue: String,
        key: Any? = null
    )

    /**
     * Adds a text node as the next child of the element under construction.
     * @param nodeValue the text within the node.
     */
    fun text(
        nodeValue: String,
        key: Any? = null
    )

}

//---------------------------------------------------------------------------------------------------------------------

