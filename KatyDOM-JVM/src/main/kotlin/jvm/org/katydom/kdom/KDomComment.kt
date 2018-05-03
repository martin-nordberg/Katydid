//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.kdom

import jvm.org.katydom.infrastructure.indent
import x.org.katydom.dom.Comment

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of DOM Comment for generating HTML text for testing or server-side rendering.
 * @constructor Constructs a new HTML comment element in given [ownerDocument] with given [_data] inside the comment.
 */
open class KDomComment(
    override val ownerDocument: KDomDocument,
    private var _data: String
) : KDomNode(), Comment {

    override var data: String
        get() = _data
        set(value) {
            _data = value
        }

    override val nodeName = "#comment"

    override var nodeValue: String?
        get() = _data
        set(value) {
            _data = value ?: ""
        }

    ////

    override fun toHtmlString(indent: Int): String {
        val result = StringBuilder()
        result.indent(indent)
        result.append(_data)
        return result.toString()
    }

}

//---------------------------------------------------------------------------------------------------------------------

