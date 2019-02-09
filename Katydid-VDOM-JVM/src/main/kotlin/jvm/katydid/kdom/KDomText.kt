//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kdom

import jvm.katydid.infrastructure.indent
import x.katydid.vdom.dom.Text

//---------------------------------------------------------------------------------------------------------------------

/**
 * Implementation of DOM Text for generating HTML text for testing or server-side rendering.
 */
open class KDomText(
    override val ownerDocument: KDomDocument,
    private var _data: String
) : KDomNode(), Text {

    override var data: String
        get() = _data
        set(value) {
            _data = value
        }

    override val nodeName = "#text"

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

